package com.example.demo.helloWorld;

import com.example.demo.helloWorld.HelloWorldBean;
import org.springframework.web.bind.annotation.*;

//Controller
@RestController
public class HelloWorldController {
    //önce method - "Hello World"
    // GET
    // URI //hello-world,

    //@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    @GetMapping(path = "/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    // URI //hello-world-BEAN
    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World");
    }

    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }
}
