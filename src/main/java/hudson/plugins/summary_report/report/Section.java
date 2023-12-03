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

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.ArrayList;

/**
 * Class responsible for a section creation.
 */
public class Section {

    private String sectionName;
    private String line;
    private String column;
    private ArrayList<Object> objectList;
    private String fontColor;

    /**
     * Constructor.
     */
    public Section() {
        objectList = new ArrayList<Object>();
    }

    /**
     * Get the section name.
     * @return the sectionName
     */
    public String getSectionName() {
        return sectionName;
    }

    /**
     * Set the section name.
     * @param sectionName
     *            the sectionName to set
     */
    public void setSectionName(final String sectionName) {
        this.sectionName = sectionName;
    }

    /**
     * Get the current line.
     * @return the line
     */
    public String getLine() {
        return line;
    }

    /**
     * Set the current line.
     * @param line
     *            the line to set
     */
    public void setLine(final String line) {
        this.line = line;
    }

    /**
     * Get the current column.
     * @return the column
     */
    public String getColumn() {
        return column;
    }

    /**
     * Set the current column.
     * @param column
     *            the column to set
     */
    public void setColumn(final String column) {
        this.column = column;
    }

    /**
     * Get the current object list.
     * @return the objectList
     */
    public ArrayList<Object> getObjectList() {
        return objectList;
    }

    /**
     * Set the current object list.
     * @param objectList
     *            the objectList to set
     */
    public void setObjectList(final ArrayList<Object> objectList) {
        this.objectList = objectList;
    }

    /**
     * Add an object to the current object list.
     * @param obj
     *		The object to add
     */
    public void addObject(final Object obj) {
        this.objectList.add(obj);
    }

    /**
     * Get font attribute.
     * @return the fontColor
     */
    @SuppressFBWarnings(value = "NM_CONFUSING", justification = "need to be fixed")
    public String getfontColor() {
        return fontColor;
    }

    /**
     * Set font attribute.
     * @param fontColor
     *            the fontColor to set
     */
    public void setFontColor(final String fontColor) {
        this.fontColor = fontColor;
    }
}
