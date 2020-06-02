package cova.rar.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import cova.rar.entities.RequestedInventory;

public class RequestService {
	
	private final String ACCESS_TOKEN = "1234123412341234";
	private final String REQUEST_INVENTORY = "http://localhost:8083/Freddy-s-Surplus-Supplies/requestInventory";
	private final String GET_PENDING_INVENTORY_REQUEST = "http://localhost:8083/Freddy-s-Surplus-Supplies/getPendingRequests";
	
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
		ResponseEntity<Void> out = null;
		try {
			out = restTemplate.exchange(REQUEST_INVENTORY, HttpMethod.POST, entity, Void.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public List<RequestedInventory> getPendingRequests() {
		//set your headers
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);
				headers.set("accessToken", ACCESS_TOKEN);

				//set your entity to send
				HttpEntity<Void> entity = new HttpEntity<Void>(headers);

				// send it!
				ResponseEntity<List<RequestedInventory>> out = null;
				try {
					out = restTemplate.exchange(GET_PENDING_INVENTORY_REQUEST, HttpMethod.GET, entity,
							new ParameterizedTypeReference<List<RequestedInventory>>(){});
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
				if (null != out && out.getStatusCode() == HttpStatus.FOUND) {
					return out.getBody();
				}
				else {
					return null;
				}
				
	}
	
//	public int getPendingRequestAmount(String prodID) {
//
//		//set your headers
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		headers.set("accessToken", ACCESS_TOKEN);
//
//		//set your entity to send
//		HttpEntity<String> entity = new HttpEntity<String>(prodID, headers);
//
//		// send it!
//		ResponseEntity<RequestedInventory> out = restTemplate.exchange(GET_PENDING_INVENTORY_REQUEST, HttpMethod.GET, entity, RequestedInventory.class);
//		return out.getBody().getRequest_qty();
//	}

}
 