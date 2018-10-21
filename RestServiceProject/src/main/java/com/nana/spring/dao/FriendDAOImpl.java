package com.nana.spring.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.nana.spring.model.Friend;
import com.nana.spring.util.HibernateUtil;

/**
 * @author Nana Febriana
 */

@Repository
public class FriendDAOImpl implements FriendDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(FriendDAOImpl.class);

	/* Get Friend */
	@Override
	public List<Friend> list() {
		List<Friend> FriendList = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			FriendList = session.createCriteria(Friend.class).list();
			session.getTransaction().commit();
			LOGGER.debug("Get Friend");

			return FriendList;
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			LOGGER.error("Error Bung {}", e.getMessage());
		} finally {
			session.close();
			LOGGER.info("Transaction Finish");
		}
		return null;
	}

	/* Get Friend By Id */
	@Override
	public Friend get(String id) {
		Friend friend = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			friend = (Friend) session.get(Friend.class, id);
			session.getTransaction().commit();
			LOGGER.debug("Get Friend By Id");
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			LOGGER.error("Error Bung {}", e.getMessage());
		} finally {
			session.close();
			LOGGER.info("Transaction finish");
		}
		return friend;
	}
	
	/* Create Friend */
	@Override
	public Friend create(Friend friend) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(friend);
			session.getTransaction().commit();
			LOGGER.debug("Data Saved");
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			LOGGER.error("Error Bung {}", e.getMessage());
		} finally {
			session.close();
			LOGGER.info("Transaction finish");
		}
		return friend;
	}

	/* Delete Friend */
	@Override
	public Friend delete(String id) {
		Friend friend = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			friend = (Friend) session.get(Friend.class, id);
			if (friend != null) {
				session.delete(friend);
				session.getTransaction().commit();
			}
			LOGGER.debug("Data sucessfully deleted!");
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			LOGGER.error("Error Bung {}", e.getMessage());
		} finally {
			session.close();
			LOGGER.info("Transaction selesai");
		}
		return friend;
	}

	/* Update Friend */
	@Override
	public Friend update(Friend friend) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.update(friend);
			session.getTransaction().commit();
			LOGGER.debug("Data Di Update");
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			LOGGER.error("Error Bung {}", e.getMessage());
		} finally {
			session.close();
			LOGGER.info("Transaction finish");
		}
		return friend;
	}

	/* Find Friend By Id */
	@Override
	public Friend findFriend(String custId) {
		Friend friend = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			friend = (Friend) session.get(Friend.class, custId);
			session.getTransaction().commit();
			LOGGER.debug("Data Di Update");
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			LOGGER.error("Error Bung {}", e.getMessage());
		} finally {
			session.close();
			LOGGER.info("Transaction finish");
		}
		return friend;
	}

}