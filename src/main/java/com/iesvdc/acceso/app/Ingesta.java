package com.iesvdc.acceso.app;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.iesvdc.acceso.app.Conexion.FConex;
import com.iesvdc.acceso.app.entidades.Reserva;

/**
 * Hello world!
 *
 */
public class Ingesta 
{
    public static void main( String[] args ){

        /**
         * CARGAR JSON
         */
        System.out.println( "\n ····----++++===******===++++----·····\n");
        System.out.println("Aquí vamos a hacer la carga del archivo: " + args[0]);
        System.out.println(
            "Puedes cambiar el parámetro en el pom.xml, \n"+
            "busca el nombre del archivo y pon el archivo que necesites.");
        System.out.println( "\n ····----++++===******===++++----·····\n");

        System.out.println("Preparando la base de datos para la ingesta...");

        FConex.dropDatabase();
        FConex.createDatabase();
        FConex.initializeDatabase("init_db.sql", "reservas");

        // configuramos Gson
        Gson gson = new GsonBuilder().
                registerTypeAdapter(LocalTime.class, new LocalTimeTypeAdapter()).
                registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter()).
                registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter()).
                setPrettyPrinting().
                create();
        // leemos
        try {
            List<Usuario> usuarios = new ArrayList<Usuario>();
            Reader readerUsuarios = new FileReader("data/usuarios.json");
            usuarios = gson.fromJson(
                    readerUsuarios, new TypeToken<List<Usuario>>() {}.getType());
            System.out.println("Usuarios JSON cargados correctamente");
            UsuarioDao uDao = new UsuarioDaoImpl();
            for (Usuario usuario : usuarios) {
                System.out.println("insertando: "+usuario);
                uDao.create(usuario);
            }
            readerUsuarios.close();
            System.out.println("Usuarios almacenado en la BBDD correctamente.\n");

            List<Instalacion> instalaciones = new ArrayList<Instalacion>();
            Reader readerInstalaciones = new FileReader("data/instalaciones.json");
            instalaciones = gson.fromJson(
                readerInstalaciones, new TypeToken<List<Instalacion>>() {}.getType());
            System.out.println("Instalaciones JSON cargados correctamente");
            InstalacionDao iDao = new InstalacionDaoImpl();
            for (Instalacion instalacion : instalaciones) {
                System.out.println("insertando: "+instalacion);
                iDao.create(instalacion);
            }
            readerInstalaciones.close();
            System.out.println("Instalaciones almacenadas en la BBDD correctamente.\n");

            List<Horario> horarios = new ArrayList<Horario>();
            Reader readerHorarios = new FileReader("data/horarios.json");
            horarios = gson.fromJson(
                readerHorarios, new TypeToken<List<Horario>>() {}.getType());
            System.out.println("Horarios JSON cargados correctamente");
            HorarioDao hDao = new HorarioDaoImpl();
            for (Horario horario : horarios) {
                System.out.println("insertando: "+horario);
                hDao.create(horario);
            }
            readerHorarios.close();
            System.out.println("Horarios almacenadas en la BBDD correctamente.\n");

            List<Reserva> reservas = new ArrayList<Reserva>();
            Reader readerReservas = new FileReader("data/reservas.json");
            reservas = gson.fromJson(
                readerReservas, new TypeToken<List<Reserva>>() {}.getType());
            System.out.println("Reservas JSON cargado correctamente");
            ReservaDao rDao = new ReservaDaoIml();
            for (Reserva reserva : reservas) {
                System.out.println("insertando: "+reserva);
                rDao.create(reserva);
            }
            readerReservas.close();
            System.out.println("Reservas almacenadas en la BBDD correctamente.\n");

        } catch (FileNotFoundException fne) {
            System.out.println("Archivo no encontrado.");
        } catch (IOException ioe){
            System.out.println("Error de entrada salida.");
        }
    }

}
