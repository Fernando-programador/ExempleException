package com.br.ajeitandoseulado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.ajeitandoseulado.VO.ClientVO;
import com.br.ajeitandoseulado.exception.ResourceNotFoundException;
import com.br.ajeitandoseulado.mapper.DozerMapper;
import com.br.ajeitandoseulado.model.Client;
import com.br.ajeitandoseulado.repository.ClientRepository;


@Service
public class ClientServiceImpl implements ClientService{

	
	@Autowired
	private ClientRepository repository;
	
	@Override
	public List<ClientVO> findAll() {
		
		var clients = repository.findAll();
				
		var vo = DozerMapper.listMap(clients, ClientVO.class);
		vo.stream().forEach(p -> findById(p.getId()));
		return vo;
		
	}
	
	
	@Override
	public ClientVO findById(Long id) {
		var entity = repository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("O " + id + " Não foi encontrado!"));
		var vo = DozerMapper.map(entity, ClientVO.class);
		return vo;
	}


	@Override
	public ClientVO create(ClientVO client) {
		client.setId(null);
		
		var newClient = DozerMapper.map(client, Client.class);
		
		var entity = repository.save(newClient);
		
		var vo = DozerMapper.map(entity, ClientVO.class);
		
		return vo;
	}
	
	@Override
	public ClientVO update(ClientVO client) {
		var entity = repository.findById(client.getId()).
				orElseThrow(()-> new ResourceNotFoundException("Cliente Não foi encontrado!"));
		entity.setName(client.getName());
		
		var updateClient = repository.save(entity);
		var vo = DozerMapper.map(updateClient, ClientVO.class);
		return vo;
		
	}
	
	@Override
	public void deleteById(Long id) {
		
		var entity = repository.findById(id).
				orElseThrow(null);
		
		repository.delete(entity);
	}
}
