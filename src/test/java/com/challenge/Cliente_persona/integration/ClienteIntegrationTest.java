package com.challenge.Cliente_persona.integration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import java.awt.PageAttributes.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;


import com.challenge.Cliente_persona.model.dao.ClienteDao;
import com.challenge.Cliente_persona.model.dto.ClienteDto;
import com.challenge.Cliente_persona.model.entity.Cliente;


@Transactional
public class ClienteIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ClienteDao clienteDao;

    private ClienteDto clienteDto;

    @BeforeEach
    public void setUp() {
    	
    	MockitoAnnotations.openMocks(this);

        ClienteDto.ClienteDtoBuilder clienteDto = ClienteDto.builder();
        clienteDto.clienteid( (long) 100);
        clienteDto.contrasena("password123");
        clienteDto.direccion("Calle Falsa 123");
        clienteDto.edad(30);
        clienteDto.estado(true);
        clienteDto.genero( "M" );
        clienteDto.identificacion("123456789" );
        clienteDto.nombre("Juan Perez");
        clienteDto.telefono("0987654321");
    	
    }
    @Test
    public void testSaveClienteIntegration() throws Exception {

        String json = "{"
                + "\"nombre\":\"" + clienteDto.getNombre() + "\","
                + "\"genero\":\"" + clienteDto.getGenero() + "\","
                + "\"edad\":" + clienteDto.getEdad() + ","
                + "\"identificacion\":\"" + clienteDto.getIdentificacion() + "\","
                + "\"direccion\":\"" + clienteDto.getDireccion() + "\","
                + "\"telefono\":\"" + clienteDto.getTelefono() + "\","
                + "\"clienteid\":\"" + clienteDto.getClienteid() + "\","
                + "\"contrasena\":\"" + clienteDto.getContrasena() + "\","
                + "\"estado\":" + clienteDto.getEstado()
                + "}";

        mockMvc.perform(post("/api/v1/cliente")  
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated());

        Cliente savedCliente = clienteDao.findByclienteid((long) 100);
        assertThat(savedCliente).isNotNull();
        assertThat(savedCliente.getNombre()).isEqualTo("Juan Perez");
    }
   
}