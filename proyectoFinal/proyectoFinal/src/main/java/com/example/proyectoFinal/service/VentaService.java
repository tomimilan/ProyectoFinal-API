package com.example.proyectoFinal.service;

import com.example.proyectoFinal.dto.VentaProductoClienteDTO;
import com.example.proyectoFinal.model.Cliente;
import com.example.proyectoFinal.model.Producto;
import com.example.proyectoFinal.model.Venta;
import com.example.proyectoFinal.repository.IVentaRepository;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService {

    @Autowired
    private IVentaRepository ventaRepository;

    @Override
    public void saveVenta(Venta venta) {
        ventaRepository.save(venta);
    }

    @Override
    public Venta getVenta(Long codigo_venta) {
        Venta venta = ventaRepository.findById(codigo_venta).orElse(null);
        return venta;
    }

    @Override
    public List<Venta> getVentas() {
        List<Venta> ventas = ventaRepository.findAll();
        return ventas;
    }

    @Override
    public void deleteVenta(Long codigo_venta) {
        ventaRepository.deleteById(codigo_venta);
    }

    @Override
    public Venta editVenta(Long codigo_venta, Long codigonuevo, LocalDate fechanueva, Double totalNuevo, List<Producto> listanueva, Cliente clientenuevo) {
        Venta venta = this.getVenta(codigo_venta);
        venta.setCodigo_venta(codigonuevo);
        venta.setFecha_venta(fechanueva);
        venta.setTotal(totalNuevo);
        venta.setListaProductos(listanueva);
        venta.setUnCliente(clientenuevo);
        this.saveVenta(venta);
        return venta;
    }

    @Override
    public List<Producto> getProductosDeterminadaVenta(Long codigo_venta) {
        Venta venta = this.getVenta(codigo_venta);

        return venta.getListaProductos();
    }

    @Override
    public String getTotalMonto(LocalDate fecha) {

        List<Venta> listaVentas = this.getVentas();

        Double sumatoriaMonto = 0.0;
        int contadorVentas = 0;

        for (Venta venta : listaVentas) {
            if (venta.getFecha_venta().equals(fecha)) {
                sumatoriaMonto = sumatoriaMonto + venta.getTotal();
                contadorVentas = contadorVentas + 1;

            }
        }

        return "El monto total correspondiente a la fecha: " + fecha + " es = " + sumatoriaMonto + " , y la cantidad de ventas fueron " + contadorVentas;

    }

    //Obtener codigoventa, total, cantidadproductos, nombreCliente y apellido de la venta mas cara.
    @Override
    public VentaProductoClienteDTO getDTO() {

        VentaProductoClienteDTO ventaDto = new VentaProductoClienteDTO();
        List<Venta> listaVentas = this.getVentas();
        Double totalVenta = 0.0;
        Double ventaMasCara;

        for (Venta venta : listaVentas) {

            if (totalVenta <= venta.getTotal()) {

                totalVenta = venta.getTotal();

                ventaMasCara = totalVenta;
                
                
                ventaDto.setCodigo_venta(venta.getCodigo_venta());
                ventaDto.setTotal(ventaMasCara);
                ventaDto.setCantidad_disponible(venta.getListaProductos().size());
                ventaDto.setNombre(venta.getUnCliente().getNombre());
                ventaDto.setApellido(venta.getUnCliente().getApellido());
            }

        }
        
        return ventaDto;

    }

    @Override
    public void editVenta(Venta venta) {
        this.saveVenta(venta);
    }

}
