package ua.lviv.lgs.admissionsCommittee.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.lviv.lgs.admissionsCommittee.domain.Notability;

@Repository
public interface NotabilityRepository extends JpaRepository<Notability, Integer> {

}
