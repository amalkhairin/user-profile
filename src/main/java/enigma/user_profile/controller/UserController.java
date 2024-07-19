package enigma.user_profile.controller;

import enigma.user_profile.model.User;
import enigma.user_profile.service.UserService;
import enigma.user_profile.service.impl.PdfGenerateService;
import enigma.user_profile.service.impl.UserServiceImpl;
import enigma.user_profile.utils.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final PdfGenerateService pdfGenerateService;

    @PostMapping
    public User create(UserDTO req) {
//        req.setProfilePicture(file);
        return userService.create(req);
    }

    @GetMapping
    public List<User>  getAll() {
        return userService.getAll();
    }

    @PutMapping("/update_image/{id}")
    public User updateProfilePicture(@PathVariable Long id, UserDTO userDTO) {
        return userService.updateProfilePicture(userDTO.getProfilePicture(), id);
    }

    @GetMapping("/getPicturePdf/{id}")
    public ResponseEntity<ByteArrayResource> getPdfFromUserId(@PathVariable Long id) {
        ByteArrayResource pdf = pdfGenerateService.getPdfFromUserId(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=image_" + id + ".pdf")
                .contentLength(pdf.contentLength())
                .body(pdf);
    }
}
