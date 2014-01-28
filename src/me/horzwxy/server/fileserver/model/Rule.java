package me.horzwxy.server.fileserver.model;

public class Rule {
	
	public long id;
	public RuleType type;
	public String content;
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Rule) {
			return this.type.equals(((Rule) o).type) && this.content.equals(((Rule) o).content);
		}
		
		return false;
	}
	
	public enum RuleType {
		WILDCARD,
		REGEXP;
	}
}
