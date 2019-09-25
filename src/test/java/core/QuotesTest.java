/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Benjamin
 */
public class QuotesTest {
    
    public QuotesTest() {
    }

    @Test
    public void testSomeMethod() {
        Quotes q = new Quotes(1);
        int i = q.getNumber();
        assertEquals(2,i);
    }
}
