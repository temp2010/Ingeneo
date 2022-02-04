package co.ingeneo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.ingeneo.dao.SeaportDao;
import co.ingeneo.model.Seaport;

@RestController
@RequestMapping("/seaport")
public class SeaportController {

	@Autowired
	SeaportDao seaportDao;

	@GetMapping("/")
	public ResponseEntity<List<Seaport>> getSeaports() {

		List<Seaport> seaport = new ArrayList<>();

		try {
			seaportDao.findAll().forEach(seaport::add);

			if (seaport.isEmpty()) {

				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(seaport, HttpStatus.OK);
		} catch (Exception e) {

			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
