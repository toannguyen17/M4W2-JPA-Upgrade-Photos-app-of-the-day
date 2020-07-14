package redt.app.model;

import javax.persistence.*;

@Entity
@Table
public class Reaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private ReactionName reaction;

	//@ManyToOne(fetch = FetchType.EAGER)
	@ManyToOne
	@JoinColumn(name = "feddback_id")
	private Feedback feedback;

	public Reaction(){}

	public Reaction(String like, Feedback feedback) {
		this.reaction = ReactionName.valueOf(like);
		this.feedback = feedback;
	}

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
