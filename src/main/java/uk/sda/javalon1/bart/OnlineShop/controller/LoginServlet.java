package uk.sda.javalon1.bart.OnlineShop.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import uk.sda.javalon1.bart.OnlineShop.model.User;
import uk.sda.javalon1.bart.OnlineShop.model.UsersAndProducts;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    //create a constant with a file path
    private final String path = "C:\\Users\\barts\\Documents\\JAVALON1\\OnlineShop\\src\\main\\webapp\\WEB-INF\\userAndProduct.json";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //creation of ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        //path to the file in the program
        InputStream inStream = getServletContext().getResourceAsStream("WEB-INF\\jsonV1_json.json");

        //loading UsersAndProducts
        UsersAndProducts usersAndProducts = mapper.readValue(new FileInputStream(path), UsersAndProducts.class);

        //creating a list with users
        List<User> listOfUsers = usersAndProducts.getUsers();

        //downloading data from the user
        String name = req.getParameter("name").trim();
        String surname = req.getParameter("surname").trim();
        String password = req.getParameter("code").trim();

        //condition, if the User Object contains elements from the list of users, move to webIntro.jsp, if they are not the same then display the red message Wrong data
        Boolean isLoginOk = false;
        for (User user : usersAndProducts.getUsers()) {
            if (name != null & name.equals(user.getName()) && surname != null & surname.equals(user.getSurname()) && password != null & password.equals(user.getPassword())) {
                Cookie cookie = new Cookie("user_cookie", name);
                cookie.setMaxAge(30 * 60 *60);
                resp.addCookie(cookie);
                req.getSession().setAttribute("button", user.getName());
                RequestDispatcher rd = req.getRequestDispatcher("webIntro.jsp");
                rd.forward(req, resp);
                resp.sendRedirect("webIntro.jsp");
                isLoginOk = true;
            }
            if (!isLoginOk) {
                RequestDispatcher rd = req.getRequestDispatcher("log.jsp");
                resp.getWriter()
                        .println("<font color=red> Wrong data </font>");

                rd.include(req, resp);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}