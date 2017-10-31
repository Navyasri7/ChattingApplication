package com.chatdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chatdata.Dao.JobDaoInt;

import com.chatdata.model.Job;


@RestController
public class JobController {
	@Autowired
	private JobDaoInt jobDao;
	@PostMapping("/addJob")
	public ResponseEntity<Job> addJobDetails(@RequestBody Job job){
		jobDao.addJob(job);
		System.out.println(job.getId());
				return new ResponseEntity<Job>(job,HttpStatus.OK);

}
@GetMapping("/reqDeleteJob")
public ResponseEntity<Job> deleteJob(@RequestParam ("id") String id){
		System.out.println(id);
		jobDao.deleteJob(id);
      return new ResponseEntity<Job>(HttpStatus.OK);		
	}

@PostMapping("/reqeditjob")
public ResponseEntity<Job> editJob(@RequestBody Job job){
	jobDao.editJob(job);
	return new ResponseEntity<Job>(job,HttpStatus.OK);
}
}
