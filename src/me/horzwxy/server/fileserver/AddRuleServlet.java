package me.horzwxy.server.fileserver;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.horzwxy.server.fileserver.dao.RuleDAO;
import me.horzwxy.server.fileserver.model.Rule;
import me.horzwxy.server.fileserver.model.Rule.RuleType;

public class AddRuleServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Rule rule = new Rule();
		rule.type = RuleType.WILDCARD;
		rule.content = req.getParameter("rule");
		if(!RuleDAO.hasRule(rule)) {
			RuleDAO.addRule(rule);
		}
		
		resp.getWriter().println("ok");
	}
}
