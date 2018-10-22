package com.nana.spring.dao;

import java.util.List;

import com.nana.spring.model.Friend;

public interface FriendDAO {

	public abstract List<Friend> list();
	public abstract Friend get(String id);
	public abstract Friend create(Friend friend);
	public abstract Friend delete(String id);
	public abstract Friend update(Friend friend);
	public abstract Friend findFriend(String custId);
	public abstract List<Friend> findFirstAndLastName(String firstName, String lastName);
	public abstract List<Friend> findFirstName(String firstName);
	public abstract List<Friend> findLastName(String lastName);

}