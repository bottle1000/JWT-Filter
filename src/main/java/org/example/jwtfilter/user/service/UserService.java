package org.example.jwtfilter.user.service;

import lombok.RequiredArgsConstructor;
import org.example.jwtfilter.common.entity.User;
import org.example.jwtfilter.common.utils.JwtUtil;
import org.example.jwtfilter.common.utils.PasswordEncoder;
import org.example.jwtfilter.user.model.request.LoginRequest;
import org.example.jwtfilter.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public String login(LoginRequest request) {

        String userName = request.userName();
        String password = request.password();

        User user = userRepository.findByUsername(userName).orElseThrow(
            () -> new IllegalArgumentException("등록된 사용자가 없습니다.")
        );

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        return jwtUtil.generateToken(user.getUsername(), user.getRole());
    }

    // InitDat 저장용 으로 만든 메서드임
    public User save(User user) {
        return userRepository.save(user);
    }
}
