package com.kulchuri.feeder.faculty;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(maxFileSize = 798798787)
@WebServlet(name = "FacultyController", urlPatterns = {"/FacultyController"})
public class FacultyController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String fid = request.getParameter("fid");
            Part p = request.getPart("photo");
            InputStream photo = p.getInputStream();
            if (new FacultyDao().addPhoto(fid, photo)) {
                response.sendRedirect("admin_viewAllFaculties.jsp");
            } else {
                response.sendRedirect("admin_addPhotoFaculty.jsp?fid=" + fid);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
