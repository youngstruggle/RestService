package com.nana.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nana.spring.model.Friend;
import com.nana.spring.service.FriendService;

/**
 * @author Nana Febriana
 */

@RestController
public class FriendController {

	@Autowired
	private FriendService friendService;

	/* Get friends */
	@GetMapping("/friends")
	public List<Friend> getFriends() {
		return friendService.list();
	}

	/* Create friends */
	@PostMapping(value = "/friends")
	public ResponseEntity<Friend> createFriends(@RequestBody Friend friend) {
		if (friend == null) {
			return new ResponseEntity<Friend>(HttpStatus.EXPECTATION_FAILED);
		} else {
			friendService.create(friend);
		}
		return new ResponseEntity<Friend>(friend, HttpStatus.OK);
	}

	/* Delete friends */
	@DeleteMapping("/friends/{id}")
	public ResponseEntity<Friend> deleteFriends(@PathVariable String id) {
		if (null == friendService.delete(id)) {
			return new ResponseEntity<Friend>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Friend>(HttpStatus.OK);
	}

	/* Update friends */
	@PutMapping("/friends/{id}")
	public ResponseEntity<Friend> updateFriends(
			@PathVariable("id") String custId, @RequestBody Friend friend) {
		Friend friendById = friendService.findFriend(custId);
		if (friendById == null) {
			return new ResponseEntity<Friend>(HttpStatus.NOT_FOUND);
		}
		friendById.setFirstName(friend.getFirstName());
		friendById.setLastName(friend.getLastName());
		friendService.update(friendById);
		return new ResponseEntity<Friend>(friend, HttpStatus.OK);
	}

	/* Get friends By Id */
	@GetMapping("/friends/{id}")
	public ResponseEntity<Friend> getFriends(@PathVariable("id") String id) {
		Friend friend = friendService.get(id);
		if (friend == null) {
			return new ResponseEntity<Friend>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Friend>(friend, HttpStatus.OK);
	}

	/* Get friends By Name */
	@GetMapping("/friends/search")
	public List<Friend> findByQuery(
			@RequestParam(value = "first", required = false) String firstName,
			@RequestParam(value = "last", required = false) String lastName) {
		
		List<Friend> friend = null;
		
		if ( firstName != null && !firstName.equalsIgnoreCase("") && 
			 lastName != null && !lastName.equalsIgnoreCase("")	){
			 friend = friendService.findFirstAndLastName(firstName, lastName);
		} else if (firstName != null && !firstName.equalsIgnoreCase("")) {
			 friend = friendService.findFirstName(firstName);
		} else if ( lastName != null && !lastName.equalsIgnoreCase("")) {
			 friend = friendService.findLastName(lastName);
		}

		return friend;
	}

}
