package app.repository.reaction;

import app.model.Feedback;
import app.model.Reaction;
import app.repository.Repository;

public interface ReactionReposiory extends Repository<Reaction> {
	public void reactions(String reaction, Feedback feedback);
}
