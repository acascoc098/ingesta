package com.iesvdc.acceso.app.entidades;

import java.time.LocalDate;

public class Reserva {
    private int id;
    private Alojamiento alojamiento;
    private LocalDate entrada;
    private LocalDate salida;
    private String pension;

    //Creamos constructor
    public Reserva(int id, Alojamiento alojamiento, LocalDate entrada, LocalDate salida, String pension) {
        this.id = id;
        this.alojamiento = alojamiento;
        this.entrada = entrada;
        this.salida = salida;
        this.pension = pension;
    }

    //Creamos getters y setters
    public Alojamiento getAlojamiento() {
        return alojamiento;
    }
    public void setAlojamiento(Alojamiento alojamiento) {
        this.alojamiento = alojamiento;
    }
    public LocalDate getEntrada() {
        return entrada;
    }
    public void setEntrada(LocalDate entrada) {
        this.entrada = entrada;
    }
    public LocalDate getSalida() {
        return salida;
    }
    public void setSalida(LocalDate salida) {
        this.salida = salida;
    }
    public String getPension() {
        return pension;
    }
    public void setPension(String pension) {
        this.pension = pension;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((alojamiento == null) ? 0 : alojamiento.hashCode());
        result = prime * result + ((entrada == null) ? 0 : entrada.hashCode());
        result = prime * result + ((salida == null) ? 0 : salida.hashCode());
        result = prime * result + ((pension == null) ? 0 : pension.hashCode());
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
        Reserva other = (Reserva) obj;
        if (id != other.id)
            return false;
        if (alojamiento == null) {
            if (other.alojamiento != null)
                return false;
        } else if (!alojamiento.equals(other.alojamiento))
            return false;
        if (entrada == null) {
            if (other.entrada != null)
                return false;
        } else if (!entrada.equals(other.entrada))
            return false;
        if (salida == null) {
            if (other.salida != null)
                return false;
        } else if (!salida.equals(other.salida))
            return false;
        if (pension == null) {
            if (other.pension != null)
                return false;
        } else if (!pension.equals(other.pension))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Reserva [id=" + id + ", alojamiento=" + alojamiento + ", entrada=" + entrada + ", salida=" + salida
                + ", pension=" + pension + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
}
