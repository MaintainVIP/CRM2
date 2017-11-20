package com.quinn.crm.post.service;

import com.quinn.crm.post.domain.Post;

import java.util.List;

public interface PostService {


    List findAll();

    void addOrEditPost(Post post);

    Post findPostById(String postId);

    List<Post> findPostByDeptId(String deptId);

}
