package com.devsuperior.dscommerc_ics.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



import com.devsuperior.dscommerc_ics.dto.ClientDTO;
import com.devsuperior.dscommerc_ics.entities.Client;
import com.devsuperior.dscommerc_ics.repository.ClientRepository;
import com.devsuperior.dscommerc_ics.repository.DatabaseException;
import com.devsuperior.dscommerc_ics.service.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Client client = repository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Recurso Nao Encontrado"));
	 
		return new ClientDTO(client);
		 
	}
	
	
	
	
	@Transactional(readOnly = true)
	public Page<ClientDTO> findAll(Pageable pageable) {
		Page<Client> result = repository.findAll(pageable);
		return result.map(x-> new ClientDTO(x));
		
	}
	
	
	@Transactional
	public ClientDTO insert(ClientDTO dto) {
	Client entity = new Client();
	copyDtoEntity(dto, entity);
	entity = repository.save(entity);
	return new ClientDTO(entity);
	}
	
	
	
	@Transactional
	public ClientDTO update(Long id, ClientDTO dto) {
	 try {
		Client entity = repository.getReferenceById(id);
	    copyDtoEntity(dto, entity);
	    entity = repository.save(entity);
	    return new ClientDTO(entity);
	    } 
	 catch (EntityNotFoundException e) {
		 throw new ResourceNotFoundException("Recurso nao encontrado");
	  }
	}

	
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public void delete(Long id) {
		if (!repository.existsById(id)) {
			throw new ResourceNotFoundException("Recurso nao Encontrado");
		}
		try {
			 repository.deleteById(id);
		}
		
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Falha de integridade referencial");
		}
		
	}
	
	
	private void copyDtoEntity(ClientDTO dto, Client entity) {
		    entity.setName(dto.getName());
			entity.setCpf(dto.getCpf());
			entity.setIncome(dto.getIncome());
			entity.setBirthDate(dto.getBirthDate());
			entity.setChildren(dto.getChildren());
			
	
	}
	

	
}
