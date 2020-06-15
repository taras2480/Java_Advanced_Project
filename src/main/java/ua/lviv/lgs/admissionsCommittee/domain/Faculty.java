package ua.lviv.lgs.admissionsCommittee.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "faculty")
public class Faculty {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column
	private String nameFaculty;

	@Column
	private Integer amountOfStudents;

	@ElementCollection
	private List<SubjectsOfAttestation> subjects;

	public Faculty() {

	}

	public Faculty(String nameFaculty, Integer amountOfStudents, List<SubjectsOfAttestation> subjects) {
		super();
		this.nameFaculty = nameFaculty;
		this.amountOfStudents = amountOfStudents;
		this.subjects = subjects;
	}

	public Faculty(Integer id, String nameFaculty, Integer amountOfStudents, List<SubjectsOfAttestation> subjects) {
		super();
		this.id = id;
		this.nameFaculty = nameFaculty;
		this.amountOfStudents = amountOfStudents;
		this.subjects = subjects;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNameFaculty() {
		return nameFaculty;
	}

	public void setNameFaculty(String nameFaculty) {
		this.nameFaculty = nameFaculty;
	}

	public Integer getAmountOfStudents() {
		return amountOfStudents;
	}

	public void setAmountOfStudents(Integer amountOfStudents) {
		this.amountOfStudents = amountOfStudents;
	}

	public List<SubjectsOfAttestation> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<SubjectsOfAttestation> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "Faculty [id=" + id + ", nameFaculty=" + nameFaculty + ", amountOfStudents=" + amountOfStudents
				+ ", subjects=" + subjects + "]";
	}

}
