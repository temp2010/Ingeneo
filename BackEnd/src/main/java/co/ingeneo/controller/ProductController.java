package co.ingeneo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.ingeneo.dao.ProductDao;
import co.ingeneo.model.Product;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductDao productDao;

	@PostMapping("/")
	public ResponseEntity<Product> createTutorial(@RequestBody Product product) {
		try {
			Product newProduct = productDao.save(new Product(product.getType(), product.getName(),
					product.getDeliveryDays(), product.getShippingPrice()));
			return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
