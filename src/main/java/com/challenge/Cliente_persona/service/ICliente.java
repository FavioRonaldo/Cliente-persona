package com.challenge.Cliente_persona.service;

import com.challenge.Cliente_persona.model.entity.Cliente;
import com.challenge.Cliente_persona.model.dto.ClienteDto;
public interface ICliente {
	Cliente save(ClienteDto cuentadto);	
	//List<Cuenta> findAllByFechaBetween(Date fechaInicio, Date fechaFin);
	void delete(Cliente cliente);
	Cliente findByclienteid(Long id);
	boolean existsByclienteid(Long id);
}
