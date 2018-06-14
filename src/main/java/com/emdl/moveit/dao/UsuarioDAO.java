package com.emdl.moveit.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.emdl.moveit.entity.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, String> {
	
	@Query("SELECT u FROM Usuario u ")
	List<Usuario> getAll();

}
