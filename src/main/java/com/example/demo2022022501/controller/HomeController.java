package com.example.demo2022022501.controller;

import com.example.demo2022022501.result.ResultData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ASUS
 */
@RestController

@RequestMapping("/*")
public class HomeController {
    @RequestMapping("/home")
    public ResultData<String> home() {
        return ResultData.success();
    }
}
