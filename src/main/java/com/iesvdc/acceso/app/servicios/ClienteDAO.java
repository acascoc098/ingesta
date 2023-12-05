package com.iesvdc.acceso.app.servicios;

import java.util.List;

import com.iesvdc.acceso.app.entidades.Cliente;
import com.iesvdc.acceso.app.entidades.Reserva;

public interface ClienteDAO {
    /**
     * Método para crear un cliente
     * @param cliente
     * @return
     * @throws ExcDAO
     */
    public Cliente create(Cliente cliente) throws ExcDAO;

    /**
     * Método que devuelve todos los clientes
     * @return
     * @throws ExcDAO
     */
    public List<Cliente> findAll() throws ExcDAO;
    
    /**
     * Método para encontrar un cliente por su ID
     * @param id
     * @return
     * @throws ExcDAO
     */
    public Cliente findById(int id) throws ExcDAO;
    
    /**
     * Método para actualizar un ciente
     * @param idOldCliente
     * @param newCliente
     * @return
     * @throws ExcDAO
     */
    public Cliente update(int idOldCliente, Cliente newCliente) throws ExcDAO;
    public Cliente update(Cliente OldCliente, Cliente newCliente) throws ExcDAO;
    
    
    /**
     * Método para eliminar un cliente por su ID
     * @param idCliente
     * @return
     * @throws ExcDAO
     */
    public Cliente delete(int idCliente) throws ExcDAO;

    /**
     * Método para eliminar un cliente pasando un objeto entero
     * @param Cliente
     * @return
     * @throws ExcDAO
     */
    public Cliente delete(Cliente Cliente) throws ExcDAO;

    /**
     * Método para encontrar un cliente por su reserva
     * @param reserva
     * @return
     * @throws ExcDAO
     */
    public List<Cliente> findByReserva(Reserva reserva) throws ExcDAO;
}
