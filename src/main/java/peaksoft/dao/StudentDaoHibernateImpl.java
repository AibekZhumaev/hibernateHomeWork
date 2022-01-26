package peaksoft.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import peaksoft.entity.Students;
import peaksoft.util.HibernateUtil;

import java.util.List;

/**
 * @author Zha_Aibek@mail.com
 */
public class StudentDaoHibernateImpl implements StudentDao {

    public StudentDaoHibernateImpl() {
    }

    @Override
    public void createStudentsTable() {
        try {
            String sql = "create table if not exists students ( " +
                    " id serial primary key, " +
                    " first_name varchar not null, " +
                    " surname varchar not null, " +
                    " course varchar not null, " +
                    " age integer not null );";
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.createSQLQuery(sql).executeUpdate();
            session.getTransaction().commit();
            session.close();
            System.out.println("Create table !!!");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void dropStudentsTable() {
        String sql = "drop table students";
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.createSQLQuery(sql).executeUpdate();
            session.getTransaction().commit();
            session.close();
            System.out.println("Drop table !!!");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public int saveStudent(Students students) {
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(students);
            session.getTransaction().commit();
            session.close();
            System.out.println("Add successfully :" + students);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return students.getId();
    }

    @Override
    public void updateStudent(int id, String name, int age) {
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Students students = session.get(Students.class, id);
            students.setName(name);
            students.setAge(age);
            session.getTransaction().commit();
            session.close();
            System.out.println("Successfully updated !!!");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void getStudentsById(int id) {
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Students student = session.get(Students.class, id);
            System.out.println(student.getName() + " " + student.getSurname());
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Students> getAllStudents() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Students> students = session.createQuery("FROM Students").getResultList();
        session.getTransaction().commit();
        System.out.println("Finded : " + students.size() + " students");
        return students;
    }

    @Override
    public void cleanStudentsTable() {
        String sql = "DELETE FROM students";
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.createSQLQuery(sql).executeUpdate();
            session.getTransaction().commit();
            session.close();
            System.out.println("Successfully deleted all dates in Students !!!");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
