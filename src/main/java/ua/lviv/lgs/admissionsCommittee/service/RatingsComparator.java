package ua.lviv.lgs.admissionsCommittee.service;

import java.util.Comparator;

import ua.lviv.lgs.admissionsCommittee.domain.Notability;

public class RatingsComparator implements Comparator<Notability> {

	@Override
	public int compare(Notability o1, Notability o2) {
		
		return o1.getSumRating() < o2.getSumRating() ? 1 : -1;
		
		
	}
	
	
	
	

}
