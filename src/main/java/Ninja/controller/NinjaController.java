package Ninja.controller;

import java.util.List;

import Ninja.model.DAO.NinjaDAO;
import Ninja.model.classes.Ninja;


public class NinjaController {
    // Instantiate the ProductDAO
    private static NinjaDAO ninjaDAO = new NinjaDAO();

    public static void insertNinja(Ninja ninja) {
        ninjaDAO.save(ninja);
    }


    public static void delete(long ninjaID) {ninjaDAO.delete(ninjaID);
    }

    public static List<Ninja> getAll() {return ninjaDAO.getAll();
    }


    public static Ninja getById(long ninjaID) {return ninjaDAO.getById(ninjaID);
    }

    public static void updateNinja(Ninja ninja) {
        ninjaDAO.update(ninja);
    }
}
