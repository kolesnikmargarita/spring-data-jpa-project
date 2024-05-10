package by.kolesnik.course.students.controller;

import by.kolesnik.course.students.dto.CreateStudentDto;
import by.kolesnik.course.students.dto.ShortStudentDto;
import by.kolesnik.course.students.dto.StudentDto;
import by.kolesnik.course.students.dto.TransferStudentRequest;
import by.kolesnik.course.students.facade.GroupFacade;
import by.kolesnik.course.students.facade.GroupStudentFacade;
import by.kolesnik.course.students.facade.StudentFacade;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentFacade studentFacade;
    private final GroupStudentFacade groupStudentFacade;

    public StudentController(StudentFacade studentFacade, GroupStudentFacade groupStudentFacade) {
        this.studentFacade = studentFacade;
        this.groupStudentFacade = groupStudentFacade;
    }

    @GetMapping
    public List<ShortStudentDto> findAll() {
        return studentFacade.findAll();
    }

    @GetMapping("/unpaid")
    public List<ShortStudentDto> findUnpaid() {
        return studentFacade.findUnpaid();
    }

    @GetMapping("/findByName")
    public List<ShortStudentDto> findByName(String name) {
        return studentFacade.findByName(name);
    }

    @GetMapping("/findByLastName")
    public List<ShortStudentDto> findByLastname(String lastname) {
        return studentFacade.findByLastname(lastname);
    }

    @GetMapping("/{groupNumber}")
    public List<ShortStudentDto> findByGroupNumber(@PathVariable Integer groupNumber) {
        return groupStudentFacade.findStudentsByGroupNumber(groupNumber);
    }

    @PatchMapping("/{id}")
    public ShortStudentDto updateStudent(@PathVariable Long id, ShortStudentDto dto) {
        return groupStudentFacade.updateStudent(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentFacade.deleteStudent(id);
    }

    @PostMapping
    public ShortStudentDto saveStudent(CreateStudentDto dto) {
        return  groupStudentFacade.saveStudent(dto);
    }

    @PatchMapping
    public void transferStudent(TransferStudentRequest dto) {
        groupStudentFacade.transferStudent(dto);
    }
}
