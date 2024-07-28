
package com.example.proyectoFinal.service;

import com.example.proyectoFinal.model.Producto;
import java.util.List;

public interface IProductoService {
    //Crear producto
    public void saveProducto(Producto producto);
    //Obtener un producto
    public Producto getProducto(Long codigo_producto);
    //Obtener todos los productos
    public List<Producto> getProductos();
    //Eliminar un producto por PK
    public void deleteProducto(Long codigo_producto);
    //Editar un producto
    public Producto editProducto(Long codigo_producto, Long codigo_nuevo, String nombreNuevo, String marcaNueva, Double costoNuevo, Double cantidadNueva);
    //Obtener todos los productos cuya cantidad_disponible sea menor a 5
    public List<Producto> getProductosCantidadMenor5();
}
