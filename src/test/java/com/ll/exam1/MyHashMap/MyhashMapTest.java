package com.ll.exam1.MyHashMap;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class MyhashMapTest {



    @Test
    @DisplayName("size()")
    void t01(){
        MyhashMap<String,Integer> map = new MyhashMap<>();
        assertThat(map.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("put 구현")
    void t02() {
        MyhashMap<String, Integer> map = new MyhashMap<>();

        assertThat(map.put("철수", 22)).isNull();
        assertThat(map.put("영희", 23)).isNull();

        assertThat(map.size()).isEqualTo(2);

        assertThat(map.put("철수", 25)).isEqualTo(22);
    }

    @Test
    @DisplayName("GET 구현")
    void t03(){
        MyhashMap<String,Integer> map =new MyhashMap<>();

        map.put("철수", 22);
        map.put("영희", 23);

        int age철수  = map.get("철수");
        assertThat(age철수).isEqualTo(22);

    }
    
    @Test
    @DisplayName("Size 구현")
    void t04(){
        MyhashMap<String,Integer> map =new MyhashMap<>();

        map.put("Key1", 1);
        map.put("Key2", 2);
        map.put("Key3", 3);

        assertEquals(3,map.size());
    }

    @Test
    @DisplayName("remove 구현")
    void t05(){
        MyhashMap<String,Integer> map =new MyhashMap<>();

        map.put("Key1", 1);
        map.put("Key2", 2);
        assertEquals(Integer.valueOf(1), map.remove("Key1"));
        assertNull(map.remove("Key3"));
        assertEquals(1, map.size());
    }

}