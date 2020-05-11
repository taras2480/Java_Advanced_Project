package ua.lviv.lgs.admissionsCommittee.service;

import java.io.IOException;
import java.util.Base64;

import org.springframework.web.multipart.MultipartFile;

import ua.lviv.lgs.admissionsCommittee.domain.Faculty;



public class FacultyDTOHelper {
	
	public static Faculty createEntity( String nameFaculty,Integer amountOfStudents,
			String subjects,MultipartFile file ) throws IOException {
		
		Faculty faculty = new Faculty();
		faculty.setNameFaculty(nameFaculty);
		faculty.setAmountOfStudents(amountOfStudents);
		faculty.setSubjects(subjects);
		faculty.setEncodedImage(Base64.getEncoder().encodeToString(file.getBytes()));
		return faculty;
	}

}
