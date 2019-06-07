package com.rodrigor.meat.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigor.meat.domain.Client;

@RestController
@RequestMapping(value="/clients")
public class ClientResource extends GenericResource<Client> {

}
