package com.example.nijiDBuseReact.contoroller;

import com.example.nijiDBuseReact.entity.Member;
import com.example.nijiDBuseReact.service.NijidbService;
import com.google.api.services.youtube.model.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class NjidbController {
    @Autowired
    private NijidbService njService;

    @GetMapping("/nijidb")
    public List<Member> main() throws IOException {
        List<Member> memberInfoList = njService.getAllMemberInfo();
        return memberInfoList;
    }
}
