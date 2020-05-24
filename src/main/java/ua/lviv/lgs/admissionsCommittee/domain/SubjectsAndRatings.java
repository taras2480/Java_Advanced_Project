package ua.lviv.lgs.admissionsCommittee.domain;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subjectsAndRatings")
public class SubjectsAndRatings {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ElementCollection
	@Column
	private Map<SubjectsOfAttestation,Integer> subjectAndRating = new HashMap<SubjectsOfAttestation,Integer>();

	

	public SubjectsAndRatings() {
		
	}



	public SubjectsAndRatings(Map<SubjectsOfAttestation, Integer> subjectAndRating) {
		
		this.subjectAndRating = subjectAndRating;
	}


	public SubjectsAndRatings(Integer id, Map<SubjectsOfAttestation, Integer> subjectAndRating) {
		
		this.id = id;
		this.subjectAndRating = subjectAndRating;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Map<SubjectsOfAttestation, Integer> getSubjectAndRating() {
		return subjectAndRating;
	}



	public void setSubjectAndRating(Map<SubjectsOfAttestation, Integer> subjectAndRating) {
		this.subjectAndRating = subjectAndRating;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((subjectAndRating == null) ? 0 : subjectAndRating.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubjectsAndRatings other = (SubjectsAndRatings) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (subjectAndRating == null) {
			if (other.subjectAndRating != null)
				return false;
		} else if (!subjectAndRating.equals(other.subjectAndRating))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "SubjectsAndRatings [id=" + id + ", subjectAndRating=" + subjectAndRating + "]";
	}
	
	
	
	
	
	
	
	
	
	

}
