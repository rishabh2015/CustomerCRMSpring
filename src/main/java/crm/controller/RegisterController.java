package crm.controller;

import crm.entity.User;
import crm.service.UserService;
import crm.entity.UserDetail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/")
public class RegisterController {
	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
    private UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping("/register")
//    public String showRegistrationPage(Model model){
//    	logger.debug("checking if this debugs successfully");
//        return "register";
//    }	

   @PostMapping(value = "/registerUser", consumes= MediaType.APPLICATION_JSON_VALUE)
   public  String processRegistrationForm(Model model, @RequestBody String username,  BindingResult bindingResult) {
       logger.debug(username);
       Gson g = new Gson();
       logger.debug("checkpoint1");
       UserDetail u = g.fromJson(username,UserDetail.class);
       
       User userFromDB = userService.findByUsername(u.getUsername());

        if (userFromDB != null) {
            model.addAttribute("alreadyRegisteredMessage",
                    "Oops!  There is already a user registered with the email provided.");
            bindingResult.reject("email");
            return "register";
        }

        if (bindingResult.hasErrors()) {
            return "redirect:/register";
        } else {
        	User user = new User();
        	user.setUsername(u.getUsername());
        	user.setPassword(u.getPassword());
        	user.setEmail(u.getEmail());
        	user.setFirstName(u.getFirstName());
        	user.setLastName(u.getLastName());
            userService.saveUser(user);
            return "success";
        }
    }

}
