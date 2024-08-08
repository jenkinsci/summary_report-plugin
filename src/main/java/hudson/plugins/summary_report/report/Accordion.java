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

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

/**
 * Class responsible for a accordion creation.
 */
public class Accordion extends Component {

    private String accordionName;

    /**
     * Constructor.
     */
    public Accordion() {
        this.setType("accordion");
        this.initChildObjects();
    }

    @Override
    public void init(final Attributes attributes) throws SAXException {

        super.init(attributes);

        this.setAccordionName(attributes.getValue("name"));
    }

    /**
     * Get the name of the accordion.
     * @return the accordionName
     */
    public String getAccordionName() {
        return accordionName;
    }

    /**
     * Set the name of the accordion.
     * @param accordionName
     *		the accordionName to set
     */
    public void setAccordionName(final String accordionName) {
        this.accordionName = accordionName;
    }
}
