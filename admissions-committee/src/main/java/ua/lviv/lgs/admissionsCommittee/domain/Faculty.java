package ua.lviv.lgs.admissionsCommittee.domain;

import java.util.Set;

public class Faculty {

	private Integer id;
	private String nameFaculty;
	private Integer amountOfStudents;
	private Set<SubjectsOfAttestation> subjects;

	public Faculty() {

	}

	public Faculty(String nameFaculty, Integer amountOfStudents, Set<SubjectsOfAttestation> subjects) {

		this.nameFaculty = nameFaculty;
		this.amountOfStudents = amountOfStudents;
		this.subjects = subjects;
	}

	public Faculty(Integer id, String nameFaculty, Integer amountOfStudents, Set<SubjectsOfAttestation> subjects) {
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

	public Set<SubjectsOfAttestation> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<SubjectsOfAttestation> subjects) {
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
		if (subjects == null) {
			if (other.subjects != null)
				return false;
		} else if (!subjects.equals(other.subjects))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Faculty [id=" + id + ", nameFaculty=" + nameFaculty + ", amountOfStudents=" + amountOfStudents
				+ ", subjects=" + subjects + "]";
	}

}
