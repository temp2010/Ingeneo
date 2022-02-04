package co.ingeneo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.ingeneo.model.Shipment;

public interface ShipmentDao extends JpaRepository<Shipment, String> {

}
