package uk.sda.javalon1.bart.OnlineShop.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import uk.sda.javalon1.bart.OnlineShop.model.Product;
import uk.sda.javalon1.bart.OnlineShop.model.User;
import uk.sda.javalon1.bart.OnlineShop.model.UsersAndProducts;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/CreateUserServlet")
public class CreateUserServlet extends HttpServlet {
    private final String path = "C:\\Users\\barts\\Documents\\JAVALON1\\OnlineShop\\src\\main\\webapp\\WEB-INF\\userAndProduct.json";


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //taking data from the user
        String newName = req.getParameter("create_name");
        String newSurname = req.getParameter("create_surname");
        String newUserName = req.getParameter("create_userName");
        String newPassword = req.getParameter("create_password");

        //data reading
        ObjectMapper mapper = new ObjectMapper();
        InputStream inStream = getServletContext().getResourceAsStream(path);
        UsersAndProducts usersAndProducts = mapper.readValue(new FileInputStream(path), UsersAndProducts.class);

        //creating a list of users and products
        List<User> listOfUsers = new ArrayList<>((usersAndProducts.getUsers()));
        List<Product> listOfProducts = new ArrayList<>(usersAndProducts.getProducts());
        User newUser = new User(listOfUsers.size() + 1, newUserName, newPassword, 0, newName, newSurname, "user");

        //adding a new user to listOfUsers
        listOfUsers.add(newUser);

        //create a new UsersAndProducts object by adding listOfProducts and listOfUsers
        usersAndProducts = new UsersAndProducts(listOfProducts, listOfUsers);
        mapper.writeValue(new FileOutputStream(path), usersAndProducts);

        //redirect to createUser.jsp
        RequestDispatcher rd = req.getRequestDispatcher("createUser.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}