package com.quinn.crm.post.service.impl;


import com.quinn.crm.post.dao.PostDao;
import com.quinn.crm.post.domain.Post;
import com.quinn.crm.post.service.PostService;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Resource;
import java.util.List;

public class PostServiceImpl implements PostService {

    private PostDao postDao;

    @Override
    public List<Post> findAll() {
        return postDao.findAll();
    }

    @Override
    public void addOrEditPost(Post post) {
        if (StringUtils.isBlank(post.getPostId())){
            post.setPostId(null);
        }
        postDao.addOrEditPosts(post);
    }

    @Override
    public Post findPostById(String postId) {
        return postDao.findPostById(postId);
    }

    @Override
    public List<Post> findPostByDeptId(String deptId) {
        return postDao.findPostByDeptId(deptId);
    }

    public PostDao getPostDao() {
        return postDao;
    }

    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }
}
