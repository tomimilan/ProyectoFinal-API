
//Obtener el codigo_venta, el total, la cantidad de productos, el nombre del cliente y el
//apellido del cliente de la venta con el monto más alto de todas. 

package com.example.proyectoFinal.dto;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class VentaProductoClienteDTO {
    
    private Long codigo_venta;
    private Double total;
    private int cantidad_disponible;
    private String nombre;
    private String apellido;

    public VentaProductoClienteDTO() {
    }

    public VentaProductoClienteDTO(Long codigo_venta, Double total, int cantidad_disponible, String nombre, String apellido) {
        this.codigo_venta = codigo_venta;
        this.total = total;
        this.cantidad_disponible = cantidad_disponible;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
}
