package com.challenge.Cliente_persona.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public ResponseEntity<?> create(@RequestBody ClienteDto clienteDto) {		
		Cliente clienteSave = null;
        try {
        	clienteSave = clienteService.save(clienteDto);
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
	@PutMapping("cliente/{id}")
	public ResponseEntity<?> update(@RequestBody ClienteDto clienteDto,@PathVariable Long id) {
		Cliente clienteUpdate = null;
        try {
            if (clienteService.existsByclienteid(id)) {
            	clienteDto.setClienteid(id);
            	clienteUpdate = clienteService.save(clienteDto);
                return new ResponseEntity<>(MensajeResponse.builder()
                        .mnesaje("Guardado correctamente")
                        .object(cuentaMapper.toDTO(clienteUpdate))
                        .build()
                        , HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(
                        MensajeResponse.builder()
                                .mnesaje("El registro que intenta actualizar no se encuentra en la base de datos.")
                                .object(null)
                                .build()
                        , HttpStatus.NOT_FOUND);
            }
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mnesaje(exDt.getMessage())
                            .object(null)
                            .build()
                    , HttpStatus.METHOD_NOT_ALLOWED);
        }
		
	}
	@DeleteMapping("cliente/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		 try {
	            Cliente clienteDelete = clienteService.findByclienteid(id);
	            clienteService.delete(clienteDelete);
	            return new ResponseEntity<>(clienteDelete, HttpStatus.NO_CONTENT);
	        } catch (DataAccessException exDt) {
	            return new ResponseEntity<>(
	                    MensajeResponse.builder()
	                            .mnesaje(exDt.getMessage())
	                            .object(null)
	                            .build()
	                    , HttpStatus.METHOD_NOT_ALLOWED);
	        }
	}
	@GetMapping("cliente/{id}")
	public ResponseEntity<?> showById(@PathVariable Long id) {
		Cliente cliente = clienteService.findByclienteid(id);

	        if (cliente == null) {
	            return new ResponseEntity<>(
	                    MensajeResponse.builder()
	                            .mnesaje("El registro que intenta buscar, no existe!!")
	                            .object(null)
	                            .build()
	                    , HttpStatus.NOT_FOUND);
	        }

	        return new ResponseEntity<>(
	                MensajeResponse.builder()
	                        .mnesaje("")
	                        .object(cuentaMapper.toDTO(cliente))
	                        .build()
	                , HttpStatus.OK);
	    }
}
