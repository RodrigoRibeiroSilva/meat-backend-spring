package com.rodrigor.meat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rodrigor.meat.domain.Client;
import com.rodrigor.meat.repositories.ClientRepository;

@Service
public class ClientService extends GenericService<Client>{
	
	@Autowired
	private ClientRepository repo;
	@Autowired
	private BCryptPasswordEncoder encrypt;
	
	public Client findByEmail(String email) {
		return repo.findByEmail(email);
	}
	
	@Override
	@Transactional
	public Client insert(Client obj) {
		obj.setId(null);
		obj.setPassword(encrypt.encode(obj.getPassword()));
		obj = repo.save(obj);
		return obj;
		 
	}

}
