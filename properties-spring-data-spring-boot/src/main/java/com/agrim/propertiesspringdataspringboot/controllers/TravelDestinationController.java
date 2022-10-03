package com.agrim.propertiesspringdataspringboot.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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

import com.agrim.propertiesspringdataspringboot.entity.TravelDestination;
import com.agrim.propertiesspringdataspringboot.exception.TravelDestinationNotFoundException;
import com.agrim.propertiesspringdataspringboot.service.TravelDestinationService;
//1-Postman calls constructor
@RestController
@RequestMapping("/traveldestinations")
public class TravelDestinationController {

	private TravelDestinationService travelDestinationService;
@Autowired
	public TravelDestinationController(TravelDestinationService travelDestinationService) {
		super();
		this.travelDestinationService = travelDestinationService;
	}

//?Please explain Valid & RequestBody- web request body of JSON binds with Traveldestination object-Jackson does that
@PostMapping
public ResponseEntity<TravelDestination> addTravelDestination(@Valid @RequestBody TravelDestination travelDestination) {
	travelDestination = travelDestinationService.addTravelDestination(travelDestination);
	                    //service object          //service method       //entity object              t
			return ResponseEntity.status(HttpStatus.FOUND).body(travelDestination);
}		

@GetMapping 
public ResponseEntity <List<TravelDestination>> getAllTravelDestinations(){
				
			
	List <TravelDestination> allTravelDestinations = travelDestinationService.findAllTravelDestinations();
	return ResponseEntity.status(HttpStatus.FOUND).body(allTravelDestinations);
}
@GetMapping (path ="/{country}")
public ResponseEntity <List<TravelDestination>> getTravelDestinationsByCountry (
		@PathVariable(value="country") String country) throws TravelDestinationNotFoundException {
	
	List <TravelDestination> travelDestinationsByCountry = travelDestinationService.findTravelDestinationsByCountry(country);
	if (travelDestinationsByCountry.isEmpty()) {
		throw new TravelDestinationNotFoundException("Travel Destinations Not Found for the Country: " + country);
	}
	return ResponseEntity.status(HttpStatus.FOUND).body(travelDestinationsByCountry);
}

@PutMapping(path ="/{id}") //Post Mapping vs Put Mapping???
public String updateTravelDestination(
		@PathVariable(value="id")Long id, 
		@RequestBody TravelDestination travelDestination) { 
	// RequestBody????
	int updateCount =  travelDestinationService.updateTravelDestination(id, travelDestination);
	
	if (updateCount > 0)
		 return "Travel Destination Updated Successfully For ID: " + id;
	else 
		return "Travel Destination Not Updated Successfully For ID: " + id;

}
@GetMapping (path ="/id/{id}")
public ResponseEntity <TravelDestination> getTravelDestinationById (
		@PathVariable(value="id")Long id) throws TravelDestinationNotFoundException {

	Optional <TravelDestination> travelDestination = travelDestinationService.findTravelDestinationById(id);
	
	if (!travelDestination.isPresent()) {
		throw new TravelDestinationNotFoundException("Travel Destination Not Found for the ID: " + id);
	}
	
	return ResponseEntity.status(HttpStatus.FOUND).body(travelDestination.get());
}
@DeleteMapping (path = "/{id}")
public String deleteTravelDestination(@PathVariable(value = "id")Long id) {
	travelDestinationService.deleteTravelDestinationById(id);
	return "Travel Destination Deleted Successfully For ID: " + id;
	
}
}


