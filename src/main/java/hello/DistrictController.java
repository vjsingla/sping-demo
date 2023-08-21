package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DistrictController {
	@Autowired
	private DistrictRepository districtRepository;

	@GetMapping(path="/districts")
	public @ResponseBody Iterable<District> getAll() {
		return districtRepository.findAll();
	}
}