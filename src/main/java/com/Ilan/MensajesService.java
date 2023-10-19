package com.Ilan;

import java.util.Scanner;

public class MensajesService {
    public static void crearMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Escribe tu mensaje: ");
        String mensaje = sc.nextLine();

        System.out.print("Tu nombre: ");
        String nombre = sc.nextLine();

        Mensajes registro = new Mensajes();
        registro.setMensaje(mensaje);
        registro.setAutor_mensaje(nombre);

        MensajesDAO.crearMensajeDB(registro);
    }
    public static void listarMensaje(){
        MensajesDAO.leerMensajeDB();
    }
    public static void borrarMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Indica ID del mensaje a borrar: ");
        int id_mensaje = sc.nextInt();
        MensajesDAO.borrarMensajeDB(id_mensaje);
    }
    public static void editarMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Escribe tu nuevo mensaje: ");
        String mensaje = sc.nextLine();
        System.out.print("Indica ID del mensaje a editar: ");
        int id_mensaje = sc.nextInt();

        Mensajes update = new Mensajes();
        update.setId_mensaje(id_mensaje);
        update.setMensaje(mensaje);

        MensajesDAO.actualizarMensajeDB(update);
    }
}
