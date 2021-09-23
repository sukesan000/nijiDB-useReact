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

    public void updateOne(String subscriber, String videoCount, String thumbnail, String chId) {
        jdbcTemplate.update(
                "U PDATE member SET subscriber = ?, video_count = ?, thumbnail = ? WHERE channel_id = ?", subscriber, videoCount, thumbnail, chId);
    };

    public void insertOne(String chId , String name) {
        jdbcTemplate.update(
                "INSERT INTO member (channel_id, name) select ?, ? WHERE NOT EXISTS (select channel_id from member where channel_id = ?)", chId, name, chId);
    };

    public List<Member> getALLChannelInfo(){
        String sql = "select * from member";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        List<Member> memberList = new ArrayList<Member>();
        for(Map<String, Object> result : list){
            Member member = new Member();
            //member.setId((int)result.get("id"));
            member.setChannel_id((String)result.get("channel_id"));
            member.setName((String)result.get("name"));
            member.setSubscriber((String)result.get("subscriber"));
            member.setThumbnail((String)result.get("thumbnail"));
            member.setVideo_count((String)result.get("video_count"));
            memberList.add(member);
        }
        return memberList;
    }
}
