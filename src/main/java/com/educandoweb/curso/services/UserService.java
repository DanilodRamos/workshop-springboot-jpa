package com.educandoweb.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.educandoweb.curso.entities.User;
import com.educandoweb.curso.repositories.UserRepository;
import com.educandoweb.curso.services.exceptions.ResourceNotFoundException;

// Registrando com annotation
@Service
public class UserService {

    // Operação para buscar todos usuários e id
    // Injeção de dependência
    @Autowired
    private UserRepository repository;

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
        repository.deleteById(id);
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