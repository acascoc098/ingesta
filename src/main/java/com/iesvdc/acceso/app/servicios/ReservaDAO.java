package com.iesvdc.acceso.app.servicios;

import java.util.List;

import com.iesvdc.acceso.app.entidades.Alojamiento;
import com.iesvdc.acceso.app.entidades.Reserva;

public interface ReservaDAO {
    public Reserva create(Reserva Reserva) throws ExcDAO;

    
    public List<Reserva> findAll() throws ExcDAO;
    
    
    public Reserva findById(int id) throws ExcDAO;
    
       
    public Reserva update(int idOldReserva, Reserva newReserva) throws ExcDAO;
    public Reserva update(Reserva oldReserva, Reserva newReserva) throws ExcDAO;
    
    
    public Reserva delete(int idReserva) throws ExcDAO;

    
    public Reserva delete(Reserva Reserva) throws ExcDAO;

    public List<Reserva> findByAlojamiento(Alojamiento alojamiento) throws ExcDAO;
}
