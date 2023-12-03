package hudson.plugins.summary_report.report;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 *
 * @author br80
 */
public class FieldTest {

    public FieldTest() {}

    /**
     * Test of Status methods, of class Field.
     */
    @Test
    public void testStatus() {
        String expResult = "fieldTest";
        Field instance = new Field();

        // Test of getter
        // In default value, status of new instance of Field is field
        assertEquals("field", instance.getStatus());

        instance.setStatus(expResult);

        // Test of setter
        assertEquals(expResult, instance.getStatus());
    }

    /**
     * Test of FieldName methods, of class Field.
     */
    @Test
    public void testFieldName() {
        String expResult = "FieldName";
        Field instance = new Field();

        // Test of getter
        assertEquals(null, instance.getFieldName());

        instance.setFieldName(expResult);

        // Test of setter
        assertEquals(expResult, instance.getFieldName());
    }

    /**
     * Test of FieldValue methods, of class Field.
     */
    @Test
    public void testFieldValue() {
        String expResult = "FieldValue";
        Field instance = new Field();

        // Test of getter
        assertEquals(null, instance.getFieldValue());

        instance.setFieldValue(expResult);

        // Test of setter
        assertEquals(expResult, instance.getFieldValue());
    }

    /**
     * Test of Cdata methods, of class Field.
     */
    @Test
    public void testCdata() {
        String expResult = "Cdata";
        Field instance = new Field();

        // Test of getter
        assertEquals(null, instance.getCdata());

        instance.setCdata(expResult);

        // Test of setter
        assertEquals(expResult, instance.getCdata());
    }

    /**
     * Test of Href methods, of class Field.
     */
    @Test
    public void testHref() {
        String expResult = "Href";
        Field instance = new Field();

        // Test of getter
        assertEquals(null, instance.getHref());

        instance.setHref(expResult);

        // Test of setter
        assertEquals(expResult, instance.getHref());
    }
}
