package wypisy.example.wypisy.services;


import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import wypisy.example.wypisy.model.AuthenticationRequest;
import wypisy.example.wypisy.model.AuthenticationResponse;
import wypisy.example.wypisy.repository.AppUserRepository;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AppUserRepository appUserRepository;
    private final JWTService  jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse authenticate(AuthenticationRequest request){

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var user = appUserRepository.findByEmail(request.getEmail())
                .orElseThrow(); //todo Add good exception

        var jwtToekn = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToekn)
                .build();
    }



}
