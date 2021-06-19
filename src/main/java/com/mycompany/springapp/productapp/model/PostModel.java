package com.mycompany.springapp.productapp.model;

import org.springframework.core.metrics.StartupStep;

import javax.management.Descriptor;
import javax.persistence.*;
import javax.swing.text.html.HTML;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity(name ="POST_TABLE")
public class PostModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ID")
    private Long id;

    @Column(name= "TITLE")
    private String title;

    @Column(name ="DESCRIPTION")
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name ="posted_at")
    private Date postedAt = new Date();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "post_tags",
                joinColumns = {@JoinColumn(name = "post_id")},
                inverseJoinColumns = {@JoinColumn(name ="tag_id")})
    private Set<TagModel> tags =new HashSet<>();

    public PostModel(){

    }

    public PostModel(String title, String description){
        this.title =title;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(Date postedAt) {
        this.postedAt = postedAt;
    }

    public Set<TagModel> getTags() {
        return tags;
    }

    public void setTags(Set<TagModel> tags) {
        this.tags = tags;
    }
}
