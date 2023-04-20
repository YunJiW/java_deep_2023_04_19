package com.ll.exam1;

import com.ll.TestUt;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class MyArrayListTest {
    private MyArrayList<String> list;

    @BeforeEach
    void setUp() {
        list = new MyArrayList<>();
    }
    @Test
    @DisplayName("testSize")
    void t1() {
        MyArrayList<String> list = new MyArrayList<>();
        assertThat(list.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("test Add")
    void t2() {
        MyArrayList<String> list = new MyArrayList<>();
        assertTrue(list.add("Element1"));
        assertThat(list.size()).isEqualTo(1);
    }


    @Test
    @DisplayName("test get(1)")
    void t3() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("Element1");
        list.add("Element2");
        assertThat(list.get(0)).isEqualTo("Element1");
        assertThat(list.get(1)).isEqualTo("Element2");
    }

    @Test
    @DisplayName("data의 크기가 자동으로 늘어나야함.")
    void t4() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("Element1");
        list.add("Element2");
        list.add("Element3");

        assertThat(list.size()).isEqualTo(3);
    }


    @Test
    @DisplayName("늘어나는지 자세히 비교")
    void t5() {
        MyArrayList<String> list = new MyArrayList<>();

        String[] data = TestUt.getFieldValue(list, "data", null);
        assertThat(data.length).isEqualTo(2);

        list.add("사과");
        list.add("포도");

        data = TestUt.getFieldValue(list, "data", null);
        assertThat(data.length).isEqualTo(2);

        list.add("당근");

        data = TestUt.getFieldValue(list, "data", null);
        assertThat(data.length).isEqualTo(4);

        assertThat(list.size()).isEqualTo(3);
    }


    @Test
    @DisplayName("리스트에서 사용되는 삭제 기능 구현해보기")
    void testRemove() {
        list.add("Element1");
        list.add("Element2");
        list.add("Element3");
        assertEquals("Element2", list.remove(1));
        assertEquals(2, list.size());
    }

    @Test
    @DisplayName("리스트에서 사용되는 contain 구현")
    void testContains() {
        list.add("Element1");
        list.add("Element2");
        assertTrue(list.contains("Element1"));
        assertFalse(list.contains("Element3"));
    }

    @Test
    @DisplayName("List에서 사용되는 indexOf 구현")
    void testIndexOf() {
        list.add("Element1");
        list.add("Element2");
        list.add("Element1");
        assertEquals(0, list.indexOf("Element1"));
        assertEquals(1, list.indexOf("Element2"));
        assertEquals(-1, list.indexOf("Element3"));
    }

    @Test
    void testClear() {
        list.add("Element1");
        list.add("Element2");
        list.add("Element3");
        list.clear();
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());

        list.add("사과");
        assertEquals(1, list.size());
    }


}
