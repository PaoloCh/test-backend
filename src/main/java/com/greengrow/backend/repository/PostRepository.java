package com.greengrow.backend.repository;

import com.greengrow.backend.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long>{
    Boolean existsByTitle(String title);
}
