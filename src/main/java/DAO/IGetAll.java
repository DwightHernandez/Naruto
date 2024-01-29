
package DAO;

import java.util.List;

/**
 *
 * @author KevinnHernandez
 */
public interface IGetAll<T> extends IDao {
    List<T> getAll();
}
