package com.luiszamudio.gestion_gastos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="gastos")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Gasto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGasto; //En MariaDB se traducirá BIGINT AUTO_INCREMENTAL
    private BigDecimal importe; //Clase del paquete java.math, garantiza precisión absoluta
    private String descripcion;
    private LocalDate fechaGasto;
    @Enumerated(EnumType.STRING)
    private CategoriaGasto categoriaGasto;
    @Enumerated(EnumType.STRING)
    private FormaPago formaPago;
    @ManyToOne
    @JoinColumn(name ="cuenta_id", nullable = false)
    private Cuenta cuenta;


}
