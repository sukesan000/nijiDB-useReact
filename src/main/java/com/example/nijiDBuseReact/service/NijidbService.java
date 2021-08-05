package com.example.nijiDBuseReact.service;

import com.example.nijiDBuseReact.entity.Member;
import com.example.nijiDBuseReact.repository.NijidbRepository;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.Channel;
import com.google.api.services.youtube.model.ChannelListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class NijidbService {
    @Autowired
    private NijidbRepository nijidbRepository;
    private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
    private static final com.google.api.client.json.JsonFactory JSON_FACTORY = new JacksonFactory();
    //APIキー
    String key = "AIzaSyCfLSCfatZoJJ7asA404PkrZG5lf4Servc";
    //検索実行
    ChannelListResponse channelsResponse;

    public List<Channel> getChannelInfo(List<Member> chId_list) throws IOException {
        YouTube youtube = new YouTube.Builder(HTTP_TRANSPORT, JSON_FACTORY, new HttpRequestInitializer() {
            public void initialize(HttpRequest request) throws IOException {
            }
        }).setApplicationName("youtube-cmdline-search-sample").build();

        List<Channel> channelsList = new ArrayList<Channel>();

        for (Member member : chId_list) {
            String chId = member.getChannel_id();
            YouTube.Channels.List channelInfo = youtube.channels().list(Arrays.asList("id,snippet,statistics"));
            channelInfo.setKey(key);
            channelInfo.setId(Arrays.asList(chId));

            channelsResponse = channelInfo.execute();
            Channel channel = channelsResponse.getItems().get(0);
            channelsList.add(channel);
        }
        return channelsList;
    }

    public List<Member> getAllChannelId(){
        return nijidbRepository.getALLChannelId();
    }
}
