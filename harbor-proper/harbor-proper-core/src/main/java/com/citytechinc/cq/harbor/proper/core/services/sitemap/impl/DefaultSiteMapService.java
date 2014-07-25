package com.citytechinc.cq.harbor.proper.core.services.sitemap.impl;

import com.citytechinc.cq.harbor.proper.core.services.sitemap.SiteMapService;
import com.citytechinc.cq.harbor.proper.core.services.sitemap.domain.SiteMap;
import com.citytechinc.cq.harbor.proper.core.services.sitemap.domain.SiteMapEntry;
import com.citytechinc.cq.library.content.page.PageDecorator;
import com.day.cq.commons.Externalizer;
import com.google.common.base.Predicate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Service
@Component(name="Dummy Page Service", label = "Dummy Page Service")
public class DefaultSiteMapService implements SiteMapService {
    protected static final Logger LOG = LoggerFactory.getLogger(DefaultSiteMapService.class);

    protected static final Predicate<PageDecorator> allMyChildrenPredicate = new Predicate<PageDecorator>() {
        @Override
        public boolean apply (PageDecorator pageDecorator){
            return true;
        }
    };

    protected static final String defaultLocSuffix = ".html";
    protected static final String iso8601DateFormat = "yyyy-MM-dd";
    protected static final String jcrAccelerateSitemapExtension = "accelerate:loc.extension";
    protected static final String jcrAccelerateSitemapChangeFrequency = "accelerate:changefreq";
    protected static final String jcrAccelerateSitemapPriority = "accelerate:priority";
    protected static final String jcrCqLastModified = "cq:lastModified";
    protected static final String jcrCreated = "jcr:created";


    @Reference
    Externalizer externalizer;


    @Override
    public SiteMap getSitemapEntryList(final ResourceResolver resourceResolver, final PageDecorator root) {
        final List<SiteMapEntry> siteMapEntries = newArrayList();

        final SiteMapEntry rootSiteMapEntry = this.buildSiteMapEntry(resourceResolver, root);
        siteMapEntries.add(rootSiteMapEntry);

        for(final PageDecorator pageDecorator : root.getChildren(allMyChildrenPredicate, true)) {
            final SiteMapEntry siteMapEntry = this.buildSiteMapEntry(resourceResolver, pageDecorator);
            siteMapEntries.add(siteMapEntry);
        }

        return this.newSiteMap(siteMapEntries);
    }

    protected SiteMapEntry buildSiteMapEntry(final ResourceResolver resourceResolver, final PageDecorator pageDecorator) {
        final Resource contentResource = pageDecorator.getContentResource();
        final ValueMap contentResourceValueMap = contentResource.adaptTo(ValueMap.class);
        final String loc = this.determineLoc(resourceResolver, pageDecorator, contentResourceValueMap);
        final String lastModified = this.determineLastModified(contentResourceValueMap);
        final String changeFrequency = contentResourceValueMap.get(jcrAccelerateSitemapChangeFrequency, null);
        final String urlPriority = contentResourceValueMap.get(jcrAccelerateSitemapPriority, null);
        final SiteMapEntry siteMapEntry = this.newSiteMapEntry(loc, lastModified, changeFrequency, urlPriority);

        return siteMapEntry;
    }

    protected String determineLoc(final ResourceResolver resourceResolver, final PageDecorator pageDecorator, final ValueMap pageContentValueMap) {
        final String externalPublishLink = externalizer.publishLink(resourceResolver, pageDecorator.getPath());
        final String extension = pageContentValueMap.get(jcrAccelerateSitemapExtension, defaultLocSuffix);
        final StringBuffer locBuffer = this.newStringBuffer(externalPublishLink).append(extension);

        return locBuffer.toString();
    }

    protected String determineLastModified(final ValueMap pageContentValueMap) {
        final GregorianCalendar lastModified =
            (GregorianCalendar)pageContentValueMap.get(jcrCqLastModified, pageContentValueMap.get(jcrCreated));

        if(null == lastModified) {
            return null;
        }else {
            final SimpleDateFormat iso8601SimpleDateFormat = this.newIso8601SimpleDateFormat();
            return iso8601SimpleDateFormat.format(lastModified.getTime());
        }
    }

    protected SiteMap newSiteMap(final List<SiteMapEntry> siteMapEntries) {
        return new SiteMap(siteMapEntries);
    }

    protected SiteMapEntry newSiteMapEntry(final String loc, final String lastModified, final String changeFrequency, final String urlPriority) {
        return new SiteMapEntry(loc, lastModified, changeFrequency, urlPriority);
    }

    protected StringBuffer newStringBuffer(final String source) {
        return new StringBuffer(source);
    }

    protected SimpleDateFormat newIso8601SimpleDateFormat() {
        return new SimpleDateFormat(iso8601DateFormat);
    }


}
