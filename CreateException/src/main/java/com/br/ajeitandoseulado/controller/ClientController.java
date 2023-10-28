package com.br.ajeitandoseulado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.ajeitandoseulado.VO.ClientVO;
import com.br.ajeitandoseulado.service.ClientService;

@CrossOrigin(origins = "localhost:8085")
@RestController
@RequestMapping("/api")
public class ClientController {

	@Autowired
	private ClientService service;
	
	
	@GetMapping("/client")
	public ResponseEntity<List<ClientVO>> findAll(){
		
		var vo = service.findAll();
		
		return new ResponseEntity<>(vo, HttpStatus.OK);
	}
	
	@GetMapping("/client/{id}")
	public ResponseEntity<ClientVO> findById(@PathVariable(value = "id") Long id){
		
		var vo = service.findById(id);
		
		return new ResponseEntity<>(vo, HttpStatus.OK);
	}
	
	@PostMapping("/client")
	public ResponseEntity<ClientVO> create(@RequestBody ClientVO client){
		
		var vo = service.create(client);
		
		return new ResponseEntity<>(vo, HttpStatus.CREATED);
	}
	
	@PutMapping("/client/{id}")
	public ResponseEntity<ClientVO> update(@RequestBody ClientVO client){
		
		var vo = service.update(client);
		
		return new ResponseEntity<>(vo, HttpStatus.OK);
	}
	
	@DeleteMapping("/client/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable(value = "id") Long id){
		
		service.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
