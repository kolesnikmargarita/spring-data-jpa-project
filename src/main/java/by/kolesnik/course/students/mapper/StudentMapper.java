package by.kolesnik.course.students.mapper;

import by.kolesnik.course.students.dto.CreateStudentDto;
import by.kolesnik.course.students.dto.ShortStudentDto;
import by.kolesnik.course.students.dto.StudentDto;
import by.kolesnik.course.students.entity.Group;
import by.kolesnik.course.students.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public StudentDto toDto(Student student){
        final StudentDto dto = new StudentDto();

        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setLastName(student.getLastName());
        dto.setPhoneNumber(student.getPhoneNumber());
        dto.setGroup(student.getGroup());
        dto.setPayment(student.getPayment());

        return dto;
    }

    public ShortStudentDto toShortDto(Student student){
        final ShortStudentDto dto = new ShortStudentDto();

        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setLastName(student.getLastName());
        dto.setPhoneNumber(student.getPhoneNumber());
        dto.setGroupNumber(student.getGroup().getNumber());
        dto.setPayment(student.getPayment());

        return dto;
    }

    public Student toEntity(StudentDto dto) {
        final Student student = new Student();

        student.setName(dto.getName());
        student.setLastName(dto.getLastName());
        student.setPhoneNumber(dto.getPhoneNumber());
        student.setGroup(dto.getGroup());
        student.setId(dto.getId());
        student.setPayment(dto.getPayment());

        return student;
    }

    public Student toEntity(ShortStudentDto dto, Group group) {
        final Student student = new Student();

        student.setName(dto.getName());
        student.setLastName(dto.getLastName());
        student.setPhoneNumber(dto.getPhoneNumber());
        student.setGroup(group);
        student.setId(dto.getId());
        student.setPayment(dto.getPayment());

        return student;
    }

    public StudentDto toDto(CreateStudentDto student, Group group){
        final StudentDto dto = new StudentDto();

        dto.setName(student.getName());
        dto.setLastName(student.getLastName());
        dto.setPhoneNumber(student.getPhoneNumber());
        dto.setGroup(group);
        dto.setPayment(student.getPayment());

        return dto;
    }

    public ShortStudentDto toShortDto(StudentDto student){
        final ShortStudentDto dto = new ShortStudentDto();

        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setLastName(student.getLastName());
        dto.setPhoneNumber(student.getPhoneNumber());
        dto.setGroupNumber(student.getGroup().getNumber());
        dto.setPayment(student.getPayment());

        return dto;
    }
}
