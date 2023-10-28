package com.br.ajeitandoseulado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.ajeitandoseulado.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
