/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Habilidad.model.DAO;
import DAO.*;
import Habilidad.model.classes.Habilidad;
import Habilidad.model.classes.builder.HabilidadBuilder;
import Habilidad.model.classes.builder.HabilidadConcreteBuilder;
import persistence.BDConnection;
import persistence.Operations;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HabilidadDAO implements ISaveDao<Habilidad>, IDeleteDao<Habilidad>, IGetAllDao<Habilidad>, IGetByIdDao<Habilidad>, IUpdateDao<Habilidad> {

    @Override
    public void save(Habilidad habilidad) {
        String stmInsert = "INSERT INTO Mision(idNinja, nombreHabilidad, descripcionHabilidad) VALUES(?,?,?);";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmInsert)) {
            ps.setLong(1, habilidad.getIdNinja());
            ps.setString(2, habilidad.getNombreHabilidad());
            ps.setString(3, habilidad.getDescripcionHabilidad());

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
    public static void delete(long idNinja) {
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "DELETE FROM Habilidad WHERE idNinja = ?;";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ps.setLong(1, idNinja);
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
    public List<Habilidad> getAll() {
        List<Habilidad> habilidad = new ArrayList<>();
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "SELECT * FROM Habilidad;";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ResultSet rs = Operations.query_db(ps);

            while (rs.next()) {
                HabilidadBuilder eventBuilder = new HabilidadConcreteBuilder();

                Habilidad sqlHabilidad = eventBuilder
                        .idNinja(rs.getLong("idNinja"))
                        .nombreHabilidad(rs.getString("nombreHabilidad"))
                        .descripcionHabilidad(rs.getString("descripcionHabilidad"))
                        .build();

                habilidadList.add(sqlHabilidad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return habilidadList;
    }



    @Override
    public Habilidad getById(long id) {
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "SELECT * FROM Habilidad where idNinja = ?;";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ps.setLong(1, id);

            ResultSet rs = Operations.query_db(ps);

            if (rs.next()) {
                HabilidadBuilder habilidadBuilder = new HabilidadConcreteBuilder();

                Habilidad sqlHabilidad = habilidadBuilder
                        .idNinja(rs.getLong("idNinja"))
                        .nombreHabilidad(rs.getString("nombreHabilidad"))
                        .descripcionHabilidad(rs.getString("descripcionHabilidad"))
                        .build();

                return sqlHabilidad;
            } else {
                System.out.println("ERROR: The id has not been found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



    @Override
    public void update(Habilidad habilidad) {
        Habilidad sqlHabilidad = getById(habilidad.getIdNinja());

        if (sqlHabilidad != null) {
            sqlHabilidad.setIdNinja(habilidad.getIdNinja());
            sqlHabilidad.setNombreHabilidad(habilidad.getNombreHabilidad());
            sqlHabilidad.setDescripcionHabilidad(habilidad.getDescripcionHabilidad());

            String stmInsert = """
            UPDATE Habilidad
            SET idNinja  = ?,
                nombreHabilidad  = ?,
                descripcionHabilidad = ?,
            WHERE idNinja  = ?;
            """;

            try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmInsert)) {
                ps.setLong(1, habilidad.getIdNinja());
                ps.setString(2, habilidad.getNombreHabilidad());
                ps.setString(3, habilidad.getDescripcionHabilidad());

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
