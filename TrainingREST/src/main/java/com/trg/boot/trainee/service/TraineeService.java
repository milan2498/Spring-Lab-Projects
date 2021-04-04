package com.trg.boot.trainee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.trg.boot.trainee.dto.Trainee;
import com.trg.boot.trainee.exception.DuplicateTraineeException;
import com.trg.boot.trainee.repo.TraineeJpaRepository;

@Service
public interface TraineeService{
	
	Trainee get(int id);
	List<Trainee> getAll();
	boolean add(Trainee t);
	boolean update(Trainee t);
	boolean delete(int id);
	
	
	
	}
