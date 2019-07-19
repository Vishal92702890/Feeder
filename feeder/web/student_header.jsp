<%
    String eno = (String) session.getAttribute("eno");
    if (eno == null) {
%>
<jsp:forward page="signin.jsp"></jsp:forward>

<%
    }
%>

<!-- header -->
<header>
    <div class="container">
        <div class="header d-lg-flex justify-content-between align-items-center py-2 px-sm-2 px-1">
            <!-- logo -->
            <div id="logo">
                <h1><a href="student_Home.jsp">Feeder</a></h1>
            </div>
            <div class="nav_w3ls ml-lg-5">
                <nav>
                    <ul>
                        <li><a href="student_Home.jsp">Home</a></li>
                        <li>
                            <label for="drop-2" class="toggle toogle-2">Pages <span class="fa fa-angle-down"
                                                                                    aria-hidden="true"></span>
                            </label>
                            <a href="#">Attendance <span class="fa fa-angle-down" aria-hidden="true"></span></a>
                            <input type="checkbox" id="drop-2" />
                            <ul>
                                <li><a href="student_viewAttendanceByDate.jsp" class="drop-text">View By Date</a></li>
                                <li><a href="student_viewAttendanceByMonth.jsp" class="drop-text">View By Month</a></li>
                                <li><a href="student_viewAttendanceBetweenDates.jsp" class="drop-text">View Between Dates</a></li>
                            </ul>
                        </li>
                        <li><a href="faculty_resetPassword.jsp">Reset Password</a></li>
                        <li><a href="#">Signout</a></li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
</header>