package ua.lviv.lgs.admissionsCommittee.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "showHappyStudents")
public class HappyFutureStudents implements Comparable<HappyFutureStudents> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "faculty_id")
	private Integer facultyId;

	@ElementCollection
	@Column(name = "statement_ratings")
	private List<Integer> statementRatings;

	@Transient
	private boolean approved;

	public HappyFutureStudents() {

	}

	public HappyFutureStudents(Integer userId, Integer facultyId, List<Integer> statementRatings, boolean approved) {
		super();
		this.userId = userId;
		this.facultyId = facultyId;
		this.statementRatings = statementRatings;
		this.approved = approved;
	}

	public HappyFutureStudents(Integer id, Integer userId, Integer facultyId, List<Integer> statementRatings,
			boolean approved) {
		super();
		this.id = id;
		this.userId = userId;
		this.facultyId = facultyId;
		this.statementRatings = statementRatings;
		this.approved = approved;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(Integer facultyId) {
		this.facultyId = facultyId;
	}

	public List<Integer> getStatementRatings() {
		return statementRatings;
	}

	public void setStatementRatings(List<Integer> statementRatings) {
		this.statementRatings = statementRatings;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (approved ? 1231 : 1237);
		result = prime * result + ((facultyId == null) ? 0 : facultyId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((statementRatings == null) ? 0 : statementRatings.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		HappyFutureStudents other = (HappyFutureStudents) obj;
		if (approved != other.approved)
			return false;
		if (facultyId == null) {
			if (other.facultyId != null)
				return false;
		} else if (!facultyId.equals(other.facultyId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (statementRatings == null) {
			if (other.statementRatings != null)
				return false;
		} else if (!statementRatings.equals(other.statementRatings))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "HappyFutureStudents [id=" + id + ", userId=" + userId + ", facultyId=" + facultyId
				+ ", statementRatings=" + statementRatings + ", approved=" + approved + "]";
	}

	@Override
	public int compareTo(HappyFutureStudents happyFutureStudents) {
		if ((happyFutureStudents.statementRatings.stream().reduce((x1, x2) -> x1 + x2).get()
				- this.statementRatings.stream().reduce((x1, x2) -> x1 + x2).get()) > 0) {
			return 1;
		} else if ((happyFutureStudents.statementRatings.stream().reduce((x1, x2) -> x1 + x2).get()
				- this.statementRatings.stream().reduce((x1, x2) -> x1 + x2).get()) < 0) {
			return -1;
		} else
			return 0;
	}

}
