package com.din.backend.store.query;
import com.din.backend.utility.TableColumn;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.CompositeFilterOperator;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;

public class PostQuery {
	public PostQuery(){
// Get the Datastore Service
DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

Filter heightMinFilter =
  new FilterPredicate(TableColumn.Post.ID,
                      FilterOperator.EQUAL,
                      "1443025300483");

Filter heightMaxFilter =
  new FilterPredicate("height",
                      FilterOperator.LESS_THAN_OR_EQUAL,
                      "maxHeight");

//Use CompositeFilter to combine multiple filters
Filter heightRangeFilter =
  CompositeFilterOperator.and(heightMinFilter, heightMaxFilter);


// Use class Query to assemble a query
Query q = new Query("Person").setFilter(heightRangeFilter);

// Use PreparedQuery interface to retrieve results
PreparedQuery pq = datastore.prepare(q);


for (Entity result : pq.asIterable()) {
  String firstName = (String) result.getProperty("firstName");
  String lastName = (String) result.getProperty("lastName");
  Long height = (Long) result.getProperty("height");

  System.out.println(firstName + " " + lastName + ", " + height + " inches tall");
}
}}