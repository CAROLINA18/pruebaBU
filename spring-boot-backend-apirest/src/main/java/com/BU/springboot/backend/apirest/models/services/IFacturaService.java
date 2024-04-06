package com.BU.springboot.backend.apirest.models.services;

import java.util.List;

import com.BU.springboot.backend.apirest.DTO.FacturaDTO;
import com.BU.springboot.backend.apirest.DTO.ProductoDTO;
import com.BU.springboot.backend.apirest.models.entity.Factura;
import com.BU.springboot.backend.apirest.models.entity.Producto;

public interface IFacturaService {
	
public FacturaDTO findFacturaById(Long id);
	
	public FacturaDTO saveFactura(FacturaDTO factura);
	
	public void deleteFacturaById(Long id);
	
	public List<ProductoDTO> findProductoByNombre(String term);

}
