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

package hudson.plugins.summary_report;


import hudson.plugins.summary_report.report.Accordion;
import hudson.plugins.summary_report.report.Field;
import hudson.plugins.summary_report.report.Section;
import hudson.plugins.summary_report.report.Tab;
import hudson.plugins.summary_report.report.Table;
import hudson.plugins.summary_report.report.Tabs;
import hudson.plugins.summary_report.report.Td;
import hudson.plugins.summary_report.report.Tr;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * XML Parser Class.
 */
public class ParserXml {

    private static Section resultat;
    private static String xmlPath;
    /**
     * XML Parser.
     *
     * @param xmlFile
     * 		Access path to the xml file
     */
    public ParserXml(final String xmlFile) {
        xmlPath = xmlFile;
    }

    /**
     * Parsing entry point.
     */
    public String parse() {
        try {
            final SAXParserFactory fabrique = SAXParserFactory.newInstance();
            final SAXParser parseur = fabrique.newSAXParser();
            final DefaultHandler gestionnaire = new Analyse();
            parseur.parse(new File(xmlPath), gestionnaire);
        } catch (ParserConfigurationException pce) {
            return pce.toString();
        } catch (SAXException sax) {
            return sax.toString();
        } catch (IOException ioe) {
            return ioe.toString();
        }
        return "";
    }


    /**
     * Return result of the section.
     */
    public Section result() {
        return resultat;
    }

    /**
     * Sub class for xml analysis.
     */
    static class Analyse extends DefaultHandler {

        private Section section;
        private Tabs tmpTabs;
        private Tab tmpTab;
        private Field tmpField;
        private Table tmpTable;
        private Tr tmpTr;
        private Td tmpTd;
        private Accordion tmpAccordion;

        /**
         * FLAGS
         */
        private boolean fSection = false;
        private boolean fTabs = false;
        private boolean fTab = false;
        private boolean fField = false;
        private boolean fTable = false;
        private boolean fTr = false;
        private boolean fTd = false;
        private boolean fAccordion = false;


        /**
         * Main entry point.
         */
        public Analyse() {
            super();
            section = new Section();
        }

        @Override
        public void characters(final char[] ch, final int start,
                final int length) throws SAXException {

            final String lecture = new String(ch, start, length);

            // if the string doesn't contain only empty charaters
            if (!lecture.matches("^\\s*$")) {
                if (fField && length > 1) {
                    tmpField.setCdata(lecture);
                }
                if (fTd && length > 1) {
                    tmpTd.setCdata(lecture);
                }
            }
       }

        @Override
        public void endDocument() throws SAXException {
            resultat = section;
        }

        @Override
        public void endElement(final String uri, final String localName,
                final String qName) throws SAXException {

            if (qName.equals("section") && fSection) {
                fSection = false;
            } else if (qName.equals("accordion") && fAccordion) {
                fAccordion = false;
                section.addObject(tmpAccordion);
            } else if (qName.equals("field") && fAccordion && fField) {
                fField = false;
                tmpAccordion.addObject(tmpField);
            } else if (qName.equals("table") && fAccordion && fTable) {
                fTable = false;
                tmpAccordion.addObject(tmpTable);
            } else if (qName.equals("tabs")  && fTabs) {
                fTabs = false;
                section.addObject(tmpTabs);
            } else if (qName.equals("tab")  && fTabs && fTab) {
                fTab = false;
                tmpTabs.addTab(tmpTab);
            } else if (qName.equals("field") && fTabs && fTab && fField) {
                fField = false;
                tmpTab.addObject(tmpField);
            } else if (qName.equals("table") && fTabs && fTab && fTable) {
                fTable = false;
                tmpTab.addObject(tmpTable);
            } else if (qName.equals("field")  && fField) {
                fField = false;
                section.addObject(tmpField);
            } else if (qName.equals("table")  && fTable) {
                fTable = false;
                section.addObject(tmpTable);
            } else if (qName.equals("tr") && fTr) {
                fTr = false;
                tmpTable.addTr(tmpTr);
            } else if (qName.equals("td") && fTd) {
                fTd = false;
                tmpTr.addTd(tmpTd);
            }
        }

        @Override
        public void startElement(final String uri, final String localName,
        		final String qName, final Attributes attributes)
        				throws SAXException {
            if (qName.equals("section")) {
                fSection = true;
                section.setSectionName(attributes.getValue("name"));
                section.setLine(attributes.getValue("line"));
                section.setColumn(attributes.getValue("column"));
                section.setFontColor(attributes.getValue("fontcolor"));
            } else if (qName.equals("tabs")) {
                fTabs = true;
                tmpTabs = new Tabs();
            } else if (qName.equals("tab")) {
                fTab = true;
                tmpTab = new Tab();
                tmpTab.setTabName(attributes.getValue("name"));
            } else if (qName.equals("accordion")) {
                fAccordion = true;
                tmpAccordion = new Accordion();
                tmpAccordion.setAccordionName(attributes.getValue("name"));
            } else if (qName.equals("field")) {
                fField = true;
                tmpField = new Field();
                tmpField.setFieldName(attributes.getValue("name"));
                tmpField.setFieldValue(attributes.getValue("value"));
                tmpField.setHref(attributes.getValue("href"));
                tmpField.setTitleColor(attributes.getValue("titlecolor"));
                tmpField.setDetailColor(attributes.getValue("detailcolor"));
            } else if (qName.equals("table")) {
                fTable = true;
                tmpTable = new Table();
                tmpTable.setSorttable(attributes.getValue("sorttable"));
            } else if (qName.equals("tr")) {
                fTr = true;
                tmpTr = new Tr();
            } else if (qName.equals("td")) {
                fTd = true;
                tmpTd = new Td();
                tmpTd.setTdValue(attributes.getValue("value"));
                tmpTd.setBgColor(attributes.getValue("bgcolor"));
                tmpTd.setFontColor(attributes.getValue("fontcolor"));
                tmpTd.setFontAttribute(attributes.getValue("fontattribute"));
                tmpTd.setTitle(attributes.getValue("title"));
                tmpTd.setHref(attributes.getValue("href"));
                tmpTd.setAlign(attributes.getValue("align"));
                tmpTd.setWidth(attributes.getValue("width"));
            }
        }
    }
}
