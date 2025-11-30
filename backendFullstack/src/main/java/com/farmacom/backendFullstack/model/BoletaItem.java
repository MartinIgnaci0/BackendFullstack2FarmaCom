package com.farmacom.backendFullstack.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "boleta_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoletaItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "boleta_id", nullable = false)
	private Boleta boleta;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "producto_id", nullable = false)
	private Producto producto;

	private Integer cantidad;

	private BigDecimal precioUnitario;

	public BigDecimal getSubtotal() {
		return precioUnitario.multiply(BigDecimal.valueOf(cantidad));
	}
  // prueba
}
