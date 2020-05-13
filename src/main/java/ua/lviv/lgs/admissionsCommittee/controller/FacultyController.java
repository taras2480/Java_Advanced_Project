package ua.lviv.lgs.admissionsCommittee.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ua.lviv.lgs.admissionsCommittee.service.FacultyDTOHelper;
import ua.lviv.lgs.admissionsCommittee.service.FacultyService;

@Controller
public class FacultyController {

	@Autowired
	private FacultyService facultyService;

	@RequestMapping(value = "/addFaculty", method = RequestMethod.POST)
	public ModelAndView createFaculty(@RequestParam MultipartFile image, @RequestParam String nameFaculty, @RequestParam Integer amountOfStudents,
			@RequestParam String subjects) throws IOException {

		facultyService.save(FacultyDTOHelper.createEntity(image, nameFaculty, amountOfStudents, subjects));
		return new ModelAndView("redirect:/home");

	}

}
