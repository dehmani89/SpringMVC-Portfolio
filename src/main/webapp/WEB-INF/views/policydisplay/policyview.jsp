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
      <h1>Policy Display Application for user: <strong><i>${name}</i></strong></h1>
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
		</div> <!-- / .row -->

		<!-- New Row -->
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-7">
				<!-- Custom Tabs -->
				<div class="nav-tabs-custom">
					<ul class="nav nav-tabs">
						<li class="active"><a href="#tab_1" data-toggle="tab"><span class="fa fa-list-alt"> </span> Contract Summary</a></li>
						<li><a href="#tab_2" data-toggle="tab"><span class="fa fa-bar-chart"> </span> Portfolio Info</a></li>
						<li><a href="#tab_3" data-toggle="tab"><span class="fa fa-exchange"> </span> Transactions</a></li>
						<li><a href="#tab_4" data-toggle="tab"><span class="fa fa-file-text"> </span> Documents</a></li>
						<li><a href="#tab_5" data-toggle="tab"><span class="fa fa-users"> </span> Owner / Rep Info</a></li>
						<li><a href="#tab_6" data-toggle="tab"><span class="fa fa-rotate-right"></span> AWD</a></li>
						<li><a href="#tab_7" data-toggle="tab"><span class="fa fa-question-circle"></span> Questions</a></li>
					</ul>


					<div class="tab-content">

						<!-- START OF TAB 1-->
						<div class="tab-pane active" id="tab_1">
							<b>Tab 1 Content:</b> <br> <br>
							<div class="row">
								<%@include file="views/contractSummary/contractInfo.jspf" %>
								<%@include file="views/contractSummary/riders.jspf" %>
								<%@include file="views/contractSummary/payoutRmdInfo.jspf" %>
								<%@include file="views/contractSummary/fixedrates.jspf" %>
								<%@include file="views/contractSummary/notes.jspf" %>
							</div>
							<!-- CLOSE ROW-->
						</div>
						<!-- END OF TAB 1-->

						<!-- START OF TAB 2-->
						<div class="tab-pane" id="tab_2">
							<b>Tab 2 Content:</b> <br> <br>
							<div class="row">
								<%@include file="views/portfolioInfo/portfolioInfo.jspf" %>
								<%@include file="views/portfolioInfo/valuesInfo.jspf" %>
							</div>
						</div>
						<!-- /.tab-pane -->
						<!-- END OF TAB 2-->

						<!-- START OF TAB 3-->
						<div class="tab-pane" id="tab_3">
							<b>Tab 3 Content:</b> <br> <br>

							<div class="row">
								<%@include file="views/transactions/requestTransaction.jspf" %>
							</div>
						</div>
						<!-- /.tab-pane -->
						<!-- END OF TAB 3-->

						<!-- START OF TAB 4-->
						<div class="tab-pane" id="tab_4">
							<b>Tab 4 Content:</b> <br> <br>
							
							<div class="row">
								<%@include file="views/documents/statements.jspf" %>
							</div>
							
						</div>
						<!-- /.tab-pane -->
						<!-- END OF TAB 4-->

						<!-- START OF TAB 5-->
						<div class="tab-pane" id="tab_5">
							<b>Tab 5 Content:</b> <br> <br>
							
							<div class="row">
								<%@include file="views/ownerRepInfo/repInfo.jspf" %>
								<%@include file="views/ownerRepInfo/ownerInfo.jspf" %>
							</div>
							
						</div>
						<!-- /.tab-pane -->
						<!-- END OF TAB 5-->

						<!-- START OF TAB 6-->
						<div class="tab-pane" id="tab_6">
							<b>Tab 6 Content:</b> <br> <br>
							<div class="row">
								<%@include file="views/ownerRepInfo/repInfo.jspf" %>
							</div>
						</div>
						<!-- /.tab-pane -->
						<!-- END OF TAB 6-->

						<!-- START OF TAB 7-->
						<div class="tab-pane" id="tab_7">
							<b>Tab 7 Content:</b> <br> <br>
							
							<div class="row">
								<%@include file="views/questions/chat.jspf" %>
							</div>
						</div>
						<!-- /.tab-pane -->
						<!-- END OF TAB 7-->

					</div>
					<!-- /.tab-content -->
				</div>
				<!-- nav-tabs-custom -->
			</div>
			<!-- /.col -->
		</div>
		<!-- End of New Row -->


	</section>
         
          
    <!-- /.content -->
</div>
  

<!-- FOOTER FRAGMENT --> 
<%@include file="../common/footer.jspf" %>
