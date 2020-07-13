package app.repository.feedback;

import app.model.Feedback;
import app.repository.Repository;

import java.util.List;

public interface FeedBackRepository extends Repository<Feedback> {
	List<Feedback> feedBackToDay();
}
