package me.horzwxy.server.fileserver;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.horzwxy.server.fileserver.dao.RuleDAO;
import me.horzwxy.server.fileserver.model.Rule;
import me.horzwxy.server.fileserver.model.Rule.RuleType;

public class GenerateTxtServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		List<Rule> rules = RuleDAO.getAllRules();
		resp.getWriter().println("#BEGIN\n[Wildcard]\n");
		for(Rule rule : rules) {
			if(rule.type == RuleType.WILDCARD) {
				resp.getWriter().println(rule.content);
			}
		}
		resp.getWriter().println("\n[RegExp]\n");
		for(Rule rule : rules) {
			if(rule.type == RuleType.REGEXP) {
				resp.getWriter().println(rule.content);
			}
		}
		resp.getWriter().println("\n#END");
	}
}
