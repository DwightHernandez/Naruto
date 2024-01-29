package Mision.controller;

import Mision.model.DAO.MisionDAO;
import Mision.model.classes.Mision;

import java.util.List;


public class MisionController {
    // Instantiate the ProductDAO
    private static MisionDAO misionDAO = new MisionDAO();

    public static void insertMision(Mision mision) {
        misionDAO.save(mision);
    }


    public static void delete(long misionID) {misionDAO.delete(misionID);}

    public static List<Mision> getAll() {return misionDAO.getAll();
    }


    public static Mision getById(long misionID) {return misionDAO.getById(misionID);
    }

    public static void updateMision(Mision mision) {
        misionDAO.update(mision);
    }


}
