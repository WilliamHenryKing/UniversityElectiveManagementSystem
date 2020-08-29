package za.ac.cput.elective.repository;

public interface IRepository<T, ID> {

    T create(T t);
    T read(ID id);
    T update(T t);
    boolean delete(ID id);

}
