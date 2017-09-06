package com.icfolson.aem.harbor.core.components.content.list.dynamic.items.v1;

import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.widgets.PathField;
import com.citytechinc.cq.component.annotations.widgets.TextField;
import com.icfolson.aem.harbor.api.components.content.list.dynamic.DynamicListItem;
import com.icfolson.aem.harbor.api.components.content.list.dynamic.items.LinkItem;
import com.icfolson.aem.harbor.api.components.content.list.dynamic.items.PageLinkItem;
import com.icfolson.aem.library.api.page.PageDecorator;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.Self;

import javax.inject.Inject;

@Model(adaptables = Resource.class, adapters = {PageLinkItem.class, LinkItem.class, DynamicListItem.class}, resourceType = DefaultPageLinkItem.RESOURCE_TYPE)
public class DefaultPageLinkItem implements PageLinkItem {

    public static final String RESOURCE_TYPE = "harbor/components/content/lists/dynamiclist/items/pagelinkitem/v1/pagelinkitem";

    @Inject @Optional
    private PageDecorator linkedPage;

    @Inject @Optional
    private String label;

    @Inject @Self
    private Resource resource;

    @DialogField(fieldLabel = "Linked Page", name = "./linkedPage") @PathField
    public String getUrl() {
        return linkedPage.getHref();
    }

    @DialogField(fieldLabel = "Label") @TextField
    public String getLabel() {
        if (StringUtils.isNotBlank(label)) {
            return label;
        }

        if (linkedPage != null) {
            if (StringUtils.isNotBlank(linkedPage.getPageTitle())) {
                return linkedPage.getPageTitle();
            }

            return linkedPage.getTitle();
        }

        return StringUtils.EMPTY;
    }

    @Override
    public String getPath() {
        return resource.getPath();
    }

    @Override
    public String getType() {
        return resource.getResourceType();
    }
}
