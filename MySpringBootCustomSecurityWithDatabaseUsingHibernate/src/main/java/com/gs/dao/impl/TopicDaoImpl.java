package com.gs.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gs.dao.TopicDao;
import com.gs.entities.Topic;
@Transactional
@Repository
public class TopicDaoImpl implements TopicDao{
	
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Topic> getAllTopics() {
		// TODO Auto-generated method stub
		String HQL="FROM Topic as t ORDER BY t.topicId";
		return (List<Topic>)entityManager.createQuery(HQL).getResultList();
	}

	@Override
	public Topic getTopicById(int topicId) {
		// TODO Auto-generated method stub
		return entityManager.find(Topic.class, topicId);
	}

	@Override
	public void addTopic(Topic topic) {
		// TODO Auto-generated method stub
		entityManager.persist(topic);
		
	}

	@Override
	public void updateTopic(Topic topic) {
		// TODO Auto-generated method stub
		Topic topicFromDb=getTopicById(topic.getTopicId());
		if(topicFromDb!=null) {
			topicFromDb.setTitle(topic.getTitle());
			topicFromDb.setCategory(topic.getCategory());
			entityManager.flush();
		}else {
			System.out.println("Topic doesn't exist which u want to update");
		}
	}

	@Override
	public void deleteTopic(int topicId) {
		// TODO Auto-generated method stub
			Topic topic=getTopicById(topicId);
			if(topic!=null) {
				entityManager.remove(topic);
			}else {
				System.out.println("Topic doesn't exist which you want to delete");
			}
	}

	@Override
	public boolean topicExists(String title, String category) {
		// TODO Auto-generated method stub
		String hql="From Topic as t WHERE t.title=?1 and t.category=?2";
		int count =entityManager.createQuery(hql).setParameter(1, title).setParameter(2, category)
				.getResultList().size();
		return count>0?true:false;
	}

}
