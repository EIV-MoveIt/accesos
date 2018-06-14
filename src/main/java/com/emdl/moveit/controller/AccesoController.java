package com.emdl.moveit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.emdl.moveit.service.AccesoService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
@RequestMapping("/moveit/acceso/")
public class AccesoController {
	
	@Autowired
	AccesoService accesoService;
	
	/**
	 * Endpoint POST para generar y guardar un token
	 * @param canal enviado por NEO
	 * @return token
	 */
	@RequestMapping(value = "token/generaToken", method = { RequestMethod.POST })
	@CrossOrigin(origins = "*")
	public ResponseEntity<String> pruebas(@RequestHeader(value = "canal", required = true) String canal) {
		
		String token = accesoService.getUsuario();
		
		HttpStatus hs = HttpStatus.OK;		
		HttpHeaders header = new HttpHeaders();
		return new ResponseEntity<String>(token,header, hs);
	}

}
