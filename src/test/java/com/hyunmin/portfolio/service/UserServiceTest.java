package com.hyunmin.portfolio.service;

import com.hyunmin.portfolio.domain.User;
import com.hyunmin.portfolio.exception.UserNotFoundException;
import com.hyunmin.portfolio.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest{
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void 유저_추가_성공(){
        // given
        User user = new User("현민");
        when(userRepository.save(any(User.class))).thenReturn(user);

        User result = userService.addUser("현민");

        assertThat(result.getName()).isEqualTo("현민");
    }

    @Test
    void 없는_유저_삭제시_예외발생(){
        when(userRepository.existsById(9999L)).thenReturn(false);

        assertThatThrownBy(() -> userService.deleteUser(9999L)).isInstanceOf(UserNotFoundException.class);

    }
}
