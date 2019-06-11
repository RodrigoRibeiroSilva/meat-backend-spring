package com.rodrigor.meat.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigor.meat.domain.Client;
import com.rodrigor.meat.services.ClientService;

@RestController
@RequestMapping(value="/clients")
public class ClientResource extends GenericResource<Client> {
	
	@Autowired
	private ClientService service;
	
	@Override
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Client> insert(@Valid @RequestBody Client entity) {
		this.service.insert(entity);
		//URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entity.getId()).toUri();
		return ResponseEntity.ok().body(entity);
	}
	
	

}
