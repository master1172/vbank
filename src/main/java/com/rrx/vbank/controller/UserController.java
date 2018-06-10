package com.rrx.vbank.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("/restful/")
@Log4j2
@Api("Swagger测试的Api")
public class UserController {

    /**
     * value = "/{username}", method = RequestMethod.GET
     * 下面RequestMapping 的用法，可以实现用户在访问根域名，并登录后回到根域名
     */
    @RequestMapping("login")
    @ApiOperation(value = "根据用户名显示登录的用户", notes = "登录，一个模拟演示Swagger")
    public String index(){
        String username = "houxj";
        log.info("Hi,{} 你好 ！",username);
        return username;
    }

//    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
//    @ApiOperation(value = "根据用户名显示登录的用户", notes = "登录，一个模拟演示Swagger")
//    @ApiImplicitParam(name = "username", value = "用户姓名", paramType = "path", required = true, dataType = "String")
//    public void index(@PathVariable String username){
//        log.info("Hi,{} 你好 ！",username);
//    }
}
