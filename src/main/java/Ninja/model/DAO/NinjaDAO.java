/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ninja.model.DAO;
import DAO.*;
import Ninja.model.classes.Ninja;
import Ninja.model.classes.builder.NinjaBuilder;
import Ninja.model.classes.builder.NinjaConcreteBuilder;
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
public class NinjaDAO implements ISaveDao<Ninja>, IDeleteDao<Ninja>, IGetAllDao<Ninja>, IGetByIdDao<Ninja>, IUpdateDao<Ninja> {

    @Override
    public void save(Ninja ninja) {
        String stmInsert = "INSERT INTO ninja(ninjaID, nombreNinja, rangoNinja, aldeaNinja) VALUES(?,?,?,?);";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmInsert)) {
            ps.setLong(1, ninja.getNinjaID());
            ps.setString(2, ninja.getNombreNinja());
            ps.setString(3, ninja.getRangoNinja());
            ps.setString(4, ninja.getAldeaNinja());

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
    public void delete(long ninjaID) {
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "DELETE FROM Ninja WHERE ninjaID = ?;";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ps.setLong(1, ninjaID);
            int rows = Operations.insert_update_delete_db(ps);
            if (rows > 0) {
                System.out.println("successful delete product");
                return;
            } else {
                System.out.println("not exists product");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("something was wrong on delete product");
    }

    /**
     * Retrieves a list of all products from the database.
     *
     * @return A list containing all products.
     */
    @Override
    public List<Ninja> getAll() {
        List<Ninja> ninjaList = new ArrayList<>();
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "SELECT * FROM Ninja";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ResultSet rs = Operations.query_db(ps);

            while (rs.next()) {
                NinjaBuilder eventBuilder = new NinjaConcreteBuilder();

                Ninja sqlNinja = eventBuilder
                        .ninjaID(rs.getLong("ninjaID"))
                        .nombreNinja(rs.getString("nombreNinja"))
                        .rangoNinja(rs.getString("rangoNinja"))
                        .aldeaNinja(rs.getString("aldeaNinja"))
                        .build();

                ninjaList.add(sqlNinja);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ninjaList;
    }

    /**
     * Retrieves a product from the database based on the provided product ID.
     *
     * @param id The ID of the product to be retrieved.
     * @return The product with the specified ID.
     */
    @Override
    public Ninja getById(long id) {
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "SELECT * FROM Ninja where ninjaID = ?;";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ps.setLong(1, id);

            ResultSet rs = Operations.query_db(ps);

            if (rs.next()) {
                NinjaBuilder ninjaBuilder = new NinjaConcreteBuilder();

                Ninja sqlNinja = ninjaBuilder
                        .ninjaID(rs.getLong("ninjaID"))
                        .nombreNinja(rs.getString("nombreNinja"))
                        .rangoNinja(rs.getString("rangoNinja"))
                        .aldeaNinja(rs.getString("aldeaNinja"))
                        .build();

                return sqlNinja;
            } else {
                System.out.println("ERROR: The id has not been found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



    @Override
    public void update(Ninja ninja) {
        Ninja sqlNinja = getById(ninja.getNinjaID());

        if (sqlNinja != null) {
            sqlNinja.setNinjaID(ninja.getNinjaID());
            sqlNinja.setNombreNinja(ninja.getNombreNinja());
            sqlNinja.setRangoNinja(ninja.getRangoNinja());
            sqlNinja.setAldeaNinja(ninja.getAldeaNinja());

            String stmInsert = """
            UPDATE Ninja
            SET ninjaID  = ?,
                nombreNinja  = ?,
                rangoNinja = ?,
                aldeaNinja  = ?,            
            WHERE ninjaID  = ?;
            """;

            try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmInsert)) {
                ps.setLong(1, ninja.getNinjaID());
                ps.setString(2, ninja.getNombreNinja());
                ps.setString(3, ninja.getRangoNinja());
                ps.setString(4, ninja.getAldeaNinja());

                System.out.println(ps.toString());

                int rows = Operations.insert_update_delete_db(ps);
                if (rows <= 0) {
                    System.out.println("Cannot update products");
                } else {
                    System.out.println("Successful update products");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("not found results products");
        }
    }
}
