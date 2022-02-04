package co.ingeneo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.ingeneo.model.Truck;

public interface TruckDao extends JpaRepository<Truck, String> {

}
