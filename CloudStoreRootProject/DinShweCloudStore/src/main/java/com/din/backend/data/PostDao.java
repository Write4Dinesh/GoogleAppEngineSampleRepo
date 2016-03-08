package com.din.backend.data;

import com.din.backend.data.model.Post;
import com.din.backend.utility.TableColumn;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;

import java.util.ArrayList;
import java.util.List;

public class PostDao {
			DatastoreService mDataStore = null;

		public PostDao() {
			mDataStore = DatastoreServiceFactory.getDatastoreService();
		}

		public Post getPostByPostId(String id) {
			 Filter postByIdFilter = new FilterPredicate(TableColumn.Post.ID,
						FilterOperator.EQUAL, id);
				Query postByIdQuery = new Query(TableColumn.Post.TABLE_NAME);
				postByIdQuery.setFilter(postByIdFilter);
				PreparedQuery pq = mDataStore.prepare(postByIdQuery);
				Iterable<Entity> resultSet = pq.asIterable();
				List<Entity> postEntities = new ArrayList<Entity>();
				Entity e = null;
				for (Entity result : resultSet) {
				  postEntities.add(result);
				  e = result;
				}
			
			return getPostFromEntity(e);
		}
		
		private Entity getPostEntityByPostId(String id) {
			Entity e = new Entity(TableColumn.Post.TABLE_NAME,id);// PostName acts as unique id in next line
			try {
				e = mDataStore.get(e.getKey());
			} catch (EntityNotFoundException e1) {
				e1.printStackTrace();
				return null;
			}
		
			return e;
		}
		public boolean removePostByPostName(String PostName) {
			return true;
		}

		public boolean insertPost(Post newPost) {
			Entity entity = getEntityFromPost(newPost);
			if(entity==null) return false;
			mDataStore.put(entity);
			return true;
		}

		public boolean updatePost(Post currentPost) {

			mDataStore.put(getEntityFromPost(currentPost));
			return true;
		}

		private Entity getEntityFromPost(Post post) {
			if(post==null) return null;
			Entity PostEntity = new Entity(TableColumn.Post.TABLE_NAME,
					post.getId());
			PostEntity.setProperty(TableColumn.Post.TITLE, post.getTitle());
			PostEntity.setProperty(TableColumn.Post.MESSAGE, post.getMessage());
			PostEntity.setProperty(TableColumn.Post.DATE, post.getDate());
			
			return PostEntity;
		}
		private Post getPostFromEntity(Entity PostEntity) {
			if(PostEntity==null) return null;
			Post Post  = new Post();
			Post.setId(PostEntity.getProperty(TableColumn.Post.ID) + "");
			Post.setTitle(PostEntity.getProperty(TableColumn.Post.TITLE) + "");
			Post.setMessage(PostEntity.getProperty(TableColumn.Post.MESSAGE) + "");					
			Post.setDate(PostEntity.getProperty(TableColumn.Post.DATE) + "");
			
			return Post;
		}
		public List<Post> getAll(){
				Query getAllQuery = new Query(TableColumn.Post.TABLE_NAME);
				PreparedQuery pq = mDataStore.prepare(getAllQuery);
				Iterable<Entity> resultSet = pq.asIterable();
				List<Post> allPosts = new ArrayList<Post>();
				for (Entity result : resultSet) {
				  allPosts.add(getPostFromEntity(result));
				}
			return allPosts;
		}
		public boolean removeById(String id){
			Post toBeDeletedPost = getPostByPostId(id);
			remove(toBeDeletedPost);			
			return true;
		}
		public boolean remove(Post post){
			Entity toBeDeleted = getEntityFromPost(post);
			if(toBeDeleted==null) return false;
			mDataStore.delete(toBeDeleted.getKey());
			
			return true;
		}
		public boolean removeAll(){
			return true;
		}
	}


