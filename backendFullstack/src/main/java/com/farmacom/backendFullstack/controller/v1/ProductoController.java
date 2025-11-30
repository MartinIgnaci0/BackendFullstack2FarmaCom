package com.farmacom.backendFullstack.controller.v1;

import com.farmacom.backendFullstack.model.Producto;
import com.farmacom.backendFullstack.service.ProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {

	private final ProductoService productoService;

	public ProductoController(ProductoService productoService) {
		this.productoService = productoService;
	}

	@GetMapping
	public ResponseEntity<List<Producto>> listProducts() {
		return ResponseEntity.ok(productoService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Producto> getProduct(@PathVariable("id") Long id) {
		return productoService.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Producto> createProduct(@RequestBody Producto producto) {
		Producto saved = productoService.save(producto);
		return ResponseEntity.created(URI.create("/api/v1/productos/" + saved.getId())).body(saved);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Producto> updateProduct(@PathVariable("id") Long id, @RequestBody Producto producto) {
		return productoService.findById(id)
				.map(existing -> {
					producto.setId(id);
					Producto updated = productoService.save(producto);
					return ResponseEntity.ok(updated);
				})
				.orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
		productoService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
