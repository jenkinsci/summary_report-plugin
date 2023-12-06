package hudson.plugins.summary_report.report;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Test;

/**
 *
 * @author br80
 */
public class TableTest {

    public TableTest() {}

    /**
     * Test of Status methods, of class Table.
     */
    @Test
    public void testStatus() {
        String expResult = "tableTest";
        Table instance = new Table();

        // Test of getter
        // In default value, status of new instance of Table is table
        assertEquals("table", instance.getStatus());

        instance.setStatus(expResult);

        // Test of setter
        assertEquals(expResult, instance.getStatus());
    }

    /**
     * Test of Sorttable methods, of class Table.
     */
    @Test
    public void testSorttable() {
        String expResult = "Sorttable";
        Table instance = new Table();

        // Test of getter
        assertEquals(null, instance.getSorttable());

        instance.setSorttable(expResult);

        // Test of setter
        assertEquals(expResult, instance.getSorttable());
    }

    /**
     * Test of TrList methods, of class Table.
     */
    @Test
    public void testTrList() {

        Table instance = new Table();

        ArrayList<Tr> tr = new ArrayList<Tr>();

        Tr tr1 = new Tr();
        Tr tr2 = new Tr();

        assertNotSame(tr1, tr2);

        /**************/
        /** Phase 1  **/
        /**************/
        // Test of getter
        assertEquals(tr, instance.getTrList());

        /**************/
        /** Phase 2  **/
        /**************/
        tr.add(tr1);
        tr.add(tr2);

        instance.setTrList(tr);

        // Test of setter
        assertEquals(tr, instance.getTrList());

        /**************/
        /** Phase 3  **/
        /**************/
        Table instance2 = new Table();

        instance2.addTr(tr1);
        instance2.addTr(tr2);

        assertEquals(tr, instance.getTrList());
    }
}
