package com.farmacom.backendFullstack.service;

import com.farmacom.backendFullstack.model.Boleta;
import com.farmacom.backendFullstack.model.BoletaItem;
import com.farmacom.backendFullstack.model.Producto;
import com.farmacom.backendFullstack.repository.BoletaRepository;
import com.farmacom.backendFullstack.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BoletaService {

	private final BoletaRepository boletaRepository;
	private final ProductoRepository productoRepository;

	public BoletaService(BoletaRepository boletaRepository, ProductoRepository productoRepository) {
		this.boletaRepository = boletaRepository;
		this.productoRepository = productoRepository;
	}

	public List<Boleta> findAll() {
		return boletaRepository.findAll();
	}

	public Optional<Boleta> findById(Long id) {
		return boletaRepository.findById(id);
	}

	public Boleta save(Boleta boleta) {
		// Calcular total si viene con items
		if (boleta.getItems() != null && !boleta.getItems().isEmpty()) {
			BigDecimal total = boleta.getItems().stream()
					.map(BoletaItem::getSubtotal)
					.reduce(BigDecimal.ZERO, BigDecimal::add);
			boleta.setTotal(total);
		} else {
			boleta.setTotal(BigDecimal.ZERO);
		}
		boleta.setCreatedAt(LocalDateTime.now());
		return boletaRepository.save(boleta);
	}

	public void delete(Long id) {
		boletaRepository.deleteById(id);
	}

}

