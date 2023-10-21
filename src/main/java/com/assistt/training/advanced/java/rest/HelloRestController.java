package com.assistt.training.advanced.java.rest;

import com.assistt.training.advanced.java.collections.Person;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

//@Controller
//@ResponseBody

@RestController
@RequestMapping("/hello")
public class HelloRestController {

    // /hello/hello1/osman -> GET
    // @RequestMapping(value = "/hello1",method = RequestMethod.GET)
    @GetMapping("/hello1/{is}")

    public String hello(@PathVariable("is") String name) {
        return "Hello world " + name;
    }

    // /hello/hello2?is=osman
    @GetMapping("/hello2")
    public String hello2(@RequestParam("is") String name) {
        return "Hello world 2 " + name;
    }

    @GetMapping("/hello3/{name}")
    public String hello3(@PathVariable String name,
                         @RequestParam("soy") String surname) {
        return "Hello world 3 " + name + " " + surname;
    }

    @GetMapping("/hello4/{name}")
    public String hello4(@PathVariable String name,
                         @MatrixVariable("soy") String surname) {
        return "Hello world 4 " + name + " " + surname;
    }

    @PostMapping("/hello5")
    @Operation(description = "deneme desc", summary = "test sum")
    public String hello5(@Valid @RequestBody Person personParam) {
        return "Hello 5 " + personParam;
    }

}
