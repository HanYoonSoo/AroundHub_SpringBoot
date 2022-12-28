package com.example.aroundhub.controller;

import com.example.aroundhub.dto.MemberDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/v1/post-api")
public class PostController {

    @PostMapping("/default")
    public String postMethod(){
        return "Hello World";
    }

    // HTTP://LOCALHOST:8080/API/V1/POST-API/MEMBER
    @PostMapping("/member")
    public String postMember(@RequestBody Map<String, Object> postData){
        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    // http://localhost:8080/api/v1/post-api/member2
    @PostMapping("/member2")
    public String postMember(@RequestBody MemberDTO memberDTO) {
        return memberDTO.toString();
    }
}
