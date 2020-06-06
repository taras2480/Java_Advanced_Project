package ua.lviv.lgs.admissionsCommittee.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.admissionsCommittee.dao.NotabilityRepository;
import ua.lviv.lgs.admissionsCommittee.domain.Notability;

@Service
public class NotabilityService {
	
	private Logger logger = LoggerFactory.getLogger(NotabilityService.class);
	
	@Autowired
	private NotabilityRepository notabilityRepository;
	
	public List<Notability> getAllNotabilities(){
						
		logger.info("Get  all registered users");
		
		return notabilityRepository.findAll();
	}
	
	public void delete(Integer id) {
		
		logger.info("Delete registered user"+id);
		
		notabilityRepository.deleteById(id);
	}
	
	public Notability add(Notability notability) {
		
		logger.info("Create registered user"+notability);
		
		return notabilityRepository.save(notability);
	}
	
	public Notability findById(Integer id) {
		logger.info("Find registered user"+id);
		
		return notabilityRepository.findById(id).get();
	}

}
