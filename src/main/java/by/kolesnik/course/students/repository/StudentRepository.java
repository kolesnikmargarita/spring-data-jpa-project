package by.kolesnik.course.students.repository;

import by.kolesnik.course.students.entity.Group;
import by.kolesnik.course.students.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByPaymentFalse();

    List<Student> findAllByName(String name);

    List<Student> findAllByLastName(String lastName);

    List<Student> findAllByGroup(Group group);
}
