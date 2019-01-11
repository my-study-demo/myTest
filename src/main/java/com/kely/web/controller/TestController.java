package com.kely.web.controller;

import com.kely.web.entity.JsonResult;
import com.kely.web.entity.QueryParam;
import com.kely.web.entity.T1;
import com.kely.web.entity.T2;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by YMO on 2018/9/5.
 */
@Api(description = "helloController")
@RestController
public class TestController {

    @GetMapping("/hello")
    @ApiOperation(value = "hello", notes = "hello", httpMethod = "GET")
    public T1 hello(@RequestParam(value = "name") String name){
        T1 t = new T1();
        T2 t2 = new T2();
        t2.setName("12");
        t.setT2(t2);
        return t;
    }

    @GetMapping("/getDataById")
    @ApiOperation(value = "getDataById", notes = "hello", httpMethod = "GET")
    public JsonResult<T2> getDataById(@ModelAttribute QueryParam queryParam) {
        JsonResult<T2> jsonResult = new JsonResult();
        jsonResult.setStatus(true);
        jsonResult.setMessage("操作成功");
        T2 t2 = new T2();
        t2.setName("张三");
        jsonResult.setData(t2);
        return jsonResult;
    }
}
