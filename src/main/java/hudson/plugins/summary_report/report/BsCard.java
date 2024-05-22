package hudson.plugins.summary_report.report;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

/**
 * Class responsible for a section creation.
 */
public class BsCard extends Component {

    private String title;
    private String icon;

    /**
     * Constructor.
     */
    public BsCard() {
        this.setType("bs-card");
        this.initChildObjects();
    }

    @Override
    public void init(final Attributes attributes) throws SAXException {

        // this.padding = "0";
        super.init(attributes);

        this.setTitle(attributes.getValue("title"));
        this.setIcon(attributes.getValue("icon"));
    }

    /**
     * Get the title.
     * @return the title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Set the title.
     * @param title
     *            the title to set
     */
    public void setTitle(final String title) {
        this.title = title;
    }

    /**
     * Get the title.
     * @return the title
     */
    public String getIcon() {
        return this.icon;
    }

    /**
     * Set the title.
     * @param icon
     *            the icon to set
     */
    public void setIcon(final String icon) {
        this.icon = icon;
    }
}
