/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ninja.model.classes;

/**
 *
 * @author Kevinn Hernandez
 */
public class  Ninja {
    
    //Atributos
    private long ninjaID;
    private String nombreNinja;
    private String rangoNinja;
    private String aldeaNinja;

    public Ninja() {
    }

    public Ninja(long ninjaID, String nombreNinja, String rangoNinja, String aldeaNinja) {
        this.ninjaID = ninjaID;
        this.nombreNinja = nombreNinja;
        this.rangoNinja = rangoNinja;
        this.aldeaNinja = aldeaNinja;
    }

    //Getters y setters


    public long getNinjaID() {
        return ninjaID;
    }

    public void setNinjaID(long ninjaID) {
        this.ninjaID = ninjaID;
    }

    public String getNombreNinja() {
        return nombreNinja;
    }

    public void setNombreNinja(String nombreNinja) {
        this.nombreNinja = nombreNinja;
    }

    public String getRangoNinja() {
        return rangoNinja;
    }

    public void setRangoNinja(String rangoNinja) {
        this.rangoNinja = rangoNinja;
    }

    public String getAldeaNinja() {
        return aldeaNinja;
    }

    public void setAldeaNinja(String aldeaNinja) {
        this.aldeaNinja = aldeaNinja;
    }

    //Metodo toString


    @Override
    public String toString() {
        return "Ninja{" +
                "ninjaID=" + ninjaID +
                ", nombreNinja='" + nombreNinja + '\'' +
                ", rangoNinja='" + rangoNinja + '\'' +
                ", aldeaNinja='" + aldeaNinja + '\'' +
                '}';
    }
}
