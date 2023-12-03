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
 * This class represents one report for one build.
 *
 */
public class Report {

    private ArrayList<Section> reportSection;

    /**
     * Initialize the section.
     */
    public Report() {
        reportSection = new ArrayList<Section>();
    }

    /**
     * Return the current list of section.
     *
     * @return section
     * 		the current section list
     */
    public ArrayList<Section> getSection() {
        return reportSection;
    }

    /**
     * Assign a section list to the report.
     *
     * @param section
     * 		the section list to set
     */
    public void setSection(final ArrayList<Section> section) {
        this.reportSection = section;
    }

    /**
     * Add a new section to the report.
     *
     * @param section
     * 		The section to add in the list of sections
     */
    public void addSection(final Section section) {
        this.reportSection.add(section);
    }
}
