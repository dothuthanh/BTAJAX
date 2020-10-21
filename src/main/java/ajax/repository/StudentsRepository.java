package ajax.repository;

import ajax.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentsRepository extends CrudRepository<Student,Long> {
    Student findByName(String name);

}
