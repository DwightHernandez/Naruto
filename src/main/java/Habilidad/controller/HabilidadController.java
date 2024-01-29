package Habilidad.controller;

import Habilidad.model.DAO.HabilidadDAO;
import Habilidad.model.classes.Habilidad;

import java.util.List;


public class HabilidadController {
    // Instantiate the ProductDAO
    private static HabilidadDAO habilidadDAO = new HabilidadDAO();

    public static void insertHabilidad(Habilidad habilidad) {
        habilidadDAO.save(habilidad);
    }

    public static void delete(long idNinja) {habilidadDAO.delete(idNinja);}

    public static List<Habilidad> getAll() {return habilidadDAO.getAll();
    }


    public static Habilidad getById(long HabilidadID) {return habilidadDAO.getById(HabilidadID);
    }

    public static void updateHabilidad(Habilidad habilidad) {
        habilidadDAO.update(habilidad);
    }


}
