package mining.controllers;

import mining.model.User;
import mining.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/user")
public class UserControllers {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public ResponseEntity<User> registrationUser(User user) throws Exception {
        User user1 = userService.registrationUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
