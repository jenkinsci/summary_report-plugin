# Jenkins Summary Display Plugin

[![Jenkins Plugin](https://img.shields.io/jenkins/plugin/v/summary_report.svg)](https://plugins.jenkins.io/summary_report-plugin)
<!--[![GitHub release](https://img.shields.io/github/release/jenkinsci/summary_report-plugin-plugin.svg?label=release)](https://github.com/jenkinsci/summary_report-plugin-plugin/releases/latest) -->
[![Jenkins Plugin Installs](https://img.shields.io/jenkins/plugin/i/summary_report.svg?color=blue)](https://plugins.jenkins.io/summary_report-plugin)
[![Build Status](https://ci.jenkins.io/buildStatus/icon?job=Plugins%2Fsummary_report-plugin%2Fmaster)](https://ci.jenkins.io/job/Plugins/job/summary_report-plugin-plugin/job/master/)
[![GitHub license](https://img.shields.io/github/license/jenkinsci/summary_report-plugin.svg)](https://github.com/jenkinsci/summary_report-plugin-plugin/blob/master/LICENSE)
[![Maintenance](https://img.shields.io/maintenance/yes/2024.svg)](https://github.com/jenkinsci/summary_report-plugin-plugin)

This plugin allows an easy and fully customized build report display on both the project page en build page.

----
## Support

“Open source” does not mean “includes free support”

You can support the contributor and buy him a coffee.
[![coffee](https://www.buymeacoffee.com/assets/img/custom_images/black_img.png)](https://www.buymeacoffee.com/mpokornyetm) 
Every second invested in an open-source project is a second you can't invest in your own family / friends / hobby.
That`s the reason, why supporting the contributors is so important.

Thx very much for supporting us.

----
## Features

+ Allow a rich summary report visible from both project and build page
+ Reports must be written in an XML format according to the syntax described in section Syntax Description
+ This plugin allow the parsing of several XML files
+ Reports displayed are ordered according to the XML file names
+ Element displayed are based on 

----
## Usage

-   In order to activate the plugin you must:
    -   Activate result archiving of xml reports
    -   Activate ACI report publication of the xml summary reports

![](docs/images/configure.jpg)

----
## Examples

-   Result at project level:

![](docs/images/result_prj.jpg)

-   Same result at build page

![](docs/images/result_build.jpg)  
  

----
## Syntax Description

The Summary\_report Hudson plugin can parse XML report with this
structure:   
Only one section can be use in each XML file.

### Section

Sections are created using *\<section\> ... \</section\>* tags.  
Section attributes are:

-   **name**: section name
-   **fontcolor**: section font color

Example:

``` syntaxhighlighter-pre
<section name="Performance Summary" fontcolor="#ffffff">
</section>
```

### Field

Fields are created using *\<field\> ... \</field\>* tags.  
Fields attributes are:

-   **name**: field name
-   **value**: field value
-   **href**: HTTP link, relative to the project build. For instance, to
    access artifact dir, you can specify href="artifact/artifacts"
-   **titlecolor**: font color for the field title
-   **detailcolor**: font color for the field details
-   **\<!\[CDATA\[ \]\]\>**: the CDATA term is used about text data that
    should not be parsed by the XML parser.  
    Everything inside a CDATA section is ignored by the parser. It can
    be used to insert HTTP link given an absolute reference, as
    specified in the example below. 

    > Only one CDATA is parsed between start and end field tag

Example:

``` syntaxhighlighter-pre
<field name="Field Name To Display" titlecolor="black" value="My Field Value" detailcolor="#000000" href="artifacts/field.txt">
    <![CDATA[
        ....TEXT....
        <a href="http://....">Link to something</a>
        ...Some more text...
     ]]>
</field>
```

### Table

Tables are created using *\<table\> ... \</table\>* tags.  
Fields attributes are:

-   ***sorttable="yes"****:* Each column become sortableTable structure:
-   Lines are created using *\<tr\>...\</tr\>* tags.
-   Column are created using *\<td\>...\</td\>* tags.

The number of column must be identical  in each line.

Attributes of a cell are:

-   **title**:\* \*The text to show when the cursor is over the table
    cell.
-   **bgcolor**: Cell background color.  
    Authorized values are: 
    -   red, 
    -   green, 
    -   black, 
    -   \#fffff....
-   **fontcolor**: Cell font color.  
    Authorized values are: 
    -   red,
    -   green, 
    -   black, 
    -   \#fffff....
-   **fontattribute**: Cell font attribute  
    Authorized values are:
    -   normal, 
    -   bold, 
    -   number between 100 and 900
-   **href**: Link, this link is relative from the artifact storage
    location.
-   **align**: The text alinment  
    Authorized values are:
    -   center, 
    -   left, 
    -   right, 
    -   justify
-   **width**: The width of the cell

Example:

``` syntaxhighlighter-pre
<table sorttable="yes">
        <tr>
                <td value="Table title" bgcolor="red" fontcolor="black" fontattribute="bold" href="report.xls" align="center" width="200"/>
                <td value="Column 1" bgcolor="white" fontcolor="black" fontattribute="normal" href="" align="center" width="200"/>
        </tr>
        <tr>
                <td value="Line 1" bgcolor="white" fontcolor="black" fontattribute="normal" href="" align="left" width="200"/>
                <td value="Value 1" bgcolor="white" fontcolor="black" fontattribute="normal" href="" align="none" width="200"/>
        </tr>
</table>
```

### Tabs

A tab set can contain a lot of tab. Tab sets are created using *\<tabs\>
... \</tabs\>* tags.

In a tab set, a tab is created using *\<tab\> ... \</tab\>* tags.

Tab attributes are:

-   **name**: Tab name

Content allowed for a tab:

-   field
-   table

> It's not possible to insert tabs or accordion.

Example:

``` syntaxhighlighter-pre
<tabs>
    <tab name="First tab">
        <field name="Build status" value="All target succeeded" />
        <field name="Functionnal status" value="Validation is Ok" />
    </tab>
    <tab name="Second tab">
        <table>
            <tr>
                <td value="Table title" bgcolor="red" fontcolor="black" fontattribute="bold" href="report.xls" align="center" width="200"/>
                <td value="Column 1" bgcolor="white" fontcolor="black" fontattribute="normal" href="" align="center" width="200"/>
            </tr>
            <tr>
                <td value="Line 1" bgcolor="white" fontcolor="black" fontattribute="normal" href="" align="left" width="200"/>
                <td value="Value 1" bgcolor="white" fontcolor="black" fontattribute="normal" href="" align="none" width="200"/>
            </tr>
        </table>
    </tab>
</tabs>
```

### Accordion.

Accordions are created using *\<accordion\> ... \</accordion\>* tags.  
Accordion* *attributes are:

-   **name**: Accordion name

Content allowed for nn accordion:

-   fields 
-   table.

> It's not possible to insert tabs or accordion.

### A Full Section Example

``` syntaxhighlighter-pre
<section name="" fontcolor="">
    // To display a field
    <field name="" titlecolor="" value="" detailcolor="" href=""> <![CDATA[  ]]> </field>

    // To display a table
    <table>
        <tr>
            <td value="" bgcolor="" fontcolor="" title="" fontattribute="" href="" align="" width=""/>
            <td value="" bgcolor="" fontcolor="" title="" fontattribute="" href="" align="" width=""/>
        </tr>
        <tr>
            <td value="" bgcolor="" fontcolor="" title="" fontattribute="" href="" align="" width=""/>
            <td value="" bgcolor="" fontcolor="" title="" fontattribute="" href="" align="" width=""/>
        </tr>
    </table>

    // To display tabs
    <tabs>
        <tab name="">
        // Only insert table or field in tab
        </tab>
        <tab name="">
        // Only insert table or field in tab
        </tab>
    </tabs>

    // To display an accordion
    <accordion name="">
    // Only insert table or field in tab
    </accordion>
</section

----
## License

All source code is licensed under the [MIT license](LICENSE)
