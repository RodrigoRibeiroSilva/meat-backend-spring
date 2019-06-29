package com.rodrigor.meat.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rodrigor.meat.domain.BaseObject;
import com.rodrigor.meat.services.GenericService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


public class GenericResource<E extends BaseObject> {

	@Autowired
	protected GenericService<E> service;

	@RequestMapping(method = RequestMethod.GET)
	public Page<E> list(Pageable pageable) {
		Page<E> page = (Page<E>) service.findAll(pageable);
		return page;
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public E get(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<E> insert(@Valid @RequestBody E entity) {
		service.insert(entity);
		//URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entity.getId()).toUri();
		return ResponseEntity.ok().body(entity);

	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseEntity<E> update(@PathVariable(value = "id") Long id, @RequestBody E entity) {
		service.update(entity, id);
		return ResponseEntity.ok().body(entity);
	}
	
	@ApiResponses(value = {
			@ApiResponse(code = 404, message = "Código inexistente") 
	})
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(value = "id") Long id) {
		service.delete(id);
	}
}
