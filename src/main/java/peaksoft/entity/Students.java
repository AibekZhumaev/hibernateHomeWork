package peaksoft.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * @author Zha_Aibek@mail.com
 */
@Component
@Entity
@Table(name = "students")
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    private String name;
    @Column(name = "surname", unique = true)
    private String surname;
    @Column(name = "course")
    private String curse;
    @Column(name = "age")
    private int age;

    public Students(String name, String surname, String curse, int age) {
        this.name = name;
        this.surname = surname;
        this.curse = curse;
        this.age = age;
    }

    public Students() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCurse() {
        return curse;
    }

    public void setCurse(String curse) {
        this.curse = curse;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", curse='" + curse + '\'' +
                ", age=" + age +
                '}';
    }
}
