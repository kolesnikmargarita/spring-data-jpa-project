package by.kolesnik.course.students.facade;

import by.kolesnik.course.students.dto.CreateStudentDto;
import by.kolesnik.course.students.dto.ShortStudentDto;
import by.kolesnik.course.students.dto.StudentDto;
import by.kolesnik.course.students.dto.TransferStudentRequest;
import by.kolesnik.course.students.entity.Group;
import by.kolesnik.course.students.entity.Student;
import by.kolesnik.course.students.exception.StudentNotFromTheGroupException;
import by.kolesnik.course.students.mapper.StudentMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GroupStudentFacade {

    private final StudentFacade studentFacade;
    private final GroupFacade groupFacade;
    private final StudentMapper studentMapper;


    public GroupStudentFacade(StudentFacade studentFacade, GroupFacade groupFacade, StudentMapper studentMapper) {
        this.studentFacade = studentFacade;
        this.groupFacade = groupFacade;
        this.studentMapper = studentMapper;
    }

    public void transferStudent(TransferStudentRequest dto) {
        final Student student = studentFacade.findById(dto.getStudentId());
        final Group groupFrom = groupFacade.findByNumber(dto.getFromNumber());
        if(groupFrom != student.getGroup()) {
            throw new StudentNotFromTheGroupException("В группе с номером " + dto.getFromNumber() + " студент с id " + dto.getStudentId() + " не найден");
        }
        final Group groupTo = groupFacade.findByNumber(dto.getToNumber());
        student.setGroup(groupTo);
        studentFacade.saveStudent(studentMapper.toDto(student));
    }

    public List<ShortStudentDto> findStudentsByGroupNumber(Integer groupNumber) {
        // find group by number
        final Group group = groupFacade.findByNumber(groupNumber);
        //find students by group number
        return studentFacade.findAllByGroup(group);
    }

    public ShortStudentDto updateStudent(Long id, ShortStudentDto dto) {
        final Student student = studentFacade.findById(id);

        if (dto.getName() != null) {
            student.setName(dto.getName());
        }

        if (dto.getLastName() != null) {
            student.setLastName(dto.getLastName());
        }

        if (dto.getPhoneNumber() != null) {
            student.setPhoneNumber(dto.getPhoneNumber());
        }

        if (dto.getGroupNumber() != null) {
            Group group = groupFacade.findByNumber(dto.getGroupNumber());
            student.setGroup(group);
        }

        if (dto.getPayment() != null) {
            student.setPayment(dto.getPayment());
        }

        final StudentDto studentDto = studentMapper.toDto(student);
        studentFacade.saveStudent(studentDto);

        return studentMapper.toShortDto(student);
    }

    public StudentDto findById(Long id) {
        final Student student = studentFacade.findById(id);
        return studentMapper.toDto(student);
    }

    public ShortStudentDto saveStudent(CreateStudentDto dto) {
        Group group = groupFacade.findByNumber(dto.getGroupNumber());
        StudentDto student = studentMapper.toDto(dto, group);
        studentFacade.saveStudent(student);
        return studentMapper.toShortDto(student);
    }
}
