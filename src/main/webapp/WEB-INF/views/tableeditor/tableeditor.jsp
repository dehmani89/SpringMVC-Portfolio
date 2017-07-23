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
      <h1>Table Editor Application for user: <strong><i>${name}</i></strong></h1>
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

<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
          <div class="box">
            <div class="box-header">
              <h3 class="box-title">Condensed Full Width Table</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body no-padding">
              <table class="table table-condensed responsive">
                <tbody><tr>
                  <th>#</th>
                  <th>Task</th>
                  <th>Progress</th>
                  <th>Label</th>
                </tr>
                <tr>
                  <td>1.</td>
                  <td>Update software</td>
                  <td>Bla Bla</td>
                  <td>
                  <a class="btn btn-danger" href="#"><span class="fa fa-trash"></span></a>
					<a class="btn btn-warning" href="#"><span class="fa fa-pencil"></span></a> 
					<a class="btn btn-success" href="#"><span class="fa fa-copy"></span></a>       
                  </td>
                </tr>
              </tbody></table>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>     
</div>
        
    </section>     
          
    <!-- /.content -->
</div>
  

<!-- FOOTER FRAGMENT --> 
<%@include file="../common/footer.jspf" %>
