package com.mycompany.springapp.productapp.service;

import com.mycompany.springapp.productapp.model.PostModel;
import com.mycompany.springapp.productapp.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository pr;
    public Iterable<PostModel> getAllPost(){
        Iterable<PostModel> postModellist = pr.findAll();
        return postModellist;
    }

    public PostModel createPost(PostModel postModel){
        postModel = pr.save(postModel);
        return postModel;
    }
}
