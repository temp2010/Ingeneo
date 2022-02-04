package co.ingeneo.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.ingeneo.dao.FleetDao;
import co.ingeneo.dao.ProductDao;
import co.ingeneo.dao.ShipmentDao;
import co.ingeneo.dao.TruckDao;
import co.ingeneo.model.Fleet;
import co.ingeneo.model.Product;
import co.ingeneo.model.Shipment;
import co.ingeneo.model.Truck;

@RestController
@RequestMapping("/shipment")
@CrossOrigin(origins = "http://localhost:4200")
public class ShipmentController {

	@Autowired
	ShipmentDao shipmentDao;

	@Autowired
	ProductDao productDao;
	
	@Autowired
	TruckDao truckDao;
	
	@Autowired
	FleetDao fleetDao;

	@GetMapping("/")
	public ResponseEntity<List<Shipment>> getShipments() {

		List<Shipment> shipment = new ArrayList<>();

		try {
			shipmentDao.findAll().forEach(shipment::add);

			if (shipment.isEmpty()) {

				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(shipment, HttpStatus.OK);
		} catch (Exception e) {

			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<Shipment> getShipmentById(@PathVariable("id") String id) {

		Optional<Shipment> shipment = shipmentDao.findById(id);

		if (shipment.isPresent()) {
			return new ResponseEntity<>(shipment.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/ground")
	public ResponseEntity<Shipment> createShipmentGround(@RequestBody Shipment shipment) {

		Shipment createShipment = new Shipment();

		try {
			Optional<Truck> truck = truckDao.findById(shipment.getPlate());
			Optional<Product> product = productDao.findById(shipment.getIdProduct());

			if (truck.isPresent() && product.isPresent()) {
				Shipment newShipment = new Shipment(shipment.getIdCustomer(), shipment.getIdProduct(),
						shipment.getPlate(), shipment.getIdStorage(), shipment.getQuantity(), "ground");

				newShipment.setGuideNumber(generateGuideNumber());
				newShipment.setDeliveryDate(getDeliveryDate(product.get()));
				newShipment.setPrice(getPrice(product.get(), shipment.getQuantity()));
				newShipment.setDiscount(getDiscount(newShipment.getPrice(), shipment.getQuantity(), "ground"));
				createShipment = shipmentDao.save(newShipment);

				return new ResponseEntity<>(createShipment, HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {

			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/maritime")
	public ResponseEntity<Shipment> createShipmentMaritime(@RequestBody Shipment shipment) {

		Shipment createShipment = new Shipment();

		try {
			Optional<Fleet> fleet = fleetDao.findById(shipment.getIdFleet());
			Optional<Product> product = productDao.findById(shipment.getIdProduct());

			if (fleet.isPresent() && product.isPresent()) {
				Shipment newShipment = new Shipment(shipment.getIdCustomer(), shipment.getIdProduct(),
						shipment.getIdFleet(), shipment.getIdSeaport(), shipment.getQuantity(), "maritime");

				newShipment.setGuideNumber(generateGuideNumber());
				newShipment.setDeliveryDate(getDeliveryDate(product.get()));
				newShipment.setPrice(getPrice(product.get(), shipment.getQuantity()));
				newShipment.setDiscount(getDiscount(newShipment.getPrice(), shipment.getQuantity(), "maritime"));
				createShipment = shipmentDao.save(newShipment);

				return new ResponseEntity<>(createShipment, HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {

			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	String generateGuideNumber() {

		StringBuilder guideNumber = new StringBuilder();
		String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

		try {
			for (int x = 0; x < 10; x++) {
				int indiceAleatorio = ThreadLocalRandom.current().nextInt(0, characters.length());
				char caracterAleatorio = characters.charAt(indiceAleatorio);
				guideNumber.append(caracterAleatorio);
			}
		} catch (Exception e) {

			return null;
		}

		return guideNumber.toString();

	}

	Date getDeliveryDate(Product product) {

		Date currentDate = new Date();
		Calendar c = Calendar.getInstance();

		try {
			c.setTime(currentDate);
			c.add(Calendar.DATE, product.getDeliveryDays());
		} catch (Exception e) {

			return null;
		}

		return c.getTime();
	}

	Float getPrice(Product product, Integer quantity) {

		Float price = null;

		try {
			price = product.getShippingPrice() * quantity;
		} catch (Exception e) {

			return null;
		}

		return price;
	}

	Float getDiscount(Float price, Integer quantity, String typeShipment) {

		Float discount = null;

		try {
			if (typeShipment.equals("ground") && quantity >= 10)
				discount = price * 5 / 100;
			else if (quantity >= 5) {
				discount = price * 3 / 100;
			}
		} catch (Exception e) {

			return null;
		}

		return discount;
	}

}
