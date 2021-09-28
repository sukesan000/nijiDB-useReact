package com.example.nijiDBuseReact.entity;

import com.google.api.client.util.DateTime;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="nijiDB")
public class Member {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="channel_id")
    private String channel_id;

    @Column(name="subscriber")
    private String subscriber;

    @Column(name="video_count")
    private String video_count;

    @Column(name="thumbnail")
    private String thumbnail;

    @Column(name="published_at")
    private Date published_at;
}
