package peaksoft;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.entity.Students;
import peaksoft.util.HibernateUtil;

import java.util.List;

/**
 * @author Zha_Aibek@mail.com
 */
public class ddl {
    public List<Students> method1() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Students> students = session.createQuery("FROM Students WHERE age > 20").getResultList();
        session.getTransaction().commit();
        session.close();
        return students;
    }
}
