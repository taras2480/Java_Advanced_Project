package ua.lviv.lgs.admissionsCommittee.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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

	@ElementCollection
	private List<Integer> ratings;

	@Column
	private Integer sumRating;

	@Lob
	private String encodedEntrantImage;

	@Column(name = "purchase_date")
	private Date purchaseDate;

	public Notability() {

	}

	public Notability(Integer id) {

		this.id = id;
	}

	public Notability(User user, Faculty faculty, List<Integer> ratings) {

		this.user = user;
		this.faculty = faculty;
		this.ratings = ratings;
	}

	public Notability(User user, Faculty faculty, List<Integer> ratings, Integer sumRating) {
		super();
		this.user = user;
		this.faculty = faculty;
		this.ratings = ratings;
		this.sumRating = sumRating;
	}

	public Notability(User user, Faculty faculty, List<Integer> ratings, Integer sumRating, String encodedEntrantImage,
			Date purchaseDate) {
		super();
		this.user = user;
		this.faculty = faculty;
		this.ratings = ratings;
		this.sumRating = sumRating;
		this.encodedEntrantImage = encodedEntrantImage;
		this.purchaseDate = purchaseDate;
	}

	public Notability(Integer id, User user, Faculty faculty, List<Integer> ratings, Integer sumRating,
			String encodedEntrantImage, Date purchaseDate) {
		super();
		this.id = id;
		this.user = user;
		this.faculty = faculty;
		this.ratings = ratings;
		this.sumRating = sumRating;
		this.encodedEntrantImage = encodedEntrantImage;
		this.purchaseDate = purchaseDate;
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

	public List<Integer> getRatings() {
		return ratings;
	}

	public void setRatings(List<Integer> ratings) {
		this.ratings = ratings;
	}

	public Integer getSumRating() {

		sumRating=0;
		for (Integer rating : ratings) {

			sumRating = sumRating + rating;
			
		}
		return sumRating;

	}

	public void setSumRating(Integer sumRating) {
		List<Integer> ratings = new ArrayList<Integer>();
		sumRating = 0;
		for (int i = 0; i < ratings.size(); i++) {
			sumRating = sumRating + ratings.get(i);
		}

		this.sumRating = sumRating;
	}

	public String getEncodedEntrantImage() {
		return encodedEntrantImage;
	}

	public void setEncodedEntrantImage(String encodedEntrantImage) {
		this.encodedEntrantImage = encodedEntrantImage;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((encodedEntrantImage == null) ? 0 : encodedEntrantImage.hashCode());
		result = prime * result + ((faculty == null) ? 0 : faculty.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((purchaseDate == null) ? 0 : purchaseDate.hashCode());
		result = prime * result + ((ratings == null) ? 0 : ratings.hashCode());
		result = prime * result + ((sumRating == null) ? 0 : sumRating.hashCode());
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
		if (encodedEntrantImage == null) {
			if (other.encodedEntrantImage != null)
				return false;
		} else if (!encodedEntrantImage.equals(other.encodedEntrantImage))
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
		if (purchaseDate == null) {
			if (other.purchaseDate != null)
				return false;
		} else if (!purchaseDate.equals(other.purchaseDate))
			return false;
		if (ratings == null) {
			if (other.ratings != null)
				return false;
		} else if (!ratings.equals(other.ratings))
			return false;
		if (sumRating == null) {
			if (other.sumRating != null)
				return false;
		} else if (!sumRating.equals(other.sumRating))
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
		return "Notability [id=" + id + ", user=" + user + ", faculty=" + faculty + ", ratings=" + ratings
				+ ", sumRating=" + sumRating + ", encodedEntrantImage=" + encodedEntrantImage + ", purchaseDate="
				+ purchaseDate + "]";
	}

}
