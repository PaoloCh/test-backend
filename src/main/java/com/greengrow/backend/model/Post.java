package com.greengrow.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="title", length =50, nullable=false)
    private String title;

    @Column(name = "author", length =50, nullable=false)
    private String author;

    @Column(name = "date", length =10, nullable=false)
    private String date;

    @Column(name = "image", length =200, nullable=false)
    private String image;

    @Column(name = "description", length =150, nullable=false)
    private String description;

    @Column(name = "views", length =6, nullable=false)
    private int views;

    @Column(name = "likes", length =6, nullable=false)
    private int likes;

    @Column(name = "comments", length =6, nullable=false)
    private int comments;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "post_tags", joinColumns = @JoinColumn(name = "post_id"))
    @Column(name = "tag", length =25, nullable=false)
    private List<String> tags;
}
