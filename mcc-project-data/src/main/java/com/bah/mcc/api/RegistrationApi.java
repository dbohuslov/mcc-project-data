package com.bah.mcc.api;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bah.mcc.domain.Registration;
//testing
@RestController
@RequestMapping("/registration")
public class RegistrationApi {
	
	List<Registration> listofRegistrations = new ArrayList<Registration>();
		
	public RegistrationApi() {
		Registration r1 = new Registration(1L, new Date(), "Rock and Roll Conference", "Rock 2021", "Diana");
		Registration r2 = new Registration(1L, new Date(),  "Manga and Animae Convention", "MangaWorld", "Ted");
		Registration r3 = new Registration(3L, new Date(), "Comicbook Convention", "ComicCon", "Tom");
		Registration r4 = new Registration(4L, new Date(),  "SteamPunk Expo", "SteamRollers 2021", "Patrick");
		
		this.listofRegistrations.add(r1);
		this.listofRegistrations.add(r2);
		this.listofRegistrations.add(r3);
		this.listofRegistrations.add(r4);
	}
		@GetMapping
		public List<Registration> getListRegistration(){
			return listofRegistrations;
		}
		@GetMapping("/{registrationid}")
		public Registration getRegistration(@PathVariable("registrationId") Long id) {
			Registration myRegistration = null;
			for(Registration registration: listofRegistrations) {
				if(registration.getId() == id) {
					myRegistration = registration;
				}
			}
			return myRegistration;
		}
		public void setListRegistration(ArrayList<Registration> listofRegistrations) {
			this.listofRegistrations = listofRegistrations;
		}
		public List<Registration> getAll(){
			return this.getListRegistration();
		}
		
	
	
	

}



