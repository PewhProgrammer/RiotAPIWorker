package test;

import com.example.test.Domain;
import junit.framework.TestCase;

/**
 * Created by Thinh on 17.06.2016.
 */
public class TestFieldTest extends TestCase {

    private int n ;
    @Override
    protected void setUp() throws Exception {
        this.n = 2 ;
    }

    public void testMult(){
        assertEquals(6, Domain.mult(this.n, 3));
        this.n += 1 ;
    }

    public void testMult2(){
        assertEquals(-6, Domain.mult(this.n, -3));
        this.n += 1 ;

    }
}