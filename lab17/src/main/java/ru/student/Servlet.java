package ru.student;

import ru.student.entity.Basket;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Servlet extends HttpServlet {
    @PersistenceContext
    public EntityManager em = Persistence.createEntityManagerFactory("Basket").createEntityManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String button = req.getParameter("button");

        if (button.equals("add")){
            Basket basket = new Basket(req.getParameter("name"), req.getParameter("path"));
            em.getTransaction().begin();
            Basket basketFromDB = em.merge(basket);
            em.getTransaction().commit();
        }
        else  if (button.equals("delete")){
            em.getTransaction().begin();
            em.remove(get(Long.parseLong(req.getParameter("id"))));
            em.getTransaction().commit();
        }
        else  if (button.equals("search")){
            TypedQuery<Basket> namedQuery = em.createNamedQuery("getAll", Basket.class);
            List<Basket> baskets = namedQuery.getResultList();
            PrintWriter writer = resp.getWriter();

            writer.write("<html><head></head><body>\n");
            writer.write("Basket:\n\n");
            writer.write("<table><tr><th>Id</th><th>Имя файла</th><th>Путь</th></tr>\n");

            for (Basket basket : baskets) {
                writer.write("<tr><td>" + basket.getId() + "</td><td>" + basket.getName() + "</td><td>" + basket.getPath() + "</td></tr>\n");
            }

            writer.write("</body></html>");
        }
        getServletContext().getRequestDispatcher("/h.jsp").forward(req, resp);
    }

    public Basket get(long id){
        return em.find(Basket.class, id);
    }
}
