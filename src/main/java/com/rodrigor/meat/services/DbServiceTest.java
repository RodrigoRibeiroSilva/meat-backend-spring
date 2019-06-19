package com.rodrigor.meat.services;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigor.meat.domain.Address;
import com.rodrigor.meat.domain.Client;
import com.rodrigor.meat.domain.MenuItem;
import com.rodrigor.meat.domain.OrderItem;
import com.rodrigor.meat.domain.OrderPurchase;
import com.rodrigor.meat.domain.Restaurant;
import com.rodrigor.meat.domain.Review;
import com.rodrigor.meat.repositories.OrderItemRepository;
import com.rodrigor.meat.repositories.OrderPurchaseRepository;
import com.rodrigor.meat.repositories.RestaurantRepository;
import com.rodrigor.meat.repositories.ReviewRepository;

@Service
public class DbServiceTest {

	@Autowired
	private ReviewRepository reviewRepo;
	@Autowired
	private MenuService menuService;
	@Autowired
	private RestaurantRepository restRepo;
	@Autowired
	private ClientService clientService;
	@Autowired
	private OrderPurchaseRepository orderPurchaseRepository;
	@Autowired
	private OrderItemRepository orderItemRepository;

	public void instantiateTestDatabase() throws ParseException {

		Restaurant restaurant = new Restaurant("Bread & Bakery", "Bakery", "25m",
				"assets/img/restaurants/breadbakery.png",
				"A Bread & Brakery tem 40 anos de mercado. Fazemos os melhores doces e pães. Compre e confira.",
				"Funciona de segunda à sexta, de 8h às 23h", 4.9);

		Review review = new Review("Ana", "2017-01-23T18:25:43",
				"Rápido e sempre uma delicia!! Ja pedi 3x e sempre veio rapido e tudo certinho.", 5.0, restaurant);
		MenuItem menu = new MenuItem("assets/img/foods/cupcake.png", "Cup Cake", "Cup Cake recheado de Doce de Leite",
				new BigDecimal(8.7), restaurant);

		restaurant.addReview(review);
		restaurant.addMenuItem(menu);

		restRepo.save(restaurant);
		reviewRepo.save(review);
		menuService.insert(menu);

		Address address = new Address("Av. Joaquim Ribeiro 800", "", "545454", "50980-000");

		Client teste = new Client("Rodrigo Ribeiro", "teste@teste.com", address, "123");
		address.setClient(teste);
		clientService.insert(teste);
		//---------------------------------------------------------------------------------------------
		
		OrderPurchase order1 = new OrderPurchase(teste);
		
		teste.getOrderList().addAll(Arrays.asList(order1));
		
		orderPurchaseRepository.save(order1);
		
		
		
		
		OrderItem orderItem = new OrderItem(order1, menu, 5, 200.0);
		order1.getItems().addAll(Arrays.asList(orderItem));
		menu.getItems().addAll(Arrays.asList(orderItem));
		  
		orderItemRepository.save(orderItem);
		 
		
		
		


	}
}
