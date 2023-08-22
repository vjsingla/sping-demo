package app.domain.controller;

import app.domain.entity.Page;
import app.infrastructure.database.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {
	@Autowired
	private PageRepository pageRepository;

	@GetMapping(path="/pages")
	public @ResponseBody Iterable<Page> getAll() {
		return pageRepository.findAll();
	}
	
	@GetMapping(path="/contact-us")
	public String contactUs() {
		return "pages/contact_us";
	}
}