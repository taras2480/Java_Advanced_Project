package ua.lviv.lgs.admissionsCommittee.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ua.lviv.lgs.admissionsCommittee.domain.Faculty;
import ua.lviv.lgs.admissionsCommittee.domain.Notability;
import ua.lviv.lgs.admissionsCommittee.domain.User;
import ua.lviv.lgs.admissionsCommittee.service.FacultyService;
import ua.lviv.lgs.admissionsCommittee.service.NotabilityService;
import ua.lviv.lgs.admissionsCommittee.service.UserService;

@Controller
public class NotabilityController {

	@Autowired
	private NotabilityService notabilityService;

	@Autowired
	private UserService userService;

	@Autowired
	private FacultyService facultyService;

	@RequestMapping(value = "/enrollmenToFaculty", method = RequestMethod.GET)
	public ModelAndView viewSubjects(@RequestParam("currentId") Integer currentId,
			@RequestParam("currentUserEmail") String currentUserEmail) {
		Faculty faculty = facultyService.findById(currentId);
		User user = userService.findByEmail(currentUserEmail);

		Notability notability = new Notability();
		notability.setFaculty(faculty);
		notability.setUser(user);

		ModelAndView modelAndView = new ModelAndView("enrollmenToFaculty");
		modelAndView.addObject("notability", notability);
		return modelAndView;
	}

	@RequestMapping(value = "/addPoints", method = RequestMethod.POST)
	public String registration(@RequestParam MultipartFile image, @RequestParam List<Integer> ratings,
			@RequestParam Integer facultyId, @RequestParam String userEmail) throws IOException {
		Faculty faculty = facultyService.findById(facultyId);
		User user = userService.findByEmail(userEmail);

		Notability notability = new Notability(user, faculty, ratings);
		notability.setEncodedEntrantImage(Base64.getEncoder().encodeToString(image.getBytes()));

		notabilityService.add(notability);
		return "redirect:/home";
	}

	
	 @RequestMapping(value = "/notabilities", method = RequestMethod.GET) public
	  ModelAndView viewRatings() { ModelAndView modelAndView = new
	  ModelAndView("notabilities"); modelAndView.addObject("notabilities",
	 notabilityService.getAllNotabilities());
	 
	 return modelAndView; }
	 
	 @RequestMapping(value = "/cabinet", method = RequestMethod.GET) public
	  ModelAndView cabinet() { ModelAndView modelAndView = new
	  ModelAndView("cabinet"); modelAndView.addObject("notabilities",
	 notabilityService.getAllNotabilities());
	 
	 return modelAndView; }

	

	
}
