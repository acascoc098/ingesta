package com.iesvdc.acceso.app.entidades;

public class Contacto {
    private int id;
    private String email;
    private int telefono;

    //Creamos el constructor
    public Contacto(int id, String email, int telefono) {
        this.id = id;
        this.email = email;
        this.telefono = telefono;
    }

    //Creamos los getter y setter
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
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
        result = prime * result + ((email == null) ? 0 : email.hashCode());
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
        Contacto other = (Contacto) obj;
        if (id != other.id)
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (telefono != other.telefono)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Contacto [id=" + id + ", email=" + email + ", telefono=" + telefono + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
