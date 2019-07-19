package com.kulchuri.feeder.student;

import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "StudentControllerServlet", urlPatterns = {"/StudentControllerServlet"})
@MultipartConfig(maxFileSize = 234567899)

public class StudentControllerServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String opn = request.getParameter("opn");
            if (opn != null && opn.equalsIgnoreCase("Update")) {
                String eno = request.getParameter("eno");
                Part p = request.getPart("photo");
                InputStream photo = p.getInputStream();
                if (new StudentDao().updatePhoto(eno, photo)) {
                    response.sendRedirect("admin_viewAllStudents.jsp");
                } else {
                    response.sendRedirect("admin_home.jsp");
                }
            } else {

                StudentDto dto = new StudentDto();
                dto.setName(request.getParameter("name"));
                dto.setEno(request.getParameter("eno"));
                dto.setBid(Integer.parseInt(request.getParameter("bid")));
                dto.setGender(request.getParameter("gender"));
                dto.setSem(Integer.parseInt(request.getParameter("sem")));
                dto.setEmail(request.getParameter("email"));
                dto.setPwd(request.getParameter("pwd"));
                dto.setMno(request.getParameter("mno"));
                dto.setDob(request.getParameter("dob"));
                Part p = request.getPart("photo");
                InputStream photo = p.getInputStream();
                if (new StudentDao().addStudent(dto, photo)) {
                    request.getRequestDispatcher("admin_viewAllStudents.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("admin_addStudent.jsp").forward(request, response);
                }
            }
        } catch (Exception e) {
            System.out.println("Exception at StudentControllerServlet():" + e);
        }
    }
}
