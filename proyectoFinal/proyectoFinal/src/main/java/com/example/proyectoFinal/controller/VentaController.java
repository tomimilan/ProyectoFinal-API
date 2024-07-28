
package com.example.proyectoFinal.controller;

import com.example.proyectoFinal.model.Cliente;
import com.example.proyectoFinal.model.Producto;
import com.example.proyectoFinal.model.Venta;
import com.example.proyectoFinal.service.IVentaService;
import java.time.LocalDate;
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
public class VentaController {
    
    @Autowired
    private IVentaService ventaService;
    
    @PostMapping("/ventas/crear")
    public String saveVentas(@RequestBody Venta venta){
        ventaService.saveVenta(venta);
        return "Venta creada exitosamente";
    }
    
    @GetMapping("/ventas/{codigo_venta}")
    public Venta getVenta(@PathVariable Long codigo_venta){
        return ventaService.getVenta(codigo_venta);
    }
    @GetMapping("/ventas")
    public List<Venta> getVentas(){
        return ventaService.getVentas();
    }
    @GetMapping("/ventas/productos/{codigo_venta}")
    public List<Producto> getProductosDeterminadaVenta(@PathVariable Long codigo_venta){
        return ventaService.getProductosDeterminadaVenta(codigo_venta);
    }
    @GetMapping("/ventas/fecha/{fecha}")
    public String getTotalMonto(@PathVariable LocalDate fecha){
        return ventaService.getTotalMonto(fecha);
    }
    
    @DeleteMapping("/ventas/eliminar/{codigo_venta}")
    public String deleteVenta(@PathVariable Long codigo_venta){
        ventaService.deleteVenta(codigo_venta);
        return "Venta eliminada correctamente";
    }
    
    @PutMapping("/ventas/editar/{codigo_venta}")
    public Venta editVenta(@PathVariable Long codigo_venta, 
                                 @RequestParam(required = false, name = "codigo_venta") Long codigonuevo,
                                 @RequestParam(required = false, name = "fecha_venta") LocalDate fechanueva,
                                 @RequestParam(required = false, name = "total") Double totalNuevo,
                                 @RequestParam(required = false, name = "listaProductos") List<Producto> listanueva,
                                 @RequestParam(required = false, name = "unCliente") Cliente clientenuevo ){
        return ventaService.editVenta(codigo_venta, codigonuevo, fechanueva, totalNuevo, listanueva, clientenuevo);
    }
    @PutMapping("/ventas/editar")
    public Venta editVenta(@RequestBody Venta venta){
        ventaService.editVenta(venta);
        return ventaService.getVenta(venta.getCodigo_venta());
    }
    
}
