<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html class=" ">
    <head>
        <!-- 
         * @Package: Ultra Admin - Responsive Theme
         * @Subpackage: Bootstrap
         * @Version: 1.0
         * This file is part of Ultra Admin Theme.
        -->
        <meta http-equiv="content-type" content="text/html;charset=UTF-8" />
        <meta charset="utf-8" />
        <title>Ultra Admin : Widgets</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
        <meta content="" name="description" />
        <meta content="" name="author" />

        <link rel="shortcut icon" href="assets/images/favicon.png" type="image/x-icon" />    <!-- Favicon -->
        <link rel="apple-touch-icon-precomposed" href="assets/images/apple-touch-icon-57-precomposed.png">	<!-- For iPhone -->
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/images/apple-touch-icon-114-precomposed.png">    <!-- For iPhone 4 Retina display -->
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/images/apple-touch-icon-72-precomposed.png">    <!-- For iPad -->
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/images/apple-touch-icon-144-precomposed.png">    <!-- For iPad Retina display -->

        <!-- CORE CSS FRAMEWORK - START -->
        <link href="assets/plugins/pace/pace-theme-flash.css" rel="stylesheet" type="text/css" media="screen"/>
        <link href="assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="assets/plugins/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
        <link href="assets/fonts/font-awesome/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/animate.min.css" rel="stylesheet" type="text/css"/>
        <link href="assets/plugins/perfect-scrollbar/perfect-scrollbar.css" rel="stylesheet" type="text/css"/>
        <!-- CORE CSS FRAMEWORK - END -->

        <!-- OTHER SCRIPTS INCLUDED ON THIS PAGE - START --> 
        <link href="assets/plugins/icheck/skins/minimal/white.css" rel="stylesheet" type="text/css" media="screen"/>
        <link href="assets/plugins/jvectormap/jquery-jvectormap-2.0.1.css" rel="stylesheet" type="text/css" media="screen"/>        
        <link href="assets/plugins/ios-switch/css/switch.css" rel="stylesheet" type="text/css" media="screen"/>
        <!-- OTHER SCRIPTS INCLUDED ON THIS PAGE - END --> 

        <!-- OTHER SCRIPTS INCLUDED ON THIS PAGE - END --> 


        <!-- CORE CSS TEMPLATE - START -->
        <link href="assets/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/responsive.css" rel="stylesheet" type="text/css"/>
        <!-- CORE CSS TEMPLATE - END -->

    </head>
    <!-- END HEAD -->

    <!-- BEGIN BODY -->
    <body class=" "><!-- START TOPBAR -->
        <div class='page-topbar '>
            <div class='logo-area'>

            </div>
            <div class='quick-area'>
                <div class='pull-right'>
                    <ul class="info-menu right-links list-inline list-unstyled">
                        <li class="profile">
                            <a href="#" data-toggle="dropdown" class="toggle">
                                <img src="data/profile/profile.png" alt="user-image" class="img-circle img-inline">
                                <span>Jason Bourne <i class="fa fa-angle-down"></i></span>
                            </a>
                            <ul class="dropdown-menu profile animated fadeIn">
                                <li>
                                    <a href="#settings">
                                        <i class="fa fa-wrench"></i>
                                        Settings
                                    </a>
                                </li>
                                <li>
                                    <a href="#profile">
                                        <i class="fa fa-user"></i>
                                        Profile
                                    </a>
                                </li>
                                <li>
                                    <a href="#help">
                                        <i class="fa fa-info"></i>
                                        Help
                                    </a>
                                </li>
                                <li class="last">
                                    <a href="ui-login.html">
                                        <i class="fa fa-lock"></i>
                                        Logout
                                    </a>
                                </li>
                            </ul>
                        </li>
                    </ul>			
                </div>		
            </div>

        </div>
        <!-- END TOPBAR -->
        <!-- START CONTAINER -->
        <div class="page-container row-fluid">
            <!-- SIDEBAR - START -->
            <div class="page-sidebar ">

                <!-- MAIN MENU - START -->
                <div class="page-sidebar-wrapper" id="main-menu-wrapper"> 
                    <ul class='wraplist'>	
                        <li class=""> 
                            <a href="index.html">
                                <i class="fa fa-dashboard"></i>
                                <span class="title">Dashboard</span>
                            </a>
                        </li>
                        <li class=""> <a href="javascript:;"> <i class="fa fa-user"></i> <span class="title">User</span> <span class="arrow "></span> </a>
                            <ul class="sub-menu">
                                <li > <a href="#"> <span class="title">Add User</span> </a> </li>
								<li > <a href="#"> <span class="title">List User</span> </a> </li>
                            </ul>
                        </li>
						<li class=""> <a href="javascript:;"> <i class="fa fa-folder-open"></i> <span class="title">Category</span> <span class="arrow "></span> </a>
                            <ul class="sub-menu">
                                <li > <a href="#"> <span class="title">Add Category</span> </a> </li>
								<li > <a href="#"> <span class="title">List Category</span> </a> </li>
                            </ul>
                        </li>
						<li class=""> <a href="javascript:;"> <i class="fa fa-folder-open"></i> <span class="title">Subject</span> <span class="arrow "></span> </a>
                            <ul class="sub-menu">
                                <li > <a href="#"> <span class="title">Add Subject</span> </a> </li>
								<li > <a href="#"> <span class="title">List Subject</span> </a> </li>
                            </ul>
                        </li>
						<li class=""> <a href="javascript:;"> <i class="fa fa-users"></i> <span class="title">Employee</span> <span class="arrow "></span> </a>
                            <ul class="sub-menu">
                                <li > <a href="#"> <span class="title">Add Employee</span> </a> </li>
								<li > <a href="#"> <span class="title">List Employee</span> </a> </li>
                            </ul>
                        </li>
                    </ul>

                </div>
                <!-- MAIN MENU - END -->
                <div class="project-info">

                    <div class="block1">
                        <div class="data">
                            <span class='title'>New&nbsp;Orders</span>
                            <span class='total'>2,345</span>
                        </div>
                        <div class="graph">
                            <span class="sidebar_orders">...</span>
                        </div>
                    </div>

                    <div class="block2">
                        <div class="data">
                            <span class='title'>Visitors</span>
                            <span class='total'>345</span>
                        </div>
                        <div class="graph">
                            <span class="sidebar_visitors">...</span>
                        </div>
                    </div>

                </div>



            </div>
            <!--  SIDEBAR - END -->
            <!-- START CONTENT -->
            <section id="main-content" class=" ">
                <section class="wrapper" style='margin-top:60px;display:inline-block;width:100%;padding:15px 0 0 15px;'>

                    <div class='col-lg-12 col-md-12 col-sm-12 col-xs-12'>
                        <div class="page-title">

                            <div class="pull-left">
                                <h1 class="title">Data Tables</h1>                            
							</div>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                    <div class="col-lg-12">
                        <section class="box ">
                            <header class="panel_header">
                                <h2 class="title pull-left">Basic Data Table</h2>
                            </header>
                            <div class="content-body">    
							   <div class="row">
                                    <div class="col-md-12 col-sm-12 col-xs-12">
                                    <c:set var="rs" value="${requestScope.allUser}"></c:set>
                                        <table id="example-1" class="table table-striped dt-responsive display" cellspacing="0" width="100%">
                                            <thead>
                                                <tr>
                                                	<th>ID</th>
                                                    <th>Name</th>
                                                    <th>Email</th>
                                                    <th>Type</th>
                                                    <th>Status</th>
                                                    <th>Action</th>
                                                </tr>
                                            </thead>

                                            <tbody>
                                            <c:forEach var="row" items="${rs }">
                                            	<c:if test="${row.position == 1}">
												   <c:set var="position" scope="session" value="User"/>
												</c:if>
												<c:if test="${row.position == 0}">
												   <c:set var="position" scope="session" value="Admin"/>
												</c:if>
                                                <tr>
                                                    <td><c:out value="${row.user_id }"></c:out></td>
													<td><c:out value="${row.username }"></c:out></td>
													<td><c:out value="${row.email }"></c:out></td>
													<td><c:out value="${position }"></c:out></td>
                                                    <td>
                                                    	<div class="form-block">
                                                    		<c:if test="${row.status == 1}">
                                                   			 	<input type="checkbox" checked="" onclick=onChangeStatus(<c:out value="${row.user_id }"></c:out>,<c:out value="${row.status }"></c:out>) class="iswitch iswitch-md iswitch-primary">
                                                   			 </c:if>
                                                   			 <c:if test="${row.status == 0}">
                                                   			 	<input type="checkbox" onclick=onChangeStatus(<c:out value="${row.user_id }"></c:out>,<c:out value="${row.status }"></c:out>) class="iswitch iswitch-md iswitch-primary">
                                                   			 </c:if>
                                                   	 	</div>
                                                    </td>
                                                    <td><a href="viewedituser?id=<c:out value="${row.user_id }"></c:out>"><i class="fa fa-trash-o icon-xs icon-rounded icon-danger inviewport animated  visible rollIn" data-vp-add-class="visible rollIn"></i>
                                                      </a></td>
                                                
                                                </tr>
                                               </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </section></div>
                </section>
            </section>
        </div>
        <!-- END CONTAINER -->
        <!-- LOAD FILES AT PAGE END FOR FASTER LOADING -->


        <!-- CORE JS FRAMEWORK - START --> 
        <script src="assets/js/jquery-1.11.2.min.js" type="text/javascript"></script> 
        <script src="assets/js/jquery.easing.min.js" type="text/javascript"></script> 
        <script src="assets/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script> 
        <script src="assets/plugins/pace/pace.min.js" type="text/javascript"></script>  
        <script src="assets/plugins/perfect-scrollbar/perfect-scrollbar.min.js" type="text/javascript"></script> 
        <script src="assets/plugins/viewport/viewportchecker.js" type="text/javascript"></script>  
        <!-- CORE JS FRAMEWORK - END --> 

		<script type="text/javascript">
		function onChangeStatus(ID,status){
			alert(status);
			if(status=="0"){ sta="1";}
			else {sta="0";}
			$.post("edituserstatus",{
				ID:ID,
				sta:sta
				},function(data){
				if(data=="success"){
					
				}else{
					
				}	
			});
		};
		function onDeletePro(id){
			$.post("deleteuser",{
				id : id
			},function(data){
				
			});
		};
		function onEditPro(id){
			$.post("viewedituser",{
				id : id
			},function(data){
				
				$("#btnadd").text("Edit");
				$("#btnadd").attr("onclick","myEdit("+data.ID+")");
			});
		}
		</script>

        <!-- OTHER SCRIPTS INCLUDED ON THIS PAGE - START --> 
        <script src="assets/plugins/datatables/js/jquery.dataTables.min.js" type="text/javascript"></script><script src="assets/plugins/datatables/extensions/TableTools/js/dataTables.tableTools.min.js" type="text/javascript"></script><script src="assets/plugins/datatables/extensions/Responsive/js/dataTables.responsive.min.js" type="text/javascript"></script><script src="assets/plugins/datatables/extensions/Responsive/bootstrap/3/dataTables.bootstrap.js" type="text/javascript"></script><!-- OTHER SCRIPTS INCLUDED ON THIS PAGE - END --> 


        <!-- CORE TEMPLATE JS - START --> 
        <script src="assets/js/scripts.js" type="text/javascript"></script> 
        <!-- END CORE TEMPLATE JS - END --> 

        <!-- Sidebar Graph - START --> 
        <script src="assets/plugins/sparkline-chart/jquery.sparkline.min.js" type="text/javascript"></script>
        <script src="assets/js/chart-sparkline.js" type="text/javascript"></script>
        <!-- Sidebar Graph - END --> 
    </body>
</html>



