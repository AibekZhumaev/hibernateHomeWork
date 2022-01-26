package peaksoft.service;

import org.springframework.stereotype.Component;
import peaksoft.entity.Students;

import java.util.List;

/**
 * @author Zha_Aibek@mail.com
 */
public interface StudentService {
    void createStudentsTable();

    void dropStudentsTable();

    int saveStudent(Students students);

    void updateStudent(int id, String name, int age);

    void getStudentsById(int id);

    List<Students> getAllStudents();

    void cleanStudentsTable();
}
