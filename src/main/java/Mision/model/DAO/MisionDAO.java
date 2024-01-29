/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mision.model.DAO;
import DAO.*;
import Mision.model.classes.Mision;
import Mision.model.classes.builder.MisionBuilder;
import Mision.model.classes.builder.MisionConcreteBuilder;
import persistence.BDConnection;
import persistence.Operations;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The {@code ProductDAO} class implements various data access operations
 * (CRUD) for the {@code Product} entity using SQL queries.
 * 
 * <p>The methods provided by this class include saving a product, deleting
 * a product, retrieving all products, retrieving a product by its ID, and
 * updating a product's information.
 * 
 * @author SneiderEsteban
 */
public class MisionDAO implements ISaveDao<Mision>, IDeleteDao<Mision>, IGetAllDao<Mision>, IGetByIdDao<Mision>, IUpdateDao<Mision> {

    @Override
    public void save(Mision mision) {
        String stmInsert = "INSERT INTO Mision(misionID, decripcionID, rangoMision, recompensaMision) VALUES(?,?,?,?);";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmInsert)) {
            ps.setLong(1, mision.getMisionID());
            ps.setString(2, mision.getDescripcionMision());
            ps.setString(3, mision.getRangoMision());
            ps.setDouble(4, mision.getRecompenzaMision());

            int rows = Operations.insert_update_delete_db(ps);
            if (rows <= 0) {
                System.out.println("Cannot push event");
            } else {
                System.out.println("Successful push event");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void delete(long misionID) {
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "DELETE FROM Mision WHERE misionID = ?;";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ps.setLong(1, misionID);
            int rows = Operations.insert_update_delete_db(ps);
            if (rows > 0) {
                System.out.println("successful delete mision");
                return;
            } else {
                System.out.println("not exists mision");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("something was wrong on delete mision");
    }

    /**
     * Retrieves a list of all products from the database.
     *
     * @return A list containing all products.
     */
    @Override
    public List<Mision> getAll() {
        List<Mision> misionList = new ArrayList<>();
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "SELECT * FROM Mision";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ResultSet rs = Operations.query_db(ps);

            while (rs.next()) {
                MisionBuilder eventBuilder = new MisionConcreteBuilder();

                Mision sqlMision = eventBuilder
                        .misionID(rs.getLong("misionID"))
                        .descripcionMision(rs.getString("descripcionMision"))
                        .rangoMision(rs.getString("rangoMision"))
                        .recompensaMision(rs.getDouble("recompensaMision"))
                        .build();

                misionList.add(sqlMision);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return misionList;
    }



    @Override
    public Mision getById(long id) {
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "SELECT * FROM Mision where misionID = ?;";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ps.setLong(1, id);

            ResultSet rs = Operations.query_db(ps);

            if (rs.next()) {
                MisionBuilder misionBuilder = new MisionConcreteBuilder();

                Mision sqlMision = misionBuilder
                        .misionID(rs.getLong("misionID"))
                        .descripcionMision(rs.getString("descripcionMision"))
                        .rangoMision(rs.getString("rangoMision"))
                        .recompensaMision(rs.getDouble("aldeaNinja"))
                        .build();

                return sqlMision;
            } else {
                System.out.println("ERROR: The id has not been found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



    @Override
    public void update(Mision mision) {
        Mision sqlMision = getById(mision.getMisionID());

        if (sqlMision != null) {
            sqlMision.setMisionID(mision.getMisionID());
            sqlMision.setDescripcionMision(mision.getDescripcionMision());
            sqlMision.setRangoMision(mision.getRangoMision());
            sqlMision.setRecompenzaMision(mision.getRecompenzaMision());

            String stmInsert = """
            UPDATE Mision
            SET misionID  = ?,
                descripcionMision  = ?,
                rangoMision = ?,
                recompensaMision  = ?,            
            WHERE misionID  = ?;
            """;

            try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmInsert)) {
                ps.setLong(1, mision.getMisionID());
                ps.setString(2, mision.getDescripcionMision());
                ps.setString(3, mision.getRangoMision());
                ps.setDouble(4, mision.getRecompenzaMision());

                System.out.println(ps.toString());

                int rows = Operations.insert_update_delete_db(ps);
                if (rows <= 0) {
                    System.out.println("Cannot update mision");
                } else {
                    System.out.println("Successful update mision");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("not found results products");
        }
    }
}
