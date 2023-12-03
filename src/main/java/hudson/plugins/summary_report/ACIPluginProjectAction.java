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
import hudson.model.AbstractBuild;
import hudson.model.AbstractProject;
import hudson.model.Action;
import hudson.model.Descriptor;
import hudson.plugins.summary_report.report.Report;
import hudson.tasks.Publisher;
import hudson.util.DescribableList;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Action to perform at project page.
 */
@SuppressFBWarnings(value = "SE_BAD_FIELD", justification = "need to be fixed")
public class ACIPluginProjectAction implements Action, Serializable {

    /**
     * Version ID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Name of the URL where results are available.
     */
    public static final String URL_NAME = "aciResult";

    /**
     * Project structure.
     */
    private AbstractProject<?, ?> project;

    /**
     * Assign project.
     *
     * @param project
     * 		Assign the current project
     */
    public ACIPluginProjectAction(final AbstractProject<?, ?> project) {
        this.project = project;
    }

    /**
     * The getIconFileName function
     * create a link to a new page with url:
     * 		http://{root}/job/{job name}/URL_NAME
     * for the page of the project.
     * This is not used in our context.
     *
     * @return null
     */
    public String getIconFileName() {
        return null;
    }
    /**
     * The getDisplayName function
     * create a link to a new page with url:
     * 		http://{root}/job/{job name}/URL_NAME
     * for the page of the project.
     * This is not used in our context.
     *
     * @return null
     */
    public String getDisplayName() {
        //        return "ACIProjectAction";
        return null;
    }
    /**
     * The getUrlName function
     * create a link to a new page with url:
     * 		http://{root}/job/{job name}/URL_NAME
     * for the page of the project.
     * This is not used in our context.
     *
     * @return null
     */
    public String getUrlName() {
        //        return URL_NAME;
        return null;
    }

    /**
     * Returns the last finished build.
     *
     * @return build
     * 		the last finished build or <code>null</code>
     * 		if there is no such build
     */
    public AbstractBuild<?, ?> getLastFinishedBuild() {
        AbstractBuild<?, ?> lastBuild = project.getLastBuild();
        while (lastBuild != null
                && (lastBuild.isBuilding() || lastBuild.getAction(ACIPluginBuildAction.class) == null)) {
            lastBuild = lastBuild.getPreviousCompletedBuild();
        }
        return lastBuild;
    }

    /**
     * This method get the report of the last finished build.
     *
     * @return report
     * 		The last Report
     */
    public Report getReport() {
        AbstractBuild<?, ?> build = getLastFinishedBuild();
        // When the project has not had a build yet, build is null
        if (build == null) {
            return null;
        }
        ACIPluginBuildAction resultAction = build.getAction(ACIPluginBuildAction.class);
        return resultAction.getReport();
    }

    /**
     * This method get the files error of the last finished build.
     *
     * @return fileerror
     * 		The last FileError
     */
    public ArrayList<ArrayList<String>> getFileError() {
        AbstractBuild<?, ?> build = getLastFinishedBuild();
        // When the project has not had a build yet, build is null
        if (build == null) {
            return null;
        }
        ACIPluginBuildAction resultAction = build.getAction(ACIPluginBuildAction.class);
        return resultAction.getFileError();
    }

    /**
     * This method return the name of the project.
     *
     * @return name
     * 		The project name
     */
    public String getProjectName() {
        String str = project.getName();
        str = str.replace(".", "dot");
        return str;
    }

    /**
     * This method return a boolean indicating whether to
     * display the report on the project page.
     *
     * @return shownOnProjectPage
     *                 The project name
     */
    public boolean isShownOnProjectPage() {
        DescribableList<Publisher, Descriptor<Publisher>> publishers = project.getPublishersList();
        ACIPluginPublisher publisher = publishers.get(ACIPluginPublisher.class);
        return publisher.isShownOnProjectPage();
    }
}
