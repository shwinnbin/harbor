# Harbor 

Harbor is a sites development SDK for AEM Sites built on the key tenants of 

* Cohesion
* Semantics
* Extensibility

## Modules

Each module in Harbor expresses an aspect of Harbor and, to some extent, may 
be used in isolation from the other modules where useful.

### Harbor API

### Harbor Core

### Harbor UI

## Components

The following is a list of the componentry in Harbor along with links to the relevant 
documentation for each.  Keep in mind the word "Component" is used loosely here as, 
while the Harbor UI module defines Resource Types, Harbor does not define any 
components as AEM would define the term.  

The componentry is broken into groups from an organizational perspective.  This 
grouping does not dictate or affect how usages of the componentry at a project 
level group concrete component implementations.  

* Group: Harbor
  * [Heading (v1)](harbor-ui/src/main/content/jcr_root/apps/harbor/components/content/heading/v1/heading)
  * [Title (v1)](harbor-ui/src/main/content/jcr_root/apps/harbor/components/content/title/v1/title)
  * [Subtitle (v1)](harbor-ui/src/main/content/jcr_root/apps/harbor/components/content/subtitle/v1/subtitle)
  * [Text (v1)](harbor-ui/src/main/content/jcr_root/apps/harbor/components/content/text/v1/text)
  * [Call to Action (v1)](harbor-ui/src/main/content/jcr_root/apps/harbor/components/content/calltoaction/v1/calltoaction)
  * [HTML (v1)](harbor-ui/src/main/content/jcr_root/apps/harbor/components/content/html/v1/html)
* Group: Harbor Scaffolding
  * [Content Container (v1)](harbor-ui/src/main/content/jcr_root/apps/harbor/components/content/contentcontainer/v1/contentcontainer)
  * [Page Header (v1)](harbor-ui/src/main/content/jcr_root/apps/harbor/components/content/pageheader/v1/pageheader)
  * [Page Footer (v1)](harbor-ui/src/main/content/jcr_root/apps/harbor/components/content/pagefooter/v1/pagefooter)
  * [Column Row (v1)](harbor-ui/src/main/content/jcr_root/apps/harbor/components/content/columnrow/v1/columnrow)
    * [Column (v1)](harbor-ui/src/main/content/jcr_root/apps/harbor/components/content/columnrow/v1/column)
  * [Accordion (v1)](harbor-ui/src/main/content/jcr_root/apps/harbor/components/content/accordion/v1/accordion)
    * [Accordion Item (v1)](harbor-ui/src/main/content/jcr_root/apps/harbor/components/content/accordion/v1/accordionitem)
  * [Dynamic Accordion (v1)](harbor-ui/src/main/content/jcr_root/apps/harbor/components/content/dynamicaccordion/v1/dynamicaccordion)
    * [Parsys Accordion Item (v1)](harbor-ui/src/main/content/jcr_root/apps/harbor/components/content/dynamicaccordion/items/parsysaccordionitem/v1/parsysaccordionitem)
  * [Tabs (v1)](harbor-ui/src/main/content/jcr_root/apps/harbor/components/content/tabs/v1/tabs)
    * [Tab (v1)](harbor-ui/src/main/content/jcr_root/apps/harbor/components/content/tabs/v1/tab)
  * [Dynamic Tabs (v1)](harbor-ui/src/main/content/jcr_root/apps/harbor/components/content/dynamictabs/v1/dynamictabs)
    * [Parsys Tab (v1)](harbor-ui/src/main/content/jcr_root/apps/harbor/components/content/dynamictabs/tabs/parsystab/v1/parsystab)
  * [Carousel (v1)](harbor-ui/src/main/content/jcr_root/apps/harbor/components/content/carousel/v1/carousel)
  * [Dynamic Carousel (v1)](harbor-ui/src/main/content/jcr_root/apps/harbor/components/content/dynamiccarousel/v1/dynamiccarousel)
    * [Parsys Slide (v1)](harbor-ui/src/main/content/jcr_root/apps/harbor/components/content/dynamiccarousel/slides/parsysslide/v1/parsysslide)
* Group: Harbor Lists
  * [Link List (v1)](harbor-ui/src/main/content/jcr_root/apps/harbor/components/content/lists/linklist/v1/linklist)
  * [Dynamic List (v1)](harbor-ui/src/main/content/jcr_root/apps/harbor/components/content/lists/dynamiclist/v1/dynamiclist)
  * [Abstract Automated List (v1)](harbor-ui/src/main/content/jcr_root/apps/harbor/components/content/lists/automatedlist/v1/automatedlist)
  * [Child Page List (v1)](harbor-ui/src/main/content/jcr_root/apps/harbor/components/content/lists/childpagelist/v1/childpagelist)
* Group: Harbor Navigation
  * [Navigable Page Tree (v1)](harbor-ui/src/main/content/jcr_root/apps/harbor/components/content/navigation/navigablepagetree/v1/navigablepagetree)
  * [Primary Navigation (v1)](harbor-ui/src/main/content/jcr_root/apps/harbor/components/content/navigation/primarynavigation/v1/primarynavigation)
  * [Section Navigation (v1)](harbor-ui/src/main/content/jcr_root/apps/harbor/components/content/navigation/sectionnavigation/v1/sectionnavigation)
  * [Bootstrap Primary Navigation (v1)](harbor-ui/src/main/content/jcr_root/apps/harbor/components/content/navigation/bootstrapnavigation/bootstrapprimarynavigation/v1/bootstrapprimarynavigation)
  * [Bootstrap Primary Navbar (v1)](harbor-ui/src/main/content/jcr_root/apps/harbor/components/content/navigation/bootstrapnavigation/bootstrapprimarynavbar/v1/bootstrapprimarynavbar)
  * [Bootstrap Section Navigation (v1)](harbor-ui/src/main/content/jcr_root/apps/harbor/components/content/navigation/bootstrapnavigation/bootstrapsectionnavigation/v1/bootstrapsectionnavigation)
  * [Bootstrap Brand (v1)](harbor-ui/src/main/content/jcr_root/apps/harbor/components/content/navigation/brand/bootstrapbrand/v1/bootstrapbrand)
  * [Breadcrumb Navigation (v1)](harbor-ui/src/main/content/jcr_root/apps/harbor/components/content/breadcrumbnavigation/v1/breadcrumbnavigation)
* Page
  * [Global (v1)](harbor-ui/src/main/content/jcr_root/apps/harbor/components/page/global/v1/global)


## --- NOTE - Old Documentation Below This Point ---

All documentation below this point is from the 2.x versions of Harbor and has not 
yet been reviewed for accuracy on the 3.x version. 

## Core Concepts

### End User Core Concepts

#### Containers

Many of the elements of Bootstrap require placement within a Container.  In Harbor there are numerous Container Components which produce such a Container suitable for placing other components within.  These are identified by the `Container` demarcation in the documentation.  

For example, the Content Container Component is a basic Container.

General information about Containers in Bootstrap can be found [in the Bootstrap Container documentation](http://getbootstrap.com/css/#overview-container).

#### Classification

Many components in Harbor are "Classifiable".  This allows for the application of semantics to an 
otherwise general component.  For example, if you are producing a recipe, you might classify your 
Container component using a `Recipe` tag.  Systematically, for most components, this classification 
simply applies an additional class attribute to the rendered HTML for the component which allows 
for extended usage such as targeting of styles or unique indexability.

Classifications are always authored as Tags.

#### Dynamics

A common authoring pattern is the creation of lists or sets of things which may 
have disparate natures.  Take for example a list.  An author may want to create 
a list which contains

* Simple text items
* Some links to external sites
* Some links to internal pages
* Some more complex links which show both a title and a thumbnail of the item linked to

Components in the Harbor Dynamics family enable this pattern by exposing a means 
to select the type of item you are going to add to a set or list.  

Returning to the example of a list, the Dynamic List component OOB gives authors 
the ability to choose whether they want to create an external link item, an 
internal link item, or a text item, each time they add a new item to the list. 
This mechanism is also extensible at a project level giving your developers the 
ability to add new types of list items. 

The Harbor Dynamics component family currently consists of 

* Dynamic List
* Dynamic Tabs 
* Dynamic Carousel 
* Dynamic Accordion (still under development)

### Developer Core Concepts

#### Namespace

Numerous properties with consistent semantics unique to Harbor are namespaced under the `icf` namespace deployed by 
the included `com.icfolson.aem.namespace:aem-namespace-extension` module.  This module also exposes String constants 
for notable properties, namespace prefixes, and URIs.  A key element of cohesion across Harbor is the use of consistent 
semantics in the creation of a data space defining the content presentation Harbor affords within AEM.  

##### Page Types

The ICF namespace defines four types of pages:

* Home Page `icf:HomePage`
* Section Landing Page `icf:SectionLandingPage`
* Structural Page `icf:StructuralPage`
* Content Page (any page which is not one of the above)

A Page is defined to be of a type if it has a jcr:mixinType value of one of the above.  For example, a 
page with jcr:mixinType `icf:HomePage` is a home page.  

Any Page may be adapted to a `HierarchicalPage` which exposes methods for finding the containing 
Home Page and Section Landing Page.  Similarly any page may be adapted to a `HomePage` or `SectionLandingPage`.  
These later adaptations will only succeed if the page under adaptation is in fact a Home Page or 
Section Landing Page respectively.

Numerous components leverage these Page Type semantics.  Most notably are the navigational components which 
know how to construct a relevant navigation starting from either a containing Home Page or Section Landing Page. 

###### Home Page

A Home Page is intended to be the root page for a site.  Home Pages may be nested under other Home Pages 
supporting use cases such as one main site housing numerous micro sites.

###### Section Landing Page

Sites are often broken into large sections with unique purpose.  The Section Landing Page represents the 
root of a major section of a site.  For example, a site may be broken up into "Products", "Services", and "About Us". 
Each of these sections would be rooted by a Section Landing Page which would inform the behavior of the 
components used within the sections.  For instance, a secondary navigation specific to Products can be 
automatically generated specifically for the site section based on the semantics of the Section Landing Page. 

Section Landing Pages may be nested arbitrarily. 

###### Structural Page

A Structural Page is one which is not intended to be navigated to by an end user.  Such pages may serve a 
number of purposes such as serving as path place holders, country/language pages, etc.  Structural pages 
to not show up in navigations or other page listings of that type.  

###### Content Page

A Content Page is any page which is not a Home Page, a Section Landing Page, or a Structural Page.  There is 
no separate mixin type for Content Page. 

###### Page Types in Template Definitions

Page templates must define their respective page types on the `jcr:content` template node.  The following is 
an example template definition for a Home Page

```xml
<?xml version="1.0" encoding="UTF-8"?>
<jcr:root xmlns:sling="http://sling.apache.org/jcr/sling/1.0"
          xmlns:cq="http://www.day.com/jcr/cq/1.0"
          xmlns:jcr="http://www.jcp.org/jcr/1.0"
          xmlns:icf="http://www.icfolson.com/ns/aem/"
          jcr:primaryType="cq:Template"
          jcr:title="Project Harbor Home Page"
          allowedPaths="/content(/.*)?"
          ranking="0">
    <jcr:content
            jcr:primaryType="cq:PageContent"
            cq:designPath="/etc/designs/project-name"
            jcr:mixinTypes="[icf:HomePage]"
            sling:resourceType="project-name/components/page/homepage"/>
</jcr:root>
```

#### Lists

The functionality of many of the Components created for a particular project can be distilled down to the presentation of a List of items.  Lists therefore are central to Harbor and enabled by Interfaces and Abstract Classes suggesting a pattern to follow in List Component development.

List Components are a composition of a List Construction Strategy and a List Rendering Strategy.  The List Construction Strategy is responsible for the creation of a list of items based on the logic of the strategy.  These items are passed to the List Rendering Strategy which has an opportunity to add additional properties germane to the rendering of a particular component.  Construction and Rendering Strategies may be mixed and matched within the context of concrete List Component implementations allowing reuse of both across multiple component types.

TODO: Insert example of reuse from the various page listing components

TODO: Link to Javadocs where appropriate

#### Trees

Similar to Lists, Trees pair a Construction Strategy with a Rendering Strategy allowing for reusability and extention via composition.

A Tree has a single TreeNode instance as its root.  A TreeNode may in turn have any number of child TreeNodes of the same type.

Tree Components are in turn components which intend to manage a Tree data structure's construction and presentation.

TODO: Link to Javadocs where appropriate

#### Classification

Components are Classifiable if they contain an `icf:classification` input which is of type Tag Field. 
What a component does with the classification is up to the needs and requirements of the component. 
For all current Harbor components, classification causes additional class attributes to be written 
to the rendered HTML of the component.  This allows for the application of style and functionality 
to sections of a site without the need to built numerous custom components.  For example, a Recipe 
component could be made up of a Content Container with an appropriate classification.  Anything 
under that container then is semantically considered to be part of the recipe.  It may be appropriate 
to further classify child elements such as Recipe Step or Ingredient depending on the granular 
needs of the site and system.

Classifiability is implemented via the `com.icfolson.aem.harbor.core.components.mixins.classifiable.Classification` 
Component class and it's inheriting counterpart `com.icfolson.aem.harbor.core.components.mixins.classifiable.InheritedClassification`.
These are intended to be added as sub-components of classifiable components.  An example of such usage is the 
`com.icfolson.aem.harbor.core.components.content.columns` class. It includes Classification as a Dialog Field Set and an 
injected component

```
    @DialogField(tab = 1, ranking = 40) @DialogFieldSet
    @Self @Optional
    private Classification classification;
```

It then uses Classification's `classNames()` method to output a space delimited set of class names in the accompanying Sightly. 



