package ua.lviv.lgs.admissionsCommittee.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.admissionsCommittee.dao.HappyFutureStudentsRepository;
import ua.lviv.lgs.admissionsCommittee.domain.HappyFutureStudents;

@Service
public class HappyFutureStudentsService {
	
	private Logger logger = LoggerFactory.getLogger(HappyFutureStudentsService.class);
	
	@Autowired
	private HappyFutureStudentsRepository happyFutureStudentsRepository;

	public HappyFutureStudents save(HappyFutureStudents happyFutureStudents) {
		
		logger.info("Added  new happy Students" + happyFutureStudents);
		return happyFutureStudentsRepository.save(happyFutureStudents);
	}

	public List<HappyFutureStudents> findAllHappyFutureStudents() {
		logger.info("Get  all students");
		return happyFutureStudentsRepository.findAll();
	}

}
