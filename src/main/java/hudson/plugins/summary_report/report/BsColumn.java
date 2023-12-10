package hudson.plugins.summary_report.report;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

/**
 * Class responsible for a bootstrap-column creation.
 * see also https://getbootstrap.com/docs/5.1/layout/columns/
 */
public class BsColumn extends Component {

    private String gridWidth;

    /**
     * Constructor.
     */
    public BsColumn() {
        this.setType("layout-column");
        this.initChildObjects();
    }

    @Override
    public void init(final Attributes attributes) throws SAXException {

        this.padding = "0";
        super.init(attributes);

        this.setGridWidth(attributes.getValue("grid-width"));
    }

    /**
     * Get the grid width of the column.
     * See also https://getbootstrap.com/docs/5.1/layout/grid/
     * @return the accordionName
     */
    public String getGridWidth() {
        if (gridWidth == null || gridWidth.isEmpty()) {
            return "";
        }
        return "col-xxl-" + gridWidth;
    }

    /**
     * Set the name of the accordion.
     * @param accordionName
     *		the accordionName to set
     */
    public void setGridWidth(final String gridWidth) {

        final int widthValue = Integer.valueOf(gridWidth);
        if (widthValue < 1 || widthValue > 12) {
            LOGGER.warning("Invalid parameter grid-width (" + gridWidth + ") in object " + this.toString());
            return;
        }
        this.gridWidth = gridWidth;
    }
}
