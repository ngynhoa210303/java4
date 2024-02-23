package com.poly.hangnt169.B2_OverviewJavaWeb;
/**
 * @author hangnt169
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = {"/login","/ket-qua"})
public class LoginController extends HttpServlet {

    // Controller là tầng trung gian trao đổi giữa client và server
    // thông qua phương thức http.
    // Với Java 4, 5 thì sẽ làm việc với 2 phương thức http
    // GET : Hiển thị dữ liêu data
    // POST : Xử lý dữ liệu
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Truyen gia tri tu jsp sang servlet
        request.setAttribute("mess1","Xin chao");
        // Hiển thị lên giao diện
        request.getRequestDispatcher("/buoi2/form-login.jsp").forward(request, response);
//        response.sendRedirect("/form-login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lay gia tri tu jsp (view- giao dien)
        String username = request.getParameter("uname");
        String password = request.getParameter("psw");

        // Day du lieu sang view moi
        request.setAttribute("u1",username);
        request.setAttribute("u2",password);

        // Chuyen trang
        request.getRequestDispatcher("/buoi2/b2kq/ket-qua.jsp").forward(request,response);
    }
}
