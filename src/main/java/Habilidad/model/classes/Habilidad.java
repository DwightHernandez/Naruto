/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Habilidad.model.classes;

/**
 *
 * @author Kevinn Hernandez
 */
public class Habilidad {
    
    //Atributos
    private long idNinja;
    private String nombreHabilidad;
    private String descripcionHabilidad;

    public Habilidad() {
    }

    public Habilidad(long idNinja, String nombreHabilidad, String descripcionHabilidad) {
        this.idNinja = idNinja;
        this.nombreHabilidad = nombreHabilidad;
        this.descripcionHabilidad = descripcionHabilidad;
    }

    //Getters y setters


    public long getIdNinja() {
        return idNinja;
    }

    public void setIdNinja(long idNinja) {
        this.idNinja = idNinja;
    }

    public String getNombreHabilidad() {
        return nombreHabilidad;
    }

    public void setNombreHabilidad(String nombreHabilidad) {
        this.nombreHabilidad = nombreHabilidad;
    }

    public String getDescripcionHabilidad() {
        return descripcionHabilidad;
    }

    public void setDescripcionHabilidad(String descripcionHabilidad) {
        this.descripcionHabilidad = descripcionHabilidad;
    }

    // toString


    @Override
    public String toString() {
        return "Habilidad{" +
                "idNinja=" + idNinja +
                ", nombreHabilidad='" + nombreHabilidad + '\'' +
                ", descripcionHabilidad='" + descripcionHabilidad + '\'' +
                '}';
    }
}
