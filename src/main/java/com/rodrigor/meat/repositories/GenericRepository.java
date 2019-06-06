package com.rodrigor.meat.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rodrigor.meat.domain.BaseObject;

@Repository
public interface GenericRepository<E extends BaseObject> extends JpaRepository<E, Serializable>{
	
}
