package com.greengrow.backend.service.impl;

import com.greengrow.backend.model.Post;
import com.greengrow.backend.repository.PostRepository;
import com.greengrow.backend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post createPost(Post post){
        return postRepository.save(post);
    }
}
