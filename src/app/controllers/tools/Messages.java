package app.controllers.tools;

public class Messages {
    public static class Error {
        public static String WRONG_CREDENTIALS = "Your login credentials are wrong.";
        public static String ITEM_NOT_VALID = "The input for the item was not valid.";
        public static String ITEM_NOT_ADDED = "The item could not be added.";
        public static String ITEM_NOT_UPDATED = "The item could not be updated.";
        public static String ITEM_NOT_FOUND = "The item was not found.";
        public static String ITEM_NOT_DELETED = "The item could not be deleted.";
        public static String COAUTHOR_NOT_ADDED = "The co author could not be added";
        public static String FIELD_IS_EMPTY = "Please fill all the required fields";
        public static String PASSWORD_NOT_MATCH = "Passwords do not match";
    }

    public static class Info {
        public static String SUCCESSFUL_LOGIN = "You logged in successfully.";
        public static String ITEM_ADDED_SUCCESSFULLY = "The item was added successfully.";
        public static String ITEM_UPDATED_SUCCESSFULLY = "The item was updated successfully.";
        public static String ITEM_FOUND = "The item was found.";
        public static String ITEM_DELETED = "The item was successfully deleted.";
        public static String COAUTHOR_ADDED = "The co author was added successfully.";
    }
}
