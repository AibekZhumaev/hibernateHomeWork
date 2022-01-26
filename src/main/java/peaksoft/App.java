package peaksoft;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.entity.Students;
import peaksoft.service.StudentService;
import peaksoft.service.StudentServiceImpl;
import peaksoft.util.HibernateUtil;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        StudentService studentService = new StudentServiceImpl();

//        Students students1 = new Students("Aza", "Абдуллаев", "Java", 23);
//        Students students2 = new Students("Aza", "Кадыров", "JavaScript", 14);
//        Students students3 = new Students("Aza", "Акматов", "Java", 32);
//        Students students4 = new Students("Aza", "Осмонов", "JavaScript", 17);
//        Students students5 = new Students("Aza", "Исаков", "Java", 24);
//
//        studentService.saveStudent(students1);
//        studentService.saveStudent(students2);
//        studentService.saveStudent(students3);
//        studentService.saveStudent(students4);
//        studentService.saveStudent(students5);

//        for (Students s : firstMethod()) {
//            System.out.println(s);
//        }
//        firstMethod();
//        secondMethod();
//        thirdMethod();
    }

    public static List<Students> firstMethod() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List students = session.createQuery("FROM Students WHERE age > 20").getResultList();
        session.getTransaction().commit();
        session.close();
        return students;
    }

    public static void secondMethod() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.createQuery("UPDATE Students SET age = 18 WHERE name = 'Aza'").executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    public static void thirdMethod() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.createQuery("DELETE FROM Students WHERE name = 'Aza'").executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted all dates in Students !!!");
    }
}

