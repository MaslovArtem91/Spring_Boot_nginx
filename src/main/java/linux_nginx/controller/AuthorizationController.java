package linux_nginx.controller;

import linux_nginx.model.Authorities;
import linux_nginx.model.User;
import linux_nginx.service.AuthorizationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AuthorizationController {

    private final AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid User user) {
        System.out.format("[User: %s, password: %s] ", user.getName(), user.getPassword());
        return service.getAuthorities(user);
    }
}
