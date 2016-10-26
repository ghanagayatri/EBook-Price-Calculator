import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//this class is to store the database in a dictionary having usernames and userID
public class ReaderInfo {

   private Map<String,String> UserInfo = new HashMap<String, String>();

   //method to add users to the database
   public void AddUser(String username,String userID) {
     UserInfo.put(username, userID);
   }

   //method to retrieve userID from the database using usernames
   public String RetrieveUserID(String username) {
	   return UserInfo.get(username);
   }

}