package hudson.plugins.summary_report.report;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;
import jenkins.model.Jenkins;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class Component {

    protected static final Logger LOGGER = Logger.getLogger(Component.class.getName());
    private static long counter;
    private String id = null;

    private String type;
    private ArrayList<Object> objectList;
    private String cdata;

    private boolean trusted = false;
    protected String padding = "1";
    protected String margin;

    public void Component() {}

    protected void setType(final String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    private void setId(final String id) {
        if (id != null && !id.isEmpty()) {
            this.id = id;
            return;
        }
        this.makeId();
    }

    public String getId() {
        if (this.id == null) {
            this.makeId();
        }
        return this.id;
    }

    private synchronized void makeId() {
        counter++;
        this.id = getClass().getName().replace(".", "-") + "-" + counter;
    }

    public void init(final Attributes attributes) throws SAXException {
        this.setId(attributes.getValue("id"));
        this.setTrustedZone(attributes.getValue("trusted"));
        this.setPadding(attributes.getValue("padding"));
        this.setMargin(attributes.getValue("margin"));
    }

    public boolean isPrimitive() {
        return this.objectList == null;
    }

    protected void initChildObjects() {
        this.objectList = new ArrayList<Object>();
    }

    /**
     * Get the current object list.
     * @return the objectList
     */
    public ArrayList<Object> getObjectList() {
        return this.objectList;
    }

    /**
     * Set the value of to the current object list.
     * @param objectList
     *            the objectList to set
     */
    public void setObjectList(final ArrayList<Object> objectList) {
        this.objectList = objectList;
    }

    /**
     * Add an object to the current object list.
     * @param obj
     *            the object to add
     */
    public void addObject(final Object obj) {
        if (this.isPrimitive()) {
            LOGGER.warning("You will add object to primitive object. This will not works: this " + this.toString()
                    + " to add " + obj.toString());
        }
        this.objectList.add(obj);
    }

    /**
     * Get cdata section of the field.
     * @return The cdata section
     */
    public String getCdata() {
        return cdata;
    }

    public String getHtmlData() {

        final String content = this.getCdata();
        if (content != null) {
            if (this.isTrustedZone()) {
                return content;
            } else {
                String out = null;
                try {
                    out = Jenkins.get().getMarkupFormatter().translate(this.getCdata());
                } catch (IOException e) {
                    LOGGER.warning("failed to translate HTML content using configured markup formatter");
                }
                return out == null ? "" : out;
            }

        } else {
            return "";
        }
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

    public String toString() {
        return this.getType() + " " + this.getId();
    }

    /**
     * Set this html content to trusted zone
     * @param trusted
     */
    private void setTrustedZone(final String trusted) {
        this.trusted = (trusted != null) && trusted.equals("true");
    }

    public boolean isTrustedZone() {
        return this.trusted;
    }

    /**
     * Get the padding.
     * See also https://weekly.ci.jenkins.io/design-library/Spacing/
     * @return the padding
     */
    public String getPadding() {
        if (this.padding == null) {
            return "jenkins-!-padding-0";
        }
        if (this.padding.isEmpty()) {
            return "";
        }
        return "jenkins-!-padding-" + this.padding;
    }

    /**
     * Set the padding.
     * See also https://weekly.ci.jenkins.io/design-library/Spacing/
     * @param padding
     *		the padding value to set
     */
    private void setPadding(final String padding) {
        if (!validateJenkinsSpacing(padding)) {
            return;
        }
        this.padding = padding;
    }

    /**
     * Get the margin.
     * See also https://weekly.ci.jenkins.io/design-library/Spacing/
     * @return the margin
     */
    public String getMargin() {
        if (this.margin == null) {
            return "jenkins-!-margin-0";
        }
        if (this.margin.isEmpty()) {
            return "";
        }
        return "jenkins-!-margin-" + this.margin;
    }

    /**
     * Set the margin.
     * See also https://weekly.ci.jenkins.io/design-library/Spacing/
     * @param margin
     *		the margin value to set
     */
    private void setMargin(final String margin) {
        if (!validateJenkinsSpacing(margin)) {
            return;
        }
        this.margin = margin;
    }

    private boolean validateJenkinsSpacing(final String space) {
        if (space == null) {
            return false; // in case the attribute does not exists
        }
        if (space.isEmpty()) {
            return true; // attribute set to empty, you will not use any of jenkins spaces
        }
        String[] parts = space.split("-");
        if (parts.length == 0 || parts.length > 2) {
            LOGGER.warning("Invalid jenkins space attribute (" + space + ") in object " + this.toString());
            return false;
        }
        String modifier = null;
        int size;
        if (parts.length > 1) {
            modifier = parts[0];
            size = Integer.valueOf(parts[1]);
        } else {
            size = Integer.valueOf(space);
        }

        if (modifier != null
                && !modifier.equals("top")
                && !modifier.equals("bottom")
                && !modifier.equals("left")
                && !modifier.equals("right")) {
            LOGGER.warning(
                    "Invalid jenkins space modifier (" + modifier + " in " + space + ") in object " + this.toString());
            return false;
        }

        if (size < 0 || size > 5) {
            LOGGER.warning("Invalid jenkins space size (" + size + " in " + space + ") in object " + this.toString());
            return false;
        }

        return true;
    }
}
