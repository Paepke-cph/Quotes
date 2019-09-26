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
        Quote q = new Quote(1,null,null);
        int i = q.getID();
        assertEquals(1,i);
    }
}
