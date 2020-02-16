package com.blog.core.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/hello")
public class HelloController {

    @RequestMapping("/helloweb")
    public String hello(ModelMap modelMap) {

        //向模板中添加属性
        modelMap.put("hello", "helloweb");
        // return模板文件的名称，对应src/main/resources/templates/dashboard.html
        return "dashboard";
    }
}