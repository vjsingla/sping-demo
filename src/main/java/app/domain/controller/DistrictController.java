package app.domain.controller;

import app.domain.entity.District;
import app.infrastructure.database.DistrictRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.Optional;

@RestController
@Tag(name = "District")
public class DistrictController {
	@Autowired
	private DistrictRepository districtRepository;

	@GetMapping(path = "/districts/{id}")
	@Operation(operationId = "getDistrict", description = "Get a single district object")
	public ResponseEntity<District> get(@PathVariable int id) {
		try {
			Optional<District> record = districtRepository.findById(id);
			return record.map(
					district -> new ResponseEntity<>(district, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND)
			);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(path="/districts")
	public ResponseEntity<Iterable<District>> getAll() {
		try {
			return new ResponseEntity<>(districtRepository.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(path="/districts")
	public ResponseEntity<District> create(@Valid @RequestBody District district) {
		try {
			District saved = districtRepository.save(district);
			return new ResponseEntity<>(saved, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping(path = "/districts/{id}")
	public ResponseEntity<Object> delete(@PathVariable int id) {
		try {
			Optional<District> record = districtRepository.findById(id);
			if (!record.isPresent()) {
				return new ResponseEntity<>("entity not found", HttpStatus.NOT_FOUND);
			}

			districtRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}