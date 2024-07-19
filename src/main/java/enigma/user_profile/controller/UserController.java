package enigma.user_profile.controller;

import enigma.user_profile.model.User;
import enigma.user_profile.service.UserService;
import enigma.user_profile.service.impl.UserServiceImpl;
import enigma.user_profile.utils.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public User create(UserDTO req) {
//        req.setProfilePicture(file);
        return userService.create(req);
    }
}
