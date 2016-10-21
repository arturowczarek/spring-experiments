package com.owczarek.protectedservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SomeController {
    @GetMapping("employee")
    public String employee() {
        return "for employees only";
    }

    @GetMapping("customer")
    public String customer() {
        return "for customers only";
    }

    @GetMapping("authenticated")
    public String authenticated() {
        return "for authenticated";
    }

    @GetMapping("all")
    public String all() {
        return "for all";
    }
}
