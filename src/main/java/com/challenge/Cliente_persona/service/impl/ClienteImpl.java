package com.challenge.Cliente_persona.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.challenge.Cliente_persona.model.dao.ClienteDao;
import com.challenge.Cliente_persona.model.dto.ClienteDto;
import com.challenge.Cliente_persona.model.entity.Cliente;
import com.challenge.Cliente_persona.model.mappers.ClienteMapper;
import com.challenge.Cliente_persona.service.ICliente;
@Service
public class ClienteImpl implements ICliente{
	@Autowired
	private ClienteDao clienteDao;
	@Autowired
	private ClienteMapper clienteMapper;
	
	@Override
	@Transactional
	public Cliente save(ClienteDto clientedto) {
		 // Convertir DTO a entidad
	    Cliente cliente = clienteMapper.toEntity(clientedto);
	    // Guardar la entidad  
	    System.out.println(cliente);
	    return clienteDao.save(cliente);
	}

	@Override
	public void delete(Cliente cliente) {
		// TODO Auto-generated method stub
		clienteDao.delete(cliente);
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return clienteDao.existsById(id);
	}
	@Transactional(readOnly = true)
	@Override
	public Cliente findById(Integer id) {
		// TODO Auto-generated method stub
		return clienteDao.findById(id).orElse(null);
	}

}
