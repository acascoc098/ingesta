package com.iesvdc.acceso.app.entidades;

public class Cliente {
    private int id;
    private String nombre;
    private Contacto contact;
    private Reserva reserva;

    //Creamos su constructor
    public Cliente(int id, String nombre, Contacto contact, Reserva reserva) {
        this.id = id;
        this.nombre = nombre;
        this.contact = contact;
        this.reserva = reserva;
    }

    //Creamos sus getter y setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Contacto getContact() {
        return contact;
    }

    public void setContact(Contacto contact) {
        this.contact = contact;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + ((contact == null) ? 0 : contact.hashCode());
        result = prime * result + ((reserva == null) ? 0 : reserva.hashCode());
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
        Cliente other = (Cliente) obj;
        if (id != other.id)
            return false;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (contact == null) {
            if (other.contact != null)
                return false;
        } else if (!contact.equals(other.contact))
            return false;
        if (reserva == null) {
            if (other.reserva != null)
                return false;
        } else if (!reserva.equals(other.reserva))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Cliente [id=" + id + ", nombre=" + nombre + ", contact=" + contact + ", reserva=" + reserva + "]";
    }
    
    
}
