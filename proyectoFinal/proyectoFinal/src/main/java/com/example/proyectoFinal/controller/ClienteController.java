/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.proyectoFinal.controller;

import com.example.proyectoFinal.model.Cliente;
import com.example.proyectoFinal.service.IClienteService;
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
public class ClienteController {
    
    @Autowired
    private IClienteService clienteService;
    
    @PostMapping("/clientes/crear")
    public String saveCliente(@RequestBody Cliente cliente){
        clienteService.saveCliente(cliente);
        return "Cliente creado exitosamente";
    }
    
    @GetMapping("/clientes/{id_cliente}")
    public Cliente getCliente(@PathVariable Long id_cliente){
        return clienteService.getCliente(id_cliente);
    }
    @GetMapping("/clientes")
    public List<Cliente> getClientes(){
        return clienteService.getClientes();
    }
    
    @DeleteMapping("/clientes/eliminar/{id_cliente}")
    public String deleteCliente(@PathVariable Long id_cliente){
        clienteService.deleteCliente(id_cliente);
        return "Cliente eliminado correctamente";
    }
    
    @PutMapping("/clientes/editar/{id_cliente}")
    public Cliente editCliente(@PathVariable Long id_cliente, 
                                 @RequestParam(required = false, name = "id_cliente") Long idnuevo,
                                 @RequestParam(required = false, name = "nombre") String nombrenuevo,
                                 @RequestParam(required = false, name = "apellido") String apellidonuevo,
                                 @RequestParam(required = false, name = "dni") String dninuevo) {
        return clienteService.editCliente(id_cliente, idnuevo, nombrenuevo, apellidonuevo, dninuevo);
    }
}
