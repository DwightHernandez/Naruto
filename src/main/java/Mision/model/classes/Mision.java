/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mision.model.classes;

/**
 *
 * @author Kevinn Hernandez
 */
public class Mision {
    
    //Atributos
    private long misionID;
    private String descripcionMision;
    private String rangoMision;
    private double recompensaMision;

    public Mision() {
    }

    public Mision(long misionID, String descripcionMision, String rangoMision, double recompensaMision) {
        this.misionID = misionID;
        this.descripcionMision = descripcionMision;
        this.rangoMision = rangoMision;
        this.recompensaMision = recompensaMision;
    }

    //Getters y setters


    public long getMisionID() {
        return misionID;
    }

    public void setMisionID(long misionID) {
        this.misionID = misionID;
    }

    public String getDescripcionMision() {
        return descripcionMision;
    }

    public void setDescripcionMision(String descripcionMision) {
        this.descripcionMision = descripcionMision;
    }

    public String getRangoMision() {
        return rangoMision;
    }

    public void setRangoMision(String rangoMision) {
        this.rangoMision = rangoMision;
    }

    public double getRecompenzaMision() {
        return recompensaMision;
    }

    public void setRecompenzaMision(double recompenzaMision) {
        this.recompensaMision = recompenzaMision;
    }

    // toString


    @Override
    public String toString() {
        return "Mision{" +
                "misionID=" + misionID +
                ", descripcionMision='" + descripcionMision + '\'' +
                ", rangoMision='" + rangoMision + '\'' +
                ", recompenzaMision=" + recompensaMision +
                '}';
    }
}
