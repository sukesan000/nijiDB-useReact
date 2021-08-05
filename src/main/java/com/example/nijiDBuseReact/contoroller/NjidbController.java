package com.example.nijiDBuseReact.contoroller;

import com.example.nijiDBuseReact.entity.Member;
import com.example.nijiDBuseReact.service.NijidbService;
import com.google.api.services.youtube.model.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class NjidbController {
    @Autowired
    private NijidbService njService;

    @GetMapping("/")
    public String main() throws IOException {
        List<Member> list = new ArrayList<Member>();
        list = njService.getAllChannelId();
        List<Channel> channelInfoList = njService.getChannelInfo(list);
        System.out.println(channelInfoList);
        return "nijiDB";
    }
}
