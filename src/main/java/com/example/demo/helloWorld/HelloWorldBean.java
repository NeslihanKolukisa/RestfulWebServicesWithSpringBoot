package com.example.demo.helloWorld;

public class HelloWorldBean {
    private String message;
    public HelloWorldBean() {
    }

    public HelloWorldBean(String hello_world) {
        this.message=hello_world;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "nesli='" + message + '\'' +
                '}';
    }
}
