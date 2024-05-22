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

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import hudson.plugins.summary_report.report.Accordion;
import hudson.plugins.summary_report.report.BsCard;
import hudson.plugins.summary_report.report.BsColumn;
import hudson.plugins.summary_report.report.BsContainer;
import hudson.plugins.summary_report.report.BsRow;
import hudson.plugins.summary_report.report.Component;
import hudson.plugins.summary_report.report.Field;
import hudson.plugins.summary_report.report.HtmlContent;
import hudson.plugins.summary_report.report.Section;
import hudson.plugins.summary_report.report.Tab;
import hudson.plugins.summary_report.report.Table;
import hudson.plugins.summary_report.report.Tabs;
import hudson.plugins.summary_report.report.Td;
import hudson.plugins.summary_report.report.Tr;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
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

    private static final Logger LOGGER = Logger.getLogger(ParserXml.class.getName());
    private static Component result;
    private static String xmlPath;
    /**
     * XML Parser.
     *
     * @param xmlFile
     * 		Access path to the xml file
     */
    @SuppressFBWarnings(value = "ST_WRITE_TO_STATIC_FROM_INSTANCE_METHOD", justification = "need to be fixed")
    public ParserXml(final String xmlFile) {
        xmlPath = xmlFile;
    }

    /**
     * Parsing entry point.
     */
    public String parse() {
        try {
            final SAXParserFactory factory = SAXParserFactory.newInstance();
            final SAXParser parser = factory.newSAXParser();
            final DefaultHandler handler = new Analyse();
            parser.parse(new File(xmlPath), handler);
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
     * Return root component.
     */
    public Component result() {
        return result;
    }

    /**
     * Sub class for xml analysis.
     */
    static class Analyse extends DefaultHandler {

        private Component rootElement = null;

        List<Component> elements = new ArrayList<>();

        /**
         * Main entry point.
         */
        public Analyse() {
            super();
        }

        @Override
        public void characters(final char[] ch, final int start, final int length) throws SAXException {

            final String lecture = new String(ch, start, length);
            // if the string doesn't contain only empty characters
            if (!lecture.matches("^\\s*$")) {
                elements.get(elements.size() - 1).setCdata(lecture);
            }
        }

        @Override
        @SuppressFBWarnings(value = "ST_WRITE_TO_STATIC_FROM_INSTANCE_METHOD", justification = "need to be fixed")
        public void endDocument() throws SAXException {
            result = (Component) rootElement;
        }

        @Override
        public void endElement(final String uri, final String localName, final String qName) throws SAXException {

            Component element = elements.remove(elements.size() - 1);

            if (elements.size() > 0) {
                elements.get(elements.size() - 1).addObject(element);
            } else {
                rootElement = element;
            }
        }

        @Override
        public void startElement(
                final String uri, final String localName, final String qName, final Attributes attributes)
                throws SAXException {

            Component element = null;
            if (qName.equals("section")) {
                Section object = new Section();
                object.init(attributes);
                element = object;
            } else if (qName.equals("tabs")) {
                Tabs object = new Tabs();
                object.init(attributes);
                element = object;
            } else if (qName.equals("tab")) {
                Tab object = new Tab();
                object.init(attributes);
                element = object;
            } else if (qName.equals("accordion")) {
                Accordion object = new Accordion();
                object.init(attributes);
                element = object;
            } else if (qName.equals("field")) {
                Field object = new Field();
                object.init(attributes);
                element = object;
            } else if (qName.equals("table")) {
                Table object = new Table();
                object.init(attributes);
                element = object;
            } else if (qName.equals("tr")) {
                Tr object = new Tr();
                object.init(attributes);
                element = object;
            } else if (qName.equals("td")) {
                Td object = new Td();
                object.init(attributes);
                element = object;
            } else if (qName.equals("layout-container")) {
                BsContainer object = new BsContainer();
                object.init(attributes);
                element = object;
            } else if (qName.equals("layout-row")) {
                BsRow object = new BsRow();
                object.init(attributes);
                element = object;
            } else if (qName.equals("layout-column") || qName.equals("layout-col")) {
                BsColumn object = new BsColumn();
                object.init(attributes);
                element = object;
            } else if (qName.equals("html")) {
                HtmlContent object = new HtmlContent();
                object.init(attributes);
                element = object;
            } else if (qName.equals("bs-card")) {
                BsCard object = new BsCard();
                object.init(attributes);
                element = object;
            }

            if (element == null) {
                // TODO throw exception here, not supported element ...
                LOGGER.warning("Unknown element " + qName + " " + attributes);
                element = new Component();
            }

            elements.add(element);
        }
    }
}
