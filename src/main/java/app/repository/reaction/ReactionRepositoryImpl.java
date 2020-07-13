package app.repository.reaction;

import app.model.Feedback;
import app.model.Reaction;
import app.model.ReactionName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
@Transactional
public class ReactionRepositoryImpl implements ReactionReposiory {
	//@Autowired
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Reaction entity) {
		if(entity.getId() != null){
			entityManager.merge(entity);
		} else {
			entityManager.persist(entity);
		}
	}

	@Override
	public Reaction findById(Long id) {
		TypedQuery<Reaction> query = entityManager.createQuery("select c from Reaction c where  c.id=:id", Reaction.class);
		query.setParameter("id", id);
		try {
			return query.getSingleResult();
		}catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public List<Reaction> findAll() {
		TypedQuery<Reaction> result = entityManager.createQuery("select c from Reaction c", Reaction.class);
		return result.getResultList();
	}

	@Override
	public void remove(Long id) {
		Reaction customer = findById(id);
		if(customer != null){
			entityManager.remove(customer);
		}
	}

	@Override
	public void reactions(String reaction, Feedback feedback) {
		Reaction reaction_feedback = new Reaction();
		reaction_feedback.setFeedbackId(feedback);
		reaction_feedback.setReaction(ReactionName.valueOf(reaction));

		entityManager.persist(reaction_feedback);

		feedback.getReaction().add(reaction_feedback);
		entityManager.merge(feedback);
	}
}
