package com.rodrigor.meat.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.rodrigor.meat.domain.BaseObject;
import com.rodrigor.meat.repositories.GenericRepository;
import com.rodrigor.meat.services.exceptions.DataIntegrityException;
import com.rodrigor.meat.services.exceptions.ObjectNotFoundException;

public class GenericService<E extends BaseObject> {
	
	@Autowired
	protected GenericRepository<E> repo;
	
	public List<E> findAll(){
		return repo.findAll();
	}
	
	public E findById(Integer id) {
		Optional<E> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: "));
	}
	
	public E insert(E dto) {
		return repo.save(dto);
	}
	
	public E update(E obj, Integer id) {
		E objTracked = findById(id);
		objTracked = obj;
		return repo.save(objTracked);
	}
	
	public void delete(Integer id) {
		findById(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não foi possível excluir esse registro");
		}	
	}
}
