package ua.lviv.lgs.admissionsCommittee.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.admissionsCommittee.dao.FacultyRepository;
import ua.lviv.lgs.admissionsCommittee.domain.Faculty;

@Service
public class FacultyService {
	
	private Logger logger = LoggerFactory.getLogger(FacultyService.class);

	@Autowired
	private FacultyRepository facultyRepository;

	public Faculty save(Faculty faculty) {
		logger.info("Created  new faculty" + faculty);

		return facultyRepository.save(faculty);

	}

	public List<Faculty> getAllFaculty() {
		logger.info("Get  all faculties");

		return facultyRepository.findAll();

	}
	
	public Faculty findById(Integer id) {
		logger.info("Get  faculty  by Id: " + id);
		return facultyRepository.findById(id).get();
	}

}
