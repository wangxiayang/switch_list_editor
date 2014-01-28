package me.horzwxy.server.fileserver.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

import me.horzwxy.server.fileserver.model.Rule;
import me.horzwxy.server.fileserver.model.Rule.RuleType;

public class RuleDAO {
	
	public static final String RULE_DATA_TYPE = "rule";
	
	public static final String RULE_KEY_CONTENT = "content";
	public static final String RULE_KEY_TYPE = "type";

	public static void addRule(Rule rule) {
		Entity entity = createEntity(rule);
        DatastoreService service = DatastoreServiceFactory.getDatastoreService();
        service.put(entity);
	}
	
	public static void removeRule(long ruleId) {
		Key key = KeyFactory.createKey( RULE_DATA_TYPE, ruleId );
		DatastoreService service = DatastoreServiceFactory.getDatastoreService();
        service.delete(key);
	}
	
	public static boolean hasRule(Rule rule) {
		return getAllRules().contains(rule);
	}
	
	public static List<Rule> getAllRules() {
		DatastoreService service = DatastoreServiceFactory.getDatastoreService();
        Query query = new Query(RULE_DATA_TYPE);
        PreparedQuery pQuery = service.prepare( query );
        Iterator< Entity > iterator = pQuery.asIterator();
        List< Rule > result = new ArrayList< Rule >();
        while( iterator.hasNext() ) {      	
        	Entity entity = iterator.next();
            result.add( createRule( entity ) );
        }
        return result;
	}
	
	private static Entity createEntity(Rule rule) {
		Entity entity = new Entity(RULE_DATA_TYPE);
		entity.setProperty(RULE_KEY_CONTENT, rule.content);
		entity.setProperty(RULE_KEY_TYPE, rule.type.name());
		
		return entity;
	}
	
	private static Rule createRule(Entity entity) {
		Rule rule = new Rule();
		rule.id = entity.getKey().getId();
		rule.type = RuleType.valueOf((String)entity.getProperty(RULE_KEY_TYPE));
		rule.content = (String)entity.getProperty(RULE_KEY_CONTENT);
		
		return rule;
	}
}
