package test;

import java.util.Set;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

public class MongoDBTest {
   public static void main(String[] args) {
	Mongo m = new Mongo();
	DB db = m.getDB("testmongo");
	Set<String> cols = db.getCollectionNames();
	for (String s : cols) {
		System.out.println(s);
	}
	DBCollection collection = db.getCollection("new_test_col");
	BasicDBObject obj = new BasicDBObject();
	obj.put("name", "gutao");
	obj.put("to", "nibei");
	obj.put("love", "顾涛");
	collection.insert(obj);
	DBObject dbobj = collection.findOne();
	System.out.println(dbobj);
	for(int i=0;i<9;i++){
		collection.insert(new BasicDBObject().append("luming", i));
	}
	System.out.println(collection.count());
	DBCursor cursor = collection.find();
	while(cursor.hasNext()){
		System.out.println("遍历："+cursor.next());
	}
	BasicDBObject query = new BasicDBObject();
	query.put("luming", 1);
	cursor = collection.find(query);
	while (cursor.hasNext()) {
		System.out.println(cursor.next());
		
	}
	System.out.println("---------------分界符----------------");
	query = new BasicDBObject();
	query.put("luming", new BasicDBObject("$gt",5).append("$lt", 9));
    cursor = collection.find(query);
    while (cursor.hasNext()) {
		System.out.println(cursor.next());;
		
	}
    m.dropDatabase("testmongo");
   }
}
