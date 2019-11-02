package com.itheima.web;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.constant.MessageConstant;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.entity.Result;
import com.itheima.pojo.CheckItem;
import com.itheima.service.CheckItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/checkitem")
@RestController
public class CheckItemController {

    @Reference
    CheckItemService checkItemService;

    @RequestMapping("/add")
    public Result add(@RequestBody CheckItem checkItem){
        try {
            checkItemService.add(checkItem);
            return new Result(true, MessageConstant.ADD_CHECKITEM_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.ADD_CHECKITEM_FAIL);
        }
    }

    /**
     * 页面传的是json数据，后端使用map 或者 pojo时 需要加@RequestBody
     * 基本类型 & 数组 & MultipartFile 只要保持页面的参数名称和controller方法形参一致就不用加@RequestParam
     * List 不管名字一不一样 必须加@RequestParam
     * @return
     */
    @RequestMapping("/edit")
    public Result edit(@RequestBody CheckItem checkItem){
        checkItemService.edit(checkItem);
        return new Result(true,"");
    }

    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean){
        return  checkItemService.findPage(queryPageBean);
    }

    @RequestMapping("/findById")
    public Result findById(Integer id){
      CheckItem checkItem =  checkItemService.findById(id);
      return new Result(true,"",checkItem);
    }
}
