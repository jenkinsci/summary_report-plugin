package hudson.plugins.summary_report.report;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

/**
 * Class responsible for a bootstrap-container creation.
 * see also https://getbootstrap.com/docs/5.1/layout/containers/
 */
public class BsContainer extends Component {

    /**
     * Constructor.
     */
    public BsContainer() {
        this.setType("layout-container");
        this.initChildObjects();
    }

    @Override
    public void init(final Attributes attributes) throws SAXException {

        this.padding = "0";
        super.init(attributes);
    }
}
