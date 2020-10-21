package ajax.service;

import ajax.model.Student;
import ajax.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentService implements IStudentService {
    @Autowired
    private StudentsRepository studentsRepository;
    @Override
    public Iterable<Student> findAll() {
        return studentsRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return studentsRepository.findOne(id);
    }

    @Override
    public void update(Student model) {

    }

    @Override
    public void save(Student model) {
        studentsRepository.save(model);


    }

    @Override
    public void remove(Long id) {
        studentsRepository.delete(id);

    }

    @Override
    public Student findByName(String name) {
        return studentsRepository.findByName(name);
    }
}
