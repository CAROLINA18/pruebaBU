package com.BU.springboot.backend.apirest.DTO;

import java.io.Serializable;

import com.BU.springboot.backend.apirest.models.entity.Producto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ItemFacturaDTO  {
	
	
	private Long id;
	private Integer cantidad;
	private Producto producto;


}
