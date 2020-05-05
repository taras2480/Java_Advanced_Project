package ua.lviv.lgs.admissionsCommittee.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.lviv.lgs.admissionsCommittee.domain.Faculty;


@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Integer> {

}
