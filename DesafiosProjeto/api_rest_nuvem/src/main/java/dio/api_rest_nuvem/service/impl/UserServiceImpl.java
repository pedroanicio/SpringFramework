package dio.api_rest_nuvem.service.impl;

import dio.api_rest_nuvem.model.User;
import dio.api_rest_nuvem.repository.UserRepository;
import dio.api_rest_nuvem.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User user) {
        if (userRepository.existsByAccountNumber(user.getAccount().getNumber())){
            throw new IllegalArgumentException("This account number already exists.");
        }

        return userRepository.save(user);
    }
}
