package cova.rar.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cova.rar.entities.RequestedInventory;
import cova.rar.service.ProductService;


@RestController
public class InventoryRequestController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/acceptRequest", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RequestedInventory> acceptRequest(@RequestBody RequestedInventory returnedRequest) {
		
		boolean success = productService.updateProductInventory(returnedRequest.getProduct_id(), returnedRequest.getRequest_qty());
		
		if (success) {
			return new ResponseEntity<RequestedInventory>(returnedRequest, HttpStatus.ACCEPTED);
		}
		else {
			return new ResponseEntity<RequestedInventory>(returnedRequest, HttpStatus.CONFLICT);
		}

	}
	
	@RequestMapping(value = "/denyRequest", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RequestedInventory> denyRequest(@RequestBody RequestedInventory returnedRequest) {
	
		return new ResponseEntity<RequestedInventory>(returnedRequest, HttpStatus.ACCEPTED);
	}
	
	

}
