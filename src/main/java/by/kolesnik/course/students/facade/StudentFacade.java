package by.kolesnik.course.students.facade;

import by.kolesnik.course.students.dto.ShortStudentDto;
import by.kolesnik.course.students.dto.StudentDto;
import by.kolesnik.course.students.entity.Group;
import by.kolesnik.course.students.entity.Student;
import by.kolesnik.course.students.mapper.StudentMapper;
import by.kolesnik.course.students.service.StudentService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentFacade {

    private final StudentService studentService;
    private final StudentMapper studentMapper;

    public StudentFacade(StudentService studentService, StudentMapper studentMapper) {
        this.studentService = studentService;
        this.studentMapper = studentMapper;
    }

    public List<ShortStudentDto> findAll() {

        return studentService.findAll().stream()
                .map(studentMapper::toShortDto)
                .toList();
    }

    public List<ShortStudentDto> findUnpaid() {
        return studentService.findUnpaid().stream()
                .map(studentMapper::toShortDto)
                .toList();
    }

    public List<ShortStudentDto> findByName(String name) {
        return studentService.findByName(name).stream()
                .map(studentMapper::toShortDto)
                .toList();
    }

    public List<ShortStudentDto> findByLastname(String lastname) {
        return studentService.findByLastName(lastname).stream()
                .map(studentMapper::toShortDto)
                .toList();
    }

    public List<ShortStudentDto> findAllByGroup(Group group) {
        return studentService.findAllByGroup(group).stream()
                .map(studentMapper::toShortDto)
                .toList();
    }

    public void deleteStudent(Long id) {
        studentService.deleteById(id);
    }

    public StudentDto saveStudent(StudentDto dto) {
        final Student student = studentMapper.toEntity(dto);
        studentService.save(student);
        return studentMapper.toDto(student);
    }

    public Student findById(Long id) {
        return studentService.findById(id);
    }


}
