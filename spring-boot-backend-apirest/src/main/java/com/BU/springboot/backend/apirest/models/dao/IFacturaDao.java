package com.BU.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.BU.springboot.backend.apirest.DTO.FacturaDTO;
import com.BU.springboot.backend.apirest.models.entity.Factura;

public interface IFacturaDao extends CrudRepository<Factura, Long>{

}
