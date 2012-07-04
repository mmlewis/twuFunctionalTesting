package kabbadi.controller;

import kabbadi.domain.User;
import kabbadi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	private UserService userService;

	@Autowired
	public HomeController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView homepage(@RequestParam(value = "username", defaultValue = "") String username) {
		ModelAndView modelAndView = new ModelAndView("home");
        if (!username.isEmpty()) {
            User user = userService.getUser(username);
            modelAndView.addObject("user", user)
                        .addObject("username", username);
        }
        return modelAndView;
	}
}
