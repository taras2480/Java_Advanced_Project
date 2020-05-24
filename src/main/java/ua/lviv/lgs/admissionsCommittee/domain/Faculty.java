package ua.lviv.lgs.admissionsCommittee.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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

	@Lob
	private String encodedImage;
	
	@ManyToOne
	@JoinColumn(name = "subjectsAndRatings_id", referencedColumnName = "id")
	private SubjectsAndRatings subjectsAndRatings;

	@Column
	private Boolean approved;

	@Column
	private Integer summaryRating;

	public Faculty() {

	}

	public Faculty(String nameFaculty, Integer amountOfStudents, String encodedImage, Boolean approved,
			Integer summaryRating) {
		super();
		this.nameFaculty = nameFaculty;
		this.amountOfStudents = amountOfStudents;
		this.encodedImage = encodedImage;
		this.approved = approved;
		this.summaryRating = summaryRating;
	}
	
	

	public Faculty(Integer id, String nameFaculty, Integer amountOfStudents, String encodedImage,
			SubjectsAndRatings subjectsAndRatings, Boolean approved, Integer summaryRating) {
		super();
		this.id = id;
		this.nameFaculty = nameFaculty;
		this.amountOfStudents = amountOfStudents;
		this.encodedImage = encodedImage;
		this.subjectsAndRatings = subjectsAndRatings;
		this.approved = approved;
		this.summaryRating = summaryRating;
	}

	public Faculty(String nameFaculty, Integer amountOfStudents, String encodedImage,
			SubjectsAndRatings subjectsAndRatings, Boolean approved, Integer summaryRating) {
		super();
		this.nameFaculty = nameFaculty;
		this.amountOfStudents = amountOfStudents;
		this.encodedImage = encodedImage;
		this.subjectsAndRatings = subjectsAndRatings;
		this.approved = approved;
		this.summaryRating = summaryRating;
	}

	public Faculty(Integer id, String nameFaculty, Integer amountOfStudents, String encodedImage, Boolean approved,
			Integer summaryRating) {
		super();
		this.id = id;
		this.nameFaculty = nameFaculty;
		this.amountOfStudents = amountOfStudents;
		this.encodedImage = encodedImage;
		this.approved = approved;
		this.summaryRating = summaryRating;
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

	public String getEncodedImage() {
		return encodedImage;
	}

	public void setEncodedImage(String encodedImage) {
		this.encodedImage = encodedImage;
	}

	public Boolean getApproved() {
		return approved;
	}

	public void setApproved(Boolean approved) {
		this.approved = approved;
	}

	public Integer getSummaryRating() {
		return summaryRating;
	}

	public void setSummaryRating(Integer summaryRating) {
		this.summaryRating = summaryRating;
	}
	
	

	public SubjectsAndRatings getSubjectsAndRatings() {
		return subjectsAndRatings;
	}

	public void setSubjectsAndRatings(SubjectsAndRatings subjectsAndRatings) {
		this.subjectsAndRatings = subjectsAndRatings;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amountOfStudents == null) ? 0 : amountOfStudents.hashCode());
		result = prime * result + ((approved == null) ? 0 : approved.hashCode());
		result = prime * result + ((encodedImage == null) ? 0 : encodedImage.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nameFaculty == null) ? 0 : nameFaculty.hashCode());
		result = prime * result + ((summaryRating == null) ? 0 : summaryRating.hashCode());
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
		if (approved == null) {
			if (other.approved != null)
				return false;
		} else if (!approved.equals(other.approved))
			return false;
		if (encodedImage == null) {
			if (other.encodedImage != null)
				return false;
		} else if (!encodedImage.equals(other.encodedImage))
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
		if (summaryRating == null) {
			if (other.summaryRating != null)
				return false;
		} else if (!summaryRating.equals(other.summaryRating))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Faculty [id=" + id + ", nameFaculty=" + nameFaculty + ", amountOfStudents=" + amountOfStudents
				+ ", encodedImage=" + encodedImage + ", approved=" + approved + ", summaryRating=" + summaryRating
				+ "]";
	}

	

}
