package com.example.zadHibernate123.myWork;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ChatRoomRepositoryTest {

    @Autowired
    private ChatRoomRepository chatRoomRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testWhen() {
        //given
        List<ChatRoom> chatList = chatRoomRepository.findAll();
        assertEquals(3, chatList.size());
        //when
        List<User> users =  userRepository.findAll();
        users.get(0).setChatRoom(null);
        userRepository.save(users.get(0));

        //then
        List<ChatRoom> chatListAfterDel = chatRoomRepository.findAll();
        assertEquals(2, chatListAfterDel.size());
    }
}