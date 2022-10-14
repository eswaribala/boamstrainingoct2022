package com.boa.customerapi.controllers;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boa.customerapi.models.Individual;
import com.boa.customerapi.payloads.ResponseWrapper;

import com.boa.customerapi.services.IndividualService;
import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@RestController
@RequestMapping("/individuals")
public class IndividualController {
	  private static final Logger LOGGER = LogManager.getLogger(IndividualController.class);
	@Autowired
	private IndividualService individualService;
	
	//post
	@PostMapping({"/v1.0/"})
	public ResponseEntity<String> addIndividual(@RequestBody Individual individual) {
		
	  Individual individualObj=this.individualService.addIndividual(individual);
	  Gson gson=new Gson();
	  if(individualObj!=null) {
		  return ResponseEntity.status(HttpStatus.CREATED)
				  .body(gson.toJson(individualObj));
	  }
	  else
	  {
		  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				  .body("Customer Data Not saved");
	  }
	}
	
	
	//post
		@PostMapping({"/v1.1/"})
		public ResponseEntity<ResponseWrapper> addIndividualV11(@RequestBody Individual individual) {
			
		  Individual individualObj=this.individualService.addIndividual(individual);
		  
		  if(individualObj!=null) {
			  return ResponseEntity.status(HttpStatus.CREATED)
					  .body(new ResponseWrapper(individualObj));
		  }
		  else
		  {
			  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					  .body(new ResponseWrapper("v1.1","Customer could not be added"));
		  }
		}
	
	//get
	@GetMapping({"/v1.0"})
	public List<Individual> getIndividuals(){
		 
	        LOGGER.info("Info level log message");
	        LOGGER.debug("Debug level log message");
	        LOGGER.error("Error level log message");
		return this.individualService.viewAllIndividuals();
	}
	
	@GetMapping({"/v1.0/{customerId}"})
	public Individual getIndividualById(@PathVariable("customerId") long customerId) {
	   return this.individualService.viewIndividualById(customerId);	
	}
	
	@DeleteMapping({"/v1.0/{customerId}"})
	public ResponseEntity<String> deleteIndividualById(@PathVariable("customerId") long customerId) {
	   if(this.individualService.deleteIndividualById(customerId)) {
		   return ResponseEntity.status(HttpStatus.ACCEPTED)
					  .body("Customer Object Deleted");
	   }
	   else
	   {
		   return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					  .body("Customer Id not existing");
	   }
	}
	
	@PutMapping({"/v1.0/{customerId}"})
	public ResponseEntity<String> updateIndividual(@PathVariable("customerId") long customerId,
			@RequestParam(name = "email") String email, 
			@RequestParam(name="contactNumber") long contactNumber) {
		 Individual individualObj=this.individualService.updateIndividual(customerId,
				 email, contactNumber);
		  Gson gson=new Gson();
		  if(individualObj!=null) {
			  return ResponseEntity.status(HttpStatus.CREATED)
					  .body(gson.toJson(individualObj));
		  }
		  else
		  {
			  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					  .body("Customer Data Not updated");
		  }
	}
	
	
	
	
}
