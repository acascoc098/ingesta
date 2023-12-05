package com.iesvdc.acceso.app.servicios;

import java.util.List;

import com.iesvdc.acceso.app.entidades.Contacto;

public interface ContactoDAO {
    public Contacto create(Contacto contacto) throws ExcDAO;

    
    public List<Contacto> findAll() throws ExcDAO;
    
    
    public Contacto findById(int id) throws ExcDAO;
    
       
    public Contacto update(int idOldContacto, Contacto newContacto) throws ExcDAO;
    public Contacto update(Contacto OldContacto, Contacto newContacto) throws ExcDAO;
    
    
    public Contacto delete(int idContacto) throws ExcDAO;

    
    public Contacto delete(Contacto Contacto) throws ExcDAO;
}
