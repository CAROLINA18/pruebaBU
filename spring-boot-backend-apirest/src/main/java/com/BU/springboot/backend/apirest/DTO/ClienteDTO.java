package com.BU.springboot.backend.apirest.DTO;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.BU.springboot.backend.apirest.models.entity.Factura;
import com.BU.springboot.backend.apirest.models.entity.Region;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ClienteDTO {
	private Long id;
	private String nombre;
	private String apellido;
	private String email;
	private Date createAt;
	private String foto;
	private Region region;
	private List<Factura> facturas;
}
