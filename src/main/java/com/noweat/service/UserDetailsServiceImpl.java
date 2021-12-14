package com.noweat.service;

import com.noweat.model.QUserDetailsEntity;
import com.noweat.model.UserEntity;
import com.noweat.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository repository;
    private final QUserDetailsEntity qEntity = QUserDetailsEntity.userDetailsEntity;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> user = repository.findOne(qEntity.username.eq(username));

        user.orElseThrow(() -> new UsernameNotFoundException(String.format("Username %s not found", username)));

        return user.get();
    }
}
