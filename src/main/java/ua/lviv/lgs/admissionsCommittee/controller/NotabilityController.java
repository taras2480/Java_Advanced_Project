package ua.lviv.lgs.admissionsCommittee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	@RequestMapping(value = "/notabilities", method = RequestMethod.GET)
	public ModelAndView getAllItems() {
		return getNotabilityItems();
	}

	@RequestMapping(value = "/notability", method = RequestMethod.POST)
	public ModelAndView create(@RequestParam String facultyId) {
		Faculty faculty = facultyService.findById(Integer.parseInt(facultyId));

		Notability notability = new Notability();
		notability.setFaculty(faculty);

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userEmail = auth.getName();
		User user = userService.findByEmail(userEmail);
		notability.setUser(user);

		notabilityService.add(notability);
		return getNotabilityItems();
	}

	@RequestMapping(value = "/notability", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam String id) {
		notabilityService.delete(new Notability(Integer.parseInt(id.replaceAll("\\s", ""))));
		return getNotabilityItems();
	}

	private ModelAndView getNotabilityItems() {
		ModelAndView map = new ModelAndView("notability");
		map.addObject("notabilityItems", notabilityService.getAllNotabilities());
		return map;
	}
}
