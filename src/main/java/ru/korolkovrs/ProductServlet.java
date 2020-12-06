package ru.korolkovrs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ProductServlet", urlPatterns = "/getProd")
public class ProductServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(ProductServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Get req");
        int count = Integer.parseInt(req.getParameter("quantity"));
        int id = Integer.parseInt(req.getParameter("id"));
        String title = req.getParameter("title");
        float cast = Float.parseFloat(req.getParameter("cost"));
        Product product = new Product(id, title, cast);
        StringBuilder stringBuilder = new StringBuilder("<html><body>");

        for (int i = 0; i < count; i++) {
            stringBuilder.append(product + "<br>");
        }
        stringBuilder.append("</body></html>");

        resp.getWriter().write(stringBuilder.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        logger.debug("Init");
        super.init();
    }
}
