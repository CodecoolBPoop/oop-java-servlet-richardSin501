package com.codecool.servlet;

import com.codecool.webshop.Item;
import com.codecool.webshop.ItemStore;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "webshopServlet", urlPatterns = {"/shop"}, loadOnStartup = 3)
public class WebshopServlet extends HttpServlet {

    private boolean initialized = false;

    private void initItems() {
        ItemStore.listOfItems = new LinkedList<>();
        ItemStore.addItem(new Item("Laptop", 1599.99));
        ItemStore.addItem(new Item("Phone", 649));
        ItemStore.addItem(new Item("Car", 30000));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
        PrintWriter out = response.getWriter();
        if (!initialized) {
            this.initItems();
            initialized = true;
        }

        String removeId = request.getParameter("remove");
        System.out.println(removeId);
        String addId = request.getParameter("add");
        System.out.println(addId);

        removeFromCart(removeId);
        addToCart(addId);

        String textPart1 = "<!DOCTYPE html>\n"
            + "<html lang=\"en\">\n"
            + "<head>\n"
            + "  <meta charset=\"UTF-8\">\n"
            + "  <title>Shop</title>\n"
            + "</head>\n"
            + "<body>\n"
            + "<table>";

        StringBuilder textPart2Buffer = new StringBuilder();

        for (Item item : ItemStore.listOfItems) {
            textPart2Buffer
                .append("<tr>")
                .append("<td>").append(item.getId()).append("</td>")
                .append("<td>").append(item.getName()).append("</td>")
                .append("<td>").append(item.getPrice()).append("</td>")
                .append("<td>")
                .append("<a href=\"?add=").append(item.getId()).append("\">add</a>")
                .append("</td>")
                .append("<td>")
                .append("<a href=\"?remove=").append(item.getId()).append("\">remove</a>")
                .append("</td>")
                .append("</tr>");
        }

        String textPart3 = "</table>\n"
            + "<a href=\"/cart\">Cart</a>"
            + "</body>\n"
            + "</html>";

        out.println(textPart1 + textPart2Buffer.toString() + textPart3);
    }

    private void removeFromCart(String removeId) {
        if (removeId != null) {
            try {
                ItemStore.removeFromCart(Integer.valueOf(removeId));
            } catch (NumberFormatException ignored) {
            }
        }
    }

    private void addToCart(String addId) {
        if (addId != null) {
            try {
                ItemStore.addToCart(Integer.valueOf(addId));
            } catch (NumberFormatException ignored) {
            }
        }
    }

}