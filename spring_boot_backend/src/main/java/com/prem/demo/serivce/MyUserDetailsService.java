package com.prem.demo.serivce;

import com.prem.demo.model.UserPrinciple;
import com.prem.demo.model.Users;
import com.prem.demo.repo.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
@Autowired
MyUserDetails myUserDetails;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Users user=myUserDetails.findByUsername(username);
       if(user==null)
       {
           System.out.println("user not found");
           throw new UsernameNotFoundException("user not found");
       }
        return new UserPrinciple(user);
    }
}
