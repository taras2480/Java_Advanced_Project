package ua.lviv.lgs.admissionsCommittee.service;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;

import org.springframework.web.multipart.MultipartFile;

import ua.lviv.lgs.admissionsCommittee.domain.Faculty;
import ua.lviv.lgs.admissionsCommittee.domain.SubjectsAndRatings;
import ua.lviv.lgs.admissionsCommittee.domain.SubjectsOfAttestation;



public class FacultyDTOHelper {
	
	public static Faculty createEntity(MultipartFile file, String nameFaculty,Integer amountOfStudents, HashMap<SubjectsOfAttestation,Integer> subjectAndRating,
			 Boolean approved, Integer summaryRating ) throws IOException {
		
		SubjectsAndRatings subjectsAndRatings = new SubjectsAndRatings();
		
		
		Faculty faculty = new Faculty();
		faculty.setNameFaculty(nameFaculty);
		faculty.setAmountOfStudents(amountOfStudents);
		subjectsAndRatings.setSubjectAndRating(subjectAndRating);
		faculty.setApproved(approved);
		faculty.setSummaryRating(summaryRating);
		faculty.setEncodedImage(Base64.getEncoder().encodeToString(file.getBytes()));
		return faculty;
	}

}
