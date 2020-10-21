package ajax.service;

import ajax.model.Student;

public interface IStudentService extends IService<Student> {
    Student findByName(String name);
}
