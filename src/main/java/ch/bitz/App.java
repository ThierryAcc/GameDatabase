package ch.bitz;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import ch.bitz.models.Developer;
import ch.bitz.models.Game;
import ch.bitz.models.Publisher;
import ch.bitz.models.Review;
import ch.bitz.models.Reviewer;

public class App {

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public static void main(String[] args) {
		new App().executeHibernate(args);
	}

	private void executeHibernate(String[] args) {
		// Manager to persistence unit <persistence-unit name="furiousGames"
		// transaction-type="RESOURCE_LOCAL">
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("furiousGames");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		// GET ALL REVIEWS
		TypedQuery<Reviewer> fromReviewer = entityManager.createQuery("from Reviewer", Reviewer.class);
		List<Reviewer> reviewerList = fromReviewer.getResultList();

		// OUTPUT gameTitle + publisherName + genreName
		for (Reviewer reviewer : reviewerList) {
			System.out.println(reviewer.getGames().toString());
		}
		System.out.println("-------------------------");


		// GET ALL REVIEWS
		TypedQuery<Review> fromReview = entityManager.createQuery("from Review", Review.class);
		List<Review> reviewList = fromReview.getResultList();

		// OUTPUT gameTitle + publisherName + genreName
		for (Review review : reviewList) {
			System.out.println(review.getReviewText() + " : " + review.getScore() + " : " + review.getGame().getTitle());
		}

		// ADD REVIEW TO DB
		Review review = new Review();
		review.setReviewText("haha alex ist lustig");
		review.setScore(new BigDecimal(2.0));
		review.setGame(reviewList.get(0).getGame());
		review.setReviewer(reviewList.get(0).getReviewer());

		// CREATE FROM QUERY and return to List
		TypedQuery<Game> fromGame = entityManager.createQuery("from Game", Game.class);
		List<Game> resultList = fromGame.getResultList();

		// OUTPUT gameTitle + publisherName + genreName
		for (Game game : resultList) {
			if(game.getReviews().size() > 0) {
				System.out.println(game);
			}
		}

		// CREATE FROM QUERY and return to List
		Query updateReview = entityManager.createQuery("update Review r set r.reviewText='banana' where r.id=1");
		
		// DELETE FROM QUERY and return to List
		Query deleteReview = entityManager.createQuery("delete Review r where r.id=2");

		// OUTPUT gameTitle + publisherName + genreName
		for (Game game : resultList) {
			if(game.getReviews().size() > 0) {
				System.out.println(game);
			}
		}

		// gleiche für developer
		TypedQuery<Developer> fromPublisher = entityManager.createQuery("from Developer", Developer.class);
		List<Developer> resultList1 = fromPublisher.getResultList();
		for (Developer developer : resultList1) {
			System.out.println(developer.getName() + " : " + developer.getYearFounded());
		}

		// SAVE AND PERSIST AN OBJECT
		Publisher publisher = new Publisher();
		publisher.setName("ACCENTURE PUB");

		// get EntityTransaction from entityManager and do the save
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(publisher);
		transaction.commit();

		transaction.begin();
		entityManager.persist(review);
		transaction.commit();
		
		transaction.begin();
		deleteReview.executeUpdate();
		updateReview.executeUpdate();
		transaction.commit();
	}

	private static void outputResultSet(List<Game> games) {
		games.forEach((game -> System.out.println("DEV: " + game.getTitle())));
	}
}
