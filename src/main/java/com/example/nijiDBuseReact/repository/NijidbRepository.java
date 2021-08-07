package com.example.nijiDBuseReact.repository;

import com.example.nijiDBuseReact.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class NijidbRepository {
    @Autowired
    private final JdbcTemplate jdbcTemplate;
    Member member;
    @Autowired
    public NijidbRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Member> getALLChannelId(){
        String sql = "select id, channel_id from member";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        List<Member> memberList = new ArrayList<Member>();
        for(Map<String, Object> result : list){
            Member member = new Member();
            member.setId((int)result.get("id"));
            member.setChannel_id((String)result.get("channel_id"));
            memberList.add(member);
        }
        return memberList;
    };

    public void insertOne(String subscriber, String videoCount, String thumbnail, int id) {
        jdbcTemplate.update(
                "UPDATE member SET subscriber = ?, video_count = ?, thumbnail = ? WHERE id = ?", subscriber, videoCount, thumbnail, id);
    }
}
