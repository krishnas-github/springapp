package com.mycompany.springapp.productapp.controller;

import com.mycompany.springapp.productapp.model.PostModel;
import com.mycompany.springapp.productapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostService ps;
    @GetMapping(value = "/postList")
    public ResponseEntity<Iterable<PostModel>> getAllPost(){
        Iterable<PostModel> list = ps.getAllPost();
        return (new ResponseEntity<Iterable<PostModel>>(list, HttpStatus.OK));
    }
    @PostMapping(value = "/post")
    public ResponseEntity<PostModel> createPost(@RequestBody PostModel postModel){
        postModel = ps.createPost(postModel);
        return new ResponseEntity<PostModel>(postModel,HttpStatus.CREATED);
    }
}
