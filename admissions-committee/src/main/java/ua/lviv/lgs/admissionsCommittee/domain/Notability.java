package ua.lviv.lgs.admissionsCommittee.domain;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "notability")
public class Notability {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "faculty_id", referencedColumnName = "id")
	private Faculty faculty;

	@Column
	private Boolean approved;

	@ElementCollection  
    @Column(name="rating", length=50)
	private Map<SubjectsOfAttestation,Integer> rating; 

	@Column
	private Integer summaryRating;

	public Notability() {

	}

	public Notability(User user, Faculty faculty, Boolean approved, Map<SubjectsOfAttestation, Integer> rating,
			Integer summaryRating) {
		super();
		this.user = user;
		this.faculty = faculty;
		this.approved = approved;
		this.rating = rating;
		this.summaryRating = summaryRating;
	}

	public Notability(Integer id, User user, Faculty faculty, Boolean approved,
			Map<SubjectsOfAttestation, Integer> rating, Integer summaryRating) {
		super();
		this.id = id;
		this.user = user;
		this.faculty = faculty;
		this.approved = approved;
		this.rating = rating;
		this.summaryRating = summaryRating;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public Boolean getApproved() {
		return approved;
	}

	public void setApproved(Boolean approved) {
		this.approved = approved;
	}

	public Map<SubjectsOfAttestation, Integer> getRating() {
		return rating;
	}

	public void setRating(Map<SubjectsOfAttestation, Integer> rating) {
		this.rating = rating;
	}

	public Integer getSummaryRating() {
		return summaryRating;
	}

	public void setSummaryRating(Integer summaryRating) {
		this.summaryRating = summaryRating;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((approved == null) ? 0 : approved.hashCode());
		result = prime * result + ((faculty == null) ? 0 : faculty.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + ((summaryRating == null) ? 0 : summaryRating.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Notability other = (Notability) obj;
		if (approved == null) {
			if (other.approved != null)
				return false;
		} else if (!approved.equals(other.approved))
			return false;
		if (faculty == null) {
			if (other.faculty != null)
				return false;
		} else if (!faculty.equals(other.faculty))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (summaryRating == null) {
			if (other.summaryRating != null)
				return false;
		} else if (!summaryRating.equals(other.summaryRating))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Notability [id=" + id + ", user=" + user + ", faculty=" + faculty + ", approved=" + approved
				+ ", rating=" + rating + ", summaryRating=" + summaryRating + "]";
	}

	
}
