package com.citytechinc.aem.harbor.core.components.content.container;

import com.citytechinc.aem.bedrock.api.components.annotations.AutoInstantiate;
import com.citytechinc.aem.bedrock.api.page.PageDecorator;
import com.citytechinc.aem.bedrock.core.components.AbstractComponent;
import com.citytechinc.aem.harbor.core.components.mixins.classifiable.InheritedClassification;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Option;
import com.citytechinc.cq.component.annotations.Tab;
import com.citytechinc.cq.component.annotations.widgets.DialogFieldSet;
import com.citytechinc.cq.component.annotations.widgets.Selection;
import com.citytechinc.aem.harbor.api.constants.bootstrap.Bootstrap;
import com.citytechinc.aem.harbor.api.constants.dom.Elements;
import com.citytechinc.aem.harbor.core.components.mixins.classifiable.Classification;
import com.citytechinc.aem.harbor.core.constants.groups.ComponentGroups;
import com.google.common.base.Optional;
import org.apache.commons.lang3.StringUtils;

@Component(
		value = "Container",
		description = "A container in which content may be placed.  All content should be placed in a container element.",
		name = "contentcontainer",
		group = ComponentGroups.HARBOR_SCAFFOLDING,
		tabs = {
				@Tab(title = "Container"),
				@Tab(title = "Advanced")
		})
@AutoInstantiate(instanceName = Container.INSTANCE_NAME)
public class Container extends AbstractComponent {

	private Classification classification;

	public static final String RESOURCE_TYPE = "harbor/components/content/contentcontainer";
	public static final String INSTANCE_NAME = "contentContainer";

	public static final String FULL_WIDTH_PROPERTY = "fullWidth";

	@DialogField(fieldLabel = "Full Width", fieldDescription = "When set to true, the container will render across the full width of the browser window", name = "./" + FULL_WIDTH_PROPERTY)
	@Selection(options = { @Option(text = "true", value = "true") }, type = Selection.CHECKBOX)
	public Boolean getIsContainerFullWidth() {
        if (isInherits()) {
            return getInherited(FULL_WIDTH_PROPERTY, false);
        }
		return get(FULL_WIDTH_PROPERTY, false);
	}

	@DialogField
	@DialogFieldSet
	public Classification getClassification() {
		if (classification == null) {
            if (isInherits()) {
                classification = getComponent(this, InheritedClassification.class);
            }
            else {
                classification = getComponent(this, Classification.class);
            }
		}

		return classification;
	}

	public String getContainerClass() {

		StringBuilder classStringBuffer = new StringBuilder();

		if (getIsContainerFullWidth()) {
			classStringBuffer.append(getContainerFullWidthClass());
		} else {
			classStringBuffer.append(getContainerDefaultClass());
		}

        if (!isSection()) {
            if (getClassification().getHasClassifications()) {
                classStringBuffer.append(" ").append(StringUtils.join(getClassification().getClassificationNames(), " "));
            }
        }

		return classStringBuffer.toString();

	}

    public String getSectionClass() {

        if (isSection()) {
            if (getClassification().getHasClassifications()) {
                return StringUtils.join(getClassification().getClassificationNames(), " ");
            }
        }

        return StringUtils.EMPTY;

    }

	public String getContainerElement() {
		return Elements.DIV;
	}

	public Optional<String> getRoleOptional() {
		return Optional.absent();
	}

	public Boolean getHasRole() {
		return getRoleOptional().isPresent();
	}

	public String getRole() {
		return getRoleOptional().get();
	}

    /**
     * Indicates whether instances of this container constitute a Section of content on a page.
     * Defaults to true.
     *
     * @return true if the container constitutes a Section of content on a page.
     */
    public boolean isSection() {
        return true;
    }

	@DialogField(
			fieldLabel = "ID",
			fieldDescription = "A unique identifier to apply to the Container element rendered in the page DOM.  If left blank, no id attribute will be applied to the rendered element.",
			tab = 2)
	public String getDomId() {
        if (isInherits()) {
            return getInherited("domId", StringUtils.EMPTY);
        }
		return get("domId", StringUtils.EMPTY);
	}

	public boolean isHasDomId() {
		return StringUtils.isNotBlank(getDomId());
	}

	protected String getContainerFullWidthClass() {
		return Bootstrap.CONTAINER_FULL_WIDTH_CLASS;
	}

	protected String getContainerDefaultClass() {
		return Bootstrap.CONTAINER_CLASS;
	}

	protected boolean isInherits() {
        return false;
    }
}
