package ua.malysh.service;

import ua.malysh.domain.User;

public interface UserService {
    User findByUsername(String username);
}
