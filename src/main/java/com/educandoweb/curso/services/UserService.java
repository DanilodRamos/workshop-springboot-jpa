package com.educandoweb.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.educandoweb.curso.entities.User;
import com.educandoweb.curso.repositories.UserRepository;
import com.educandoweb.curso.resources.exceptions.ResourceExceptionHandler;
import com.educandoweb.curso.services.exceptions.DatabaseException;
import com.educandoweb.curso.services.exceptions.ResourceNotFoundException;

// Registrando com annotation
@Service
public class UserService {

    private final ResourceExceptionHandler resourceExceptionHandler;
	// Operação para buscar todos usuários e id
    // Injeção de dependência
    @Autowired
    private UserRepository repository;

	UserService(ResourceExceptionHandler resourceExceptionHandler) {
		this.resourceExceptionHandler = resourceExceptionHandler;
	}

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User obj) {
        // Operação básica para inserir um novo usuário
        return repository.save(obj);
    }

    // Método para deletar
    public void delete(Long id) {
    	try{
    		 repository.deleteById(id);
    	}
       catch(EmptyResultDataAccessException e) {
    	   e.printStackTrace();
    	   throw new ResourceNotFoundException(id);
       } catch (DataIntegrityViolationException e) {
    	   throw new DatabaseException(e.getMessage());//lancando excessao da minha camada de servico
       }
    }

    // Método para atualizar usuário
    @Transactional
    public User update(Long id, User obj) {

        // Busca a referência do usuário pelo ID
        User entity = repository.getReferenceById(id);

        // Atualiza os dados
        updateData(entity, obj);

        // Salva a alteração
        return repository.save(entity);
    }

    private void updateData(User entity, User obj) {

        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}