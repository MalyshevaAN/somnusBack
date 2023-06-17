package nastia.demoAuthorization.service;

import nastia.demoAuthorization.model.User;

public interface UserService {
    void save(User user);

    User findByEmail(String email);
}
