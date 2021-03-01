package com.example.RaysCourses.Registration;

import com.example.RaysCourses.ApplicationUser.AppUserService;
import com.example.RaysCourses.ApplicationUser.ApplicationUser;
import com.example.RaysCourses.Registration.Token.ConfirmationToken;
import com.example.RaysCourses.Registration.Token.ConfirmationTokenService;
import com.example.RaysCourses.Security.ApplicationUserRole;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final AppUserService appUserService;
    private EmailValidator emailValidator;
    private final ConfirmationTokenService confirmationTokenService;

    public  String register(RegistrationRequest request){

        boolean isValidEmail = emailValidator.test(request.getEmail());
        if(!isValidEmail){
            throw  new IllegalStateException("email not valid");
        }
        return appUserService.signUpUser(
                new ApplicationUser(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getPassword(),
                        ApplicationUserRole.USER
                )
        );
    }

    @Transactional
    public String confirmToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService
                .getToken(token)
                .orElseThrow(() ->
                        new IllegalStateException("token not found"));

        if (confirmationToken.getConfirmedAt() != null) {
            throw new IllegalStateException("email already confirmed");
        }

        LocalDateTime expiredAt = confirmationToken.getExpiresAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("token expired");
        }

        confirmationTokenService.setConfirmedAt(token);
        appUserService.enableAppUser(
                confirmationToken.getApplicationUser().getEmail());
        return "confirmed";
    }


}
