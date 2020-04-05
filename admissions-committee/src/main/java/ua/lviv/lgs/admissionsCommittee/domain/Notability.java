package ua.lviv.lgs.admissionsCommittee.domain;

public class Notability {

	private Integer id;
	private Integer userId;
	private Integer facultyId;
	private Boolean approved;
	private Integer rating;
	private Integer summaryRating;

	public Notability() {

	}

	public Notability(Integer userId, Integer facultyId, Boolean approved, Integer rating, Integer summaryRating) {
		super();
		this.userId = userId;
		this.facultyId = facultyId;
		this.approved = approved;
		this.rating = rating;
		this.summaryRating = summaryRating;
	}

	public Notability(Integer id, Integer userId, Integer facultyId, Boolean approved, Integer rating,
			Integer summaryRating) {
		super();
		this.id = id;
		this.userId = userId;
		this.facultyId = facultyId;
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

	public Boolean getApproved() {
		return approved;
	}

	public void setApproved(Boolean approved) {
		this.approved = approved;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
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
		result = prime * result + ((facultyId == null) ? 0 : facultyId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + ((summaryRating == null) ? 0 : summaryRating.hashCode());
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
		Notability other = (Notability) obj;
		if (approved == null) {
			if (other.approved != null)
				return false;
		} else if (!approved.equals(other.approved))
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
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Notability [id=" + id + ", userId=" + userId + ", facultyId=" + facultyId + ", approved=" + approved
				+ ", rating=" + rating + ", summaryRating=" + summaryRating + "]";
	}

}
