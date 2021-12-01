package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


@WebServlet("/controller")
public class ControllerServlet extends HttpServlet {
    private final List<Double> rValues = Arrays.asList(1.0, 1.5, 2.0, 2.5, 3.0);

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/clear").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession();
            session.setAttribute("queryTime", System.nanoTime());
            String x = req.getParameter("x");
            String y = req.getParameter("y");
            String r = req.getParameter("r");
            //check validation and forwarding to area checker
            if (x != null && y != null && r != null) {
                getServletContext().getRequestDispatcher("/area_check").forward(req, resp);
            } else {
                resp.setStatus(400);
                throw new Exception("Incorrect number");
            }

        } catch (Exception ignored) {

        }
    }
}


