package com.challenge.Cliente_persona.model.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.challenge.Cliente_persona.model.entity.Cliente;

public interface ClienteDao extends JpaRepository<Cliente, Integer>  {

}
