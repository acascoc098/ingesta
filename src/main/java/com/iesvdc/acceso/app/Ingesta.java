package com.iesvdc.acceso.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
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
import com.iesvdc.acceso.app.entidades.Cliente;
import com.iesvdc.acceso.app.entidades.Reserva;
import com.iesvdc.acceso.app.servicios.ClienteDAO;
import com.iesvdc.acceso.app.servicios.ReservaDAO;

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
            List<Cliente> usuarios = new ArrayList<Cliente>();
            Reader readerUsuarios = new FileReader("bach.json");
            usuarios = gson.fromJson(
                    readerUsuarios, new TypeToken<List<Cliente>>() {}.getType());
            System.out.println("Clientes JSON cargados correctamente");
            ClienteDAO uDao = new ClienteDAOIMP();
            for (Cliente usuario : usuarios) {
                System.out.println("insertando: "+usuario);
                uDao.create(usuario);
            }
            readerUsuarios.close();
            System.out.println("Cliente almacenado en la BBDD correctamente.\n");

            List<Reserva> reservas = new ArrayList<Reserva>();
            Reader readerReservas = new FileReader("data/reservas.json");
            reservas = gson.fromJson(
                readerReservas, new TypeToken<List<Reserva>>() {}.getType());
            System.out.println("Reservas JSON cargado correctamente");
            ReservaDAO rDao = new ReservaDaoIml();
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

        /**
         * GUARDAR EL JSON
         */

         try (PrintWriter prClientes = new PrintWriter(new File("bach.json"))){
            // Para que salga "bonito"
            Gson gson = new GsonBuilder().
                registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter()).
                setPrettyPrinting().
                create();
            // Gson gson = new Gson();
            prClientes.write(gson.toJson());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
