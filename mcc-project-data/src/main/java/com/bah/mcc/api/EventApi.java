package com.bah.mcc.api;

import java.net.URI;
import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.bah.mcc.repository.EventRepository;

import com.bah.mcc.domain.Event;
//
@RestController
@RequestMapping("/event")
public class EventApi {
	@Autowired
	EventRepository repo;

	@GetMapping
	public Iterable<Event> getAll() {
		return repo.findAll();
	}

	@GetMapping("/{eventId}")
	public Optional<Event> getEventById(@PathVariable("eventId") long id) {
		//return repo.findOne(id);
		return repo.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<?> adEvent(@RequestBody Event newEvent, UriComponentsBuilder uri) {
		if (newEvent.getId() != 0 || newEvent.getName() == null || newEvent.getEmail() == null) {
			// Reject we'll assign the Event id
			return ResponseEntity.badRequest().build();
		}
		newEvent = repo.save(newEvent);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(newEvent.getId()).toUri();
		ResponseEntity<?> response = ResponseEntity.created(location).build();
		return response;
	}

	//lookupEventByName GET
	@GetMapping("/byname/{event}")
	public ResponseEntity<?> lookupEventByNameGet(@PathVariable("event") String event,
			UriComponentsBuilder uri) {
		//ApiLogger.log("Event " + Event);
		
		Iterator<Event> events = repo.findAll().iterator();
		while(events.hasNext()) {
			Event eve = events.next();
			if(eve.getName().equalsIgnoreCase(event)) {
				ResponseEntity<?> response = ResponseEntity.ok(eve);
				return response;				
			}			
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	//lookupEventByName POST
	@PostMapping("/byname")
	public ResponseEntity<?> lookupEventByNamePost(@RequestBody String event, UriComponentsBuilder uri) {
		//ApiLogger.log("Event: " + Event);
		Iterator<Event> events = repo.findAll().iterator();
		while(events.hasNext()) {
			Event eve = events.next();
			if(eve.getName().equals(event)) {
				ResponseEntity<?> response = ResponseEntity.ok(eve);
				return response;				
			}			
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}	
	
	@PutMapping("/{eventId}")
	public ResponseEntity<?> putEvent(
			@RequestBody Event newEvent,
			@PathVariable("eventId") long eventId) 
	{
		if (newEvent.getId() != eventId || newEvent.getName() == null || newEvent.getEmail() == null) {
			return ResponseEntity.badRequest().build();
		}
		newEvent = repo.save(newEvent);
		return ResponseEntity.ok().build();
	}	
	
	@DeleteMapping("/{eventId}")
	public ResponseEntity<?> deleteEventById(@PathVariable("eventId") long id) {
		// repo.delete(id);
		repo.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}	
	
	
}

