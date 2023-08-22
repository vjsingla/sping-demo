package app.domain.controller;

import app.domain.entity.State;
import app.infrastructure.database.StateRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class StateController {
	@Resource
	private StateRepository stateRepository;

	@GetMapping(path="/states")
	public @ResponseBody Iterable<State> getAll() {
		return stateRepository.findAll();
	}
}