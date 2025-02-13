package hello.servlet.basic.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // [status-line]
        resp.setStatus(HttpServletResponse.SC_OK);

        // [response-header]
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("utf-8");
        resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("my-header","hello");

        // 리다이렉트
        // redirect(resp);

        PrintWriter writer = resp.getWriter();
        writer.println("안녕하세요.");

    }

    private void redirect(HttpServletResponse response) throws IOException {
        // Status Code : 302
        // Location : /basic/hello-form.html

        response.setStatus(HttpServletResponse.SC_FOUND);
        response.sendRedirect("/basic/hello-form.html");
    }
}
