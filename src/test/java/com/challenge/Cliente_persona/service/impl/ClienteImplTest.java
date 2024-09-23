package com.challenge.Cliente_persona.service.impl;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.challenge.Cliente_persona.model.dao.ClienteDao;
import com.challenge.Cliente_persona.model.dto.ClienteDto;
import com.challenge.Cliente_persona.model.entity.Cliente;
import com.challenge.Cliente_persona.model.mappers.ClienteMapper;

public class ClienteImplTest {

    @Mock
    private ClienteDao clienteDao;

    @Mock
    private ClienteMapper clienteMapper;

    @InjectMocks
    private ClienteImpl clienteService;

    private ClienteDto clienteDto;
    private Cliente cliente;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        ClienteDto.ClienteDtoBuilder clienteDto = ClienteDto.builder();
        clienteDto.clienteid( (long) 1);
        clienteDto.contrasena("password123");
        clienteDto.direccion("Calle Falsa 123");
        clienteDto.edad(30);
        clienteDto.estado(true);
        clienteDto.genero( "M" );
        clienteDto.identificacion("123456789" );
        clienteDto.nombre("Juan Perez");
        clienteDto.telefono("0987654321");

        cliente = new Cliente();
        cliente.setNombre("Juan Perez");
        cliente.setGenero("Masculino");
        cliente.setEdad(30);
        cliente.setIdentificacion("123456789");
        cliente.setDireccion("Calle Falsa 123");
        cliente.setTelefono("0987654321");
        cliente.setContrasena("password123");
        cliente.setEstado(true);
    }

    @Test
    public void testSaveCliente() {
        
        when(clienteMapper.toEntity(clienteDto)).thenReturn(cliente);
        when(clienteDao.save(cliente)).thenReturn(cliente);

        
        Cliente result = clienteService.save(clienteDto);

       
        verify(clienteMapper, times(1)).toEntity(clienteDto);
        verify(clienteDao, times(1)).save(cliente);

        assertThat(result.getNombre()).isEqualTo("Juan Perez");
        assertThat(result.getContrasena()).isEqualTo("password123");
    }
}

