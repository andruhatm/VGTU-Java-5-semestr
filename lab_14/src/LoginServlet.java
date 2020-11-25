import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");

		resp.getWriter().write("<!DOCTYPE html>\n" +
						"<html>\n" +
						"<head>\n" +
						"  <meta charset=\"UTF-8\">\n" +
						"  <title>User Form</title>\n" +
						"</head>\n" +
						"<body>\n" +
						"<form action=\"hello\" method=\"POST\">\n" +
						"  Login: <input name=\"login\"/>\n" +
						"  <br><br>\n" +
						"  Password: <input name=\"password\" type=\"password\" />\n" +
						"  <br><br>\n" +
						"  <input type=\"submit\" value=\"Submit\" />\n" +
						"</form>\n" +
						"</body>\n" +
						"</html>");

	}
}
