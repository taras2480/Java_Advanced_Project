package ua.lviv.lgs.admissionsCommittee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.admissionsCommittee.dao.HappyFutureStudentsRepository;
import ua.lviv.lgs.admissionsCommittee.domain.HappyFutureStudents;

@Service
public class HappyFutureStudentsService {
	
	@Autowired
	private HappyFutureStudentsRepository happyFutureStudentsRepository;

	public HappyFutureStudents save(HappyFutureStudents happyFutureStudents) {
		return happyFutureStudentsRepository.save(happyFutureStudents);
	}

	public List<HappyFutureStudents> findAllHappyFutureStudents() {
		return happyFutureStudentsRepository.findAll();
	}

}
