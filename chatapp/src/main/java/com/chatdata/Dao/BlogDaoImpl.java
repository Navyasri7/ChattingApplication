package com.chatdata.Dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chatdata.model.Blog;
@Repository("blogDao")
@Transactional
public class BlogDaoImpl implements BlogDaoInt {
	
	@Autowired
	private SessionFactory sessionFactory;
	public boolean addBlog(Blog blog) {
		Session session=sessionFactory.getCurrentSession();
		 try{
			 session.save(blog);
			 return true;
		 }catch(Exception e)
		 {
			 System.out.println(e.getMessage());
			 return false;
		 }
	}

	public void deleteBlog(String blogId) {
		Session session=sessionFactory.getCurrentSession();
		Blog blog=session.get(Blog.class,blogId);
		session.delete(blog);
		

	}

	public void editBlog(Blog blog) {
		Session session = sessionFactory.getCurrentSession();
		session.update(blog);
	}

	public Blog getBlog(String blogId) {
		Session session=sessionFactory.getCurrentSession();
		Blog blog=(Blog)session.get(Blog.class, blogId);
		return blog;
	}

	public List<Blog> getAllBlogs() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Blog");
		return query.getResultList();
	}

}
