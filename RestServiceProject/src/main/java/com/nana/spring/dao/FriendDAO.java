package com.nana.spring.dao;

import java.util.List;

import com.nana.spring.model.Friend;

public interface FriendDAO {

	/* Get Friend */
	public abstract List<Friend> list();

	/* Get Friend By Id */
	public abstract Friend get(String id);

	/* Create Friend */
	public abstract Friend create(Friend friend);

	/* Delete Friend */
	public abstract Friend delete(String id);

	/* Update Friend */
	public abstract Friend update(Friend friend);

	/* Find Friend By Id */
	public abstract Friend findFriend(String custId);

}