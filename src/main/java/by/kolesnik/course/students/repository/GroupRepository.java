package by.kolesnik.course.students.repository;

import by.kolesnik.course.students.entity.Group;
import by.kolesnik.course.students.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

    Optional<Group> findByNumber(Integer number);
}
