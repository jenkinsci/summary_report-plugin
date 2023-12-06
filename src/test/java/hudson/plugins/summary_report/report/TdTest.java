package hudson.plugins.summary_report.report;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 *
 * @author br80
 */
public class TdTest {

    public TdTest() {}

    /**
     * Test of TdValue methods, of class Td.
     */
    @Test
    public void testTdValue() {
        String expResult = "TdValue";
        Td instance = new Td();

        // Test of getter
        assertEquals(null, instance.getTdValue());

        instance.setTdValue(expResult);

        // Test of setter
        assertEquals(expResult, instance.getTdValue());
    }

    /**
     * Test of BgColor methods, of class Td.
     */
    @Test
    public void testBgColor() {
        String expResult = "BgColor";
        Td instance = new Td();

        // Test of getter
        assertEquals(null, instance.getBgColor());

        instance.setBgColor(expResult);

        // Test of setter
        assertEquals(expResult, instance.getBgColor());
    }

    /**
     * Test of FontColor methods, of class Td.
     */
    @Test
    public void testFontColor() {
        String expResult = "FontColor";
        Td instance = new Td();

        // Test of getter
        assertEquals(null, instance.getFontColor());

        instance.setFontColor(expResult);

        // Test of setter
        assertEquals(expResult, instance.getFontColor());
    }

    /**
     * Test of FontAttribute methods, of class Td.
     */
    @Test
    public void testFontAttribute() {
        String expResult = "FontAttribute";
        Td instance = new Td();

        // Test of getter
        assertEquals(null, instance.getFontAttribute());

        instance.setFontAttribute(expResult);

        // Test of setter
        assertEquals(expResult, instance.getFontAttribute());
    }

    /**
     * Test of Href methods, of class Td.
     */
    @Test
    public void testHref() {
        String expResult = "Href";
        Td instance = new Td();

        // Test of getter
        assertEquals(null, instance.getHref());

        instance.setHref(expResult);

        // Test of setter
        assertEquals(expResult, instance.getHref());
    }

    /**
     * Test of Width methods, of class Td.
     */
    @Test
    public void testWidth() {
        String expResult = "widthTest";
        Td instance = new Td();

        // Test of getter
        // In default value, width of new instance of Td is 100
        assertEquals("100", instance.getWidth());

        instance.setWidth(expResult);

        // Test of setter
        assertEquals(expResult, instance.getWidth());
    }

    /**
     * Test of Align methods, of class Td.
     */
    @Test
    public void testAlign() {
        String expResult = "alignTest";
        Td instance = new Td();

        // Test of getter
        // In default value, align of new instance of Td is left
        assertEquals("left", instance.getAlign());

        instance.setAlign(expResult);

        // Test of setter
        assertEquals(expResult, instance.getAlign());
    }

    /**
     * Test of Cdata methods, of class Td.
     */
    @Test
    public void testCdata() {
        String expResult = "Cdata";
        Td instance = new Td();

        // Test of getter
        assertEquals(null, instance.getCdata());

        instance.setCdata(expResult);

        // Test of setter
        assertEquals(expResult, instance.getCdata());
    }
}
