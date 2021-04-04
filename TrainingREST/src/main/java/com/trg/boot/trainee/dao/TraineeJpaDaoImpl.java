package com.trg.boot.trainee.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trg.boot.trainee.dto.Trainee;
import com.trg.boot.trainee.exception.DuplicateTraineeException;
import com.trg.boot.trainee.repo.TraineeJpaRepository;


@Component("jpaDao")
public class TraineeJpaDaoImpl implements TraineeDao{
	@Autowired
	TraineeJpaRepository repository;

	@Override
	public void save(Trainee t) throws DuplicateTraineeException {
		if(repository.existsById(t.getTid()))
			throw new DuplicateTraineeException("trainee with"+t.getTid()+"already exits");
		repository.save(t);
	}

	@Override
	public boolean update(Trainee t) {
		if(repository.existsById(t.getTid())) {
			repository.save(t);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		if(repository.existsById(id))
			repository.deleteById(id);
		return false;
	}

	@Override
	public Trainee getTrainee(int id) {
		Optional<Trainee> opt=repository.findById(id);
		if(opt.isPresent()) {
			 return opt.get();
		}
		return null;
	}

	@Override
	public List<Trainee> getAllTrainees() {
		List<Trainee> list=(List)repository.findAll();
		return list;
	}

	
}
