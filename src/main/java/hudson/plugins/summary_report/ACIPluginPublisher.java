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

import hudson.Launcher;
import hudson.model.AbstractBuild;
import hudson.model.AbstractProject;
import hudson.model.Action;
import hudson.model.BuildListener;

import hudson.tasks.BuildStepMonitor;
import hudson.tasks.Recorder;
import java.io.File;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.tools.ant.types.FileSet;
import org.apache.tools.ant.Project;

import org.kohsuke.stapler.DataBoundConstructor;
import org.xml.sax.SAXException;

/**
 * ACIPluginPublisher Is the main class for
 * publishing data over build & project page.
 */
@SuppressWarnings("unchecked")
public class ACIPluginPublisher extends Recorder {

	/* The list name of the files to parse */
	private String name;

	/**
	 * Set the name of the publisher.
	 * @param name
	 * 		The name of the published report
	 */
	@DataBoundConstructor
	public ACIPluginPublisher(final String name) {
		this.name = name;
	}

	/**
	 * Get the name of the publisher.
	 * @return string
	 * 		The name of the published report
	 */
	public String getName() {
		return name;
	}

	/**
	 * Get the action associated to the publisher.
	 * @param project
	 * 		Project on which to apply publication
	 */
	@Override
	public Action getProjectAction(final AbstractProject<?, ?> project) {
		return new ACIPluginProjectAction(project);
	}

	/**
	 * Perform the publication.
	 * @param build
	 * 		Build on which to apply publication
	 * @param launcher
	 * 		Unused
	 * @param listener
	 * 		Unused
	 * @return boolean
	 * 		true if the publishing successfully complete
	 * 		true if the publishing could not complete
	 * @throws IOException
	 * 		In case of file IO mismatch
	 * @throws InterruptedException
	 * 		In case of interuption
	 */
	@Override
	public boolean perform(
			final AbstractBuild<?, ?> build,
			final Launcher launcher,
			final BuildListener listener)
					throws IOException, InterruptedException {

		/**
		 * Define if we must parse multiple file by searching for ','
		 * in the name var.
		 */
		String[] files = name.split(",");

		ArrayList<String> filesToParse = new ArrayList<String>();
		for (int i = 0; i < files.length; i++) {
			FileSet fileSet = new FileSet();
			File workspace = build.getArtifactsDir();
			fileSet.setDir(workspace);
			fileSet.setIncludes(files[i].trim());
			Project antProject = new Project();
			fileSet.setProject(antProject);
			String[] tmpFiles = new String[] {};
			try {
				tmpFiles = fileSet.getDirectoryScanner(antProject)
					.getIncludedFiles();
			} catch (Exception ex) {
				listener.getLogger().println(ex.toString());
				return false;
			}
			for (int j = 0; j < tmpFiles.length; j++) {
				filesToParse.add(tmpFiles[j]);
			}

		}

		try {
			ACIPluginBuildAction buildAction;
			buildAction = new ACIPluginBuildAction(build, filesToParse);
			build.addAction(buildAction);
		} catch (ParserConfigurationException ex) {
			listener.getLogger().println(ex.toString());
            return false;
		} catch (SAXException ex) {
			listener.getLogger().println(ex.toString());
            return false;
		} catch (URISyntaxException ex) {
			listener.getLogger().println(ex.toString());
            return false;
		}
		return true;
	}

	/**
	 * Method that returns the status of the service required.
	 */
	public BuildStepMonitor getRequiredMonitorService() {
		return BuildStepMonitor.BUILD;
	}
}
