package com.mikemopo.workbook.service;

import com.mikemopo.workbook.model.User;
import com.mikemopo.workbook.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;


class UserServiceImplTest {

    @Mock
    private UserRepository userRepository ;
    private AutoCloseable autoCloseable;
    @Autowired
    private UserServiceImpl userSIT;

    @BeforeEach
    void setUp() {
       autoCloseable = MockitoAnnotations.openMocks(this);
        userSIT = new UserServiceImpl(userRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void thisSaveUser() {
        //given
        User user = new User(
                1L,
                "Mr",
                "Test",
                "Case",
                "01/01/1989",
                "Chiremba"
        );
        //when
        userSIT.saveUser(user);
        //then
        ArgumentCaptor<User> userArgumentCaptor =
                ArgumentCaptor.forClass(User.class);
        verify(userRepository).save
                (userArgumentCaptor.capture());
        User capturedUser = userArgumentCaptor.getValue();

        //Assertion
        assertThat(capturedUser).isEqualTo(user);

    }

    @Test
    @Disabled
    void saveUsers() {
    }

    @Test
    void shouldGetsAllUsers() {
        //given
        User user = new User(
                1L,
                "Mr",
                "Test",
                "Case",
                "01/01/1989",
                "Chiremba"
        );
        //when
        when(userRepository.findAll())
                .thenReturn(Stream
                .of(user)
                .collect(Collectors.toList()));
        //Assertion
        assertThat(1).isEqualTo(userSIT.getUsers().size());
    }

    @Test
    void shouldGetUserById() {

        //Given
        User user = new User(
                1L,
                "Mr",
                "Test",
                "Case",
                "01/01/1989",
                "Chiremba"
        );
        //when
        Long id = 1L;
        userSIT.saveUser(user);
        //then
        //doReturn(user).

                when(userRepository.findById(id)).thenReturn(Stream.of(user).collect(doReturn(user)));
        //assertion
        assertThat(1L).isEqualTo(userSIT.getUserById(id));
    }

    @Test
    @Disabled
    void deleteUser() {
    }

    @Test
    @Disabled
    void updateUser() {
    }
}