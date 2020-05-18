package de.stefanschade.primefacesshowcase.backend.controller;

import de.stefanschade.primefacesshowcase.backend.entities.HelloWorld;
import de.stefanschade.primefacesshowcase.backend.entities.SimpleEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloWorldController {

    private final String[] COUNTING = {"one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine", "ten"};

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/helloworld")
    public HelloWorld helloWorld(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new HelloWorld(counter.incrementAndGet(), String.format(template, name), new SimpleEntity("hallo", 1));
    }

    @GetMapping("/helloworldlist")
    public List<HelloWorld> helloWorldList() {
        List<HelloWorld> returnValue = new ArrayList<>();
        for(int i=0;i<10;i++) {
            returnValue.add(new HelloWorld(i+1,COUNTING[i], new SimpleEntity(COUNTING[i],i)));
        }
        return returnValue;
    }
}