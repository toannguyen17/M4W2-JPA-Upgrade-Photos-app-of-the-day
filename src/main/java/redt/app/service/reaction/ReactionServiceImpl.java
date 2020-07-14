package redt.app.service.reaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redt.app.model.Feedback;
import redt.app.model.Reaction;
import redt.app.repository.FeedBackRepository;
import redt.app.repository.ReactionReposiory;

@Service
public class ReactionServiceImpl implements ReactionService {
	@Autowired
	private FeedBackRepository feedBackRepository;

	@Autowired
	private ReactionReposiory reactionReposiory;

	@Override
	public void reactions(String like, Feedback feedback) {
		Reaction reaction = new Reaction(like, feedback);
		reaction = reactionReposiory.save(reaction);

		feedback.getReaction().add(reaction);
		feedBackRepository.save(feedback);
	}
}
