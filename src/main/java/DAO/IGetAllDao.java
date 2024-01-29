/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

/**
 *
 * @author KevinnHernandez
 */
import java.util.List;

public interface IGetAllDao<T> extends IDao{
    /**
     
Retrieves a list of all objects of the specified type.*
@return A list containing all objects of the specified type.*/
List<T> getAll();
}