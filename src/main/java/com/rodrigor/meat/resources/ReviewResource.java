package com.rodrigor.meat.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigor.meat.domain.Review;

@RestController
@RequestMapping(value="/reviews")
public class ReviewResource extends GenericResource<Review> {

}
