package gr.aueb.cf.schoolappspringcf3.Service;

import gr.aueb.cf.schoolappspringcf3.DTO.UserDTO;
import gr.aueb.cf.schoolappspringcf3.model.User;
import gr.aueb.cf.schoolappspringcf3.Service.Exceptions.EntityNotFoundException;

public interface IUserService {
    User registerUser(UserDTO userToRegister);
    User updateUser(UserDTO userDTO) throws EntityNotFoundException;
    void deleteUser(Long id) throws EntityNotFoundException;
    User getUserByUsername(String username) throws EntityNotFoundException;
    User getUserById(Long id) throws EntityNotFoundException;
    boolean usernameAlreadyExists(String email);
}
