package com.trg.boot.trainee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trg.boot.trainee.dto.Trainee;
import com.trg.boot.trainee.service.TraineeService;

@RestController
@RequestMapping("trainees")
public class TraineeController {
	@Autowired
	TraineeService service;
	
	@GetMapping
	public List<Trainee> getAllTrainee(){
		return service.getAll();
	}
	
	@GetMapping("{tid}")
	public ResponseEntity<?> getTrainee(@PathVariable("tid") int tid) {
		Trainee t=service.get(tid);
		if(t==null)
			return new ResponseEntity<String>("Trainee with id "+tid+" not found",HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Trainee>(t,HttpStatus.OK) ;
	}
	/*@GetMapping("{tname}")
	public ResponseEntity<?> getTrainee(@PathVariable("tname") String tname) {
		Trainee t=service.
		if(t==null)
			return new ResponseEntity<String>("Trainee with id "+tid+" not found",HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Trainee>(t,HttpStatus.OK) ;
	}*/
	
	@DeleteMapping("{tid}")
	public String deleteTrainee(@PathVariable("tid") int tid) {
		if(service.delete(tid))
			return "data deleted";
		else
			return "data not exists";
	}
	@PostMapping("{tid}/{tname}/{tdomain}/{tloc}")
	public String insertTrainee(@PathVariable("tid") int tid,@PathVariable("tname") String tname,@PathVariable("tdomain") String tdomain,@PathVariable("tloc") String tloc ) {
		Trainee t=new Trainee();
		t.setTid(tid);
		t.setTname(tname);
		t.setTdomain(tdomain);
		t.setTloc(tloc);
		if (service.add(t))
			return "trainee data successfully added";
		else
			return "trainee data is duplicated";
	}
	@PatchMapping("{tid}/{tname}")
	public String updateTraineeName(@PathVariable("tid") int tid,@PathVariable("tname") String tname) {
		Trainee t=service.get(tid);
		if(t==null)
			return "trainee for name update nt found";
		t.setTname(tname);
		service.update(t);
		return "trainee name update successfully";
	}
	@PatchMapping("{tid}/{tdomain}")
	public String updateTraineeDomain(@PathVariable("tid") int tid,@PathVariable("tdomain") String tdomain) {
		Trainee t=service.get(tid);
		if(t==null)
			return "trainee for domain update nt found";
		t.setTdomain(tdomain);
		service.update(t);
		return "trainee domain update successfully";
	}
	@PatchMapping("{tid}/{tloc}")
	public String updateTraineeLoc(@PathVariable("tid") int tid,@PathVariable("tloc") String tloc) {
		Trainee t=service.get(tid);
		if(t==null)
			return "trainee for location update nt found";
		t.setTloc(tloc);
		service.update(t);
		return "trainee location update successfully";
	}
}
