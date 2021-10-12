
package com.bediss.hotel.security;
import com.bediss.hotel.repository.AdminRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private AdminRepository adminRepository;
//
//    @Override
//    public UserDetailsImpl loadUserByUsername(String usernameField) throws
//            UsernameNotFoundException {
//    	
//    	AdminRepository admin = adminRepository.findByUsername(usernameField)
//        System.out.println(usernameField);
//        System.out.println(admin);
//        if(admin == null) {
//            throw new UsernameNotFoundException("No user named " + usernameField);
//        } else {
//            return new UserDetailsImpl(admin);
//        }
//    }

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
