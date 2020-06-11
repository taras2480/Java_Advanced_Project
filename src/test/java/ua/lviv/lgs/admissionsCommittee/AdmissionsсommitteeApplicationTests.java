package ua.lviv.lgs.admissionsCommittee;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

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
	
	

}