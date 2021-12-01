package Servlets;

import HelpMyself.Helper;
import Model.Result;
import Model.Results;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;


@WebServlet("/area_check")
public class AreaCheckServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            double x = Helper.getDoubleParameter(req.getParameter("x"));
            double y = Helper.getDoubleParameter(req.getParameter("y"));
            double r = Helper.getDoubleParameter(req.getParameter("r"));
            if (!Helper.checkDataValidation(x,y,r)){
                throw new Exception();
            }
            String area = atArea(x, y, r);
            HttpSession session = req.getSession();
            Date currentTime = new Date();
            Result entry = new Result(x, y, r, area, (Long) session.getAttribute("queryTime"), currentTime);
            Results results = (Results) session.getAttribute("results");
            if (results == null) results = new Results();
            results.addEntry(entry);
            session.setAttribute("results", results);
            resp.getWriter().println(Helper.getTable(results));
        } catch (Exception e) {
            resp.sendError(400);
            resp.setStatus(400);
        }
    }
    private static String atArea(double x, double y, double r) {
        if (atQuarterCircle(x, y, r) || atRectangle(x, y, r) || atTriangle(x, y, r)) return "dead_inside";
        else return "dead_outside";
    }

    private static boolean atQuarterCircle(double x, double y, double r) {
        return ((x <= 0) && (y >= 0) && ((x * x + y * y) <= r * r / 4));
    }

    private static boolean atTriangle(double x, double y, double r) {
        return ((x >= 0) && (y <= 0) && (x<=r+2*y));
    }

    private static boolean atRectangle(double x, double y, double r) {
        return ((x >= 0) && (y >= 0) && (y <= r) && (x <= r / 2));
    }
}
