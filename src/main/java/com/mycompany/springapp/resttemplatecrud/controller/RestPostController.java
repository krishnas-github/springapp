package com.mycompany.springapp.resttemplatecrud.controller;

import com.mycompany.springapp.resttemplatecrud.model.CommentModel;
import com.mycompany.springapp.resttemplatecrud.model.RestPostModel;
import com.mycompany.springapp.resttemplatecrud.service.RestPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class RestPostController {
    @Autowired
    RestPostService restPostService;

    @GetMapping("/posts")
    public RestPostModel[] getAllPosts(){
        RestPostModel[] response = restPostService.getAllPosts();
        return response;
    }

    @GetMapping("/posts/{postId}/comments")
    public CommentModel[] getAllCommentsForApost(@PathVariable("postId") Long postId){
        return restPostService.getAllCommentsForApost(postId);

    }

    @PostMapping("/posts")
    public RestPostModel createPost(@RequestBody RestPostModel restPostModel){
        RestPostModel model = restPostService.createPost(restPostModel);
        return model;
    }

    @PutMapping("/posts/{postId}")
    public RestPostModel updatePost(@RequestBody RestPostModel restPostModel,@PathVariable("postId") Long postId){
        RestPostModel model = restPostService.updatePost(restPostModel,postId);
        return model;
    }

    @DeleteMapping("/posts/{postId}")
    public void deletePost(@PathVariable("postId") Long postId){
        restPostService.deletePost(postId);
    }
}
