package ua.lviv.lgs.admissionsCommittee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.lviv.lgs.admissionsCommittee.domain.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Integer> {

}
