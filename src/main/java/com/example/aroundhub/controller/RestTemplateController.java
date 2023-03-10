package com.example.aroundhub.controller;

import com.example.aroundhub.dto.MemberDTO;
import com.example.aroundhub.service.RestTemplateService;
import com.example.aroundhub.service.impl.RestTemplateServiceImpl;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/rest-template")
public class RestTemplateController {

    RestTemplateService restTemplateService;

    @Autowired
    public RestTemplateController(RestTemplateService restTemplateService){
        this.restTemplateService = restTemplateService;
    }

    @GetMapping("/around-hub")
    public String getAroundHub(){
        return restTemplateService.getAroundHub();
    }

    @GetMapping("/name")
    public String getName(){
        return restTemplateService.getName();
    }

    @GetMapping("/name2")
    public String getName2(){
        return restTemplateService.getName2();
    }

    @PostMapping("/dto")
    public ResponseEntity<MemberDTO> postDto(){
        return restTemplateService.postDto();
    }

    @PostMapping("/add-header")
    public ResponseEntity<MemberDTO> addHeader(){
        return restTemplateService.addHeader();
    }


}
