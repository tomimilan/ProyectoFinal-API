package com.example.proyectoFinal.controller;

import com.example.proyectoFinal.model.Producto;
import com.example.proyectoFinal.service.IProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {
    
    @Autowired
    private IProductoService productoService;
    
    @PostMapping("/productos/crear")
    public String saveProducto(@RequestBody Producto producto){
        productoService.saveProducto(producto);
        return "Producto creado exitosamente";
    }
    
    @GetMapping("/productos/{codigo_producto}")
    public Producto getProducto(@PathVariable Long codigo_producto){
        return productoService.getProducto(codigo_producto);
    }
    @GetMapping("/productos")
    public List<Producto> getProductos(){
        return productoService.getProductos();
    }
    
    @DeleteMapping("/productos/eliminar/{codigo_producto}")
    public String deleteProducto(@PathVariable Long codigo_producto){
        productoService.deleteProducto(codigo_producto);
        return "Producto eliminado correctamente";
    }
    
    @PutMapping("/productos/editar/{codigo_producto}")
    public Producto editProducto(@PathVariable Long codigo_producto, 
                                 @RequestParam(required = false, name = "codigo_producto") Long codigoNuevo,
                                 @RequestParam(required = false, name = "nombre") String nombreNuevo,
                                 @RequestParam(required = false, name = "marca") String marcaNueva,
                                 @RequestParam(required = false, name = "costo") Double costoNuevo,
                                 @RequestParam(required = false, name = "cantidad_disponible") Double cantidadNueva ){
        return productoService.editProducto(codigo_producto, codigoNuevo, nombreNuevo, marcaNueva, costoNuevo, cantidadNueva);
    }
    @GetMapping("/productos/falta_stock")
    public List<Producto> getProductosCantidadMenor5(){
        return productoService.getProductosCantidadMenor5();
    }
}
