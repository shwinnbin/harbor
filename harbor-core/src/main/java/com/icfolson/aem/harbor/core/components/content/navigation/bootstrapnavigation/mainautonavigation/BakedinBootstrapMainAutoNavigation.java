package com.icfolson.aem.harbor.core.components.content.navigation.bootstrapnavigation.mainautonavigation;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.Tab;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

@Component(
    value = "Bakedin Bootstrap Main Auto Navigation",
    group = ".hidden",
    path = "content/navigation",
    resourceSuperType = BootstrapMainAutoNavigation.RESOURCE_TYPE,
    disableTargeting = true,
    actions = { "text: Main Auto Navigation", "-", "edit" },
    tabs = {
            @Tab(title = "Main Auto Navigation", touchUINodeName = BootstrapMainAutoNavigation.TAB_1_NODE_NAME)
    })
@Model(adaptables = Resource.class)
public class BakedinBootstrapMainAutoNavigation extends BootstrapMainAutoNavigation {

    public static final String RESOURCE_TYPE = "harbor/components/content/navigation/bakedinbootstrapmainautonavigation";

}