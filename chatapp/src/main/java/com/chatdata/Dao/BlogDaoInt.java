package com.chatdata.Dao;

import java.util.List;

import com.chatdata.model.Blog;

public interface BlogDaoInt {
 boolean addBlog(Blog blog);
 public void deleteBlog(String blogId);
 public void editBlog(Blog blog);
 public Blog getBlog(String blogId);
 public List<Blog> getAllBlogs();
 public List<Blog> waitingForApproval();
 public Blog blogApproved(Blog blog);
}
