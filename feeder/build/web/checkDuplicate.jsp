<%@page import="com.kulchuri.feeder.branch.BranchDao"%>
<%
    if (request.getMethod().equalsIgnoreCase("post")) {
        if (request.getParameter("opn").equalsIgnoreCase("bname")) {
            String bname = request.getParameter("bname");
            if (new BranchDao().checkDuplicateBranch(bname)) {
%>
<%="Already Register"%>
<%
            }
        }
    }
%>