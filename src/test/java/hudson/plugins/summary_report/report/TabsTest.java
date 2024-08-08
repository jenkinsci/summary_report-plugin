package hudson.plugins.summary_report.report;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Test;

/**
 *
 * @author br80
 */
public class TabsTest {

    public TabsTest() {}

    /**
     * Test of TabList methods, of class Tabs.
     */
    @Test
    public void testTabList() {

        Tabs instance = new Tabs();

        ArrayList<Tab> tab = new ArrayList<Tab>();

        Tab tab1 = new Tab();
        Tab tab2 = new Tab();

        assertNotSame(tab1, tab2);

        /**************/
        /** Phase 1  **/
        /**************/
        // Test of getter
        assertEquals(tab, instance.getTabList());

        /**************/
        /** Phase 2  **/
        /**************/
        tab.add(tab1);
        tab.add(tab2);

        instance.setTabList(tab);

        // Test of setter
        assertEquals(tab, instance.getTabList());

        /**************/
        /** Phase 3  **/
        /**************/
        Tabs instance2 = new Tabs();

        instance2.addTab(tab1);
        instance2.addTab(tab2);

        assertEquals(tab, instance.getTabList());
    }
}
