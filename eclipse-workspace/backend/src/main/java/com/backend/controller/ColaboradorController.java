package com.backend.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.business.ColaboradorBusiness;
import com.backend.dto.ChefeSubordinado;
import com.backend.entity.ColaboradorEntity;

@RestController()
@RequestMapping("/colaborador")
public class ColaboradorController {

	@Autowired
	ColaboradorBusiness colaboradorBusiness;

	@GetMapping("/{id}")
	public ResponseEntity<ColaboradorEntity> get(@PathVariable Integer id) {
		return ResponseEntity.ok(colaboradorBusiness.findById(id));
	}

	@GetMapping()
	public ResponseEntity<List<ColaboradorEntity>> findAll() {
		return ResponseEntity.ok(colaboradorBusiness.findAll());
	}

	@PostMapping()
	public ResponseEntity<ColaboradorEntity> post(@RequestBody ColaboradorEntity colaboradorEntity) throws Exception {
		return ResponseEntity.created(URI.create("/colaborador/" + colaboradorEntity.getNome())).body(colaboradorBusiness.save(colaboradorEntity));
	}

	@PostMapping(path = "/associaChefe")
	public ResponseEntity<ColaboradorEntity> associaChefe(@RequestBody ChefeSubordinado chefeSubordinadoDTO) throws Exception {
		return ResponseEntity.created(URI.create("/colaborador/associaChefe/" + chefeSubordinadoDTO.getIdSubordinado())).body(colaboradorBusiness.assosiaSubordinado(chefeSubordinadoDTO));
	}

}
