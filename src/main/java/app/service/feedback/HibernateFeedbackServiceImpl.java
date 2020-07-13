package app.service.feedback;

import app.model.Feedback;
import app.repository.feedback.FeedBackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HibernateFeedbackServiceImpl implements FeedbackService {
	@Autowired
	private FeedBackRepository feedBackRepository;

	@Override
	public Feedback findById(Long id) {
		return feedBackRepository.findById(id);
	}

	@Override
	public void save(Feedback feedback) {
		feedBackRepository.save(feedback);
	}

	@Override
	public List<Feedback> feedbackToday() {
		return feedBackRepository.feedBackToDay();
	}
}
