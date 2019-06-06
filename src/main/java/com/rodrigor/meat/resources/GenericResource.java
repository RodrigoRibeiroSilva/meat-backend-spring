package com.rodrigor.meat.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rodrigor.meat.domain.BaseObject;
import com.rodrigor.meat.services.GenericService;


public class GenericResource<E extends BaseObject> {

	@Autowired
	protected GenericService<E> service;

	@RequestMapping(method = RequestMethod.GET)
	public List<E> list() {
		return service.findAll();
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public E get(@PathVariable(value = "id") Integer id) {
		return service.findById(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody E entity) {
		service.insert(entity);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entity.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public E update(@PathVariable(value = "id") Integer id, @RequestBody E entity) {
		return service.update(entity, id);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(value = "id") Integer id) {
		service.delete(id);
	}
}
