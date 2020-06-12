package ua.lviv.lgs.admissionsCommittee;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import ua.lviv.lgs.admissionsCommittee.dao.FacultyRepository;
import ua.lviv.lgs.admissionsCommittee.dao.HappyFutureStudentsRepository;
import ua.lviv.lgs.admissionsCommittee.dao.NotabilityRepository;
import ua.lviv.lgs.admissionsCommittee.dao.UserRepository;
import ua.lviv.lgs.admissionsCommittee.domain.Faculty;
import ua.lviv.lgs.admissionsCommittee.domain.HappyFutureStudents;
import ua.lviv.lgs.admissionsCommittee.domain.Notability;
import ua.lviv.lgs.admissionsCommittee.domain.User;
import ua.lviv.lgs.admissionsCommittee.domain.UserRole;
import ua.lviv.lgs.admissionsCommittee.service.FacultyService;
import ua.lviv.lgs.admissionsCommittee.service.HappyFutureStudentsService;
import ua.lviv.lgs.admissionsCommittee.service.NotabilityService;
import ua.lviv.lgs.admissionsCommittee.service.UserService;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AdmissionsсommitteeApplicationTests {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private FacultyService facultyService;

	@Autowired
	private FacultyRepository facultyRepository;

	@Autowired
	private NotabilityService notabilityService;

	@Autowired
	private NotabilityRepository notabilityRepository;

	@Autowired
	private HappyFutureStudentsService happyFutureStudentsService;

	@Autowired
	private HappyFutureStudentsRepository happyFutureStudentsRepository;

	@Test
	public void testSaveUser() {

		List<User> users = userRepository.findAll();
		assertThat(users, hasSize(0));

		User user = new User();
		user.setEmail("aviator2480@gmail.com");
		user.setFirstName("1");
		user.setLastName("1");
		user.setBirthday("15");
		user.setPassword("1");
		user.setConfirmPassword("1");
		user.setRole(UserRole.ROLE_USER);

		userService.save(user);

		users = userRepository.findAll();
		assertThat(users, hasSize(1));

		User userFromDB = users.get(0);
		assertTrue(userFromDB.getEmail().equals(user.getEmail()));
		assertTrue(userFromDB.getFirstName().equals(user.getFirstName()));
		assertTrue(userFromDB.getLastName().equals(user.getLastName()));
		assertTrue(userFromDB.getBirthday().equals(user.getBirthday()));
		assertTrue(userFromDB.getRole().equals(user.getRole()));
	}

	@Test
	public void testFindUserByEmail() {

		List<User> users = userRepository.findAll();
		assertThat(users, hasSize(0));

		User user = new User();
		user.setEmail("aviator22480@gmail.com");
		user.setFirstName("2");
		user.setLastName("2");
		user.setBirthday("16");
		user.setPassword("2");
		user.setConfirmPassword("2");
		user.setRole(UserRole.ROLE_ADMIN);

		userRepository.save(user);

		users = userRepository.findAll();
		assertThat(users, hasSize(1));

		User findByEmail = userService.findByEmail(user.getEmail());

		assertTrue(findByEmail.getEmail().equals(user.getEmail()));
		assertTrue(findByEmail.getFirstName().equals(user.getFirstName()));
		assertTrue(findByEmail.getLastName().equals(user.getLastName()));
		assertTrue(findByEmail.getBirthday().equals(user.getBirthday()));
		assertTrue(findByEmail.getRole().equals(user.getRole()));
	}

	@Test
	public void testFindUserById() {

		List<User> users = userRepository.findAll();
		assertThat(users, hasSize(0));

		User user = new User();
		user.setEmail("aviator22480@gmail.com");
		user.setFirstName("2");
		user.setLastName("2");
		user.setBirthday("16");
		user.setPassword("2");
		user.setConfirmPassword("2");
		user.setRole(UserRole.ROLE_ADMIN);

		userRepository.save(user);

		users = userRepository.findAll();
		assertThat(users, hasSize(1));

		User findById = userService.findById(user.getId());

		assertTrue(findById.getEmail().equals(user.getEmail()));
		assertTrue(findById.getFirstName().equals(user.getFirstName()));
		assertTrue(findById.getLastName().equals(user.getLastName()));
		assertTrue(findById.getBirthday().equals(user.getBirthday()));
		assertTrue(findById.getRole().equals(user.getRole()));
	}

	@Test
	public void testSaveFaculty() {

		List<Faculty> faculties = facultyRepository.findAll();
		assertThat(faculties, hasSize(0));

		Faculty faculty = new Faculty();
		faculty.setNameFaculty("f");
		faculty.setAmountOfStudents(5);

		facultyService.save(faculty);

		faculties = facultyRepository.findAll();
		assertThat(faculties, hasSize(1));

		Faculty facultyFromDB = faculties.get(0);
		assertTrue(facultyFromDB.getNameFaculty().equals(faculty.getNameFaculty()));
		assertTrue(facultyFromDB.getAmountOfStudents().equals(faculty.getAmountOfStudents()));

	}

	@Test
	public void testGetAllFaculty() {

		List<Faculty> faculties = facultyRepository.findAll();
		assertThat(faculties, hasSize(0));

		Faculty faculty = new Faculty();
		faculty.setNameFaculty("1");
		faculty.setAmountOfStudents(5);

		Faculty faculty2 = new Faculty();
		faculty2.setNameFaculty("7");
		faculty2.setAmountOfStudents(6);

		Faculty faculty3 = new Faculty();
		faculty3.setNameFaculty("7");
		faculty3.setAmountOfStudents(6);

		facultyRepository.saveAll(Arrays.asList(faculty, faculty2, faculty3));

		faculties = facultyRepository.findAll();
		assertThat(faculties, hasSize(3));

		List<Faculty> facultiesFromDb = facultyService.getAllFaculty();

		assertTrue(facultiesFromDb.get(0).getNameFaculty().equals(faculty.getNameFaculty()));
		assertTrue(facultiesFromDb.get(0).getAmountOfStudents().equals(faculty.getAmountOfStudents()));

		assertTrue(facultiesFromDb.get(1).getNameFaculty().equals(faculty2.getNameFaculty()));
		assertTrue(facultiesFromDb.get(1).getAmountOfStudents().equals(faculty2.getAmountOfStudents()));

		assertTrue(facultiesFromDb.get(2).getNameFaculty().equals(faculty3.getNameFaculty()));
		assertTrue(facultiesFromDb.get(2).getAmountOfStudents().equals(faculty3.getAmountOfStudents()));

	}

	@Test
	public void testFindByIdFaculty() {

		List<Faculty> faculties = facultyRepository.findAll();

		assertThat(faculties, hasSize(0));

		Faculty faculty = new Faculty();
		faculty.setNameFaculty("6");
		faculty.setAmountOfStudents(8);

		facultyRepository.save(faculty);

		faculties = facultyRepository.findAll();
		assertThat(faculties, hasSize(1));

		Faculty findById = facultyService.findById(faculty.getId());

		assertTrue(findById.getNameFaculty().equals(faculty.getNameFaculty()));
		assertTrue(findById.getAmountOfStudents().equals(faculty.getAmountOfStudents()));

	}

	@Test
	public void testGetAllNotabilities() {

		User user = new User();
		user.setEmail("custom12480@gmail.com");
		user.setFirstName("3");
		user.setLastName("3");
		user.setPassword("32");
		user.setConfirmPassword("32");
		user.setRole(UserRole.ROLE_USER);

		userService.save(user);

		User userFromDB = userRepository.findAll().stream().findFirst().get();

		Faculty faculty = new Faculty();
		faculty.setNameFaculty("1");
		faculty.setAmountOfStudents(5);

		Faculty faculty2 = new Faculty();
		faculty2.setNameFaculty("7");
		faculty2.setAmountOfStudents(6);

		facultyRepository.saveAll(Arrays.asList(faculty, faculty2));

		List<Faculty> facultiesFromDB = facultyRepository.findAll();

		Notability notability = new Notability();
		notability.setFaculty(facultiesFromDB.get(0));
		notability.setUser(userFromDB);
		notability.setSumRating(6);

		Notability notability2 = new Notability();
		notability2.setFaculty(facultiesFromDB.get(1));
		notability2.setUser(userFromDB);
		notability2.setSumRating(3);

		List<Notability> notabilities = notabilityRepository.findAll();
		assertThat(notabilities, hasSize(0));

		notabilityRepository.saveAll(Arrays.asList(notability, notability2));

		List<Notability> notabilitiesFromDB = notabilityService.getAllNotabilities();
		assertThat(notabilitiesFromDB, hasSize(2));

	}

	@Test
	public void testDeleteFromNotability() {

		User user = new User();
		user.setEmail("custom12480@gmail.com");
		user.setFirstName("3");
		user.setLastName("3");
		user.setPassword("32");
		user.setConfirmPassword("32");
		user.setRole(UserRole.ROLE_USER);

		userService.save(user);

		User userFromDB = userRepository.findAll().stream().findFirst().get();

		Faculty faculty = new Faculty();
		faculty.setNameFaculty("1");
		faculty.setAmountOfStudents(5);

		Faculty faculty2 = new Faculty();
		faculty2.setNameFaculty("7");
		faculty2.setAmountOfStudents(6);

		facultyRepository.saveAll(Arrays.asList(faculty, faculty2));

		List<Faculty> facultiesFromDB = facultyRepository.findAll();

		Notability notability = new Notability();
		notability.setFaculty(facultiesFromDB.get(0));
		notability.setUser(userFromDB);
		notability.setSumRating(6);

		Notability notability2 = new Notability();
		notability2.setFaculty(facultiesFromDB.get(1));
		notability2.setUser(userFromDB);
		notability2.setSumRating(3);

		List<Notability> notabilities = notabilityRepository.findAll();
		assertThat(notabilities, hasSize(0));

		notabilityRepository.saveAll(Arrays.asList(notability, notability2));

		notabilities = notabilityRepository.findAll();
		assertThat(notabilities, hasSize(2));

		Notability findById = notabilityService.findById(notability.getId());

		notabilityService.delete(findById.getId());

		notabilities = notabilityRepository.findAll();
		assertThat(notabilities, hasSize(1));

	}

	@Test
	public void testFindNotabilityById() {

		User user = new User();
		user.setEmail("custom12480@gmail.com");
		user.setFirstName("3");
		user.setLastName("3");
		user.setPassword("32");
		user.setConfirmPassword("32");
		user.setRole(UserRole.ROLE_USER);

		userService.save(user);

		User userFromDB = userRepository.findAll().stream().findFirst().get();

		Faculty faculty = new Faculty();
		faculty.setNameFaculty("1");
		faculty.setAmountOfStudents(5);

		Faculty faculty2 = new Faculty();
		faculty2.setNameFaculty("7");
		faculty2.setAmountOfStudents(6);

		facultyRepository.saveAll(Arrays.asList(faculty, faculty2));

		List<Faculty> facultiesFromDB = facultyRepository.findAll();

		Notability notability = new Notability();
		notability.setFaculty(facultiesFromDB.get(0));
		notability.setUser(userFromDB);

		Notability notability2 = new Notability();
		notability2.setFaculty(facultiesFromDB.get(1));
		notability2.setUser(userFromDB);

		List<Notability> notabilities = notabilityRepository.findAll();
		assertThat(notabilities, hasSize(0));

		notabilityRepository.saveAll(Arrays.asList(notability, notability2));

		notabilities = notabilityRepository.findAll();
		assertThat(notabilities, hasSize(2));

		Notability findById = notabilityService.findById(notability.getId());

		assertTrue(findById.getFaculty().equals(notability.getFaculty()));
		assertTrue(findById.getUser().equals(notability.getUser()));

	}
	
	@Test
	public void testGetAllHappyStudents() {
		
		HappyFutureStudents happyFutureStudents = new HappyFutureStudents();
		happyFutureStudents.setFacultyId(1);
		happyFutureStudents.setUserId(5);
		

		HappyFutureStudents happyFutureStudents2 = new HappyFutureStudents();
		happyFutureStudents2.setFacultyId(3);
		happyFutureStudents2.setUserId(6);

		List<HappyFutureStudents> happyFutureStudentss = happyFutureStudentsRepository.findAll();
		assertThat(happyFutureStudentss, hasSize(0));

		happyFutureStudentsRepository.saveAll(Arrays.asList(happyFutureStudents, happyFutureStudents2));

		List<HappyFutureStudents> happyFutureStudentssFromDB = happyFutureStudentsService.findAllHappyFutureStudents();
		assertThat(happyFutureStudentssFromDB, hasSize(2));

	}
	
	@Test
	public void testSaveHappyStudents() {

		List<HappyFutureStudents> happyFutureStudentss = happyFutureStudentsRepository.findAll();
		assertThat(happyFutureStudentss, hasSize(0));

		HappyFutureStudents  happyFutureStudents = new HappyFutureStudents();
		happyFutureStudents.setFacultyId(1);
		happyFutureStudents.setUserId(5);

		happyFutureStudentsService.save(happyFutureStudents);

		happyFutureStudentss = happyFutureStudentsRepository.findAll();
		assertThat(happyFutureStudentss, hasSize(1));

		HappyFutureStudents happyFutureStudentsFromDB = happyFutureStudentss.get(0);
		assertTrue(happyFutureStudentsFromDB.getFacultyId().equals(happyFutureStudents.getFacultyId()));
		assertTrue(happyFutureStudentsFromDB.getUserId().equals(happyFutureStudents.getUserId()));
		
	}

}