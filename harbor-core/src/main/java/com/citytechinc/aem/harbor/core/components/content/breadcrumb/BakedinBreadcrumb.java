package com.citytechinc.aem.harbor.core.components.content.breadcrumb;

import com.citytechinc.aem.bedrock.api.components.annotations.AutoInstantiate;
import com.citytechinc.cq.component.annotations.Component;

@Component(
        value = "Bakedin Breadcrumb",
        group = ".hidden",
        resourceSuperType = Breadcrumb.RESOURCE_TYPE,
        disableTargeting = true,
        actions = { "text: Breadcrumb", "-", "edit" })
@AutoInstantiate(instanceName = "breadcrumb")
public class BakedinBreadcrumb extends Breadcrumb {

    public static final String RESOURCE_TYPE = "harbor/components/content/bakedinbreadcrumb";

}
