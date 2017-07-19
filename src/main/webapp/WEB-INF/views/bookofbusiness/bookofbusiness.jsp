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
      <h1>Book Of Business Application for user: <strong><i>${name}</i></strong></h1>
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
        
        
        
        <!-- Search for Book of business -->
        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
        <div class="box box-info">
            <div class="box-header with-border">
              <h3 class="box-title">Search for a Book of business</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form class="form-horizontal">
              <div class="box-body">
                <div class="form-group">
                  <label for="inputagentNumber" class="col-sm-3 control-label">Agent Number</label>
                  <div class="col-sm-9">
                    <input type="text" class="form-control" id="inputagentNumber" placeholder="Agent Number">
                  </div>
                </div>
                <div class="form-group">
                  <label for="inputagencyNumber" class="col-sm-3 control-label">Agency Number</label>
                  <div class="col-sm-9">
                    <input type="text" class="form-control" id="inputagencyNumber" placeholder="Agency Number">
                  </div>
                </div>
              </div>
              <!-- /.box-body -->
              <div class="box-footer">
                <button type="submit" class="btn btn-info pull-right">Search</button>
              </div>
              <!-- /.box-footer -->
            </form>
          </div>
          </div>
        
        
</div>        
        
    </section>        
          
    <!-- /.content -->
</div>
  

<!-- FOOTER FRAGMENT --> 
<%@include file="../common/footer.jspf" %>
