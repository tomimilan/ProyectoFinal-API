
package com.example.proyectoFinal.service;

import com.example.proyectoFinal.model.Cliente;
import com.example.proyectoFinal.repository.IClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    private IClienteRepository clienteRepository;
    
    @Override
    public void saveCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public Cliente getCliente(Long id_cliente) {
        Cliente cliente = clienteRepository.findById(id_cliente).orElse(null);
        return cliente;
    }

    @Override
    public List<Cliente> getClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes;
    }

    @Override
    public void deleteCliente(Long id_cliente) {
        clienteRepository.deleteById(id_cliente);
    }

    @Override
    public Cliente editCliente(Long id_cliente, Long idnuevo, String nombrenuevo, String apellidonuevo, String dninuevo) {
        
        Cliente cliente = this.getCliente(id_cliente);
        
        cliente.setId_cliente(idnuevo);
        cliente.setNombre(nombrenuevo);
        cliente.setApellido(apellidonuevo);
        cliente.setDni(dninuevo);
        
        this.saveCliente(cliente);
        
        return cliente;
    }
}
