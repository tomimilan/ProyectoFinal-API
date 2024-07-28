
package com.example.proyectoFinal.service;

import com.example.proyectoFinal.model.Producto;
import com.example.proyectoFinal.repository.IProductoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService{
    
    //Inyeccion dependencia
    @Autowired
    private IProductoRepository productoRepository;
    
    //Implementacion metodos
    @Override
    public void saveProducto(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public Producto getProducto(Long codigo_producto) {
        Producto producto = productoRepository.findById(codigo_producto).orElse(null);
        return producto;
    }

    @Override
    public List<Producto> getProductos() {
        List<Producto> productos = productoRepository.findAll();
        return productos;
    }

    @Override
    public void deleteProducto(Long codigo_producto) {
        productoRepository.deleteById(codigo_producto);
    }

    @Override
    public Producto editProducto(Long codigo_producto, Long codigoNuevo, String nombreNuevo, String marcaNueva, Double costoNuevo, Double cantidadNueva) {
        Producto producto = this.getProducto(codigo_producto);
        
        producto.setCodigo_producto(codigoNuevo);
        producto.setNombre(nombreNuevo);
        producto.setMarca(marcaNueva);
        producto.setCosto(costoNuevo);
        producto.setCantidad_disponible(cantidadNueva);
        
        this.saveProducto(producto);
        
        return producto;
    }
    
    //Obtener todos los productos cuya cantidad_disponible sea menor a 5

    @Override
    public List<Producto> getProductosCantidadMenor5() {
        List<Producto> listaProductos = this.getProductos();
        List<Producto> listaProdutosCantidadMenor5 = new ArrayList<Producto>();
        
        for (Producto producto:listaProductos) {
            if (producto.getCantidad_disponible() < 5) {
                listaProdutosCantidadMenor5.add(producto);
            }
        }
        return listaProdutosCantidadMenor5;
    } 
    
}
