package by.kolesnik.course.students.service;

import by.kolesnik.course.students.entity.Group;
import by.kolesnik.course.students.entity.Student;
import by.kolesnik.course.students.exception.EntityNotFoundException;
import by.kolesnik.course.students.repository.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GroupService {

    private final GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    /*public Group findGroupByNumber(Integer number) {
        return groupRepository.findGroupByNumber(number);
    }*/
    public Group findByNumber(Integer number) {
        final Optional<Group> optionalGroup = groupRepository.findByNumber(number);

        if (optionalGroup.isEmpty()) {
            throw new EntityNotFoundException("Группа с номером '" + number + "' не найдена");
        }

        return optionalGroup.get();
    }
}
