package com.challenge.Cliente_persona.model.entity;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class ClienteTest {

    @Test
    public void testClienteConstructor() {
     
        Cliente cliente = new Cliente(
            "Juan Perez",               // Nombre
            "M",		                // Género
            30,                         // Edad
            "123456789",                // Identificación
            "Calle 123",                // Dirección
            "0987654321",               // Teléfono
            "password123",              // Contraseña
            true                        // Estado
        );

       
        assertThat(cliente.getNombre()).isEqualTo("Juan Perez");
        assertThat(cliente.getGenero()).isEqualTo("M");
        assertThat(cliente.getEdad()).isEqualTo(30);
        assertThat(cliente.getIdentificacion()).isEqualTo("123456789");
        assertThat(cliente.getDireccion()).isEqualTo("Calle 123");
        assertThat(cliente.getTelefono()).isEqualTo("0987654321");
        assertThat(cliente.getContrasena()).isEqualTo("password123");
        assertThat(cliente.getEstado()).isTrue();
    }

    @Test
    public void testClienteSetters() {
        
        Cliente cliente = new Cliente();

        cliente.setNombre("Ana Gomez");
        cliente.setGenero("Femenino");
        cliente.setEdad(25);
        cliente.setIdentificacion("987654321");
        cliente.setDireccion("Avenida 456");
        cliente.setTelefono("1234567890");
        cliente.setContrasena("password456");
        cliente.setEstado(false);


        assertThat(cliente.getNombre()).isEqualTo("Ana Gomez");
        assertThat(cliente.getGenero()).isEqualTo("Femenino");
        assertThat(cliente.getEdad()).isEqualTo(25);
        assertThat(cliente.getIdentificacion()).isEqualTo("987654321");
        assertThat(cliente.getDireccion()).isEqualTo("Avenida 456");
        assertThat(cliente.getTelefono()).isEqualTo("1234567890");
        assertThat(cliente.getContrasena()).isEqualTo("password456");
        assertThat(cliente.getEstado()).isFalse();
    }
}
