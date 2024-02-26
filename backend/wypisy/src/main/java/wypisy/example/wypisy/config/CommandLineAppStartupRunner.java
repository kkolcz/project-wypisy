package wypisy.example.wypisy.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import wypisy.example.wypisy.enums.AppUserRole;
import wypisy.example.wypisy.model.AppUser;
import wypisy.example.wypisy.repository.AppUserRepository;

import static wypisy.example.wypisy.enums.AppUserRole.ADMIN;


@Component
@RequiredArgsConstructor
public class CommandLineAppStartupRunner implements CommandLineRunner {

    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        AppUser admin = AppUser.builder()
                .name("Admin")
                .username("Admin")
                .email("admin@gmail.com")
                .password(passwordEncoder.encode("pass123"))
                .appUserRole(ADMIN)
                .locked(false)
                .enabled(true)
                .build();

        appUserRepository.save(admin);

    }
}
