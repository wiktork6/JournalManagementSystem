package app.controllers.tools;

public class Messages {
    public static class Error {
        public static String WRONG_CREDENTIALS = "Your login credentials are wrong.";
        public static String ITEM_NOT_VALID = "The input for the item was not valid.";
        public static String ITEM_NOT_ADDED = "The item could not be added.";
        public static String ITEM_NOT_UPDATED = "The item could not be updated.";
        public static String ITEM_NOT_FOUND = "The item was not found.";
        public static String ITEM_NOT_DELETED = "The item could not be deleted.";
        public static String COAUTHOR_NOT_FOUND = "The co author was not found.";
        public static String FIELD_IS_EMPTY = "Please fill all the required fields";
        public static String PASSWORD_NOT_MATCH = "Passwords do not match";
        public static String JOURNAL_ALREADY_EXISTS = "Journal with such name or ISSN already exists";
        public static String COAUTHOR_NOT_ADDED = "Co author could not be added";
        public static String CANT_ADD_YOURSELF_AS_COAUTHOR = "You can not add yourself as a co-author";
        public static String ALREADY_ADDED = "User is already added as an co-author";
        public static String EMAIL_TAKEN = "User with this email already exists.";
        public static String ISSN_LENGTH = "ISSN number has to be 8 digit long";
        public static String JOURNAL_DOES_NOT_EXIST = "Journal with following credentials does not exist";
        public static String CANT_RETIRE = "You can't retire if you are the only editor of a journal";
        public static String FUNCTION_NOT_ALLOWED = "Only chief editors are allowed to use this function";
        public static String SUBMISSION_NOT_FOUND = "Submissions not found";
        public static String VOLUMES_NOT_FOUND = "No volumes were found for this journal";
        public static String EDITIONS_NOT_FOUND = "No editions were found for this volume";
        public static String ARTICLES_NOT_FOUND = "No articles were found for this edition";
        public static String REVIEW_NOT_FOUND = "Reviews not found";
        public static String FINAL_VERDICT_NOT_SUBMITTED = "Final verdict is not submitted";
        public static String REVIEWER_NO_QUESTION = "Reviewer of your submission did not submit any questions";
        public static String TYPOGRAPHICALL_ERRORS_NOT_SUBMITTED = "Reviewer of you submission did not submit any typographicall errors";
        public static String CANT_ADD_YOURSELF_AS_NEW_EDITOR = "You can not add yourself as a new editor";
        public static String YOU_MUST_WAIT_FOR_REVIEWS = "You have to wait for all 3 reviews to be submitted before accessing verdicts";
        public static String USER_NOT_FOUND = "User with such email does not exist";
        public static String ONLY_MAIN_AUTHOR_CAN_RESPOND = "Only main authors can respond to questions";
    }

    public static class Info {
        public static String NO_AVAILABLE_SUBMISSION = "There are no submissions to be reviewed.";
        public static String NO_NEED_TO_REVIEW = "You do not need to review any more submissions.";
        public static String SUCCESSFUL_LOGIN = "You logged in successfully.";
        public static String ITEM_ADDED_SUCCESSFULLY = "The item was added successfully.";
        public static String ITEM_UPDATED_SUCCESSFULLY = "The item was updated successfully.";
        public static String ITEM_FOUND = "The item was found.";
        public static String ITEM_DELETED = "The item was successfully deleted.";
        public static String COAUTHOR_ADDED = "The co author was added successfully.";
    }
}
