package com.aylan;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
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
 * Servlet implementation class DeleteDao
 */
@WebServlet("/deleteDao")
public class DeleteDao extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SessionFactory sessionFactory;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteDao() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println(request.getParameter("data-id"));
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		remover(Long.parseLong(request.getParameter("data-id")));
	}
	public void remover(long id) {

	     
		this.sessionFactory=new Configuration().configure().buildSessionFactory();
	    Session session = this.sessionFactory.getCurrentSession();
	    Transaction tx = session.beginTransaction();
	    Produto produto = (Produto) session.load(Produto.class, new Long(id));
	    if (null != produto) {
	    	session.delete(produto);
	    }
	    tx.commit();
	    session.close();

	}
	
	
	

}
