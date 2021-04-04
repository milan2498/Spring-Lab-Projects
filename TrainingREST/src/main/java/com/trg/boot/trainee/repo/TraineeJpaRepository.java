package com.trg.boot.trainee.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trg.boot.trainee.dto.Trainee;

@Repository
public interface TraineeJpaRepository extends CrudRepository<Trainee, Integer> {

}
