package com.agrim.propertiesspringdataspringboot.service;

import java.util.List;
import java.util.Optional;

import com.agrim.propertiesspringdataspringboot.entity.TravelDestination;
import com.agrim.propertiesspringdataspringboot.exception.TravelDestinationNotFoundException;

public interface TravelDestinationService {
	TravelDestination addTravelDestination(TravelDestination travelDestination);
	List<TravelDestination> findAllTravelDestinations();
	
	int updateTravelDestination(Long id, TravelDestination travelDestination);
	
	
	List<TravelDestination> findTravelDestinationsByCountry(String country) throws TravelDestinationNotFoundException;
	Optional <TravelDestination> findTravelDestinationById(Long id) throws TravelDestinationNotFoundException;
	void deleteTravelDestinationById(Long id);
	
	
}
