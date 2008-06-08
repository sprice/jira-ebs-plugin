package com.ikeen.jira.plugin.report.ebs.ebsreport;

import com.atlassian.jira.plugin.report.impl.AbstractReport;
import com.atlassian.jira.util.ParameterUtils;
import com.atlassian.jira.web.action.ProjectActionSupport;

import java.util.*;

public class EbsReport extends AbstractReport
{
    public String generateReportHtml(ProjectActionSupport action, Map params) throws Exception
    {
        Map velocityParams = new HashMap();
        velocityParams.put("message", "Hello, world!");

        return descriptor.getHtml("view", velocityParams);
    }
       
    public void validate(ProjectActionSupport action, Map params)
    {
        Long versionId = ParameterUtils.getLongParam(params, "versionId");

        if (versionId == null)
            action.addError("projectid", action.getText("report.ebsreport.projectid.invalid"));
    }
}
