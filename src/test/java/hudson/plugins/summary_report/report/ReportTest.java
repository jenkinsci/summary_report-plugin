package hudson.plugins.summary_report.report;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Test;

/**
 *
 * @author br80
 */
public class ReportTest {

    public ReportTest() {}

    /**
     * Test of Component methods, of class Report.
     */
    @Test
    public void testComponent() {

        Report instance = new Report();

        ArrayList<Component> component = new ArrayList<Component>();

        Component component1 = new Component();
        Component component2 = new Component();

        assertNotSame(component1, component2);

        /**************/
        /** Phase 1  **/
        /**************/
        // Test of getter
        assertEquals(component, instance.getComponents());

        /**************/
        /** Phase 2  **/
        /**************/
        component.add(component1);
        component.add(component2);

        instance.addComponent(component1);
        instance.addComponent(component2);

        // Test of setter
        assertEquals(component, instance.getComponents());
    }
}
