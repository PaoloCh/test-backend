package com.greengrow.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name", length =150, nullable=false)
    private String name;

    @Column(name="image", length =200, nullable=false)
    private String image;

    @Column(name="description", length =150, nullable=false)
    private String description;

    @Column(name="price", length =6, nullable=false)
    private String price;

    @Column(name="rating", length =3, nullable=false)
    private String rating;

    @Column(name="duration", length =3, nullable=false)
    private String duration;

    @Column(name="category", length = 150, nullable=false)
    private String category;

    @Column(name="date", length =30, nullable=false)
    private String date;
}
