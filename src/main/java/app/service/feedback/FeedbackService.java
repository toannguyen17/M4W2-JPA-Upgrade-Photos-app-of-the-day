package app.service.feedback;

import app.model.Feedback;

import java.sql.Timestamp;
import java.util.List;

public interface FeedbackService {
	Feedback findById(Long id);

	void save(Feedback feedback);

	List<Feedback> feedbackToday();
}
