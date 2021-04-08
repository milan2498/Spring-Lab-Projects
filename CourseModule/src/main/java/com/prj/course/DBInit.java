package com.prj.course;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.prj.course.dto.Course;
import com.prj.course.repo.CourseRepository;


@Component
public class DBInit  implements CommandLineRunner{
	@Autowired
	CourseRepository repo;
	@Override
	public void run(String...args) throws Exception{
		Logger logger=LoggerFactory.getLogger(DBInit.class);
		logger.info("h2 database COURSE DATABASE created");
		repo.save(new Course(100,"B.com","3 years",LocalDate.now(),LocalDate.now().plus(3, ChronoUnit.YEARS),"300000"));
		repo.save(new Course(200,"B.Sc","3 years",LocalDate.now(),LocalDate.now().plus(3, ChronoUnit.YEARS),"350000"));
		repo.save(new Course(300,"B.Tech","4 years",LocalDate.now(),LocalDate.now().plus(4, ChronoUnit.YEARS),"700000"));
		repo.save(new Course(400,"B.A.","3 years",LocalDate.now(),LocalDate.now().plus(3, ChronoUnit.YEARS),"200000"));
		repo.save(new Course(500,"B.Ed","2 years",LocalDate.now(),LocalDate.now().plus(2, ChronoUnit.YEARS),"175000"));
		

		
		logger.info("6 rows inserted into table");
	/*	List<Employee> ls = repo.findByName("Kunal");
		System.out.println(ls);
		
		List<Employee> ls1 = repo.findBySalary(12500);
		System.out.println(ls1);
		
		List<Employee> ls2 = repo.givemeSalary(12500, 40000);
		System.out.println(ls2);
		
		List<Employee> ls3 = repo.giveByPattern("r%");
		System.out.println(ls3);*/

	}
	
	
	
}
