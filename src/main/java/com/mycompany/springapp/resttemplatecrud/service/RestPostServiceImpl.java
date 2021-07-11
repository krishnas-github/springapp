package com.mycompany.springapp.resttemplatecrud.service;

import com.mycompany.springapp.resttemplatecrud.model.CommentModel;
import com.mycompany.springapp.resttemplatecrud.model.RestPostModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestPostServiceImpl implements RestPostService {
    @Value("${external.api.url}")
    private String postApiBaseUrl;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public RestPostModel[] getAllPosts() {
        RestPostModel[] result = restTemplate.getForObject(postApiBaseUrl+"/posts", RestPostModel[].class);
        //System.out.println(result);
        return result;
    }

    @Override
    @Cacheable(cacheNames = "allcomentsCache", key = "#postId")
    public CommentModel[] getAllCommentsForApost(Long postId) {
        //https://jsonplaceholder.typicode.com/posts/1/comments
        CommentModel[] result = restTemplate.getForObject(postApiBaseUrl+"/posts/"+postId+"/comments", CommentModel[].class);
        return result;

    }

    @Override
    public RestPostModel createPost(RestPostModel restPostModel) {
        RestPostModel model = null;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<RestPostModel> httpEntity = new HttpEntity<>(restPostModel,headers);
        ResponseEntity<RestPostModel> newPostEntity = restTemplate.postForEntity(postApiBaseUrl+"/posts", httpEntity,RestPostModel.class);

        if(newPostEntity.getStatusCode() == HttpStatus.CREATED){
            model = newPostEntity.getBody();
        }
        return model;
    }
    @Override
    public RestPostModel updatePost(RestPostModel restPostModel, Long id) {
        RestPostModel model = null;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<RestPostModel> httpEntity = new HttpEntity<>(restPostModel,headers);
        ResponseEntity<RestPostModel> upPostEntity = restTemplate.exchange(postApiBaseUrl+"/posts/{id}",HttpMethod.PUT,httpEntity,RestPostModel.class,id);

        if(upPostEntity.getStatusCode() == HttpStatus.OK){
            model = upPostEntity.getBody();
        }
        return model;
    }
    @Override
    public void deletePost(Long id) {
        restTemplate.delete(postApiBaseUrl+"/posts/{id}", id);

    }

}
