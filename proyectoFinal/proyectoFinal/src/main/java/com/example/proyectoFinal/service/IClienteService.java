
package com.example.proyectoFinal.service;

import com.example.proyectoFinal.model.Cliente;
import java.util.List;

public interface IClienteService {
    public void saveCliente(Cliente cliente);
    public Cliente getCliente(Long id_cliente);
    public List<Cliente> getClientes();
    public void deleteCliente(Long id_cliente);
    public Cliente editCliente(Long id_cliente, Long idnuevo, String nombrenuevo, String apellidonuevo, String dninuevo);
}
