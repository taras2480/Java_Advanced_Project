package ua.lviv.lgs.admissionsCommittee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.admissionsCommittee.dao.FacultyRepository;
import ua.lviv.lgs.admissionsCommittee.domain.Faculty;

@Service
public class FacultyService {

	@Autowired
	private FacultyRepository facultyRepository;

	public Faculty save(Faculty faculty) {

		return facultyRepository.save(faculty);

	}

	public List<Faculty> getAllFaculty() {

		return facultyRepository.findAll();

	}
	
	public Faculty findById(Integer id) {
		return facultyRepository.findById(id).get();
	}

}
