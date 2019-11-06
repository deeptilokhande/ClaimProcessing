package com.deepti.restclient.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.deepti.restclient.model.Claims;

@RestController
public class CopyCatController {

	@Autowired
	private RestTemplate rt;
	 final String baseurl = "http://localhost:8080/claims" ;
	
 
	  @GetMapping("/copycat/claims") 
	  public List<Claims> getList(){ 
		 ResponseEntity<List<Claims>> responseList =  rt.exchange(baseurl,
				 HttpMethod.GET,
				 null,
				 new ParameterizedTypeReference<List<Claims> >() {
				});
          List<Claims> list = responseList.getBody();
          return list;
 }
 
  
  
  @GetMapping("/copycat/claims/{id}")	
  public  Claims getList(@PathVariable int id){
	 final String url = "http://localhost:8080/claims/"+id;
	 Claims c =  rt.getForObject(url, Claims.class);
	 return c;
}	
  
  @PostMapping("/copycat/claims")
  public ResponseEntity<String> postClaim() {
	  Claims c = new Claims(34,34.0,"sdds",34.0,898 );
	  String r= rt.postForObject(baseurl, c, String.class);
	return  ResponseEntity.ok(r);
  }
  
	
}
