package co.ingeneo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.ingeneo.model.Seaport;

public interface SeaportDao extends JpaRepository<Seaport, Integer> {

}
