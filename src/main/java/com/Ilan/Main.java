package com.Ilan;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // System.out.println("Hello world!");
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("-----------------");
            System.out.println(" Aplicacion de mensajes");
            System.out.println(" 1. crear mensaje");
            System.out.println(" 2. listar mensajes");
            System.out.println(" 3. eliminar mensaje");
            System.out.println(" 4. editar mensaje");
            System.out.println(" 5. salir");

            System.out.print("Resp: ");
            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    MensajesService.crearMensaje();
                    break;
                case 2:
                    MensajesService.listarMensaje();
                    break;
                case 3:
                    MensajesService.borrarMensaje();
                    break;
                case 4:
                    MensajesService.editarMensaje();
                    break;
                default:
                    break;
            }
        } while(opcion!=5);

        Conexion conexion = new Conexion();
        try(Connection cnx = conexion.getConnection()) {

        } catch(Exception e){
            System.out.println(e);
        }
    }
}