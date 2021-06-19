package com.mycompany.springapp.productapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "TAG_TABLE")
public class TagModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ID")
    private Long id;

    @Column(name ="TAG_NAME")
    private String name;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)//To avoid circular referencing while deserialization
    @ManyToMany(mappedBy = "tags")
    private Set<PostModel> posts = new HashSet<>();

    public TagModel(){

    }
    public TagModel(String name){
        this.name  = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<PostModel> getPosts() {
        return posts;
    }

    public void setPosts(Set<PostModel> posts) {
        this.posts = posts;
    }
}
