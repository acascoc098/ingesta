package com.iesvdc.acceso.app.entidades;

public class Alojamiento {
    private int id;
    private String tipo;
    private String nombre;
    private String direccion;
    private int telefono;
    
    //Creamos su constructor
    public Alojamiento(int id, String tipo, String nombre, String direccion, int telefono) {
        this.id = id;
        this.tipo = tipo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    //Creamos sus getter y setter de cada atributo
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public int getTelefono() {
        return telefono;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
        result = prime * result + telefono;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Alojamiento other = (Alojamiento) obj;
        if (id != other.id)
            return false;
        if (tipo == null) {
            if (other.tipo != null)
                return false;
        } else if (!tipo.equals(other.tipo))
            return false;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (direccion == null) {
            if (other.direccion != null)
                return false;
        } else if (!direccion.equals(other.direccion))
            return false;
        if (telefono != other.telefono)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Alojamiento [id=" + id + ", tipo=" + tipo + ", nombre=" + nombre + ", direccion=" + direccion
                + ", telefono=" + telefono + "]";
    }
    
}
