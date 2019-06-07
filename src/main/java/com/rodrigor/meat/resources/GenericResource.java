package com.rodrigor.meat.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public ResponseEntity<E> insert(@Valid @RequestBody E entity) {
		service.insert(entity);
		//URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entity.getId()).toUri();
		return ResponseEntity.ok().body(entity);

	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseEntity<E> update(@PathVariable(value = "id") Integer id, @RequestBody E entity) {
		service.update(entity, id);
		return ResponseEntity.ok().body(entity);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(value = "id") Integer id) {
		service.delete(id);
	}
}
