package com.gs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs.dao.TopicDao;
import com.gs.entities.Topic;
import com.gs.service.TopicService;
@Service
public class TopicServiceImpl implements TopicService {
	
	@Autowired
	private TopicDao topicDao;
	@Override
	public List<Topic> getAllTopics() {
		// TODO Auto-generated method stub
		return topicDao.getAllTopics();
	}

	@Override
	public Topic getTopicByID(int topicId) {
		// TODO Auto-generated method stub
		return topicDao.getTopicById(topicId);
	}

	@Override
	public boolean addTopic(Topic topic) {
		// TODO Auto-generated method stub
		if(topicDao.topicExists(topic.getTitle(), topic.getCategory())) {
			return false;
		}else {
			topicDao.addTopic(topic);
		return true;
		}
	}

	@Override
	public void updateTopic(Topic topic) {
		// TODO Auto-generated method stub
		topicDao.updateTopic(topic);
	}

	@Override
	public void deleteTopic(int topicId) {
		// TODO Auto-generated method stub
		topicDao.deleteTopic(topicId);
	}

}
