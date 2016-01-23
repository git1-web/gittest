
package org.testgit.gittest.git;

import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class HelloTest {
    
    private Hello hello;
    private PrintStream oldOut;
    
    @Before
    public void setUp() {
       hello = new Hello();
       PrintStream newOut = Mockito.mock(PrintStream.class);
       oldOut = System.out;
       System.setOut(newOut);
    }
    
    @After
    public void tearDown() {
        System.setOut(oldOut);
    }
    
    @Test
    public void testHello() {
        hello.hello();
        verify(System.out).println("Hello world!");
    }
}
