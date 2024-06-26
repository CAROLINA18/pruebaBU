package com.BU.springboot.backend.apirest.models.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.SliceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.BU.springboot.backend.apirest.DTO.ClienteDTO;
import com.BU.springboot.backend.apirest.DTO.RegionDTO;
import com.BU.springboot.backend.apirest.models.dao.IClienteDao;
import com.BU.springboot.backend.apirest.models.entity.Cliente;
import com.BU.springboot.backend.apirest.models.entity.Region;
import org.modelmapper.ModelMapper;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteDao clienteDao;
	@Autowired
    private ModelMapper modelMapper;

	@Override
	@Transactional(readOnly = true)
    public List<ClienteDTO> findAll() {
        List<Cliente> clientes = clienteDao.findAll();
        return clientes.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Page<ClienteDTO> findAll(Pageable pageable) {
        Page<Cliente> clientesPage = clienteDao.findAll(pageable);
        List<ClienteDTO> clienteDTOList = clientesPage.getContent().stream()
                                             .map(this::convertToDTO)
                                             .collect(Collectors.toList());
        return new PageImpl<>(clienteDTOList, pageable, clientesPage.getTotalElements());
    }

    private ClienteDTO convertToDTO(Cliente cliente) {
        ClienteDTO clienteDTO = modelMapper.map(cliente, ClienteDTO.class);
        clienteDTO.setRegion(cliente.getRegion());
        return clienteDTO;
    }

	@Override
	@Transactional(readOnly = true)
	public ClienteDTO findById(Long id) {
        Optional<Cliente> clienteOptional = clienteDao.findById(id);
        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            return modelMapper.map(cliente, ClienteDTO.class);
        }
        return null;
    }

	@Override
	@Transactional
    public ClienteDTO save(ClienteDTO clienteDTO) {
        Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
        cliente = clienteDao.save(cliente);
        return modelMapper.map(cliente, ClienteDTO.class);
    }
	@Override
	@Transactional
	public void delete(Long id) {
		clienteDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
    public List<RegionDTO> findAllRegiones() {
        List<RegionDTO> regiones = clienteDao.findAllRegiones();
        return regiones.stream()
                       .map(region -> modelMapper.map(region, RegionDTO.class))
                       .collect(Collectors.toList());
    }

}
