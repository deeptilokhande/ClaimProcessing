package com.deepti.claimprocessing.Resource;
  import java.util.Iterator;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deepti.claimprocessing.model.Claims;
import com.deepti.claimprocessing.repository.ClaimsRepository;

import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder.*;
 


@RestController
public class ClaimsResourceController {
	
	@Autowired
	ClaimsRepository repo;
	
	@GetMapping("/claims")
	public ResponseEntity<List<Claims>>  getAllClaims(@RequestParam(value="page",defaultValue="1") int page,
			@RequestParam(value="limit",defaultValue="5") int limit) {
		List<Claims> list =repo.findAll();

		//list.stream().forEach(System.out::println);
		Iterator<Claims> i = list.iterator();
		int count=0;
		while(i.hasNext()) {
			count++;
			Claims c =   i.next();
			if(count>limit) {
				i.remove();
			}
			
		}
		
		return new ResponseEntity<List<Claims>>(list,HttpStatus.OK);
		
	}
	
	@GetMapping("/claims/{id}")
	public ResponseEntity<Optional<Claims>> getClaimById(@PathVariable("id") int id) {
		
		Optional<Claims> c = repo.findById(id);
		return new ResponseEntity<Optional<Claims>>(c,HttpStatus.OK);
		
	}
	
	
	@PostMapping("/claims")
	public ResponseEntity<Claims> addClaim(@RequestBody Claims c) {
		
		Claims res = repo.save(c);
		  
		return new ResponseEntity<>(res,HttpStatus.CREATED);
	}
	
	
	@PutMapping("/claims")
	public ResponseEntity<Claims> updateClaim(@RequestBody Claims c){
			Claims res =repo.save(c);
			return new ResponseEntity<Claims>(res,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/claims/{id}")
	public ResponseEntity<String> deleteClaim(@PathVariable int id) {
		
		if (repo.existsById(id)) {
		repo.deleteById(id);
		return new ResponseEntity<String>("Record successfully deleted", HttpStatus.OK);
		}
		return new ResponseEntity<String>("No record with id :"+id,HttpStatus.NOT_FOUND);
		
	}
	

}
