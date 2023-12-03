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
     * Test of Section methods, of class Report.
     */
    @Test
    public void testSection() {

        Report instance = new Report();

        ArrayList<Section> section = new ArrayList<Section>();

        Section section1 = new Section();
        Section section2 = new Section();

        assertNotSame(section1, section2);

        /**************/
        /** Phase 1  **/
        /**************/
        // Test of getter
        assertEquals(section, instance.getSection());

        /**************/
        /** Phase 2  **/
        /**************/
        section.add(section1);
        section.add(section2);

        instance.setSection(section);

        // Test of setter
        assertEquals(section, instance.getSection());

        /**************/
        /** Phase 3  **/
        /**************/
        Report instance2 = new Report();

        instance2.addSection(section1);
        instance2.addSection(section2);

        assertEquals(section, instance.getSection());
    }
}
