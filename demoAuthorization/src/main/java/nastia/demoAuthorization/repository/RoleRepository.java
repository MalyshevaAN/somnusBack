package nastia.demoAuthorization.repository;


import nastia.demoAuthorization.model.Role;
import nastia.demoAuthorization.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
