package gr.aueb.cf.schoolappspringcf3.Service;

import gr.aueb.cf.schoolappspringcf3.DTO.TeacherDTO;
import gr.aueb.cf.schoolappspringcf3.model.Teacher;
import gr.aueb.cf.schoolappspringcf3.Service.Exceptions.EntityNotFoundException;

import java.util.List;

public interface ITeacherService {
    Teacher insertTeacher(TeacherDTO teacherDTO);
    Teacher updateTeacher(TeacherDTO teacherDTO) throws EntityNotFoundException;
    void deleteTeacher(Long id) throws EntityNotFoundException;
    List<Teacher> getTeachersByLastname(String lastname) throws EntityNotFoundException;
    Teacher getTeacherById(Long id) throws EntityNotFoundException;
}
