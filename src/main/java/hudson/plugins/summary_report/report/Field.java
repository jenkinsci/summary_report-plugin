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

/**
 * Class responsible for a field creation.
 */
public class Field {

    private static long counter;
    private String id = null;
    private String fieldName;
    private String fieldValue;
    private String cdata;
    private String href;
    private String titleColor;
    private String detailColor;

    /**
     * Constructor.
     */
    public Field() {
        this.makeId();
    }

    private synchronized void makeId() {
        counter++;
        this.id = getClass().getName().replace(".", "-") + "-" + counter;
    }

    public String getId() {
        if (this.id == null) {
            makeId();
        }
        return this.id;
    }


    /**
     * Get Field Name.
     * @return the fieldName
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * Set the name of the field.
     * @param fieldName
     * 		the fieldName to set
     */
    public void setFieldName(final String fieldName) {
        this.fieldName = fieldName;
    }

    /**
     * Get the value of the field.
     * @return the fieldValue
     */
    public String getFieldValue() {
        return fieldValue;
    }

    /**
     * Set the value of the field.
     * @param fieldValue
     *		the fieldValue to set
     */
    public void setFieldValue(final String fieldValue) {
        this.fieldValue = fieldValue;
    }

    /**
     * Get cdata section of the field.
     * @return The cdata section
     */
    public String getCdata() {
        return cdata;
    }

    /**
     * Set cdata section of the field.
     * @param cdata
     * 		The cdata section to set
     */
    public void setCdata(final String cdata) {
        if (this.cdata == null) {
            this.cdata = cdata;
        } else {
            this.cdata = this.cdata + cdata;
        }
    }

    /**
     * Get the hyperlink reference the field.
     * @return the ref
     */
    public String getHref() {
        return href;
    }

    /**
     * Set the hyperlink reference the field.
     * @param href
     * 		the ref to set
     */
    public void setHref(final String href) {
        this.href = href;
    }

    /**
     * Get the title color of the field.
     * @return the titleColor
     */
    public String getTitleColor() {
        return titleColor;
    }

    /**
     * Set the title color of the field.
     * @param titleColor
     *		The titleColor to set
     */
    public void setTitleColor(final String titleColor) {
        this.titleColor = titleColor;
    }

    /**
     * Get the value color of the field.
     * @return the detailColor
     */
    public String getDetailColor() {
        return detailColor;
    }

    /**
     * Set the title color of the field.
     * @param detailColor
     * 		The detailColor to set
     */
    public void setDetailColor(final String detailColor) {
        this.detailColor = detailColor;
    }
}
