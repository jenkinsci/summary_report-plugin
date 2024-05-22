package hudson.plugins.summary_report.report;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Test;

/**
 *
 * @author br80
 */
public class SectionTest {

    public SectionTest() {}

    /**
     * Test of SectionName methods, of class Section.
     */
    @Test
    public void testSectionName() {
        String expResult = "SectionName";
        Section instance = new Section();

        // Test of getter
        assertEquals(null, instance.getSectionName());

        instance.setSectionName(expResult);

        // Test of setter
        assertEquals(expResult, instance.getSectionName());
    }

    /**
     * Test of ObjectList methods, of class Section.
     */
    @Test
    public void testObjectList() {

        Object obj1 = new Integer(1);
        Object obj2 = new Integer(2);

        /**************/
        /** Phase 1  **/
        /**************/
        // Creation of empty objectList
        ArrayList<Object> objectList = new ArrayList<Object>();
        // Creation of an instance of Accordion
        Section instance = new Section();

        // Normally at the creation of an instance of Accordion,
        // the objectList is empty
        assertEquals(objectList, instance.getObjectList());

        /**************/
        /** Phase 2  **/
        /**************/
        objectList.add(obj1);

        instance.setObjectList(objectList);

        // Test of setter
        assertEquals(objectList, instance.getObjectList());

        /**************/
        /** Phase 3  **/
        /**************/
        // Creation of empty objectList
        ArrayList<Object> objectList2 = new ArrayList<Object>();
        // Creation of an instance of Accordion
        Section instance2 = new Section();

        instance2.addObject(obj2);
        objectList2.add(obj2);

        // Test of add
        assertEquals(objectList2, instance2.getObjectList());
    }
}
