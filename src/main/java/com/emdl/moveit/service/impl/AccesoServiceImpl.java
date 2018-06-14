package com.emdl.moveit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emdl.moveit.dao.UsuarioDAO;
import com.emdl.moveit.entity.Usuario;
import com.emdl.moveit.service.AccesoService;

@Service
public class AccesoServiceImpl implements AccesoService {
	
	@Autowired
	UsuarioDAO usuarioDao;

	@Override
	public String getUsuario() {
		List<Usuario> usuarioList = (List<Usuario>)usuarioDao.findAll();
		System.out.println("usuarioList--->"+usuarioList);
		if(usuarioList != null) {
			System.out.println("getUsername--->"+usuarioList.get(0).getUsername());
			return usuarioList.get(0).getUsername();
		}
		return "vacio";
	}

}
