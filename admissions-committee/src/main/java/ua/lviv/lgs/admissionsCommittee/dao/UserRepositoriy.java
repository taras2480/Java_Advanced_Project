package ua.lviv.lgs.admissionsCommittee.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.lviv.lgs.admissionsCommittee.domain.User;

@Repository
public interface UserRepositoriy extends JpaRepository<User, Integer> {

	List<User> findByEmail(String email);

}
