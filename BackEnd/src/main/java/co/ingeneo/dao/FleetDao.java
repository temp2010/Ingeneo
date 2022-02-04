package co.ingeneo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.ingeneo.model.Fleet;

public interface FleetDao extends JpaRepository<Fleet, String> {

}
