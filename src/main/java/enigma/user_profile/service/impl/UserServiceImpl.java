package enigma.user_profile.service.impl;

import enigma.user_profile.model.User;
import enigma.user_profile.repository.UserRepository;
import enigma.user_profile.service.CloudinaryService;
import enigma.user_profile.service.UserService;
import enigma.user_profile.utils.UserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final CloudinaryService cloudinaryService;
    private final UserRepository userRepository;


    @Override
    public User create(UserDTO req) {
        User user = User.builder()
                .name(req.getName())
                .email(req.getEmail())
                .build();
        String url = cloudinaryService.uploadFile(req.getProfilePicture(), "user_profile");
        user.setProfilePicture(url);

        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return List.of();
    }

    @Override
    public User updateProfilePicture(MultipartFile file) {
        return null;
    }

    @Override
    public User getById(Long id) {
        return null;
    }

    @Override
    public User update(Long id, UserDTO req) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
