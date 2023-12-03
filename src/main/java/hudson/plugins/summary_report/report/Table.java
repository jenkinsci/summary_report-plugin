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

/**
 * Class responsible for a table creation.
 */
public class Table {

    private String status;
    private ArrayList<Tr> trList;
    private String sorttable;

    /**
     * Constructor.
     */
    public Table() {
        trList = new ArrayList<Tr>();
        status = "table";
    }

    /**
     * Get the status.
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Set the status.
     * @param status
     *		the status to set
     */
    public void setStatus(final String status) {
        this.status = status;
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
     * @return the sorttable
     */
    public String getSorttable() {
        return sorttable;
    }

    /**
     * Set the current table sortable.
     * @param sorttable
     * 		the sorttable to set
     */
    public void setSorttable(final String sorttable) {
        this.sorttable = sorttable;
    }

    /**
     * Add a row to the current list of rows.
     * @param tr
     * 		the row to add.
     */
    public void addTr(final Tr tr) {
        this.trList.add(tr);
    }
}
