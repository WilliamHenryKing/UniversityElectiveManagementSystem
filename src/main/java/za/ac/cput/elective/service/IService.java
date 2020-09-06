package za.ac.cput.elective.service;

/**
 * @author @WilliamHenryKing
 * Desc: General Interface for Service
 * Date: 2020/09/04
 **/

public interface IService<T, ID> {

    T create(T t);
    T read(ID id);
    T update(T t);
    boolean delete(ID id);
}
