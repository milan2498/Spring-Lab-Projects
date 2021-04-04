package com.trg.boot.trainee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.trg.boot.trainee.dao.TraineeDao;
import com.trg.boot.trainee.dto.Trainee;
import com.trg.boot.trainee.exception.DuplicateTraineeException;
@Service
public class TraineeServiceImpl implements TraineeService{
	@Autowired
	@Qualifier("jpaDao")
	TraineeDao dao;
	
	@Override
	public boolean add(Trainee t) {
		try {
			dao.save(t);
			return true;
		}
		catch(DuplicateTraineeException t1) {
			return false;
		}
	}

	@Override
	public boolean update(Trainee t) {
		return dao.update(t);
	}

	@Override
	public boolean delete(int id) {
		return dao.delete(id);
	}

	@Override
	public Trainee get(int id) {
		return dao.getTrainee(id);
	}

	@Override
	public List<Trainee> getAll() {
		return dao.getAllTrainees();
	}
	
}
