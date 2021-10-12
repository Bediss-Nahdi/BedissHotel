
package com.bediss.hotel.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bediss.hotel.entities.Admin;
import com.bediss.hotel.repository.AdminRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public UserDetailsImpl loadUserByUsername(String usernameField) throws
            UsernameNotFoundException {
    	
    	Admin admin = adminRepository.findByUsername(usernameField);
        System.out.println(usernameField);
        System.out.println(admin);
        if(admin == null) {
            throw new UsernameNotFoundException("No user named " + usernameField);
        } else {
            return new UserDetailsImpl(admin);
        }
    }


}
