package com.Ilan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MensajesDAO {
    public static void crearMensajeDB(Mensajes mensaje){
        Conexion db_connect = new Conexion();

        try(Connection conexion = db_connect.getConnection()){
            PreparedStatement ps = null;

            try {
                String query = "INSERT INTO `mensajes_app`.`mensaje` (`mensaje`, `autor_mensaje`) VALUES (?, ?);\n";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutor_mensaje());
                ps.executeUpdate();
                System.out.println("Mensaje creado");

            } catch (SQLException ignored){
                System.out.println(ignored);
            }
        } catch (SQLException e){
            System.out.println(e);
        }
    }
    public static void leerMensajeDB(){
        Conexion db_connect = new Conexion();

        PreparedStatement ps = null;
        ResultSet rs = null;

        try(Connection conexion = db_connect.getConnection()){
            String query = "SELECT * FROM mensajes_app.mensaje;";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()){
                System.out.println("ID: "+rs.getInt("id_mensaje"));
                System.out.println("Mensaje: "+rs.getString("mensaje"));
                System.out.println("Autor: "+rs.getString("autor_mensaje"));
                System.out.println("Fecha: "+rs.getString("fecha_mensaje"));
                System.out.println(" ");
            }

        } catch (SQLException e){
            System.out.println("No se pudieron recuperar los mensajes.");
            System.out.println(e);
        }
    }
    public static void borrarMensajeDB(int id_mensaje){
        Conexion db_connect = new Conexion();
        try(Connection conexion = db_connect.getConnection()){
            PreparedStatement ps = null;
            try {
                String query = "DELETE FROM `mensajes_app`.`mensaje` WHERE (`id_mensaje` = ?);\n";
                ps = conexion.prepareStatement(query);
                ps.setInt(1, id_mensaje);
                ps.executeUpdate();
                System.out.println("El mensaje ha sido borrado.");
                System.out.println(" ");

            } catch (SQLException e){
                System.out.println("No se puedo borrar el mensaje");
                System.out.println(e);
            }

        } catch (SQLException e){
            System.out.println(e);
        }

    }
    public static void actualizarMensajeDB(Mensajes mensaje){
        Conexion db_connect = new Conexion();

        try(Connection conexion = db_connect.getConnection()){
            PreparedStatement ps = null;

            try {
                String query = "UPDATE `mensajes_app`.`mensaje` SET `mensaje` = ? WHERE (`id_mensaje` = ?);";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setInt(2, mensaje.getId_mensaje());
                ps.executeUpdate();
                System.out.println("El mensaje se ha actualizado correctamente \n");

            } catch (SQLException e){
                System.out.println("No se puedo borrar el mensaje");
                System.out.println(e);
            }

        } catch (SQLException e){
            System.out.println(e);
        }

    }
}
