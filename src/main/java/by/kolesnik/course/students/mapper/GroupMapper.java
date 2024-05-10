package by.kolesnik.course.students.mapper;

import by.kolesnik.course.students.dto.GroupDto;
import by.kolesnik.course.students.entity.Group;
import org.springframework.stereotype.Component;

@Component
public class GroupMapper {

    public GroupDto toDto(Group group){
        final GroupDto dto = new GroupDto();

        dto.setId(group.getId());
        dto.setFaculty(group.getFaculty());
        dto.setNumber(group.getNumber());
        dto.setStudents(group.getStudents());

        return dto;
    }
}
