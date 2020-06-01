package cova.rar.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import cova.rar.entities.RequestedInventory;

public class RequestService {
	
	private final String ACCESS_TOKEN = "1234123412341234";
	private final String REQUEST_INVENTORY = "http://localhost:8084/Freddy-s-Surplus-Supplies/requestInventory";
	
	@Autowired
	RestTemplate restTemplate;
	
	public void sendInventoryRequest(RequestedInventory request) {

		//set your headers
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("accessToken", ACCESS_TOKEN);

		//set your entity to send
		HttpEntity<RequestedInventory> entity = new HttpEntity<RequestedInventory>(request, headers);

		// send it!
		ResponseEntity<Void> out = restTemplate.exchange(REQUEST_INVENTORY, HttpMethod.PUT, entity
		    , Void.class);
		System.out.println(out.getBody().toString());
	}

}
 