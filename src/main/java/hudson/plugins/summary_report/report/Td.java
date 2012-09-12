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
 * Class responsible for a table column creation.
 */
public class Td {
	private String tdValue;
	private String bgColor;
	private String fontColor;
	private String fontAttribute;
	private String href;
	private String width;
	private String align;
	private String cdata;
	private String title;

	/**
	 * Constructor.
	 */
	public Td() {
		this.width = "100";
		this.align = "left";
	}

	/**
	 * Get Column value.
	 * @return the tdValue
	 */
	public String getTdValue() {
		return tdValue;
	}

	/**
	 * Set Cell title.
	 * @param title
	 *            the title to set
	 */
	public void setTitle(final String title) {
		this.title = title;
	}

	/**
	 * Get Cell title.
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Set Column value.
	 * @param tdValue
	 *            the tdValue to set
	 */
	public void setTdValue(final String tdValue) {
		this.tdValue = tdValue;
	}

	/**
	 * Get background color.
	 * @return the bgColor
	 */
	public String getBgColor() {
		return bgColor;
	}

	/**
	 * Set background color.
	 * @param bgColor
	 *            the bgColor to set
	 */
	public void setBgColor(final String bgColor) {
		this.bgColor = bgColor;
	}

	/**
	 * Get font color.
	 * @return the fontColor
	 */
	public String getFontColor() {
		return fontColor;
	}

	/**
	 * Set font color.
	 * @param fontColor
	 *            the fontColor to set
	 */
	public void setFontColor(final String fontColor) {
		this.fontColor = fontColor;
	}

	/**
	 * Get font attribute.
	 * @return the fontAttribute
	 */
	public String getFontAttribute() {
		return fontAttribute;
	}

	/**
	 * Set font attribute.
	 * @param fontAttribute
	 *            the fontAttribute to set
	 */
	public void setFontAttribute(final String fontAttribute) {
		this.fontAttribute = fontAttribute;
	}

	/**
	 * Get Hyperlink value.
	 * @return the ref
	 */
	public String getHref() {
		return href;
	}

	/**
	 * Set Hyperlink value.
	 * @param href
	 *            the ref to set
	 */
	public void setHref(final String href) {
		this.href = href;
	}

	/**
	 * Get column width.
	 * @return the width
	 */
	public String getWidth() {
		return width;
	}

	/**
	 * Set column width.
	 * @param width
	 *            the width to set
	 */
	public void setWidth(final String width) {
		this.width = width;
	}

	/**
	 * Get the alignment.
	 * @return the align
	 */
	public String getAlign() {
		return align;
	}

	/**
	 * Set the alignment.
	 * @param align
	 *            the alignment to set
	 */
	public void setAlign(final String align) {
		this.align = align;
	}

	/**
	 * Get the cdata section.
	 * @return the cdata
	 */
	public String getCdata() {
		return cdata;
	}

	/**
	 * Set cdata section.
	 * @param cdata
	 *            the cdata to set
	 */
	public void setCdata(final String cdata) {
		if (this.cdata == null) {
			this.cdata = cdata;
		} else {
			this.cdata = this.cdata + cdata;
		}
	}
}
