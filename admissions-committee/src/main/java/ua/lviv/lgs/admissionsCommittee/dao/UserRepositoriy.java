package ua.lviv.lgs.admissionsCommittee.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.lviv.lgs.admissionsCommittee.domain.User;

public interface UserRepositoriy extends JpaRepository<User, Integer> {

	List<User> findByEmail(String email);

}
