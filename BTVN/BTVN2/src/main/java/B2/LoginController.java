package B2;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = {"/login","/home"})
public class LoginController extends HttpServlet {
    private static final String USERNAME = "HangNT169";
    private static final String PASSWORD = "123456";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Hiển thị lên giao diện
        request.getRequestDispatcher("login.jsp").forward(request, response);
//        request.getRequestDispatcher("home.jsp").forward(request, response);
//        request.getRequestURL();
//        if ()
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//Lấy giá trị từ jsp (view-GD)
        String username=request.getParameter("uname");
        String pass=request.getParameter("psw");//name
        if (username == null || username.isEmpty() || pass == null || pass.isEmpty()) {
            // Username or password is empty, show error message on login page
            request.setAttribute("error", "Please enter both username and password.");
            response.sendRedirect(request.getContextPath()+"/login");
//            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else if (USERNAME.equals(username) && PASSWORD.equals(pass)) {
            // Login successful, redirect to home page
            //đẩy dữ liệu
            request.setAttribute("u1",username);
            request.setAttribute("u2",pass);
            request.getRequestDispatcher("/home.jsp").forward(request, response);
        } else {
            // Login failed, show error message on login page
            request.setAttribute("error", "Invalid username or password.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
