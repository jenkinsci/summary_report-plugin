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
 * Class responsible for a tab creation.
 */
public class Tab {

    private String status;
    private String tabName;
    private ArrayList<Object> objectList;

    /**
     * Constructor of a tab.
     */
    public Tab() {
        objectList = new ArrayList<Object>();
        status = "tab";
    }

    /**
     * Get the status of a tab.
     * @return status
     * 		the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Set the status of a tab.
     * @param status
     *            the status to set
     */
    public void setStatus(final String status) {
        this.status = status;
    }

    /**
     * Get the name of the tab.
     * @return the tabName
     */
    public String getTabName() {
        return tabName;
    }

    /**
     * Set the name of the tab.
     * @param tabName
     *            the tabName to set
     */
    public void setTabName(final String tabName) {
        this.tabName = tabName;
    }

    /**
     * Get the current object list.
     * @return the objectList
     */
    public ArrayList<Object> getObjectList() {
        return objectList;
    }

    /**
     * Set the current object list value.
     * @param objectList
     *            the objectList to set
     */
    public void setObjectList(final ArrayList<Object> objectList) {
        this.objectList = objectList;
    }

    /**
     * Add an object to the current object list value.
     * @param obj
     *            the object to add
     */
    public void addObject(final Object obj) {
        this.objectList.add(obj);
    }
}
