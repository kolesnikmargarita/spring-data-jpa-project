package by.kolesnik.course.students.service;

import by.kolesnik.course.students.dto.StudentDto;
import by.kolesnik.course.students.entity.Group;
import by.kolesnik.course.students.entity.Student;
import by.kolesnik.course.students.exception.EntityNotFoundException;
import by.kolesnik.course.students.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findById(Long id) {
        final Optional<Student> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isEmpty()) {
            throw new EntityNotFoundException("Пользователь с id '" + id + "' не найден");
        }

        return optionalStudent.get();
    }

    public List<Student> findByName(String name) {
        /*final Optional<Student> optionalStudent = studentRepository.findByName(name);

        if (optionalStudent.isEmpty()) {
            throw new EntityNotFoundException("Пользователь с именем '" + name + "' не найден");
        }

        return optionalStudent.get();*/

        return studentRepository.findAllByName(name);
    }

    public List<Student> findByLastName(String lastName) {
        return studentRepository.findAllByLastName(lastName);
    }

    public List<Student> findAllByGroup(Group group) {
        return studentRepository.findAllByGroup(group);
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> findUnpaid() {
        return studentRepository.findByPaymentFalse();
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }
}
