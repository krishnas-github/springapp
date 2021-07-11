package com.mycompany.springapp.resttemplatecrud.service;

import com.mycompany.springapp.resttemplatecrud.model.CommentModel;
import com.mycompany.springapp.resttemplatecrud.model.RestPostModel;

public interface RestPostService {

    public RestPostModel[] getAllPosts();

    public CommentModel[] getAllCommentsForApost(Long postId);

    public RestPostModel createPost(RestPostModel restPostModel);

    public RestPostModel updatePost(RestPostModel restPostModel, Long postId);

    public void deletePost(Long postId);
}
