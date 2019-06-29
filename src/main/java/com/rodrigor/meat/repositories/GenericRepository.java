package com.rodrigor.meat.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.rodrigor.meat.domain.BaseObject;

@Repository
public interface GenericRepository<E extends BaseObject> extends PagingAndSortingRepository<E, Long>{
	
}
