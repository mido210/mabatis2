package com.example.mybatis2;

import com.example.mybatis2.memo.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.transaction.annotation.*;

import java.time.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MemoDaoTest {
    @Autowired
    private MemoDao memoDao;

    //@Test
    public void saveTest() {
        Memo m = Memo.builder().title("토익점수").content("토익 점수 확인").writer("spring").build();
        int result = memoDao.save(m);
        assertEquals(1, result);
    }

    //@Test
    public void findAllTest() {
        assertEquals(1, memoDao.findAll().size());
    }

    //@Test
    public void findByMno() {
        Optional<Memo> result = memoDao.findByMno(1);
        // Optional을 전달받으면 get()으로 객체를 꺼낼 수 있다
        // 단 없으면  NosuchElementException발생
        // Memo momo = result.get();
        if(result.isPresent()){
            Memo memo = result.get();
        }
    }


    //@Test
    public void updateTest() {
        int result = memoDao.update("토익점수 확인했니", 1);
        assertEquals(1, result);
        result = memoDao.update("토익점수 확인했니", 100);
        assertEquals(0, result);
    }

//    @Transactional
//    @Test
    public void deleteTest() {
        int result = memoDao.delete(1);
        assertEquals(1, result);
        result = memoDao.delete(100);
        assertEquals(0, result);
    }
}
