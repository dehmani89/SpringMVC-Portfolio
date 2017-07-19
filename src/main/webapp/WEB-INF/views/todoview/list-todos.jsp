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
      <h1>List Todo(s) Application for user: <strong><i>${name}</i></strong></h1>
    </section>

    <!-- Main content -->
    <section class="content">

<div class="row">
        <div class="col-xs-12">
          <div class="box box-solid">
            <div class="box-header with-border">
              <i class="fa fa-file-text-o"></i>

              <h3 class="box-title">Description:</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <dl class="dl-horizontal">
                <dt>Short Description</dt>
                <dd>This is a simple to-do list application. It allows the user to perform typical actions such as Add, Edit, and Delete functionalities on the user's list.</dd>
                <dt>Delete Button</dt>
                <dd>Allows a user to delete an item FROM the list.</dd>
                <dt>Update Button</dt>
                <dd>Allows a user to update an item FROM the list.</dd>
                <dt>Add Button</dt>
                <dd>Allows a user to add a new item TO the list.</dd>
              </dl>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
</div>        
        
        
	<div class="row">
        <div class="col-xs-12">
       	<!-- Custom spring tag below used for internationalization (see header.jspf) -->
        <spring:message code="todo.caption"/>
          <div class="box">
            <div class="box-header">
              <h3 class="box-title">Responsive Hover Table</h3>
              <div class="box-tools">
                <div class="input-group input-group-sm" style="width: 150px;">
                  <input type="text" name="table_search" class="form-control pull-right" placeholder="Search">

                  <div class="input-group-btn">
                    <button type="submit" class="btn btn-default"><i class="fa fa-search"></i></button>
                  </div>
                </div>
              </div>
            </div>
            <!-- /.box-header -->
            <div class="box-body table-responsive no-padding">
              <table class="table table-hover">
                <tr>
	                <th>ID</th>
	                <th>Description</th>
					<th>Target Date</th>
					<th>Is Completed</th>
					<th>Actions</th>
                </tr>
                <c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.id}</td>
						<td>${todo.desc}</td>					
						<td>${todo.targetDate}</td>
						<%-- <td><fmt:format pattern="dd/MM/yyyy" value="${todo.targetDate}"></fmt:formatDate></td> --%>
						<td>${todo.done}</td>
						<td>
							<a class="btn btn-danger" href="/delete-todo?id=${todo.id}">Delete!</a>
							<a class="btn btn-warning" href="/update-todo?id=${todo.id}">Update!</a></td>
					</tr>
				</c:forEach>	
              </table>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
      </div>
      
	<div class="row">
		<div class="col-xs-12">
		<a class="btn btn-success" href="/add-todo">Add!</a>
		</div>
	</div>
    </section>
    <!-- /.content -->
    
</div>



<!-- FOOTER FRAGMENT --> 
<%@include file="../common/footer.jspf" %>
