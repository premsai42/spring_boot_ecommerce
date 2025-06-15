package com.prem.demo.serivce;

import com.prem.demo.model.Users;
import com.prem.demo.repo.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    @Autowired
    private MyUserDetails mud;
    @Autowired
    private BCryptPasswordEncoder encoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtToken jwtToken;
    public Users register(Users us)
    {
        us.setPassword(encoder.encode(us.getPassword()));
        return mud.save(us);
    }

    public String verify(Users us) {
        Authentication authentication=authenticationManager.authenticate(new
          UsernamePasswordAuthenticationToken(us.getUsername(),us.getPassword()));
        if (authentication.isAuthenticated())
        {
            return jwtToken.generateToken(us.getUsername());
        }
        return "failed";
    }
}
