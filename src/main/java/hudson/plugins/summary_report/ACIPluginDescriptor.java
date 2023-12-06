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
import hudson.Extension;
import hudson.model.AbstractProject;
import hudson.tasks.BuildStepDescriptor;
import hudson.tasks.Publisher;

/**
 * Plugin connection to jenkins.
 */
@Extension
@SuppressFBWarnings(value = "MC_OVERRIDABLE_METHOD_CALL_IN_CONSTRUCTOR", justification = "need to be fixed")
public class ACIPluginDescriptor extends BuildStepDescriptor<Publisher> {

    /**
     * Get plugin description.
     */
    public ACIPluginDescriptor() {
        super(ACIPluginPublisher.class);
        load();
    }

    /**
     * Get plugin availability.
     * @param jobType
     * 		Type of Job to we want this plugin to apply
     */
    public boolean isApplicable(final Class<? extends AbstractProject> jobType) {
        return true;
    }

    /**
     * Get Name of the plugin.
     */
    @Override
    public String getDisplayName() {
        return "Publish XML Summary Reports";
    }
}
