package com.chatdata.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chatdata.Dao.BlogDaoInt;
import com.chatdata.model.Blog;



@RestController
public class BlogController {
	@Autowired
	private BlogDaoInt blogDao;
	
	@PostMapping("/blogDetails")
	public ResponseEntity<Blog> addBlog(@RequestBody Blog blog){
		blogDao.addBlog(blog);
		System.out.println(blog.getBlogId());
				return new ResponseEntity<Blog>(blog,HttpStatus.OK);				
		}
	@GetMapping("/reqDeleteBlog")
	public ResponseEntity<Blog> deleteBlog(@RequestParam ("blogId") String blogId){
		System.out.println(blogId);
		 blogDao.deleteBlog(blogId);
      return new ResponseEntity<Blog>(HttpStatus.OK);		
	}
	@GetMapping("/getblog")
	public ResponseEntity<Blog> getBlog(@RequestParam ("blogId") String blogId){
		System.out.println(blogId);
		Blog blog=blogDao.getBlog(blogId);
		return new ResponseEntity<Blog>(HttpStatus.OK);
	}
	
	
	@PostMapping("/reqeditblog")
	public ResponseEntity<Blog> editBlog(@RequestBody Blog blog){
		blogDao.editBlog(blog);
		return new ResponseEntity<Blog>(blog,HttpStatus.OK);
	}
}
