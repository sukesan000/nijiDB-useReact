package com.example.nijiDBuseReact.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="nijiDB")
public class Member {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="channel_id")
    private String channel_id;

    @Column(name="subscriber")
    private String subscriber;

    @Column(name="video_count")
    private String video_count;
}
