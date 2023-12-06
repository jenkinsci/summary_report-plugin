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
 * Class responsible for a set of tab creation.
 */
public class Tabs {

    private String status;
    private ArrayList<Tab> tabList;

    /**
     * Constructor.
     */
    public Tabs() {
        tabList = new ArrayList<Tab>();
        status = "tabs";
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
     * Get the current tab list.
     * @return the tabList
     */
    public ArrayList<Tab> getTabList() {
        return tabList;
    }

    /**
     * Set the current tab list.
     * @param tabList
     *            the tabList to set
     */
    public void setTabList(final ArrayList<Tab> tabList) {
        this.tabList = tabList;
    }

    /**
     * Add a tab to the current tab list.
     * @param obj
     *		The tab to add
     */
    public void addTab(final Tab obj) {
        this.tabList.add(obj);
    }
}
