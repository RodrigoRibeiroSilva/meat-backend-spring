package com.rodrigor.meat.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigor.meat.domain.Restaurant;

@RestController
@RequestMapping(value="/restaurants")
public class RestaurantResource extends GenericResource<Restaurant> {

}
