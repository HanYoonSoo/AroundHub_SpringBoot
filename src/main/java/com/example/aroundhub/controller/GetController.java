package com.example.aroundhub.controller;

import com.example.aroundhub.dto.MemberDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

    @GetMapping("/hello")
    public String getHello(){
        return "Hello World";
    }

    @GetMapping("/name")
    public String getName(){
        return "YoonSoo";
    }

    @GetMapping("/variable1/{variable}")
    public String getVariable1(@PathVariable String variable){
        return variable;
    }

    @GetMapping("/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var){
        return var;
    }

    // http://localhost:8080/api/v1/get-api/request1?name=yoonsoo&email=cya0405@naver.com&organization=yesin
    @GetMapping("/request1")
    public String getRequestParam1(
        @RequestParam String name,
        @RequestParam String email,
        @RequestParam String organization){
        return name + " " + email + " " + organization;
    }

    // http://localhost:8080/api/v1/get-api/request2?key1=value1&key2=value2
    @GetMapping("/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param){
        StringBuilder sb = new StringBuilder();

        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    // http://localhost:8080/api/v1/get-api/request3?name=yoonsoo&email=cya0405@naver.com&organization=yesin
    @GetMapping("/request3")
    public String getRequestParam3(MemberDTO memberDTO){
        return memberDTO.toString();
    }
}
