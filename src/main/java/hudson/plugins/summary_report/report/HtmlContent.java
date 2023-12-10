package hudson.plugins.summary_report.report;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

/**
 * Class responsible for a HTML-content creation.
 */
public class HtmlContent extends Component {

    /**
     * Constructor.
     */
    public HtmlContent() {
        this.setType("html");
    }

    @Override
    public void init(final Attributes attributes) throws SAXException {

        super.init(attributes);
    }

    /**
     * Get the HTML content.
     * @return safe (trusted) HTML content
     */
    public String getContent() {
        return getHtmlData();
    }
}
