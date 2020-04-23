package ch.bitz.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "reviewers")
public class Reviewer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	String title;

	String email;
	
	@ManyToMany(mappedBy = "reviewers")
	private Set<Game> games = new HashSet<>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "reviewer")
	List<Review> reviews;

	public Set<Game> getGames() {
		return games;
	}

	public void setGames(Set<Game> games) {
		this.games = games;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Reviewer [title=" + title + "]";
	}

}
