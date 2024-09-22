package com.challenge.Cliente_persona.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.Cliente_persona.model.dto.ClienteDto;
import com.challenge.Cliente_persona.model.entity.Cliente;
import com.challenge.Cliente_persona.model.mappers.ClienteMapper;
import com.challenge.Cliente_persona.model.payload.MensajeResponse;
import com.challenge.Cliente_persona.service.ICliente;



@RestController
@RequestMapping("/api/v1")
public class ClienteController {
	@Autowired
	private ICliente clienteService;
	@Autowired
	private ClienteMapper cuentaMapper;
	@PostMapping("cliente")
	public ResponseEntity<?> create(@RequestBody ClienteDto cuentaDto) {		
		Cliente clienteSave = null;
        try {
        	clienteSave = clienteService.save(cuentaDto);
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mnesaje("Guardado correctamente")
                    .object(cuentaMapper.toDTO(clienteSave))
                    .build()
                    , HttpStatus.CREATED);
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mnesaje(exDt.getMessage())
                            .object(null)
                            .build()
                    , HttpStatus.METHOD_NOT_ALLOWED);
        }
	}
}
