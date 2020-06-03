package ua.lviv.lgs.admissionsCommittee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.admissionsCommittee.dao.NotabilityRepository;
import ua.lviv.lgs.admissionsCommittee.domain.Notability;

@Service
public class NotabilityService {
	
	@Autowired
	private NotabilityRepository notabilityRepository;
	
	public List<Notability> getAllNotabilities(){
		
		return notabilityRepository.findAll();
	}
	
	public void delete(Integer id) {
		
		notabilityRepository.deleteById(id);
	}
	
	public Notability add(Notability notability) {
		
		return notabilityRepository.save(notability);
	}
	
	public Notability findById(Integer id) {
		return notabilityRepository.findById(id).get();
	}

}
