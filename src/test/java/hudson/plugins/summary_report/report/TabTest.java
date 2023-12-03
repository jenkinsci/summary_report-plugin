package hudson.plugins.summary_report.report;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Test;

/**
 *
 * @author br80
 */
public class TabTest {

    public TabTest() {}

    /**
     * Test of Status methods, of class Tab.
     */
    @Test
    public void testStatus() {
        String expResult = "tabTest";
        Tab instance = new Tab();

        // Test of getter
        // In default value, status of new instance of Accordion is accordion
        assertEquals("tab", instance.getStatus());

        instance.setStatus(expResult);

        // Test of setter
        assertEquals(expResult, instance.getStatus());
    }

    /**
     * Test of TabName methods, of class Tab.
     */
    @Test
    public void testTabName() {
        String expResult = "TabName";
        Tab instance = new Tab();

        // Test of getter
        assertEquals(null, instance.getTabName());

        instance.setTabName(expResult);

        // Test of setter
        assertEquals(expResult, instance.getTabName());
    }

    /**
     * Test of ObjectList methods, of class Tab.
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
        Tab instance = new Tab();

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
        Tab instance2 = new Tab();

        instance2.addObject(obj2);
        objectList2.add(obj2);

        // Test of add
        assertEquals(objectList2, instance2.getObjectList());
    }
}
