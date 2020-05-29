package ua.lviv.lgs.admissionsCommittee.service;

import java.util.TreeMap;

import ua.lviv.lgs.admissionsCommittee.domain.Notability;
import ua.lviv.lgs.admissionsCommittee.domain.User;

public class NotabilityDtoHelper {
	
	TreeMap<Integer, Object> sucsessStudents;
	User user = new User();
	Notability notability = new Notability();
	
	public TreeMap<Integer, Object> sucsessStudent (){
		
		sucsessStudents.put(notability.getSumRating(), new User(user.getId(),user.getFirstName(),user.getLastName()));
		return sucsessStudents;
				
		
	}

}
