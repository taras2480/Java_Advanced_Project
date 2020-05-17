package ua.lviv.lgs.admissionsCommittee.service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import ua.lviv.lgs.admissionsCommittee.domain.Faculty;
import ua.lviv.lgs.admissionsCommittee.domain.SubjectsOfAttestation;



public class FacultyDTOHelper {
	
	public static Faculty createEntity(MultipartFile file, String nameFaculty,Integer amountOfStudents,
			List<SubjectsOfAttestation> subjects, List<Integer> ratings, Boolean approved, Integer summaryRating ) throws IOException {
		
		Faculty faculty = new Faculty();
		faculty.setNameFaculty(nameFaculty);
		faculty.setAmountOfStudents(amountOfStudents);
		faculty.setSubjects(subjects);
		faculty.setRatings(ratings);
		faculty.setApproved(approved);
		faculty.setSummaryRating(summaryRating);
		faculty.setEncodedImage(Base64.getEncoder().encodeToString(file.getBytes()));
		return faculty;
	}

}
