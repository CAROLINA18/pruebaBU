package com.BU.springboot.backend.apirest.DTO;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class RegionDTO {
	
    public RegionDTO(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
	
	private Long id;
	private String nombre;


}
