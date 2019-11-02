package com.itheima.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.dao.CheckItemMapper;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.pojo.CheckItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(interfaceClass = CheckItemService.class)
@Transactional
public class CheckItemServiceImpl implements CheckItemService {
    @Autowired
    CheckItemMapper checkItemMapper;
    @Override
    public void add(CheckItem checkItem) {
        checkItemMapper.add(checkItem);
    }

    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {
        //使用分页插件(告诉分页拦截器现在要分页)
       Page page = PageHelper.startPage(queryPageBean.getCurrentPage(),queryPageBean.getPageSize());

       List<CheckItem> checkItems = checkItemMapper.findPage(queryPageBean.getQueryString());

       return new PageResult(page.getTotal(),checkItems);
    }

    @Override
    public CheckItem findById(Integer id) {
        return checkItemMapper.findById(id);
    }

    @Override
    public void edit(CheckItem checkItem) {
        checkItemMapper.edit(checkItem);
    }
}
