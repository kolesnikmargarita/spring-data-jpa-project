package by.kolesnik.course.students.facade;

import by.kolesnik.course.students.dto.GroupDto;
import by.kolesnik.course.students.dto.StudentDto;
import by.kolesnik.course.students.entity.Group;
import by.kolesnik.course.students.entity.Student;
import by.kolesnik.course.students.mapper.GroupMapper;
import by.kolesnik.course.students.service.GroupService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GroupFacade {

    public final GroupService groupService;
    public final GroupMapper groupMapper;


    public GroupFacade(GroupService groupService, GroupMapper groupMapper) {
        this.groupService = groupService;
        this.groupMapper = groupMapper;
    }

    public Group findByNumber(Integer number) {
        return groupService.findByNumber(number);
    }

}
