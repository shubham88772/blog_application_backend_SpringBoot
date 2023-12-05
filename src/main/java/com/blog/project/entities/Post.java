package com.blog.project.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "post_title",length = 100,nullable = false)
    private String title;
    @Column(length = 1000)
    private String content;
    private String imageName;
    private Date addedDate;
    @ManyToOne
    private Category category;
    @ManyToOne
    private User user;

}
