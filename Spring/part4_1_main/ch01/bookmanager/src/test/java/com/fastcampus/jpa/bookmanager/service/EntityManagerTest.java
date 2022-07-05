package com.fastcampus.jpa.bookmanager.service;

import com.fastcampus.jpa.bookmanager.domain.User;
import com.fastcampus.jpa.bookmanager.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@SpringBootTest
@Transactional
public class EntityManagerTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private UserRepository userRepository;
    @Test
    void entityManagerTest(){
        System.out.println(entityManager.createQuery("select u from User u").getResultList());
    }

    @Test
    void cacheFindTest(){
        System.out.println(userRepository.findByEmail("martin@fastcampus.com"));
        System.out.println(userRepository.findByEmail("martin@fastcampus.com"));
        System.out.println(userRepository.findByEmail("martin@fastcampus.com"));
        System.out.println(userRepository.findById(2L).get());
        System.out.println(userRepository.findById(2L).get());
        System.out.println(userRepository.findById(2L).get());

        userRepository.deleteById(1L);
    }

    @Test
    void cacheFindTest2(){
        User user = userRepository.findById(1L).get();
        user.setName("marrrrrtin");

        userRepository.save(user);

        System.out.println("------------------------------");

        user.setEmail("marrrrrrrrtin@fastcampus.com");

        userRepository.save(user);

        //이상하게 2번째 없데이트 일어나기 전에 이름과 이메일이 업데이트 된 값이 출력됨.하지만 실제로 DB에는 반영되지 않
        System.out.println(">>>> 1 : "+userRepository.findById(1L).get());

        userRepository.flush();

        System.out.println(">>>> 1 : "+userRepository.findById(1L).get());

    }
}
