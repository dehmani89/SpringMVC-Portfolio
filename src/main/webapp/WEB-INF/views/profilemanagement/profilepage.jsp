<!-- 
	Using JSP Fragments to separate the items that are needed for every page such as header/footer/navigation etc.
	This way the code will be organized in separate fragements and we use the include tag to add the needed
	Fragments as needed in different pages.
 -->
<!-- HEADER FRAGMENT --> 
<%@include file="../common/header.jspf" %>

<!-- MAIN CONTENT OF THE PAGE GOES HERE --> 
<c:set value="${userInfo}" var="userData"></c:set> 
<form:form method="post" commandName="updateprofile" class="form-horizontal">
<div class="modal-header">
  <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
  <h4 class="modal-title text-center" id="profileModalLabel">User Profile Management</h4>
</div>


    	
<div class="modal-body"> <!--  OPEN Modal Body -->	
<div class="row">  
	      <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
          <!-- Profile Image -->
          <div class="box box-primary">
            <div class="box-body box-profile">
              <img class="profile-user-img img-responsive img-circle" src="/adminTemplateImg/avatar5.png" alt="User profile picture">
              <h3 class="profile-username text-center">${userData.firstname} ${userData.lastname}</h3>
              <p class="text-muted text-center">${userData.occupation}</p>
              <ul class="list-group list-group-unbordered">
                <li class="list-group-item">
                  <b>Followers</b> <a class="pull-right">1,322</a>
                </li>
                <li class="list-group-item">
                  <b>Following</b> <a class="pull-right">543</a>
                </li>
                <li class="list-group-item">
                  <b>Friends</b> <a class="pull-right">13,287</a>
                </li>
              </ul>
            </div>
            <!-- /.box-body -->
          </div>
          </div>
          
          <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
          <!-- /.box -->
          <!-- About Me Box -->
          <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">About Me</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <strong><i class="fa fa-book margin-r-5"></i> Education</strong>
              <p class="text-muted">${userData.education}</p>
              <hr>
              <strong><i class="fa fa-map-marker margin-r-5"></i> Location</strong>
              <p class="text-muted">${userData.city}, ${userData.state}</p>
              <hr>
              <strong><i class="fa fa-pencil margin-r-5"></i> Skills</strong>
              <p>
              	<c:forEach items="${userData.skills}" var="skill">
              		${skill} 
              	</c:forEach>
              </p>
              <hr>
              <strong><i class="fa fa-file-text-o margin-r-5"></i> Notes</strong>
              <p>Leave a note here</p>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
	        

          <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
          <!-- /.box -->
          <!-- About Me Box -->
          <div class="box box-warning">
            <div class="box-header with-border">
              <h3 class="box-title">About Me</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
                    <%-- <fieldset class="form-group">
                    <form:hidden path="id"/>
						<form:label path="id" class="col-sm-2 control-label" for="inputId">ID</form:label>
					<div class="col-sm-10">
						<form:input path="id" type="text" class="form-control" required="required" disabled="disabled"/>
					</div>
					<form:errors path="id" cssClass="text-danger"></form:errors>
					</fieldset> --%>
					
					<%-- <fieldset class="form-group">
						<form:label path="username" class="col-sm-2 control-label" for="inputUserName">Username</form:label>
					<div class="col-sm-10">
						<form:input path="username" type="text" class="form-control" required="required"/>
					</div>
					<form:errors path="username" cssClass="text-danger"></form:errors>
					</fieldset> --%>
					
					<fieldset class="form-group">
						<form:hidden path="id"/>
						<form:label path="password" class="col-sm-2 control-label" for="inputPassWord">Password</form:label>
					<div class="col-sm-10">
						<form:input path="password" type="text" class="form-control" required="required"/>
					</div>
					<form:errors path="password" cssClass="text-danger"></form:errors>
					</fieldset>
					
					<%-- <fieldset class="form-group">
						<form:label path="enabled" class="col-sm-2 control-label" for="inputEnabled">Enabled</form:label>
					<div class="col-sm-10">
						<form:input path="enabled" type="text" class="form-control" required="required"/>
					</div>
					<form:errors path="enabled" cssClass="text-danger"></form:errors>
					</fieldset> --%>
					
					<fieldset class="form-group">
						<form:label path="firstname" class="col-sm-2 control-label" for="inputFirstName">First Name</form:label>
					<div class="col-sm-10">
						<form:input path="firstname" type="text" class="form-control" required="required"/>
					</div>
					<form:errors path="firstname" cssClass="text-danger"></form:errors>
					</fieldset>	
					
                    <fieldset class="form-group">
						<form:label path="lastname" class="col-sm-2 control-label" for="inputLastName">Last Name</form:label>
					<div class="col-sm-10">
						<form:input path="lastname" type="text" class="form-control" required="required"/>
					</div>
					<form:errors path="lastname" cssClass="text-danger"></form:errors>
					</fieldset>	
                  
                   <fieldset class="form-group">
						<form:label path="email" class="col-sm-2 control-label" for="inputEmail">Email</form:label>
					<div class="col-sm-10">
						<form:input path="email" type="text" class="form-control" required="required"/>
					</div>
					<form:errors path="email" cssClass="text-danger"></form:errors>
					</fieldset>
					
					
                  <fieldset class="form-group">
						<form:label path="education" class="col-sm-2 control-label" for="inputEducation">Education</form:label>
					<div class="col-sm-10">
						<form:input path="education" type="text" class="form-control" required="required"/>
					</div>
					<form:errors path="education" cssClass="text-danger"></form:errors>
					</fieldset>
					
                   <fieldset class="form-group">
						<form:label path="skills" class="col-sm-2 control-label" for="inputSkills">Skills</form:label>
					<div class="col-sm-10">
						<form:textarea path="skills" type="text" class="form-control" required="required"/>
					</div>
					<form:errors path="skills" cssClass="text-danger"></form:errors>
					</fieldset>
					
                  <fieldset class="form-group">
						<form:label path="occupation" class="col-sm-2 control-label" for="inputOccupation">Occupation</form:label>
					<div class="col-sm-10">
						<form:input path="occupation" type="text" class="form-control" required="required"/>
					</div>
					<form:errors path="occupation" cssClass="text-danger"></form:errors>
					</fieldset>
					
                  <fieldset class="form-group">
						<form:label path="city" class="col-sm-2 control-label" for="inputCity">City</form:label>
					<div class="col-sm-10">
						<form:input path="city" type="text" class="form-control" required="required"/>
					</div>
					<form:errors path="city" cssClass="text-danger"></form:errors>
					</fieldset>
					
                  <fieldset class="form-group">
						<form:label path="state" class="col-sm-2 control-label" for="inputState">State</form:label>
					<div class="col-sm-10">
						<form:input path="state" type="text" class="form-control" required="required"/>
					</div>
					<form:errors path="state" cssClass="text-danger"></form:errors>
					</fieldset>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>

	        
</div>	<!-- Close Row -->
</div>	<!-- Close model body Section -->
<div class="modal-footer">
	      <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	      <input class="btn btn-success" type="submit" value="Save changes">   
</div>  
</form:form> 

 