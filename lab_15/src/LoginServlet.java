import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.InetAddress;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");

		String path = "/login.jsp";
		ServletContext selvletContext = getServletContext();
		String ip = String.valueOf(InetAddress.getLocalHost());
		selvletContext.setAttribute("ip",ip);

		getServletContext().getRequestDispatcher(path).forward(req,resp);

	}
}
