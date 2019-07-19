package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class student_005fheader_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");


    String eno = (String) session.getAttribute("eno");
    if (eno == null) {

      out.write('\n');
      if (true) {
        _jspx_page_context.forward("signin.jsp");
        return;
      }
      out.write('\n');
      out.write('\n');

    }

      out.write("\n");
      out.write("\n");
      out.write("<!-- header -->\n");
      out.write("<header>\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <div class=\"header d-lg-flex justify-content-between align-items-center py-2 px-sm-2 px-1\">\n");
      out.write("            <!-- logo -->\n");
      out.write("            <div id=\"logo\">\n");
      out.write("                <h1><a href=\"student_Home.jsp\">Feeder</a></h1>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"nav_w3ls ml-lg-5\">\n");
      out.write("                <nav>\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href=\"student_Home.jsp\">Home</a></li>\n");
      out.write("                        <li>\n");
      out.write("                            <label for=\"drop-2\" class=\"toggle toogle-2\">Pages <span class=\"fa fa-angle-down\"\n");
      out.write("                                                                                    aria-hidden=\"true\"></span>\n");
      out.write("                            </label>\n");
      out.write("                            <a href=\"#\">Attendance <span class=\"fa fa-angle-down\" aria-hidden=\"true\"></span></a>\n");
      out.write("                            <input type=\"checkbox\" id=\"drop-2\" />\n");
      out.write("                            <ul>\n");
      out.write("                                <li><a href=\"student_viewAttendanceByDate.jsp\" class=\"drop-text\">View By Date</a></li>\n");
      out.write("                                <li><a href=\"student_viewAttendanceByMonth.jsp\" class=\"drop-text\">View By Month</a></li>\n");
      out.write("                                <li><a href=\"student_viewAttendanceBetweenDates.jsp\" class=\"drop-text\">View Between Dates</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                        <li><a href=\"faculty_resetPassword.jsp\">Reset Password</a></li>\n");
      out.write("                        <li><a href=\"#\">Signout</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </nav>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</header>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
