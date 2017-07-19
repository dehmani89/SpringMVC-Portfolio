<!-- 
	Using JSP Fragments to separate the items that are needed for every page such as header/footer/navigation etc.
	This way the code will be organized in separate fragements and we use the include tag to add the needed
	Fragments as needed in different pages.
 -->
<!-- HEADER FRAGMENT --> 
<%@include file="../common/header.jspf" %>
<!-- Navigation Bar FRAGMENT --> 
<%@include file="../common/navigation.jspf" %>

<!-- MAIN CONTENT OF THE PAGE GOES HERE --> 
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        <!-- Custom spring tag below used for internationalization (see header.jspf) -->
        <spring:message code="greeting.caption"/> ${name}
        <small>Optional description</small>
      </h1>
    </section>

    <!-- Main content -->
    <section class="content">
		
	<!-- 
		using the form: spring style coding that allows us to bind data with the controller
		for example commandName="todo" on the view side gets binded with the model in the TodoController
	 -->
	<form:form method="post" commandName="todo">
		<fieldset class="form-group">
			<form:hidden path="id"/>
			<form:label path="desc">Description</form:label>
			<form:input path="desc" type="text" class="form-control" required="required"/>
			<form:errors path="desc" cssClass="text-danger"></form:errors>
		</fieldset>		
		<fieldset class="form-group ">
			<form:label path="targetDate">Target Date</form:label>
			<div class="input-group date">
                  <div class="input-group-addon">
                    <i class="fa fa-calendar"></i>
                  </div>
                  <form:input path="targetDate" type="text" class="form-control pull-right" required="required" id="datepicker" />
            </div>
			<form:errors path="targetDate" cssClass="text-danger"></form:errors>
		</fieldset>
		<!-- /.input group -->
		<input class="btn btn-success" type="submit" value="Submit">
		
		
	</form:form>		
		
		
		
    </section>
    <!-- /.content -->
</div>
<!-- FOOTER FRAGMENT --> 
<%@include file="../common/footer.jspf" %>
<script type="text/javascript">
//Date picker
$('#datepicker').datepicker({
  autoclose: true,
  orientation: 'bottom auto',
  todayHighlight: true,
});
$("#datepicker").datepicker('setDate', new Date());
</script>
