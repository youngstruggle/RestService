package com.nana.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nana.spring.dao.FriendDAO;
import com.nana.spring.model.Friend;

/**
 * @author Nana Febriana
 */

@Service
public class FriendServiceImpl implements FriendService {

	@Autowired
	private FriendDAO friendDAO;

	@Override
	public List<Friend> list() {
		return friendDAO.list();
	}

	@Override
	public Friend get(String id) {
		return friendDAO.get(id);
	}

	@Override
	public Friend create(Friend friend) {
		return friendDAO.create(friend);
	}

	@Override
	public Friend delete(String id) {
		return friendDAO.delete(id);
	}

	@Override
	public Friend update(Friend friend) {
		return friendDAO.update(friend);
	}

	@Override
	public Friend findFriend(String custId) {
		return friendDAO.findFriend(custId);
	}

}
