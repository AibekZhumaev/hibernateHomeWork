package peaksoft.service;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import peaksoft.dao.StudentDao;
import peaksoft.dao.StudentDaoHibernateImpl;
import peaksoft.entity.Students;

import java.util.List;

/**
 * @author Zha_Aibek@mail.com
 */
public class StudentServiceImpl implements StudentService {

    private final StudentDao studentDao = new StudentDaoHibernateImpl();

    @Override
    public void createStudentsTable() {
        studentDao.createStudentsTable();
    }

    @Override
    public void dropStudentsTable() {
        studentDao.dropStudentsTable();
    }

    @Override
    public int saveStudent(Students students) {
        return studentDao.saveStudent(students);
    }

    @Override
    public void updateStudent(int id, String name, int age) {
        studentDao.updateStudent(id, name, age);
    }

    @Override
    public void getStudentsById(int id) {
        studentDao.getStudentsById(id);
    }

    @Override
    public List<Students> getAllStudents() {
        return studentDao.getAllStudents();
    }

    @Override
    public void cleanStudentsTable() {
        studentDao.cleanStudentsTable();
    }
}
