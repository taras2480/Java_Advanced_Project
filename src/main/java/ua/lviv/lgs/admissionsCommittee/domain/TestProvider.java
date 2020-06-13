package ua.lviv.lgs.admissionsCommittee.domain;

import java.util.ArrayList;
import java.util.List;

public class TestProvider {

	public static Faculty createNewFaculty() {
		Faculty faculty = new Faculty();
		faculty.setNameFaculty("1");
		faculty.setAmountOfStudents(5);
		faculty.setSubjects(createListSubjects());

		return faculty;
	}
	
	// Size must be 4
	public static List<SubjectsOfAttestation> createListSubjects() {

		ArrayList<SubjectsOfAttestation> subjectsOfAttestation = new ArrayList<>();
		subjectsOfAttestation.add(SubjectsOfAttestation.BIOLOGY);
		subjectsOfAttestation.add(SubjectsOfAttestation.ENGLISH);
		subjectsOfAttestation.add(SubjectsOfAttestation.HISTORY);
		subjectsOfAttestation.add(SubjectsOfAttestation.MUSIC);

		return subjectsOfAttestation;

	}

}
