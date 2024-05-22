/*
 * The MIT License
 *
 * Copyright (c) 2012, Thomas Deruyter, Raynald Briand
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package hudson.plugins.summary_report.report;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

/**
 * Class responsible for a table creation.
 */
public class Table extends Component {

    // private static long counter;
    // private String id = null;
    private ArrayList<Tr> trList;
    private String sortable;

    /**
     * Constructor.
     */
    public Table() {
        this.setType("table");
        this.trList = new ArrayList<Tr>();
    }

    @Override
    public void init(final Attributes attributes) throws SAXException {

        super.init(attributes);

        // @TODO do we need it, We shall provide some solution to enable more options from data-table-plugin
        this.setSortable(attributes.getValue("sortable"));
    }

    /**
     * Get the list of rows.
     * @return the trList
     */
    public ArrayList<Tr> getTrList() {
        return trList;
    }

    /**
     * Set the list of rows.
     * @param trList
     *		the trList to set
     */
    public void setTrList(final ArrayList<Tr> trList) {
        this.trList = trList;
    }

    /**
     * Return if the table can be sorted.
     * @return the sortable
     */
    public String getSortable() {
        return sortable;
    }

    /**
     * Set the current table sortable.
     * @param sortable
     * 		the sortable to set
     */
    public void setSortable(final String sortable) {
        this.sortable = sortable;
    }

    /**
     * Add a row to the current list of rows.
     * @param tr
     * 		the row to add.
     */
    public void addTr(final Tr tr) {
        this.trList.add(tr);
    }

    /**
     * Add an object to the current object list.
     * @param obj
     *            the object to add
     */
    @Override
    public void addObject(final Object obj) {
        this.addTr((Tr) obj);
    }

    @Override
    public boolean isPrimitive() {
        return false;
    }
}
