package com.farmacom.backendFullstack.controller.v1;

import com.farmacom.backendFullstack.model.Boleta;
import com.farmacom.backendFullstack.service.BoletaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/boletas")
public class BoletaController {

	private final BoletaService boletaService;

	public BoletaController(BoletaService boletaService) {
		this.boletaService = boletaService;
	}

	@GetMapping
	public ResponseEntity<List<Boleta>> listBoletas() {
		return ResponseEntity.ok(boletaService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Boleta> getBoleta(@PathVariable("id") Long id) {
		return boletaService.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Boleta> createBoleta(@RequestBody Boleta boleta) {
		Boleta saved = boletaService.save(boleta);
		return ResponseEntity.created(URI.create("/api/v1/boletas/" + saved.getId())).body(saved);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBoleta(@PathVariable("id") Long id) {
		boletaService.delete(id);
		return ResponseEntity.noContent().build();
	}

}

