package com.github.hendrikneuschulz.backend.service;

import com.github.hendrikneuschulz.backend.model.MongoUser;
import com.github.hendrikneuschulz.backend.repository.MongoUserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

 class MongoUserServiceTest {

     private final MongoUserRepository userRepository = Mockito.mock(MongoUserRepository.class);
     private final MongoUserDetailsService userDetailsService = new MongoUserDetailsService(userRepository);

     @Test
     void loadUserByUsername_userFound_returnsUserDetails() {
         MongoUser user = new MongoUser("testUser", "password", "USER", "BASIC");

         when(userRepository.findByUsername("testUser")).thenReturn(Optional.of(user));

         UserDetails userDetails = userDetailsService.loadUserByUsername("testUser");

         assertEquals(user.username(), userDetails.getUsername());
         assertEquals(user.password(), userDetails.getPassword());
     }

     @Test
     void loadUserByUsername_userNotFound_throwsException() {
         when(userRepository.findByUsername("nonExistentUser")).thenReturn(Optional.empty());

         assertThrows(UsernameNotFoundException.class, () -> userDetailsService.loadUserByUsername("nonExistentUser"));
     }
 }
