package com.br.ajeitandoseulado.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.br.ajeitandoseulado.VO.ClientVO;

@Service
public interface ClientService {
	
	public List<ClientVO> findAll();
	public ClientVO findById(Long id);
	public ClientVO create(ClientVO client);
	public ClientVO update(ClientVO client);
	public void deleteById(Long id);

}
