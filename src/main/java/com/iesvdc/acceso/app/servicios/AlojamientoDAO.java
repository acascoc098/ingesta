package com.iesvdc.acceso.app.servicios;

import java.util.List;

import com.iesvdc.acceso.app.entidades.Alojamiento;

public interface AlojamientoDAO {
    /**
     * Método para crear un alojamiento
     * @param Alojamiento
     * @return
     * @throws ExcDAO
     */
    public Alojamiento create(Alojamiento Alojamiento) throws ExcDAO;

    /**
     * Método que devuelve todos los alojamientos
     * @return
     * @throws ExcDAO
     */
    public List<Alojamiento> findAll() throws ExcDAO;
    
    /**
     * Método para encontrar un alojamiento por su ID
     * @param id
     * @return
     * @throws ExcDAO
     */
    public Alojamiento findById(int id) throws ExcDAO;
    
    /**
     * Método para acualizar un alojamiento
     * @param idOldAlojamiento
     * @param newAlojamiento
     * @return
     * @throws ExcDAO
     */
    public Alojamiento update(int idOldAlojamiento, Alojamiento newAlojamiento) throws ExcDAO;
    public Alojamiento update(Alojamiento OldAlojamientoe, Alojamiento newAlojamiento) throws ExcDAO;
    
    /**
     * Método para eliminar un alojamiento según su id o pasando el alojamiento
     * @param idAlojamiento
     * @return
     * @throws ExcDAO
     */
    public Alojamiento delete(int idAlojamiento) throws ExcDAO;    
    public Alojamiento delete(Alojamiento alojamiento) throws ExcDAO;
}
