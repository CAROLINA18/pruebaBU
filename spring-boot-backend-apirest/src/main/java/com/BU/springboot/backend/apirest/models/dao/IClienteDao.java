package com.BU.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.BU.springboot.backend.apirest.DTO.RegionDTO;
import com.BU.springboot.backend.apirest.models.entity.Cliente;
import com.BU.springboot.backend.apirest.models.entity.Region;

public interface IClienteDao extends JpaRepository<Cliente, Long>{

	@Query("select new com.BU.springboot.backend.apirest.DTO.RegionDTO(r.id, r.nombre) from Region r")
    public List<RegionDTO> findAllRegiones();
}
