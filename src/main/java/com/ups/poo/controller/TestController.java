package com.ups.poo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public String test(){
        return "Hello world, this is my first Project!....";
    }

    @GetMapping("/hello")
    public String hello(@RequestParam String name,
                        @RequestParam (required = false) String lastname,
                        @RequestParam(required = false) Integer age){
        String message = "This is my first SpringBootProject!"+
                "and my mane is: " + name;
        if (lastname != null){
            message = message + "my lastname is: " + lastname;

        }
        if (age != null){
            message = message + " and my age is " + age;
        }

        return message;
    }
    @GetMapping("/concat/{name}/{lastname}/{age}")
    public String concatenate(@PathVariable String name, @PathVariable String lastname,
                              @PathVariable (required = false )int age){
        return "This is my second rest service!, and my name is: "
                + name + " " + lastname + " " + age;
    }


    @GetMapping("/my-exercise/{name1}/{lastname1}/{age1}")
    public String exercise(@PathVariable String name1, @PathVariable String lastname1,
                           @PathVariable (required = false) Integer age1){
        String message = name1;
        if(lastname1 != null) {
            message = message + lastname1;
        }
        if (age1 != null & age1 != 0) {
            message = message + age1;
        }
        return message;

    }
}
