package za.ac.cput.elective.repository;

/**
 * @author @WilliamHenryKing
 * Desc: General Interface for Repository
 * Date: 2020/08/26
 **/

public interface IRepository<T, ID> {

    T create(T t);
    T read(ID id);
    T update(T t);
    boolean delete(ID id);

}
