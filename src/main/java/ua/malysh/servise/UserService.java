package ua.malysh.servise;

import ua.malysh.domain.User;

public interface UserService {
    User findByUsername(String username);
}
