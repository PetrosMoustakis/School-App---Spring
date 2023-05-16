package gr.aueb.cf.schoolappspringcf3.Service;

import gr.aueb.cf.schoolappspringcf3.DTO.UserDTO;
import gr.aueb.cf.schoolappspringcf3.model.User;
import gr.aueb.cf.schoolappspringcf3.Service.Exceptions.EntityNotFoundException;
import gr.aueb.cf.schoolappspringcf3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;
    @Autowired
    public UserServiceImpl (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public User registerUser(UserDTO userToRegister) {
        return userRepository.save(convertToUser(userToRegister));
    }

    @Transactional
    @Override
    public User updateUser(UserDTO userDTO) throws EntityNotFoundException {
        User user = userRepository.findByUsernameEquals(userDTO.getUsername());
        if (user == null) throw new EntityNotFoundException(User.class, userDTO.getId());
        return userRepository.save(convertToUser(userDTO));
    }
    @Transactional
    @Override
    public void deleteUser(Long id) throws EntityNotFoundException {
        userRepository.deleteById(id);
    }

    @Override
    public User getUserByUsername(String username) throws EntityNotFoundException {
        User user = userRepository.findByUsernameEquals(username);
        if (user == null) throw new EntityNotFoundException(User.class, 0L);
        return user;
    }
    @Override
    public User getUserById(Long id) throws EntityNotFoundException {
        Optional<User> users;
        users = userRepository.findById(id);
        if (users.isEmpty()) throw new EntityNotFoundException(User.class,0L);
        return users.get();
    }

    @Override
    public boolean usernameAlreadyExists(String email) {
        return userRepository.usernameExists(email);
    }

    private static User convertToUser(UserDTO dto) {
        return new User(dto.getId(), dto.getUsername(), dto.getPassword());
    }
}
