package test;
/**
 * This program is to test the whole project
 * @author Andrew
 * @version 2020-04-08
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import stl.*;

class SolidTest {
    Vertex testVer = new Vertex(0,1,2);
    /**
     * @Test failure test. this is a test set up to fail should the vertexes not
     *       match anything. Since Solid blank was never used, it will always fail.
     */
    @Test
    public void testInvalid() {
        Solid testFail = new Solid();
        Solid testSolid = new Solid();

        assertFalse(testFail.addFacet());
        assertFalse(testFail.addFacet(testVer));
        assertFalse(testFail.addFacet(testVer, testVer));
        assertEquals(testSolid.toString(), testFail.toString());
    }
    /**
     * @Test success on 3 test. This is a test set up to only succeed if the vertex
     *       has exactly 3 vertices.
     */
    @Test
    public void test3vertices() {
        Solid testPass = new Solid();
        Solid testSolid2 = new Solid();

        assertTrue(testPass.addFacet(testVer, testVer, testVer));
        assertTrue(testSolid2.addFacet(new Facet(testVer, testVer, testVer)));
        assertEquals(testSolid2.toString(), testPass.toString());

    }
    /**
     * @Test success on test for 4 vertices. This is a test set up to succeed if
     *       there are at least 4 vertices.
     */
    @Test
    public void test4vertices() {
        Solid testPass2 = new Solid();
        Solid testSolid3 = new Solid();

        assertTrue(testPass2.addFacet(testVer, testVer, testVer, testVer));
        assertTrue(testSolid3.addFacet(new Facet(testVer, testVer, testVer)));
        assertTrue(testSolid3.addFacet(new Facet(testVer, testVer, testVer)));
        assertEquals(testSolid3.toString(), testPass2.toString());
    }
    /**
     * @Test success on test for 9 vertices. This is a test set up to succeed if
     *       there are 9 vertices. It compares it's vertices to 7 other sets of 3
     *       vertices.
     */
    @Test
    public void test9vertices() {
        Solid testPass3 = new Solid();
        Solid testSolid4 = new Solid();

        assertTrue(testPass3.addFacet(testVer, (testVer), (testVer),(testVer), (testVer), (testVer), (testVer), (testVer), (testVer)));
        assertTrue(testSolid4.addFacet(new Facet(testVer, testVer, testVer)));
        assertTrue(testSolid4.addFacet(new Facet(testVer, testVer, testVer)));
        assertTrue(testSolid4.addFacet(new Facet(testVer, testVer, testVer)));
        assertTrue(testSolid4.addFacet(new Facet(testVer, testVer, testVer)));
        assertTrue(testSolid4.addFacet(new Facet(testVer, testVer, testVer)));
        assertTrue(testSolid4.addFacet(new Facet(testVer, testVer, testVer)));
        assertTrue(testSolid4.addFacet(new Facet(testVer, testVer, testVer)));
        assertEquals(testSolid4.toString(), testPass3.toString());

    }
}