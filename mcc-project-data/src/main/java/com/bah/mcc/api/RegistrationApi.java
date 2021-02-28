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

import com.bah.mcc.domain.Registration;
import com.bah.mcc.repository.RegistrationRepository;

//me
@RestController
@RequestMapping("/registration")
public class RegistrationApi {
	@Autowired
	RegistrationRepository repo;

	@GetMapping
	public Iterable<Registration> getAll() {
		return repo.findAll();
	}

	@GetMapping("/{registrationId}")
	public Optional<Registration> getRegistrationById(@PathVariable("registrationId") long id) {
		//return repo.findOne(id);
		return repo.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<?> addRegistration(@RequestBody Registration newRegistration, UriComponentsBuilder uri) {
		if (newRegistration.getId() != 0 || newRegistration.getCustomer_name() == null || newRegistration.getEvent_name() == null || newRegistration.getNotes() == null || newRegistration.getNotes() == null) {
			// Reject we'll assign the registration id
			return ResponseEntity.badRequest().build();
		}
		newRegistration = repo.save(newRegistration);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(newRegistration.getId()).toUri();
		ResponseEntity<?> response = ResponseEntity.created(location).build();
		return response;
	}

	//lookupRegistrationByName GET
	@GetMapping("/byname/{registration}")
	public ResponseEntity<?> lookupRegistrationByNameGet(@PathVariable("registration") String registration,
			UriComponentsBuilder uri) {
		//ApiLogger.log("registration " + registration);
		
		Iterator<Registration> registrations = repo.findAll().iterator();
		while(registrations.hasNext()) {
			Registration regist = registrations.next();
			if(regist.getEvent_name().equalsIgnoreCase(registration)) {
				ResponseEntity<?> response = ResponseEntity.ok(regist);
				return response;				
			}			
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	//lookupRegistrationByName POST
	@PostMapping("/byname")
	public ResponseEntity<?> lookupRegistrationByNamePost(@RequestBody String registration, UriComponentsBuilder uri) {
		//ApiLogger.log("registration: " + registration);
		Iterator<Registration> regist = repo.findAll().iterator();
		while(regist.hasNext()) {
			Registration reg = regist.next();
			if(reg.getEvent_name().equals(registration)) {
				ResponseEntity<?> response = ResponseEntity.ok(reg);
				return response;				
			}			
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}	
	
	
	@PutMapping("/{registrationId}")
	public ResponseEntity<?> putRegistration(
			@RequestBody Registration newRegistration,
			@PathVariable("registrationId") long registrationId) 
	{
		if (newRegistration.getId() != 0 || newRegistration.getCustomer_name() == null || newRegistration.getEvent_name() == null || newRegistration.getNotes() == null || newRegistration.getNotes() == null) {
			return ResponseEntity.badRequest().build();
		}
		newRegistration = repo.save(newRegistration);
		return ResponseEntity.ok().build();
	}	
	
	@DeleteMapping("/{registrationId}")
	public ResponseEntity<?> deleteRegistrationById(@PathVariable("registrationId") long id) {
		// repo.delete(id);
		repo.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}	
	
	
}
