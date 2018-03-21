package mining.controllers;

import io.swagger.annotations.ApiOperation;
import mining.model.User;
import mining.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("${api.root}")
@CrossOrigin(origins = "${origins}")
public class UserControllers {

    public static final int CLEAR_COOKIE_AGE = 0;
    public static final int CREATE_COOKIE_AGE = 256 * 24 * 60 * 60;

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    @ApiOperation(value = "registration attempt", notes = "Temporary register service")
    public ResponseEntity<User> registrationUser(@RequestBody User user) throws Exception {
        User user1 = userService.registrationUser(user);
        return new ResponseEntity<>(user1, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/login")
    @ApiOperation(value = "login attempt", notes = "Temporary login service")
    public ResponseEntity<Cookie> loginUser(@PathVariable String email,@PathVariable String password) throws Exception {
        User user1 = userService.loginUser(email, password);
        Cookie cookie = createCookie(user1);
        return new ResponseEntity<Cookie>(cookie, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/logout")
    @ApiOperation(value = "logout", notes = "Temporary logout service")
    public ResponseEntity logout(HttpServletResponse response, HttpServletRequest request) {
        clearCookie(request, response);
        return new ResponseEntity(HttpStatus.OK);
    }

    private Cookie createCookie(User user) {
        Cookie cookie = new Cookie("name", user.getFirstName());
        cookie.setMaxAge(CREATE_COOKIE_AGE);
        cookie.setPath("/");
        return cookie;
    }

    //TODO the esc of the site
    private void clearCookie(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if (request.isRequestedSessionIdValid() && session != null) {
            session.invalidate();
        }
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            cookie.setMaxAge(CLEAR_COOKIE_AGE);
            cookie.setValue(null);
            cookie.setPath("/");
            response.addCookie(cookie);
        }
    }
}
