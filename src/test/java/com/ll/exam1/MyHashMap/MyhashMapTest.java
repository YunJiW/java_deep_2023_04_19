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

}