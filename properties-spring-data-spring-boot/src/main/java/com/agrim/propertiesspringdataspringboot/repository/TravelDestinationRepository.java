package com.agrim.propertiesspringdataspringboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.agrim.propertiesspringdataspringboot.entity.TravelDestination;

public interface TravelDestinationRepository extends CrudRepository<TravelDestination, Long> {

	@Query("SELECT td FROM TravelDestination td WHERE td.country = :country")
	List<TravelDestination> findByCountry( @Param("country") String country);

	//int updateTravelDestination(Long id, String placeName, String country); 
	
	@Modifying
	@Query("UPDATE TravelDestination td SET td.placeName = :placeName, td.country = :country WHERE "
             + "td.id = :id")
	int updateTravelDestination(@Param("id") Long id,@Param("placeName") String placeName,@Param("country") String country); 
	
}
