package com.bah.mcc.api;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.bah.mcc.domain.Event;

@RestController
@RequestMapping("/event")
public class EventApi {
	List<Event> listofEvents = new ArrayList<Event>();
	
	public EventApi() {
		Event e1 = new Event(1L, "4X25", "Rock 2021", "Rock and Roll Conference");
		Event e2 = new Event(1L, "4X30", "MangaWorld", "Manga and Animae Convention");
		Event e3 = new Event(3L, "3X25", "ComicCon", "Comicbook Convention");
		Event e4 = new Event(4L, "3X30", "SteamRollers 2021", "SteamPunk Expo");
		
		this.listofEvents.add(e1);
		this.listofEvents.add(e2);
		this.listofEvents.add(e3);
		this.listofEvents.add(e4);
	}
		@GetMapping
		public List<Event> getListEvent(){
			return listofEvents;
		}
		@GetMapping("/{eventid}")
		public Event getEvent(@PathVariable("eventId") Long id) {
			Event myEvent = null;
			for(Event event: listofEvents) {
				if(event.getId() == id) {
					myEvent = event;
				}
			}
			return myEvent;
		}
		public void setListEvent(ArrayList<Event> listofEvents) {
			this.listofEvents = listofEvents;
		}
		public List<Event> getAll(){
			return this.getListEvent();
		}
		
	
	
	

}
