package by.komposter.Services;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

public interface DaoInt<T> {
    T create(T object);
    void update(T object);
    T delete (T object);
    T getById(int id);
    T getByStr(String str);
}