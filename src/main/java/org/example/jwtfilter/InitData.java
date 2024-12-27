package org.example.jwtfilter;

import jakarta.annotation.PostConstruct;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.jwtfilter.common.entity.User;
import org.example.jwtfilter.common.enums.UserRoleEnum;
import org.example.jwtfilter.common.utils.PasswordEncoder;
import org.example.jwtfilter.user.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class InitData {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    @PostConstruct
    @Transactional
    public void init() {
        List<User> productList =
            List.of(new User("김동현",passwordEncoder.encode("1234"),"user1@sparta.com", UserRoleEnum.ADMIN),
                new User("아이유",passwordEncoder.encode("1234"),"user2@sparta.com",UserRoleEnum.USER),
                new User("태연",passwordEncoder.encode("1234"),"user3@sparta.com",UserRoleEnum.ADMIN));
        for (User product : productList) {
            userService.save(product);
        }
    }
}
