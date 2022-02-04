package co.ingeneo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.ingeneo.dao.StorageDao;
import co.ingeneo.model.Storage;

@RestController
@RequestMapping("/storage")
public class StorageController {

	@Autowired
	StorageDao storageDao;

	@GetMapping("/")
	public ResponseEntity<List<Storage>> getStorages() {

		List<Storage> storage = new ArrayList<>();

		try {
			storageDao.findAll().forEach(storage::add);

			if (storage.isEmpty()) {

				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(storage, HttpStatus.OK);
		} catch (Exception e) {

			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
