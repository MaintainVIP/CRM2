package com.quinn.crm.post.dao.impl;


import com.quinn.crm.post.dao.PostDao;
import com.quinn.crm.post.domain.Post;
import org.hibernate.LockMode;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;
public class PostDaoImpl extends HibernateDaoSupport implements PostDao{

    @Override
    public List<Post> findAll() {
        return getHibernateTemplate().loadAll(Post.class);
    }
    @Override
    public Post findPostById(String postId) {
        return getHibernateTemplate().load(Post.class,postId, LockMode.READ);
    }

    @Override
    public void addOrEditPosts(Post post) {
        getHibernateTemplate().saveOrUpdate(post);
    }

    @Override
    public List<Post> findPostByDeptId(String deptId) {

        String sql = "from Post where dept.deptId = ?";

        List<Post> depts = (List<Post>) getHibernateTemplate().find(sql, deptId);

        return depts;
    }

    @Override
    public List find(Object o) {
        return null;
    }

    @Override
    public void save(Object o) {

    }

    @Override
    public void update(Object o) {

    }

    @Override
    public void delete(Object o) {

    }

}
