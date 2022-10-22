package controller;

import com.alibaba.fastjson2.JSONObject;
import dao.UserDao;
import domain.User;
import service.UserService;
import service.impl.IUserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/user")
public class UserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService service = new IUserServiceImpl();
        List<User> users;
        try {
            users = service.selectALL();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        session.setAttribute("user",users);
        resp.sendRedirect("demo1.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService service = new IUserServiceImpl();
        List<User> users;
        try {
            users = service.selectALL();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("content-type","text/html;charset = UTF-8");
        PrintWriter out = resp.getWriter();
        out.write(JSONObject.toJSONString(users));
        out.close();
    }
}
