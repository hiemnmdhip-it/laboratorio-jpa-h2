package org.zabalburu.laboratorio_jpa_h2.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zabalburu.laboratorio_jpa_h2.repository.ItemPromptRepository;


@Controller
public class ItemPromptController {
	
	private final ItemPromptRepository repository;
	
	public ItemPromptController(ItemPromptRepository repository) {
		this.repository = repository;
	}

	
	@GetMapping
	public String index(Model modelo) {
		return "index";
	}
	
	@PostMapping("/categoria")
	public String verPromptsCategoria(@RequestParam("id") String categoria,
			Model modelo) {
		modelo.addAttribute("prompts", repository.findByCategoriaIgnoreCase(categoria));
		return "prompts";
	}
	

}
