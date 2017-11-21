package edu.hm.cs.cnj.cnjbackend.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VeranstaltungRepository extends JpaRepository<Veranstaltung, Long> {
	
}