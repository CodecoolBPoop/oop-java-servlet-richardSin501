package com.codecool.servlet;

import com.codecool.webshop.Item;
import com.codecool.webshop.ItemStore;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ShoppingCartServlet", urlPatterns = {"/cart"}, loadOnStartup = 4)
public class ShoppingCartServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
        PrintWriter out = response.getWriter();

        double sumOfPrices = 0;

        String textPart1 = "<!DOCTYPE html>\n"
            + "<html lang=\"en\">\n"
            + "<head>\n"
            + "  <meta charset=\"UTF-8\">\n"
            + "  <title>Shop</title>\n"
            + "</head>\n"
            + "<body>\n"
            + "<table>";

        StringBuilder textPart2Buffer = new StringBuilder();

        for (Item item : ItemStore.shoppingCart) {
            textPart2Buffer
                .append("<tr>")
                .append("<td>").append(item.getId()).append("</td>")
                .append("<td>").append(item.getName()).append("</td>")
                .append("<td>").append(item.getPrice()).append("</td>")
                .append("<td>")
                .append("</tr>");
            sumOfPrices+=item.getPrice();
        }

        String textPart3 = "</table>\n"
            + "<span>Sum"+sumOfPrices+"</span>"
            + "</body>\n"
            + "</html>";

        out.println(textPart1 + textPart2Buffer.toString() + textPart3);
    }


}