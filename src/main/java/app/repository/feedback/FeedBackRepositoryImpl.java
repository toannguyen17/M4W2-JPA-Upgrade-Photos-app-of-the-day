package app.repository.feedback;

import app.model.Feedback;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
@Transactional
public class FeedBackRepositoryImpl implements FeedBackRepository {
//	@PersistenceUnit
//	private static SessionFactory sessionFactory;

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Feedback> feedBackToDay() {
		LocalDate localDate    = LocalDate.now();

		LocalDateTime today    = localDate.atStartOfDay();
		LocalDateTime tomorrow = today.plusDays(1);

		Timestamp timestamp_today    = Timestamp.valueOf(today);
		Timestamp timestamp_tomorrow = Timestamp.valueOf(tomorrow);

		TypedQuery<Feedback> list = entityManager.createQuery("SELECT c FROM Feedback c WHERE c.createdAt >= :today and c.createdAt < :tomorrow", Feedback.class);
		list.setParameter("today", timestamp_today);
		list.setParameter("tomorrow", timestamp_tomorrow);
		return list.getResultList();
	}

	@Override
	public void save(Feedback entity) {
		if(entity.getId() != null){
			entityManager.merge(entity);
		} else {
			entityManager.persist(entity);
		}
	}

	@Override
	public Feedback findById(Long id) {
		TypedQuery<Feedback> query = entityManager.createQuery("select c from Feedback c where  c.id=:id", Feedback.class);
		query.setParameter("id", id);
		try {
			return query.getSingleResult();
		}catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public List<Feedback> findAll() {
		TypedQuery<Feedback> result = entityManager.createQuery("select c from Feedback c", Feedback.class);
		return result.getResultList();
	}

	@Override
	public void remove(Long id) {
		Feedback customer = findById(id);
		if(customer != null){
			entityManager.remove(customer);
		}
	}
}
