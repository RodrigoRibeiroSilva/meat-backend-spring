package com.rodrigor.meat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rodrigor.meat.domain.Client;
import com.rodrigor.meat.repositories.ClientRepository;
import com.rodrigor.meat.security.UserSS;

@Service
public class UserDetailsServiceImp implements UserDetailsService{
	
	@Autowired
	private ClientRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Client client = repo.findByEmail(email);
		
		if(client.equals(null)) {
			throw new UsernameNotFoundException(email);
		}
		return new UserSS(client.getId(), client.getEmail(), client.getPassword(), client.getProfile());
	}

}
