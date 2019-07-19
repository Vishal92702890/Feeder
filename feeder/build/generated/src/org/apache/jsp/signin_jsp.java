package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.kulchuri.feeder.student.StudentDao;

public final class signin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/head.html");
    _jspx_dependants.add("/main_header.html");
  }

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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        ");
      out.write("<title>My School Education Category Bootstrap Responsive website Template | Home :: w3layouts</title>\n");
      out.write("    <!-- Meta tag Keywords -->\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("    <meta charset=\"UTF-8\" />\n");
      out.write("    <meta name=\"keywords\" content=\"My School Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design\" />\n");
      out.write("    <script>\n");
      out.write("        addEventListener(\"load\", function () {\n");
      out.write("\t\t\tsetTimeout(hideURLbar, 0);\n");
      out.write("\t\t}, false);\n");
      out.write("\n");
      out.write("\t\tfunction hideURLbar() {\n");
      out.write("\t\t\twindow.scrollTo(0, 1);\n");
      out.write("\t\t}\n");
      out.write("\t</script>\n");
      out.write("    <!-- //Meta tag Keywords -->\n");
      out.write("\n");
      out.write("    <!-- Custom-Files -->\n");
      out.write("    <link href=\"css/bootstrap.css\" rel='stylesheet' type='text/css' />\n");
      out.write("    <!-- Bootstrap-CSS -->\n");
      out.write("    <link href=\"css/style.css\" rel='stylesheet' type='text/css' />\n");
      out.write("    <!-- Style-CSS -->\n");
      out.write("    <link href=\"css/font-awesome.min.css\" rel=\"stylesheet\">\n");
      out.write("    <!-- Font-Awesome-Icons-CSS -->\n");
      out.write("    <!-- //Custom-Files -->\n");
      out.write("\n");
      out.write("    <!-- Web-Fonts -->\n");
      out.write("    <link href=\"//fonts.googleapis.com/css?family=Lora:400,400i,700,700i&amp;subset=cyrillic,cyrillic-ext,latin-ext,vietnamese\"\n");
      out.write("        rel=\"stylesheet\">\n");
      out.write("    <link href=\"//fonts.googleapis.com/css?family=Dosis:200,300,400,500,600,700,800&amp;subset=latin-ext\" rel=\"stylesheet\">\n");
      out.write("    <!-- //Web-Fonts -->");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    ");

        if (request.getMethod().equalsIgnoreCase("post")) {
            String uname = request.getParameter("uname");
            String pwd = request.getParameter("pwd");
            String ltype = request.getParameter("ltype");
            if (ltype.equalsIgnoreCase("admin")) {
                
            } else if (ltype.equalsIgnoreCase("student")) {
                if (new StudentDao().login(uname, pwd)) {
                    session.setAttribute("eno", uname);
                    response.sendRedirect("student_Home.jsp");
                } else {
                    out.print("<script>alert('Please Enter Valid Login Details')</script>");
                }
            } else {
                
            }
        }
    
      out.write("\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write(" <!-- header -->\n");
      out.write("    <header>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"header d-lg-flex justify-content-between align-items-center py-2 px-sm-2 px-1\">\n");
      out.write("                <!-- logo -->\n");
      out.write("                <div id=\"logo\">\n");
      out.write("                    <h1><a href=\"index.jsp\">Feeder</a></h1>\n");
      out.write("                </div>\n");
      out.write("                <!-- //logo -->\n");
      out.write("                <!-- nav -->\n");
      out.write("                <div class=\"nav_w3ls ml-lg-5\">\n");
      out.write("                    <nav>\n");
      out.write("                        <label for=\"drop\" class=\"toggle\">Menu</label>\n");
      out.write("                        <input type=\"checkbox\" id=\"drop\" />\n");
      out.write("                        <ul class=\"menu\">\n");
      out.write("                            <li><a href=\"index.html\">Home</a></li>\n");
      out.write("                            <li><a href=\"#about\">About</a></li>\n");
      out.write("                            <li><a href=\"#join\">Join Now</a></li>\n");
      out.write("                            <li>\n");
      out.write("                                <!-- First Tier Drop Down -->\n");
      out.write("                                <label for=\"drop-2\" class=\"toggle toogle-2\">Pages <span class=\"fa fa-angle-down\"\n");
      out.write("                                        aria-hidden=\"true\"></span>\n");
      out.write("                                </label>\n");
      out.write("                                <a href=\"#\">Pages <span class=\"fa fa-angle-down\" aria-hidden=\"true\"></span></a>\n");
      out.write("                                <input type=\"checkbox\" id=\"drop-2\" />\n");
      out.write("                                <ul>\n");
      out.write("                                    <li><a href=\"#events\" class=\"drop-text\">Events</a></li>\n");
      out.write("                                    <li><a href=\"#what\" class=\"drop-text\">What We Do?</a></li>\n");
      out.write("                                    <li><a href=\"#courses\" class=\"drop-text\">Popular Courses</a></li>\n");
      out.write("                                    <li><a href=\"#stats\" class=\"drop-text\">Statistics</a></li>\n");
      out.write("                                    <li><a href=\"#gallery\" class=\"drop-text\">Gallery</a></li>\n");
      out.write("                                </ul>\n");
      out.write("                            </li>\n");
      out.write("                            <li><a href=\"#contact\">Contact</a></li>\n");
      out.write("                            <li><a href=\"login.html\">Login</a></li>\n");
      out.write("                            <li><a href=\"register.html\">Register</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </nav>\n");
      out.write("                </div>\n");
      out.write("                <!-- //nav -->\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </header>\n");
      out.write("    <!-- //header -->");
      out.write("\n");
      out.write("        <!-- inner banner -->\n");
      out.write("        <div class=\"inner-banner-w3ls py-5\">\n");
      out.write("            <div class=\"container py-xl-5 py-lg-3\">\n");
      out.write("                <!-- register  -->\n");
      out.write("                <div class=\"modal-body mt-md-2 mt-5\">\n");
      out.write("                    <h3 class=\"title-w3 mb-5 text-center text-wh font-weight-bold\">Login</h3>\n");
      out.write("                    <form action=\"signin.jsp\" method=\"post\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <input type=\"text\" class=\"form-control\" placeholder=\"Enter email\" name=\"email\" required=\"\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <input type=\"password\" class=\"form-control\" placeholder=\"Enter password\" name=\"pwd\" required=\"\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <select class=\"form-control\">\n");
      out.write("                                <option value=\"Admin\">Admin</option>\n");
      out.write("                                <option value=\"Student\">Student</option>\n");
      out.write("                                <option value=\"Faculty\">Faculty</option>\n");
      out.write("                            </select>\n");
      out.write("                        </div>\n");
      out.write("                        <button type=\"submit\" class=\"btn button-style-w3\">Login</button>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
