package me.horzwxy.server.fileserver;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.horzwxy.server.fileserver.dao.RuleDAO;

public class ListRulesServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ServletContext context = getServletContext();
		req.setAttribute("rules", RuleDAO.getAllRules());
		
		RequestDispatcher rd = req.getRequestDispatcher("edit.jsp");
		rd.forward(req, resp);
	}
}
