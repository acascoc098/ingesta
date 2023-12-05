package com.iesvdc.acceso.app.servicios;

import java.util.List;

import com.iesvdc.acceso.app.entidades.Cliente;
import com.iesvdc.acceso.app.entidades.Reserva;

public interface ClienteDAO {
    public Cliente create(Cliente cliente) throws ExcDAO;

    
    public List<Cliente> findAll() throws ExcDAO;
    
    
    public Cliente findById(int id) throws ExcDAO;
    
       
    public Cliente update(int idOldCliente, Cliente newCliente) throws ExcDAO;
    public Cliente update(Cliente OldCliente, Cliente newCliente) throws ExcDAO;
    
    
    public Cliente delete(int idCliente) throws ExcDAO;

    
    public Cliente delete(Cliente Cliente) throws ExcDAO;

    public List<Cliente> findByReserva(Reserva reserva) throws ExcDAO;
}
