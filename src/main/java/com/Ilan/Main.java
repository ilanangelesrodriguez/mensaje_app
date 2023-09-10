package com.Ilan;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        // System.out.println("Hello world!");

        Conexion conexion = new Conexion();
        try(Connection cnx = conexion.getConnection()) {

        } catch(Exception e){
            System.out.println(e);
        }
    }
}