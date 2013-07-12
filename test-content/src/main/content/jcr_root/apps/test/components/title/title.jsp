<%@include file="/libs/foundation/global.jsp"%>
<%@taglib prefix="slice" uri="http://cognifide.com/jsp/slice"%>

<p>Test Slice 1</p>
<slice:lookup appName="injectorName" var="model" type="<%=com.razorfish.test.core.TextModel.class%>" />
<p>testing: ${model.text} 1</p>
