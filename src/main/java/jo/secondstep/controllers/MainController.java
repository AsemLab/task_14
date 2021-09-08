package jo.secondstep.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import jo.secondstep.repositories.JobsRepository;

@Controller
@RequestMapping("/hello")
public class MainController {
	@Autowired
	private JobsRepository jobsRepository;

	@RequestMapping(value = "/{lang}/hi", method = RequestMethod.GET)
	public String sayHello(@PathVariable String lang, @RequestParam(defaultValue = "Mr") String first_name,
			@RequestParam(defaultValue = "Nobody") String last_name, ModelMap modelMap) {

		if (lang.toLowerCase().equals("ar"))
			modelMap.addAttribute("lang", "„—Õ»«");
		else if (lang.toLowerCase().equals("de"))
			modelMap.addAttribute("lang", "Welkommen");
		else if (lang.toLowerCase().equals("fr"))
			modelMap.addAttribute("lang", "Bienvenue");
		else
			modelMap.addAttribute("lang", "Welcome");

		modelMap.addAttribute("first_name", first_name);
		modelMap.addAttribute("last_name", last_name);

		return "welcome";
	}

	@GetMapping(path = "/alljobs")
	public String getAllJobs(ModelMap map) {
		map.addAttribute("jobs", jobsRepository.findAll());

		return "alljobs";

	}
}
