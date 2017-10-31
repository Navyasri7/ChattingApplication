package com.chatdata.Dao;

import com.chatdata.model.Blog;

public interface BlogDaoInt {
 boolean addBlog(Blog blog);
 public void deleteBlog(String blogId);
 public void editBlog(Blog blog);
 public Blog getBlog(String blogId);
}
