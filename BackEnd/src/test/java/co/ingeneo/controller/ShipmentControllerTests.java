package co.ingeneo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import co.ingeneo.model.Product;

@SpringBootTest
class ShipmentControllerTests {

	ShipmentController shipmentController = new ShipmentController();

	@Test
	void testGenerateGuideNumber() {

		assertEquals(shipmentController.generateGuideNumber().length(), 10);
	}

	@Test
	void testgetDeliveryDate() {

		Date currentDate = new Date();
		Product product = new Product();
		product.setDeliveryDays(5);

		assertEquals(shipmentController.getDeliveryDate(product), currentDate);
	}

	@Test
	void testGetPrice() {

		Float price = (float) 5000;
		Integer quantity = 100;
		Product product = new Product();
		product.setShippingPrice(price);

		assertEquals(shipmentController.getPrice(product, quantity), price * quantity);
	}

	@Test
	void testGetDiscountGround() {

		Float price = (float) 5000;
		Integer quantity = 100;

		assertEquals(shipmentController.getDiscount(price, quantity, "ground"), price * 5 / 100);
	}

	@Test
	void testGetDiscountmMaritime() {

		Float price = (float) 5000;
		Integer quantity = 100;

		assertEquals(shipmentController.getDiscount(price, quantity, "maritime"), price * 3 / 100);
	}

}
