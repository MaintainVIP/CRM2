package com.quinn.crm.post.dao;


import com.quinn.crm.post.domain.Post;
import com.quinn.crm.utils.BaseDao;

import java.util.List;

public interface PostDao extends BaseDao{

    List<Post> findAll();

    Post findPostById(String postId);

    void addOrEditPosts(Post post);

    List<Post> findPostByDeptId(String deptId);
}
