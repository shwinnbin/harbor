package com.citytechinc.cq.harbor.proper.core.components.content.list;

import com.citytechinc.cq.harbor.proper.api.lists.RootedItems;
import com.citytechinc.cq.harbor.proper.api.lists.construction.RootedListConstructionStrategy;
import com.citytechinc.cq.harbor.proper.api.lists.rendering.RootedListRenderingStrategy;
import com.citytechinc.cq.library.components.AbstractComponent;
import com.citytechinc.cq.library.content.node.ComponentNode;
import com.citytechinc.cq.library.content.request.ComponentRequest;
import com.google.common.base.Optional;

public abstract class AbstractRootedListComponent <T extends RootedItems, R extends RootedItems> extends AbstractComponent implements RootedListComponent<R> {

    private Optional<R> renderableItemsOptional;
    private Optional<T> rawItemsOptional;

    public AbstractRootedListComponent(ComponentRequest request) {
        super(request);
    }

    public AbstractRootedListComponent(ComponentNode node) {
        super(node);
    }

    protected abstract RootedListConstructionStrategy<T> getListConstructionStrategy();

    protected abstract RootedListRenderingStrategy<T, R> getListRenderingStrategy();

    @Override
    public R getRoot() {
        if (renderableItemsOptional == null) {

            Optional<T> requestedRawItemsOptional = getRawItemsOptional();

            if (requestedRawItemsOptional.isPresent()) {
                renderableItemsOptional = Optional.of(getListRenderingStrategy().toRenderableList(requestedRawItemsOptional.get()));
            }
            else {
                renderableItemsOptional = Optional.absent();
            }
        }

        return renderableItemsOptional.get();
    }

    @Override
    public boolean getHasRoot() {
        return getListConstructionStrategy().construct().isPresent();
    }

    protected Optional<T> getRawItemsOptional() {
        if (rawItemsOptional == null) {
            rawItemsOptional = getListConstructionStrategy().construct();
        }

        return rawItemsOptional;
    }

}