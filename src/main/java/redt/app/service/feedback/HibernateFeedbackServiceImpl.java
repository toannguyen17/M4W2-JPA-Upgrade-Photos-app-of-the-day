package redt.app.service.feedback;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import redt.app.model.Feedback;
import redt.app.repository.FeedBackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HibernateFeedbackServiceImpl implements FeedbackService {
	@Autowired
	private FeedBackRepository feedBackRepository;

	@Override
	public Feedback findById(Long id) {
		return feedBackRepository.findOne(id);
	}

	@Override
	public void save(Feedback feedback) {
		feedBackRepository.save(feedback);
	}

	@Override
	public Page<Feedback> findAll(Pageable pageable) {
		return feedBackRepository.findAll(pageable);
	}
}
