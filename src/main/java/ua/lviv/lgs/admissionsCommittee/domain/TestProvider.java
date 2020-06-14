package ua.lviv.lgs.admissionsCommittee.domain;

import java.util.ArrayList;
import java.util.List;

public class TestProvider {

	public static User createNewUser() {
		User user = new User();
		user.setEmail("aviator2480@gmail.com");
		user.setFirstName("1");
		user.setLastName("1");
		user.setBirthday("15");
		user.setPassword("1");
		user.setConfirmPassword("1");
		user.setRole(UserRole.ROLE_USER);

		return user;
	}

	public static Faculty createNewFaculty() {
		Faculty faculty = new Faculty();
		faculty.setNameFaculty("1");
		faculty.setAmountOfStudents(5);
		faculty.setSubjects(createListSubjects());

		return faculty;
	}

	public static Faculty createNewFaculty1() {
		Faculty faculty = new Faculty();
		faculty.setNameFaculty("3");
		faculty.setAmountOfStudents(2);
		faculty.setSubjects(createListSubjects1());

		return faculty;
	}

	public static Faculty createNewFaculty2() {
		Faculty faculty = new Faculty();
		faculty.setNameFaculty("5");
		faculty.setAmountOfStudents(3);
		faculty.setSubjects(createListSubjects2());

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

	public static List<SubjectsOfAttestation> createListSubjects1() {

		ArrayList<SubjectsOfAttestation> subjectsOfAttestation = new ArrayList<>();
		subjectsOfAttestation.add(SubjectsOfAttestation.CHEMISTRY);
		subjectsOfAttestation.add(SubjectsOfAttestation.ENGLISH);
		subjectsOfAttestation.add(SubjectsOfAttestation.HISTORY);
		subjectsOfAttestation.add(SubjectsOfAttestation.MUSIC);

		return subjectsOfAttestation;

	}

	public static List<SubjectsOfAttestation> createListSubjects2() {

		ArrayList<SubjectsOfAttestation> subjectsOfAttestation = new ArrayList<>();
		subjectsOfAttestation.add(SubjectsOfAttestation.PHYSICAL_EDUCATION);
		subjectsOfAttestation.add(SubjectsOfAttestation.ENGLISH);
		subjectsOfAttestation.add(SubjectsOfAttestation.HISTORY);
		subjectsOfAttestation.add(SubjectsOfAttestation.MUSIC);

		return subjectsOfAttestation;

	}

	public static Notability createNewNotability() {

		Notability notability = new Notability();

		notability.setUser(createNewUser());
		notability.setFaculty(createNewFaculty());
		notability.setRatings(createListRatings());
		notability.setSumRating(notability.getSumRating());

		return notability;
	}
	
	//Size must be 4
	public static List<Integer> createListRatings() {

		ArrayList<Integer> ratings = new ArrayList<>();
		ratings.add(2);
		ratings.add(3);
		ratings.add(35);
		ratings.add(46);

		return ratings;

	}
	
	//Size must be 4
		public static List<Integer> createListRatings1() {

			ArrayList<Integer> ratings = new ArrayList<>();
			ratings.add(2);
			ratings.add(3);
			ratings.add(35);
			ratings.add(46);

			return ratings;

		}

}
