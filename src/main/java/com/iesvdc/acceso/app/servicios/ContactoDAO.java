package com.iesvdc.acceso.app.servicios;

import java.util.List;

import com.iesvdc.acceso.app.entidades.Contacto;

public interface ContactoDAO {
    /**
     * Método para crear un contacto
     * @param contacto
     * @return
     * @throws ExcDAO
     */
    public Contacto create(Contacto contacto) throws ExcDAO;

    /**
     * Método que devuelve todos los contactos
     * @return
     * @throws ExcDAO
     */
    public List<Contacto> findAll() throws ExcDAO;
    
    /**
     * Método para encontrar un contacto por su ID
     * @param id
     * @return
     * @throws ExcDAO
     */
    public Contacto findById(int id) throws ExcDAO;
    
    /**
     * Método para ctualizar un contacto
     * @param idOldContacto
     * @param newContacto
     * @return
     * @throws ExcDAO
     */
    public Contacto update(int idOldContacto, Contacto newContacto) throws ExcDAO;
    public Contacto update(Contacto OldContacto, Contacto newContacto) throws ExcDAO;
    
    /**
     * Método para eliminar un contacto según su id o pasando el contacto
     * @param idContacto
     * @return
     * @throws ExcDAO
     */
    public Contacto delete(int idContacto) throws ExcDAO;    
    public Contacto delete(Contacto Contacto) throws ExcDAO;
}
