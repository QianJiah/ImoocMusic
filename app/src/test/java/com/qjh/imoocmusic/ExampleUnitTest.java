package com.qjh.imoocmusic;

import com.qjh.imoocmusic.entities.A;
import com.qjh.imoocmusic.entities.B;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {

        assertEquals(4, 2 + 2);
    }

    @Test
    public void main(){
        A a = new B();
        a.print();
    }
}