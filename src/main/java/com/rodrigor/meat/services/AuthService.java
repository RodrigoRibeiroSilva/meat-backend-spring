package com.rodrigor.meat.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rodrigor.meat.domain.Client;
import com.rodrigor.meat.repositories.ClientRepository;
import com.rodrigor.meat.services.exceptions.ObjectNotFoundException;

@Service
public class AuthService {
	
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private BCryptPasswordEncoder pe;
	
	private Random random = new Random();
	
	public void sendNewPassword(String email) {
		Client client = clientRepository.findByEmail(email);
		
		if(client == null) throw new ObjectNotFoundException("Email não encontrado");
		
		String newPass = newPassword();
		client.setPassword(pe.encode(newPass));
		
		clientRepository.save(client);
	}

	private String newPassword() {
		char[] vet = new char[10];
		for(int i=0; i<10; i++) {
			vet[i] = randomChar();
		}			
		return new String(vet);
	}

	private char randomChar() {
		int opt = random.nextInt(3);
		if(opt == 0) { //gera um digito
			return (char) (random.nextInt(10) + 48);
		}
		else if(opt == 1) { //gera letra maiuscula
			return (char) (random.nextInt(26) + 65);
		}
		else { //gera letra minuscula
			return (char) (random.nextInt(26) + 97);
		}
	}
}
