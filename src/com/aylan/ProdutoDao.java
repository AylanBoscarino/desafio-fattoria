package com.aylan;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
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
import org.hibernate.query.Query;

/**
 * Servlet implementation class ProdutoDao
 */
@WebServlet("/produtoDao")
public class ProdutoDao extends HttpServlet {
	private SessionFactory sessionFactory;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdutoDao() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(new JsonConverter().convertToJson(listar()));
		out.flush();
		
	}

	/**d
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Produto p = new Produto();
		p.setNome(request.getParameter("nome"));
		p.setPreco(new BigDecimal(request.getParameter("preco")));
		p.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
		p.setData(Date.valueOf(request.getParameter("data")));
		
		salvar(p);
	}
	
	
	
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void salvar(Produto p) {
		//System.out.println("na fábrica");
		//Session session = this.sessionFactory.openSession();
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();

		Transaction tx = session.beginTransaction();
		
		session.persist(p);
		
		tx.commit();
		session.close();
		
	}
	public List<Produto> listar() {
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		Query query = session.createQuery("from Produto");
		
		List<Produto> listaProdutos = query.list();
		session.close();
		return listaProdutos;
	}

	
			

}
