package com.example.nijiDBuseReact.contoroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NjidbController {
    @GetMapping("/nnijidb")
    public String main(){
        return "nijiDB";
    }
}
