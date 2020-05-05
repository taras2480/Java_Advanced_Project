package ua.lviv.lgs.admissionsCommittee.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.lviv.lgs.admissionsCommittee.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByEmail(String email);

}
