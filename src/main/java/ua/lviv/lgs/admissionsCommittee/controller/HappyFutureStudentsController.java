package ua.lviv.lgs.admissionsCommittee.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ua.lviv.lgs.admissionsCommittee.domain.Faculty;
import ua.lviv.lgs.admissionsCommittee.domain.HappyFutureStudents;
import ua.lviv.lgs.admissionsCommittee.domain.User;
import ua.lviv.lgs.admissionsCommittee.service.FacultyService;
import ua.lviv.lgs.admissionsCommittee.service.HappyFutureStudentsService;
import ua.lviv.lgs.admissionsCommittee.service.NotabilityService;
import ua.lviv.lgs.admissionsCommittee.service.UserService;

@Controller
public class HappyFutureStudentsController {
	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private FacultyService facultyService;
	
	@Autowired
	private NotabilityService notabilityService;

	@Autowired
	private HappyFutureStudentsService happyFutureStudentsServices;
	
	
	@RequestMapping(value = "/entrolled", method = RequestMethod.POST)
	public ModelAndView entrantSubmiting(@RequestParam("facultyId") Integer facultyId,
			@RequestParam("userId") Integer userId, @RequestParam("notabilityId") Integer notabilityId) {
		HappyFutureStudents happyFutureStudents = new HappyFutureStudents();

		happyFutureStudents.setUserId(userId);
		happyFutureStudents.setFacultyId(facultyId);
		happyFutureStudents.setStatementRatings(new ArrayList<Integer>(notabilityService.findById(notabilityId).getRatings()));

		happyFutureStudentsServices.save(happyFutureStudents);

		notabilityService.delete(notabilityId);

		ModelAndView modelAndView = new ModelAndView("notabilities");
		modelAndView.addObject("notabilities", notabilityService.getAllNotabilities());
		return modelAndView;
	}
	
	@RequestMapping(value = "/showHappyStudents", method = RequestMethod.GET)
	public ModelAndView showHappystudents(@RequestParam("currentFacultyId") Integer currentFacultyId) {

		List<HappyFutureStudents> allHappyFutureStudents = happyFutureStudentsServices.findAllHappyFutureStudents();
		Faculty currentFaculty = facultyService.findById(currentFacultyId);
		
		List<HappyFutureStudents> ofCurrentFaculty = allHappyFutureStudents.stream().filter(s -> facultyService.findById(s.getFacultyId()).getNameFaculty().equals(currentFaculty.getNameFaculty())).collect(Collectors.toList());
		
		System.out.println("BEFORE sorting: " + ofCurrentFaculty);
		
		Collections.sort(ofCurrentFaculty);

		ofCurrentFaculty.stream().forEach(happyFutureStudents -> {
			if (ofCurrentFaculty.indexOf(happyFutureStudents) < facultyService.findById(currentFacultyId).getAmountOfStudents())
				happyFutureStudents.setApproved(true);
		});

		System.out.println("After sorting and rating: " + ofCurrentFaculty);

		List<User> usersCurrentFaculty = ofCurrentFaculty.stream().map(o -> userService.findById(o.getUserId())).collect(Collectors.toList());
		List<Boolean> isApproved = ofCurrentFaculty.stream().map(o -> o.isApproved()).collect(Collectors.toList());
		
		
		ModelAndView modelAndView = new ModelAndView("showHappyStudents");
		modelAndView.addObject("happyFutureStudentss", ofCurrentFaculty);
		modelAndView.addObject("users", usersCurrentFaculty);
		modelAndView.addObject("faculty", currentFaculty);
		modelAndView.addObject("accepting", isApproved);
		
		return modelAndView;
	}

}


