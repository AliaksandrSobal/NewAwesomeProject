package by.alex.servelts;

import by.alex.domain.User;
import by.alex.storage.InMemoryUserStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/auth", name = "authorization")
public class AuthorizationServlet extends HttpServlet {
    private InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/authorization.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User byLogin = inMemoryUserStorage.getByLogin(login);
        if (byLogin != null) {
            if (byLogin.getPassword().equals(password)) {
                req.getSession().setAttribute("user", byLogin);
                resp.sendRedirect("/");

            } else {
                req.setAttribute("message", "Wrong password");
                req.getRequestDispatcher("/authorization.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("message", "User not found");
            req.getRequestDispatcher("/authorization.jsp").forward(req, resp);
        }
    }
}
