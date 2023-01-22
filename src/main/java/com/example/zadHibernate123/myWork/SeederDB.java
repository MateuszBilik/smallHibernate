//package com.example.zadHibernate123.myWork;
//
//import jakarta.persistence.Column;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Configuration
//public class SeederDB {
//
//    private ChatRoomRepository chatRoomRepository;
//
//    public SeederDB(ChatRoomRepository chatRoomRepository) {
//        this.chatRoomRepository = chatRoomRepository;
//    }
//
//    @Bean
//    CommandLineRunner createUsersAndChats(){
//        return args -> {
//            User userMat = new User(null, "Mateusz", 20L, "MAT", Sex.MALE, null);
//            User userMich = new User(null, "Michal", 30L, "Kolo", Sex.MALE, null);
//            User userPaw = new User(null, "Pawel", 40L, "P14", Sex.MALE, null);
//
//            ChatRoom chatSchool = new ChatRoom(null, "School", 5L, Type.PRIVATE, null);
//            ChatRoom chatCity = new ChatRoom(null, "City", 1000L, Type.PUBLIC, null);
//            ChatRoom chatWork = new ChatRoom(null, "Work", 50L, Type.PRIVATE, null);
//
//            chatSchool.setUser(userMat);
//            chatCity.setUser(userMich);
//            chatWork.setUser(userPaw);
//
//            chatRoomRepository.saveAll(List.of(chatCity, chatSchool, chatWork));
//        };
//    }
//}
