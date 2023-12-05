package com.iesvdc.acceso.app.servicios;

import java.util.List;

import com.iesvdc.acceso.app.entidades.Alojamiento;

public interface AlojamientoDAO {
    public Alojamiento create(Alojamiento Alojamiento) throws ExcDAO;

    
    public List<Alojamiento> findAll() throws ExcDAO;
    
    
    public Alojamiento findById(int id) throws ExcDAO;
    
       
    public Alojamiento update(int idOldAlojamiento, Alojamiento newAlojamiento) throws ExcDAO;
    public Alojamiento update(Alojamiento OldAlojamientoe, Alojamiento newAlojamiento) throws ExcDAO;
    
    
    public Alojamiento delete(int idAlojamiento) throws ExcDAO;

    
    public Alojamiento delete(Alojamiento alojamiento) throws ExcDAO;
}
