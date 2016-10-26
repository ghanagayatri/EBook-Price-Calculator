
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.api.services.books.Books;
import java.io.IOException;
import java.util.ArrayList;

import com.google.api.services.books.Books.Bookshelves;
import com.google.api.services.books.Books.Bookshelves.List;
import com.google.api.services.books.Books.Bookshelves.Volumes;
import com.google.api.services.books.model.Bookshelf;
import com.google.api.services.books.model.Volume;
import com.google.api.services.books.model.Volumeannotations;

public class Retrievingbookids{
	
	  public ArrayList<String> queryUserID(JsonFactory jsonFactory, String userID) throws Exception {
	    // Set up Books client.
	    final Books books = Books.builder(new NetHttpTransport(), jsonFactory).build();
	    ArrayList<String> list = new ArrayList<String>();
	    long  maxResult = 40;
	    com.google.api.services.books.model.Volumes volume= books.bookshelves().volumes().list(userID,"2").setMaxResults(maxResult).execute();
	    
	    // Execute the query.
	    if (volume.isEmpty()) {
	      System.out.println("matches not found.");
	    }

	    // Output results.
	    for (Volume volumes : volume.getItems()) {
	    	 list.add(volumes.getId());
	    }
	    
	    return list;
	  }
}
	 
/*	public static void main(String[] args) {
	    JsonFactory jsonFactory = new JacksonFactory();
	    try {
	      String userid = "104374773528264225928";
	     
	      try {
	        queryGoogleBooks(jsonFactory, userid);
	       
	        return;
	      } catch (IOException e) {
	        System.err.println(e.getMessage());
	      }
	    } catch (Throwable t) {
	      t.printStackTrace();
	    }
	    System.exit(0);
	  }
}*/