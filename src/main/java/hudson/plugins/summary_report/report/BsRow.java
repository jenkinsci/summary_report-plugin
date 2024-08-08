package hudson.plugins.summary_report.report;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

/**
 * Class responsible for a Container creation.
 */
public class BsRow extends Component {

    /**
     * Constructor.
     */
    public BsRow() {
        this.setType("layout-row");
        this.initChildObjects();
    }

    @Override
    public void init(final Attributes attributes) throws SAXException {

        this.padding = "0";
        super.init(attributes);
    }
}
