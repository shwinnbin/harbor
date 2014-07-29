package com.citytechinc.cq.harbor.imperium.components.layout.columns;

import com.citytechinc.aem.imperium.proper.core.components.layout.AbstractLayoutComponent;
import com.citytechinc.cq.component.annotations.*;
import com.citytechinc.cq.component.annotations.widgets.DialogFieldSet;
import com.citytechinc.cq.component.annotations.widgets.Selection;
import com.citytechinc.cq.harbor.proper.core.components.mixins.classifiable.Classification;
import com.citytechinc.cq.library.components.annotations.AutoInstantiate;
import com.citytechinc.cq.library.content.node.ComponentNode;
import com.citytechinc.cq.library.content.request.ComponentRequest;

/**
 *
 * Note: Most of the properties germane to the .content.xml are excluded as a hand-crafted .content.xml exists under the component definition
 */
@Component(value = "Layout Column",
        actions = {"text:Column", "edit", "delete"},
        listeners = {
                @Listener(name = "afterdelete", value = "REFRESH_PARENT"),
                @Listener(name = "afteredit", value = "REFRESH_PARENT"),
        },
        name = "layoutcolumn",
        path = "layout",
        layout = "rollover"
)
@AutoInstantiate(instanceName="column")
public class Column extends AbstractLayoutComponent {

    private String colClass;
    private Classification classification;

    public Column(ComponentRequest request) {
        super(request);
    }

    public Column(ComponentNode componentNode, Boolean layoutMode) {
        super(componentNode, layoutMode);
    }

    @DialogField(fieldLabel = "Inherit Content?",
            fieldDescription = "Inherit column content from parent page.")
    @Selection(type=Selection.CHECKBOX, options = {
            @Option(text="", value = "true")
    })
    public Boolean getIsInherited(){

        return false;

    }

    @DialogField(fieldLabel = "Column Width",
            fieldDescription="The amount of the space in which the column row is contained which this column will occupy.")
    @Selection(type = Selection.SELECT, options = {
            @Option(text = "1/12", value = "1"),
            @Option(text = "2/12", value = "2"),
            @Option(text = "3/12", value = "3"),
            @Option(text = "4/12", value = "4"),
            @Option(text = "5/12", value = "5"),
            @Option(text = "6/12", value = "6"),
            @Option(text = "7/12", value = "7"),
            @Option(text = "8/12", value = "8"),
            @Option(text = "9/12", value = "9"),
            @Option(text = "10/12", value = "10"),
            @Option(text = "11/12", value = "11"),
            @Option(text = "12/12", value = "12")
    })
    public String getColClass() {

        if (colClass == null) {
            colClass = get("colClass", "1");
        }

        return colClass;

    }

    public String getName() {
        return getResource().getName();
    }

    @DialogField
    @DialogFieldSet
    public Classification getClassification() {

        if (classification == null) {
            classification = new Classification(getResource().adaptTo(ComponentNode.class));
        }

        return classification;

    }
}