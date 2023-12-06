package hudson.plugins.summary_report.report;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Test;

/**
 *
 * @author br80
 */
public class TrTest {

    public TrTest() {}

    /**
     * Test of TdList methods, of class Tr.
     */
    @Test
    public void testTdList() {

        Tr instance = new Tr();

        ArrayList<Td> tdList = new ArrayList<Td>();

        Td td1 = new Td();
        Td td2 = new Td();

        assertNotSame(td1, td2);

        /**************/
        /** Phase 1  **/
        /**************/
        // Test of getter
        assertEquals(tdList, instance.getTdList());

        /**************/
        /** Phase 2  **/
        /**************/
        tdList.add(td1);
        tdList.add(td2);

        instance.setTdList(tdList);

        // Test of setter
        assertEquals(tdList, instance.getTdList());

        /**************/
        /** Phase 3  **/
        /**************/
        Tr instance2 = new Tr();

        instance2.addTd(td1);
        instance2.addTd(td2);

        assertEquals(tdList, instance.getTdList());
    }
}
