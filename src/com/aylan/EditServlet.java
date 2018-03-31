package com.aylan;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.Value;

import com.google.gson.Gson;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/editServlet/*")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SessionFactory sessionFactory;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] fatias = request.getRequestURI().split("/");    
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		List<Produto> produtos = new ArrayList<Produto>();
	    produtos.add(buscar(Long.valueOf(fatias[3])));
	   
		out.print(new JsonConverter().convertToJson(produtos));
		out.flush();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Produto p = buscar(Long.valueOf(request.getParameter("id")));
		p.setNome(request.getParameter("nome"));
		p.setPreco(new BigDecimal(request.getParameter("preco")));
		p.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
		p.setData(Date.valueOf(request.getParameter("data")));
		update(p);

	}
	
	public void update(Produto produto) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.update(produto);
		tx.commit();
		session.clear();
		session.close();
	}
	
	protected Produto buscar(Long id){
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
	    Transaction tx = session.beginTransaction();
	    Produto produto = (Produto) session.get(Produto.class, new Long(id));
	     session.close();
	   
		return produto;
	}
}
