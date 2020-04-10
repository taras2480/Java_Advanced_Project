package ua.lviv.lgs.admissionsCommittee.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
	
	@Enumerated(EnumType.STRING)
	private SubjectsOfAttestation subjects;

	public Faculty() {

	}

	public Faculty(String nameFaculty, Integer amountOfStudents, SubjectsOfAttestation subjects) {
		super();
		this.nameFaculty = nameFaculty;
		this.amountOfStudents = amountOfStudents;
		this.subjects = subjects;
	}

	public Faculty(Integer id, String nameFaculty, Integer amountOfStudents, SubjectsOfAttestation subjects) {
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

	public SubjectsOfAttestation getSubjects() {
		return subjects;
	}

	public void setSubjects(SubjectsOfAttestation subjects) {
		this.subjects = subjects;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amountOfStudents == null) ? 0 : amountOfStudents.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nameFaculty == null) ? 0 : nameFaculty.hashCode());
		result = prime * result + ((subjects == null) ? 0 : subjects.hashCode());
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
		Faculty other = (Faculty) obj;
		if (amountOfStudents == null) {
			if (other.amountOfStudents != null)
				return false;
		} else if (!amountOfStudents.equals(other.amountOfStudents))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nameFaculty == null) {
			if (other.nameFaculty != null)
				return false;
		} else if (!nameFaculty.equals(other.nameFaculty))
			return false;
		if (subjects != other.subjects)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Faculty [id=" + id + ", nameFaculty=" + nameFaculty + ", amountOfStudents=" + amountOfStudents
				+ ", subjects=" + subjects + "]";
	}

	

}
