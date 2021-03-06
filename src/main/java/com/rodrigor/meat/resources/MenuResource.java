package com.rodrigor.meat.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigor.meat.domain.MenuItem;

@RestController
@RequestMapping(value="/menu")
public class MenuResource extends GenericResource<MenuItem> {

}
