package kabbadi.service;

import kabbadi.domain.User;
import kabbadi.domain.db.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private GenericRepository<User> userRepository;

    @Deprecated
    public UserService() {}

    @Autowired
    public UserService(@Qualifier("userRepository") GenericRepository<User> userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User getUser(String userName) {
        return userRepository.findBy(User.NAME_PROPERTY, userName);
    }

}
