package com.example.zadHibernate123.myWork;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserRepositoryTest {

    @Autowired
    private ChatRoomRepository chatRoomRepository;
    @Autowired
    private UserRepository userRepository;

    @BeforeAll
    public void createDB(){
        User userMat = new User(null, "Mateusz", 20L, "MAT", Sex.MALE, null);
        User userMich = new User(null, "Michal", 30L, "Kolo", Sex.MALE, null);
        User userPaw = new User(null, "Pawel", 40L, "P14", Sex.MALE, null);

        ChatRoom chatSchool = new ChatRoom(null, "School", 5L, Type.PRIVATE, null);
        ChatRoom chatCity = new ChatRoom(null, "City", 1000L, Type.PUBLIC, null);
        ChatRoom chatWork = new ChatRoom(null, "Work", 50L, Type.PRIVATE, null);

        chatSchool.setUser(userMat);
        chatCity.setUser(userMich);
        chatWork.setUser(userPaw);

        chatRoomRepository.saveAll(List.of(chatCity, chatSchool, chatWork));
    }

    @Test
    public void testWhen() {

        //given
        List<User> userList = userRepository.findAll();
        assertEquals(3, userList.size());
        //when
        List<ChatRoom> chats =  chatRoomRepository.findAll();
        chats.get(0).setUser(null);
        chatRoomRepository.save(chats.get(0));

        //then
        List<User> userListAfterDel = userRepository.findAll();
        assertEquals(2, userListAfterDel.size());
    }

    @Test
    public void testWhen2() {
        //given
        List<User> userList = userRepository.findAll();
        assertEquals(3, userList.size());

        //when
        User userMat = new User(null, "Matesdusz", 20L, "MAT", Sex.MALE, null);
        ChatRoom chatSchool = new ChatRoom(null, "School", 5L, Type.PRIVATE, null);
        chatSchool.setUser(userMat);
        chatRoomRepository.saveAll(List.of(chatSchool));

        //then
        List<User> userListAfterDel = userRepository.findAll();
        assertEquals(4, userListAfterDel.size());
    }

}