package com.challenge.Cliente_persona.model.mappers;

import org.mapstruct.Mapper;

import com.challenge.Cliente_persona.model.dto.ClienteDto;
import com.challenge.Cliente_persona.model.entity.Cliente;



@Mapper(componentModel = "spring")
public abstract class ClienteMapper {
	// Mapea de entidad a DTO
		public abstract ClienteDto toDTO(Cliente cliente);

		// Mapea de DTO a entidad
		public abstract Cliente toEntity(ClienteDto clienteDto);
}
