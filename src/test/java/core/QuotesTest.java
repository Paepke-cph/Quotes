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
    public void testConstructor() {
        Quote q = new Quote(1,"T","TT");
        int i = q.getID();
        String author = q.getAuthor();
        String text = q.getText();
        assertEquals(1,i);
        assertEquals("T",author);
        assertEquals("TT",text);
        assertEquals("T: TT", q.toString());
    }
}
