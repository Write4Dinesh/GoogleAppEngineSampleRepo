package com.din.shwe.data;

import com.din.shwe.constants.TableColumn;
import com.din.shwe.data.model.User;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;

public class UserDao {
	DatastoreService mDataStore = null;

	public UserDao() {
		mDataStore = DatastoreServiceFactory.getDatastoreService();
	}

	public User getUserByUserName(String userName) {
		Entity e = null;
			e = getUserEntityByUserName(userName);
		
		return getUserFromEntity(e);
	}
	public Entity getUserEntityByUserName(String userName) {
		Entity e = new Entity(TableColumn.User.TABLE_NAME,userName);// userName acts as unique id in next line
		try {
			e = mDataStore.get(e.getKey());
		} catch (EntityNotFoundException e1) {
			e1.printStackTrace();
			return null;
		}
	
		return e;
	}
	public boolean removeUserByUserName(String userName) {
		return true;
	}

	public boolean addUser(User newUser) {
		Entity entity = getEntityFromUser(newUser);
		mDataStore.put(entity);
		return true;
	}

	public boolean updateUser(User newUser) {

		mDataStore.put(getEntityFromUser(newUser));
		return true;
	}

	private Entity getEntityFromUser(User user) {
		Entity userEntity = new Entity(TableColumn.User.TABLE_NAME,
				user.getUserName());
		userEntity.setProperty(TableColumn.User.NAME, user.getName());
		userEntity.setProperty(TableColumn.User.USER_NAME, user.getUserName());
		userEntity.setProperty(TableColumn.User.IS_ACTIVE, user.getIsActive());
		userEntity.setProperty(TableColumn.User.IS_LOGGED_IN,
				user.getIsLoggedIn());
		userEntity.setProperty(TableColumn.User.PASSWORD, user.getPassword());
		userEntity
				.setProperty(TableColumn.User.SESSION_ID, user.getSessionId());

		return userEntity;
	}
	private User getUserFromEntity(Entity userEntity) {
		User user  = new User();
		user.setUserName(userEntity.getProperty(TableColumn.User.USER_NAME).toString());
		user.setPassword(userEntity.getProperty(TableColumn.User.PASSWORD).toString());
		Boolean b = (Boolean)userEntity.getProperty(TableColumn.User.IS_ACTIVE);
				user.setIsActive(b);
				Boolean bb = (Boolean)userEntity.getProperty(TableColumn.User.IS_LOGGED_IN);
				
				user.setIsLoggedIn(bb);
				
		user.setName(userEntity.getProperty(TableColumn.User.NAME).toString());
		Object sId = userEntity.getProperty(TableColumn.User.SESSION_ID);
		if(sId!=null){
			user.setSessionId(sId.toString());
		}
		
		
		return user;
	}
}
