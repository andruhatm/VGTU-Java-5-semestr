package com.company;

import com.company.entity.Basket;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/basket")
public class BasketServlet extends HttpServlet {

	@PersistenceContext
	public EntityManager manager = Persistence.createEntityManagerFactory("Basket").createEntityManager();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		String button = req.getParameter("button");

		if(button.equals("add")){
			if(req.getParameter("name").isEmpty()||req.getParameter("path").isEmpty()){
				writer.write("No params added");
			}
			else {
				Basket basket = new Basket(req.getParameter("name"),req.getParameter("path"));
				manager.getTransaction().begin();
				Basket basket1 = manager.merge(basket);
				manager.getTransaction().commit();
				writer.write("added!");
			}
		}
		else if(button.equals("delete")){
			if(req.getParameter("id").isEmpty()){
				writer.write("No param added");
			}
			else {
				manager.getTransaction().begin();
				manager.remove(get(Integer.parseInt(req.getParameter("id"))));
				manager.getTransaction().commit();
				writer.write("deleted!");
			}
		}
		else if(button.equals("getAll")){
			TypedQuery<Basket> list = manager.createNamedQuery("getAllRows",Basket.class);
			List<Basket> baskets = list.getResultList();

			writer.write("<html><head></head><body>");
			writer.write("<p>Basket items:</p>");
			writer.write("<table><tr><td>id</td><td>name</td><td>path</td></tr>");

			for(Basket basket: baskets){
				writer.write("<tr><td>"+ basket.getId() +"</td><td>"+ basket.getName() +"</td><td>"+ basket.getPath() +"</td></tr>");
			}
		}
		//getServletContext().getRequestDispatcher("/h").forward(req,resp);
	}

	public Basket get(int id){return manager.find(Basket.class,id);}
}
