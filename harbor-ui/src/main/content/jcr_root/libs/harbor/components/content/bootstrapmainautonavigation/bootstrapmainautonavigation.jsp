<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/libs/harbor/components/global.jsp" %>

<c:choose>
    <c:when test="${bootstrapMainAutoNavigation.stickyNavigationEnabled}">
        <div class="navbar navbar-default navbar-fixed-top" role="navigation">
    </c:when>
    <c:otherwise>
        <div class="navbar navbar-default" role="navigation">
    </c:otherwise>
</c:choose>
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <%-- Show autogenerated navigation elements--%>
                <c:if test="${bootstrapMainAutoNavigation.hasRootNode}">
                    <c:forEach var="currentNode" items="${bootstrapMainAutoNavigation.rootChildrenAsRenderable}" varStatus="status">
                        ${currentNode.renderedTreeNodeValue}
                    </c:forEach>
                </c:if>
            </ul>
        </div>
    </div>
</div>