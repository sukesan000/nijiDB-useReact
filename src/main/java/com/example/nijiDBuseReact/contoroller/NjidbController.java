package com.example.nijiDBuseReact.contoroller;

import com.example.nijiDBuseReact.entity.Member;
import com.example.nijiDBuseReact.service.NijidbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "*")
public class NjidbController {
    @Autowired
    private NijidbService njService;
    Logger logger = Logger.getLogger("NjidbController   ");

    @GetMapping("/nijidb")
    public List<Member> main() throws IOException {
        List<Member> memberInfoList = njService.getAllMemberInfo();
        return memberInfoList;
    }

    @PostMapping("/nijidb/search/{word}")
    public List<Member> search(@PathVariable("word") String keyword){
        List<Member> memberInfoList = njService.findMember(keyword);
        logger.info("メンバーを取得しました");
        return memberInfoList;
    }
}
