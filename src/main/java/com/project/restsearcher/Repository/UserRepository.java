package com.project.restsearcher.Repository;

import com.project.restsearcher.Model.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component("UserRepository")
public interface UserRepository extends JpaRepository<User, Long> {
    User findAccountCredentialsByUsername(String s);
    User findOneByUsername(String s);
}
