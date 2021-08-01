package com.example.nijiDBuseReact.service;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.ChannelListResponse;
import org.springframework.stereotype.Service;


import java.io.IOException;

@Service
public class NijidbService {
    private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
    private static final com.google.api.client.json.JsonFactory JSON_FACTORY = new JacksonFactory();

    YouTube youtube = new YouTube.Builder(HTTP_TRANSPORT, JSON_FACTORY, new HttpRequestInitializer() {
        public void initialize(HttpRequest request) throws IOException {
        }
    }).setApplicationName("youtube-cmdline-search-sample").build();

    //APIキー
    String key = "AIzaSyCfLSCfatZoJJ7asA404PkrZG5lf4Servc";
    //検索実行
    ChannelListResponse channelsResponse;
}
