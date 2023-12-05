package com.iesvdc.acceso.app.servicios;

import java.util.List;

import com.iesvdc.acceso.app.entidades.Alojamiento;
import com.iesvdc.acceso.app.entidades.Reserva;

public interface ReservaDAO {
    /**
     * Método para crera una reserva
     * @param Reserva
     * @return
     * @throws ExcDAO
     */
    public Reserva create(Reserva Reserva) throws ExcDAO;

    /**
     * Método que devuelve todas las reservas
     * @return
     * @throws ExcDAO
     */
    public List<Reserva> findAll() throws ExcDAO;
    
    /**
     * Método para encontrar una reserva según su ID
     * @param id
     * @return
     * @throws ExcDAO
     */
    public Reserva findById(int id) throws ExcDAO;
    
    /**
     * Método para actualizar una reserva
     * @param idOldReserva
     * @param newReserva
     * @return
     * @throws ExcDAO
     */
    public Reserva update(int idOldReserva, Reserva newReserva) throws ExcDAO;
    public Reserva update(Reserva oldReserva, Reserva newReserva) throws ExcDAO;
    
    /**
     * Método para eliminar una reserva según su id o la reserva
     * @param idReserva
     * @return
     * @throws ExcDAO
     */
    public Reserva delete(int idReserva) throws ExcDAO;    
    public Reserva delete(Reserva Reserva) throws ExcDAO;

    /**
     * Método paar encontrar una reserva según el alojamiento
     * @param alojamiento
     * @return
     * @throws ExcDAO
     */
    public List<Reserva> findByAlojamiento(Alojamiento alojamiento) throws ExcDAO;
}
