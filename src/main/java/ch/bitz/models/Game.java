package ch.bitz.models;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "games")
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	String title;

	@Column(name = "year_published")
	Integer yearPublished;

	@Column(name = "suggested_price")
	BigDecimal suggestedPrice;

	// mehrere games haben mehrere genres
	// die gejointe table mit @JoinTable
	//     die kolumnen joinen mit @JoinColumn
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "games_genres", joinColumns = { 
			@JoinColumn(name = "game_id") }, inverseJoinColumns = {
			@JoinColumn(name = "genre_id") })
	Set<Genre> genres = new HashSet<>();

	String rated;
	Integer viewed;

	@ManyToOne
	Publisher publisher;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "game")
	List<Review> reviews;
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "games_reviewers", joinColumns = { 
			@JoinColumn(name = "game_id") }, inverseJoinColumns = {
			@JoinColumn(name = "reviewer_id") })
	Set<Reviewer> reviewers = new HashSet<>();

	
	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public Set<Genre> getGenres() {
		return genres;
	}

	public void setGenres(Set<Genre> genres) {
		this.genres = genres;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
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

	public Integer getYearPublished() {
		return yearPublished;
	}

	public void setYearPublished(Integer yearPublished) {
		this.yearPublished = yearPublished;
	}

	public BigDecimal getSuggestedPrice() {
		return suggestedPrice;
	}

	public void setSuggestedPrice(BigDecimal suggestedPrice) {
		this.suggestedPrice = suggestedPrice;
	}

	public String getRated() {
		return rated;
	}

	public void setRated(String rated) {
		this.rated = rated;
	}

	public Integer getViewed() {
		return viewed;
	}

	public void setViewed(Integer viewed) {
		this.viewed = viewed;
	}

	@Override
	public String toString() {
		return "Game [title=" + title + ", reviews=" + reviews + ", reviewers=" + reviewers + "]";
	}

	
	
	
}
