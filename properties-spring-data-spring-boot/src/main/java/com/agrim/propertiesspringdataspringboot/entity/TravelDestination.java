package com.agrim.propertiesspringdataspringboot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "travel_destination")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class TravelDestination {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String country;
	private String placeName;
	
	//? How do I change primary key for the table DB?
	
	
	
	
	

}
