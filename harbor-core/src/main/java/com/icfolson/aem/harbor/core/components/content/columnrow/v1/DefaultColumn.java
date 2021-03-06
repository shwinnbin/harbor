package com.icfolson.aem.harbor.core.components.content.columnrow.v1;

import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Option;
import com.citytechinc.cq.component.annotations.widgets.Selection;
import com.google.common.collect.Lists;
import com.icfolson.aem.harbor.api.components.content.columnrow.Column;
import com.icfolson.aem.harbor.api.components.content.columnrow.ParagraphSystemColumn;
import com.icfolson.aem.harbor.api.components.mixins.paragraphsystem.ParagraphSystemContainer;
import com.icfolson.aem.harbor.api.constants.bootstrap.Bootstrap;
import com.icfolson.aem.harbor.api.components.mixins.classifiable.Classification;
import com.icfolson.aem.harbor.core.components.mixins.classifiable.TagBasedClassification;
import com.icfolson.aem.harbor.core.util.ComponentUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;

import javax.inject.Inject;
import java.util.List;

@Model(adaptables = Resource.class,
        adapters = {Column.class, ParagraphSystemColumn.class, ParagraphSystemContainer.class},
        resourceType = DefaultColumn.RESOURCE_TYPE)
public class DefaultColumn implements ParagraphSystemColumn {

    public static final String RESOURCE_TYPE = "harbor/components/content/columnrow/v1/column";

    public static final String DEFAULT_VALUE = "default";

    @Inject @Default(values = DEFAULT_VALUE)
    private String xsSize;

    @Inject @Default(values = DEFAULT_VALUE)
    private String smSize;

    @Inject @Default(values = DEFAULT_VALUE)
    private String mdSize;

    @Inject @Default(values = DEFAULT_VALUE)
    private String lgSize;

    @Inject @Default(values = DEFAULT_VALUE)
    private String mdOrdering;

    @Inject @Self
    private Resource resource;

    public Resource getResource() {
        return resource;
    }

    public String getName() { return getResource().getName(); }

    public String getPath() {
        return getResource().getPath();
    }

    public String getType() {
        return getResource().getResourceType();
    }

    public String getColumnWidthClasses() {
        List<String> colSizes = Lists.newArrayList();

        if (!DEFAULT_VALUE.equals(getXsSize())) {
            colSizes.add(getXsSize());
        }
        if (!DEFAULT_VALUE.equals(getSmSize())) {
            colSizes.add(getSmSize());
        }
        if (!DEFAULT_VALUE.equals(getMdSize())) {
            colSizes.add(getMdSize());
        }
        if (!DEFAULT_VALUE.equals(getLgSize())) {
            colSizes.add(getLgSize());
        }
        if (!DEFAULT_VALUE.equals(getMdOrdering())) {
            colSizes.add(getMdOrdering());
        }

        if (colSizes.isEmpty()) {
            colSizes.add(Bootstrap.GRID_MEDIUM + "1");
        }

        return StringUtils.join(colSizes, " ");
    }

    public Classification getClassification() {
        return getResource().adaptTo(TagBasedClassification.class);
    }

    public String getId() {
        return ComponentUtils.DomIdForResourcePath(getResource().getPath());
    }

    @Override
    public String getParagraphSystemType() {
        return ParagraphSystemContainer.PARSYS;
    }

    @DialogField(fieldLabel = "Extra Small Device Width", ranking = 0)
    @Selection(type = Selection.SELECT, options = {
            @Option(text = "Default", value = DEFAULT_VALUE),
            @Option(text = "1/12", value = Bootstrap.GRID_EXTRA_SMALL + "1"),
            @Option(text = "2/12", value = Bootstrap.GRID_EXTRA_SMALL + "2"),
            @Option(text = "3/12", value = Bootstrap.GRID_EXTRA_SMALL + "3"),
            @Option(text = "4/12", value = Bootstrap.GRID_EXTRA_SMALL + "4"),
            @Option(text = "5/12", value = Bootstrap.GRID_EXTRA_SMALL + "5"),
            @Option(text = "6/12", value = Bootstrap.GRID_EXTRA_SMALL + "6"),
            @Option(text = "7/12", value = Bootstrap.GRID_EXTRA_SMALL + "7"),
            @Option(text = "8/12", value = Bootstrap.GRID_EXTRA_SMALL + "8"),
            @Option(text = "9/12", value = Bootstrap.GRID_EXTRA_SMALL + "9"),
            @Option(text = "10/12", value = Bootstrap.GRID_EXTRA_SMALL + "10"),
            @Option(text = "11/12", value = Bootstrap.GRID_EXTRA_SMALL + "11"),
            @Option(text = "12/12", value = Bootstrap.GRID_EXTRA_SMALL + "12")
    })
    public String getXsSize() {
        return xsSize;
    }

    @DialogField(fieldLabel = "Small Device Width", ranking = 10)
    @Selection(type = Selection.SELECT, options = {
            @Option(text = "Default", value = DEFAULT_VALUE),
            @Option(text = "1/12", value = Bootstrap.GRID_SMALL + "1"),
            @Option(text = "2/12", value = Bootstrap.GRID_SMALL + "2"),
            @Option(text = "3/12", value = Bootstrap.GRID_SMALL + "3"),
            @Option(text = "4/12", value = Bootstrap.GRID_SMALL + "4"),
            @Option(text = "5/12", value = Bootstrap.GRID_SMALL + "5"),
            @Option(text = "6/12", value = Bootstrap.GRID_SMALL + "6"),
            @Option(text = "7/12", value = Bootstrap.GRID_SMALL + "7"),
            @Option(text = "8/12", value = Bootstrap.GRID_SMALL + "8"),
            @Option(text = "9/12", value = Bootstrap.GRID_SMALL + "9"),
            @Option(text = "10/12", value = Bootstrap.GRID_SMALL + "10"),
            @Option(text = "11/12", value = Bootstrap.GRID_SMALL + "11"),
            @Option(text = "12/12", value = Bootstrap.GRID_SMALL + "12")
    })
    public String getSmSize() {
        return smSize;
    }

    @DialogField(fieldLabel = "Medium Device Width", ranking = 20)
    @Selection(type = Selection.SELECT, options = {
            @Option(text = "Default", value = DEFAULT_VALUE),
            @Option(text = "1/12", value = Bootstrap.GRID_MEDIUM + "1"),
            @Option(text = "2/12", value = Bootstrap.GRID_MEDIUM + "2"),
            @Option(text = "3/12", value = Bootstrap.GRID_MEDIUM + "3"),
            @Option(text = "4/12", value = Bootstrap.GRID_MEDIUM + "4"),
            @Option(text = "5/12", value = Bootstrap.GRID_MEDIUM + "5"),
            @Option(text = "6/12", value = Bootstrap.GRID_MEDIUM + "6"),
            @Option(text = "7/12", value = Bootstrap.GRID_MEDIUM + "7"),
            @Option(text = "8/12", value = Bootstrap.GRID_MEDIUM + "8"),
            @Option(text = "9/12", value = Bootstrap.GRID_MEDIUM + "9"),
            @Option(text = "10/12", value = Bootstrap.GRID_MEDIUM + "10"),
            @Option(text = "11/12", value = Bootstrap.GRID_MEDIUM + "11"),
            @Option(text = "12/12", value = Bootstrap.GRID_MEDIUM + "12")
    })
    public String getMdSize() {
        return mdSize;
    }

    @DialogField(fieldLabel = "Large Device Width", ranking = 30)
    @Selection(type = Selection.SELECT, options = {
            @Option(text = "Default", value = DEFAULT_VALUE),
            @Option(text = "1/12", value = Bootstrap.GRID_LARGE + "1"),
            @Option(text = "2/12", value = Bootstrap.GRID_LARGE + "2"),
            @Option(text = "3/12", value = Bootstrap.GRID_LARGE + "3"),
            @Option(text = "4/12", value = Bootstrap.GRID_LARGE + "4"),
            @Option(text = "5/12", value = Bootstrap.GRID_LARGE + "5"),
            @Option(text = "6/12", value = Bootstrap.GRID_LARGE + "6"),
            @Option(text = "7/12", value = Bootstrap.GRID_LARGE + "7"),
            @Option(text = "8/12", value = Bootstrap.GRID_LARGE + "8"),
            @Option(text = "9/12", value = Bootstrap.GRID_LARGE + "9"),
            @Option(text = "10/12", value = Bootstrap.GRID_LARGE + "10"),
            @Option(text = "11/12", value = Bootstrap.GRID_LARGE + "11"),
            @Option(text = "12/12", value = Bootstrap.GRID_LARGE + "12")
    })
    public String getLgSize() {
        return lgSize;
    }

    @DialogField(fieldLabel = "Ordering", ranking = 35)
    @Selection(type = Selection.SELECT, options = {
            @Option(text = "Default", value = DEFAULT_VALUE),
            @Option(text = "Push 1", value = Bootstrap.GRID_MEDIUM + "push-1"),
            @Option(text = "Push 2", value = Bootstrap.GRID_MEDIUM + "push-2"),
            @Option(text = "Push 3", value = Bootstrap.GRID_MEDIUM + "push-3"),
            @Option(text = "Push 4", value = Bootstrap.GRID_MEDIUM + "push-4"),
            @Option(text = "Push 5", value = Bootstrap.GRID_MEDIUM + "push-5"),
            @Option(text = "Push 6", value = Bootstrap.GRID_MEDIUM + "push-6"),
            @Option(text = "Push 7", value = Bootstrap.GRID_MEDIUM + "push-7"),
            @Option(text = "Push 8", value = Bootstrap.GRID_MEDIUM + "push-8"),
            @Option(text = "Push 9", value = Bootstrap.GRID_MEDIUM + "push-9"),
            @Option(text = "Push 10", value = Bootstrap.GRID_MEDIUM + "push-10"),
            @Option(text = "Push 11", value = Bootstrap.GRID_MEDIUM + "push-11"),
            @Option(text = "Pull 1", value = Bootstrap.GRID_MEDIUM + "pull-1"),
            @Option(text = "Pull 2", value = Bootstrap.GRID_MEDIUM + "pull-2"),
            @Option(text = "Pull 3", value = Bootstrap.GRID_MEDIUM + "pull-3"),
            @Option(text = "Pull 4", value = Bootstrap.GRID_MEDIUM + "pull-4"),
            @Option(text = "Pull 5", value = Bootstrap.GRID_MEDIUM + "pull-5"),
            @Option(text = "Pull 6", value = Bootstrap.GRID_MEDIUM + "pull-6"),
            @Option(text = "Pull 7", value = Bootstrap.GRID_MEDIUM + "pull-7"),
            @Option(text = "Pull 8", value = Bootstrap.GRID_MEDIUM + "pull-8"),
            @Option(text = "Pull 9", value = Bootstrap.GRID_MEDIUM + "pull-9"),
            @Option(text = "Pull 10", value = Bootstrap.GRID_MEDIUM + "pull-10"),
            @Option(text = "Pull 11", value = Bootstrap.GRID_MEDIUM + "pull-11"),
    })
    public String getMdOrdering() {
        return mdOrdering;
    }
}