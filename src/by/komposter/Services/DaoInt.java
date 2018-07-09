package by.komposter.Services;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

public interface DaoInt {
    public Object create(SessionFactory sFactory);
    public Object update(SessionFactory sFactory, Object o);
    public boolean delete (SessionFactory sFactory,Object o);
    public Object read(SessionFactory sFactory, Object o);
}
