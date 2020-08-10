package com.gs.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import com.gs.entities.Topic;

public interface TopicService {
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	public abstract List<Topic> getAllTopics();
	
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	public abstract Topic getTopicByID(int topicId);
	
	@Secured({"ROLE_ADMIN"})
	public abstract boolean addTopic(Topic topic);
	
	@Secured({"ROLE_ADMIN"})
	public abstract void updateTopic(Topic topic);
	
	@Secured({"ROLE_ADMIN"})
	public abstract void deleteTopic(int topicId);

}
