package com.rodrigor.meat.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigor.meat.domain.Menu;

@RestController
@RequestMapping(value="/menu")
public class MenuResource extends GenericResource<Menu> {

}
