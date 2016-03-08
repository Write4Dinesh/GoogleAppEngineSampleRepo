package com.din.backend.utility;

public class TableColumn {
	public static final class Post {
		public static final String TABLE_NAME = "Post";
		public static final String ID = "Id";
		public static final String TITLE = "Title";
		public static final String DATE = "Date";
		public static final String MESSAGE = "Message";
	}
	public static final class User {
		public static final String TABLE_NAME = "User";
		public static final String USER_NAME = "user_name";
		public static final String NAME = "name";
		public static final String PASSWORD = "password";
		public static final String IS_ACTIVE = "is_active";
		public static final String SESSION_ID = "session_id";
		public static final String IS_LOGGED_IN = "is_logged_in";
	}
}
