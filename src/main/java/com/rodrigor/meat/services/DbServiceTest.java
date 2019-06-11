package com.rodrigor.meat.services;

import java.math.BigDecimal;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigor.meat.domain.Client;
import com.rodrigor.meat.domain.MenuItem;
import com.rodrigor.meat.domain.Restaurant;
import com.rodrigor.meat.domain.Review;
import com.rodrigor.meat.repositories.ClientRepository;
import com.rodrigor.meat.repositories.MenuRepository;
import com.rodrigor.meat.repositories.RestaurantRepository;
import com.rodrigor.meat.repositories.ReviewRepository;

@Service
public class DbServiceTest {
	
	@Autowired
	private ReviewRepository reviewRepo;
	@Autowired
	private MenuRepository menuRepo;
	@Autowired
	private RestaurantRepository restRepo;
	@Autowired
	private ClientService clientService;
	
	
	public void instantiateTestDatabase() throws ParseException {
		
		Restaurant restaurant = new Restaurant("Bread & Bakery", "Bakery","25m",  
				"assets/img/restaurants/breadbakery.png", 
				"A Bread & Brakery tem 40 anos de mercado. Fazemos os melhores doces e pães. Compre e confira.",
				"Funciona de segunda à sexta, de 8h às 23h", 4.9);
		
		Review review = new Review("Ana", "2017-01-23T18:25:43", "Rápido e sempre uma delicia!! Ja pedi 3x e sempre veio rapido e tudo certinho.", 5.0, restaurant);
		MenuItem menu = new MenuItem("assets/img/foods/cupcake.png", "Cup Cake", "Cup Cake recheado de Doce de Leite", new BigDecimal(8.7), restaurant);
		
		restaurant.addReview(review);
		restaurant.addMenuItem(menu);
		
		restRepo.save(restaurant);
		reviewRepo.save(review);
		menuRepo.save(menu);
		
		Client teste = new Client("Rodrigo Ribeiro", "teste@teste.com","Av. Joaquim Ribeiro, 800", "545454", "", "123");
		clientService.insert(teste);
	}
}
