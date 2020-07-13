package app.model;

import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
@Table
//@Transactional
public class Reaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private ReactionName reaction;

	@ManyToOne(fetch = FetchType.EAGER)
	private Feedback feedback;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ReactionName getReaction() {
		return reaction;
	}

	public void setReaction(ReactionName reaction) {
		this.reaction = reaction;
	}

	public Feedback getFeedbackId() {
		return feedback;
	}

	public void setFeedbackId(Feedback feedback) {
		this.feedback = feedback;
	}
}
