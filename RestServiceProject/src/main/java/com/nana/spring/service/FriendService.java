package com.nana.spring.service;

import java.util.List;

import com.nana.spring.model.Friend;

public interface FriendService {

	public abstract List<Friend> list();

	public abstract Friend get(String id);

	public abstract Friend create(Friend friend);

	public abstract Friend delete(String id);

	public abstract Friend update(Friend friend);

	public abstract Friend findFriend(String custId);

}