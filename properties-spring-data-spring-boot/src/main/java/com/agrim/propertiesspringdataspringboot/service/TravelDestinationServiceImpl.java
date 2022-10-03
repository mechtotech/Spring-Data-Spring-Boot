package com.agrim.propertiesspringdataspringboot.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agrim.propertiesspringdataspringboot.entity.TravelDestination;
import com.agrim.propertiesspringdataspringboot.exception.TravelDestinationNotFoundException;
import com.agrim.propertiesspringdataspringboot.repository.TravelDestinationRepository;

@Service(value ="tds")
@Transactional
public class TravelDestinationServiceImpl implements TravelDestinationService {
	
	private TravelDestinationRepository travelDestinationRepository;
	
@Autowired//inject the dependancy
	public TravelDestinationServiceImpl(TravelDestinationRepository travelDestinationRepository) {
		super();
		this.travelDestinationRepository = travelDestinationRepository;
	}
//? can we use Lombok here to avoid constructor??- only for Entity package/class

	@Override
	public TravelDestination addTravelDestination(TravelDestination travelDestination) {
		
		travelDestination = travelDestinationRepository.save(travelDestination);
		                    //repository implementation object
		
		return travelDestination;
	}

	@Override
	public List<TravelDestination> findAllTravelDestinations() {
		Iterable <TravelDestination> allTravelDestinations = travelDestinationRepository.findAll();
		return (List<TravelDestination>) allTravelDestinations;
	}

	@Override
	public int updateTravelDestination(Long id, TravelDestination travelDestination) {
		int updateCount = 0;
		if( travelDestination.getPlaceName().equals("")|| travelDestination.getCountry().equals("")) {
			updateCount=0;
		}
		else {
		updateCount = travelDestinationRepository.updateTravelDestination(id, 
 				travelDestination.getPlaceName(), travelDestination.getCountry());
		}
	
	return updateCount;
		
		
	}


	@Override
	
	public List<TravelDestination> findTravelDestinationsByCountry(String country) throws TravelDestinationNotFoundException{
		List<TravelDestination> travelDestinations = travelDestinationRepository.findByCountry(country);
	
		return travelDestinations;
	}
	
	@Override
	public Optional <TravelDestination> findTravelDestinationById(Long id) throws TravelDestinationNotFoundException {
		
		Optional <TravelDestination>  travelDestination = travelDestinationRepository.findById(id);
	
		return travelDestination;
	}

	
	@Override
	public void deleteTravelDestinationById(Long id) {
		travelDestinationRepository.deleteById(id);
		
	}
		
	}

