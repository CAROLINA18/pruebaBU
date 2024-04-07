package com.BU.springboot.backend.apirest.models.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.BU.springboot.backend.apirest.DTO.FacturaDTO;
import com.BU.springboot.backend.apirest.DTO.ProductoDTO;
import com.BU.springboot.backend.apirest.DTO.RegionDTO;
import com.BU.springboot.backend.apirest.models.dao.IFacturaDao;
import com.BU.springboot.backend.apirest.models.dao.IProductoDao;
import com.BU.springboot.backend.apirest.models.entity.Factura;
import com.BU.springboot.backend.apirest.models.entity.Producto;

@Service
public class FacturaServiceImpl implements IFacturaService  {

	@Autowired
	private IFacturaDao facturaDao;
	
	@Autowired
	private IProductoDao productoDao;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@Override
	@Transactional(readOnly = true)
    public FacturaDTO findFacturaById(Long id) {
        Factura factura = facturaDao.findById(id).orElse(null);
        if (factura != null) {
            return modelMapper.map(factura, FacturaDTO.class);
        }
        return null;
    }

	@Override
	@Transactional
    public FacturaDTO saveFactura(FacturaDTO facturaDTO) {
        Factura factura = modelMapper.map(facturaDTO, Factura.class);
        factura = facturaDao.save(factura);
        return modelMapper.map(factura, FacturaDTO.class);
    }

	@Override
	@Transactional
	public void deleteFacturaById(Long id) {
		facturaDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
    public List<ProductoDTO> findProductoByNombre(String term) {
        List<Producto> productos = productoDao.findByNombre(term);
        return productos.stream()
                       .map(this::convertToDto)
                       .collect(Collectors.toList());
    }

    private ProductoDTO convertToDto(Producto producto) {
        ProductoDTO productoDTO = modelMapper.map(producto, ProductoDTO.class);
        return productoDTO;
    }
	
}
