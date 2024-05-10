package by.kolesnik.course.students.dto;

import by.kolesnik.course.students.entity.Student;
import jakarta.persistence.*;

import java.util.Collection;

public class GroupDto {

    private Long id;
    private Integer number;
    private String faculty;
    private Collection<Student> students;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Collection<Student> getStudents() {
        return students;
    }

    public void setStudents(Collection<Student> students) {
        this.students = students;
    }
}
