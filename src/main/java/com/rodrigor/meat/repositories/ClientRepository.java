package com.rodrigor.meat.repositories;

import org.springframework.transaction.annotation.Transactional;

import com.rodrigor.meat.domain.Client;

public interface ClientRepository extends GenericRepository<Client>{
	
	@Transactional(readOnly=true)
	Client findByEmail(String email);
}
