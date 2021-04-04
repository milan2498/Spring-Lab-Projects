package com.trg.boot.trainee.dao;

import java.util.List;

import com.trg.boot.trainee.dto.Trainee;
import com.trg.boot.trainee.exception.DuplicateTraineeException;



public interface TraineeDao {
	void save(Trainee t) throws DuplicateTraineeException;
	boolean update(Trainee t);
	boolean delete(int id);
	Trainee getTrainee(int id);
	List<Trainee> getAllTrainees();
}
