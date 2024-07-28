
package com.example.proyectoFinal.service;

import com.example.proyectoFinal.dto.VentaProductoClienteDTO;
import com.example.proyectoFinal.model.Cliente;
import com.example.proyectoFinal.model.Producto;
import com.example.proyectoFinal.model.Venta;
import java.time.LocalDate;
import java.util.List;


public interface IVentaService {
    
    public void saveVenta(Venta venta);
    //Obtener un producto
    public Venta getVenta(Long codigo_venta);
    //Obtener todos los productos
    public List<Venta> getVentas();
    //Eliminar un producto por PK
    public void deleteVenta(Long codigo_venta);
    //Editar un producto
    public Venta editVenta(Long codigo_venta, Long codigonuevo, LocalDate fechanueva, Double totalNuevo, List<Producto> listanueva, Cliente clientenuevo);
    public void editVenta(Venta venta);
    //Obtener la lista de productos de una determinada venta
    public List<Producto> getProductosDeterminadaVenta(Long codigo_venta);
    public String getTotalMonto(LocalDate fecha);
    public VentaProductoClienteDTO getDTO();
}
