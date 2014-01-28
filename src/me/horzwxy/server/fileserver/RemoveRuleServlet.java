package me.horzwxy.server.fileserver;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.horzwxy.server.fileserver.dao.RuleDAO;

public class RemoveRuleServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		RuleDAO.removeRule(Long.parseLong(req.getParameter("ruleId")));
		
		resp.getWriter().println("ok");
	}
}
