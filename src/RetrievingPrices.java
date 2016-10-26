//Sequential Retrieval of prices from a list of BookIds:
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.api.services.books.Books;
import com.google.api.services.books.model.Volume;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

public class RetrievingPrices{
	
	  private static final NumberFormat CURRENCY_FORMATTER = NumberFormat.getCurrencyInstance();
	  
	  public Double queryBookIDList(JsonFactory jsonFactory, String bookID) throws Exception 
	  {
	    // Set up Books client.
	    final Books books = Books.builder(new NetHttpTransport(), jsonFactory).build();
	    // Set query string and filter only Google eBooks.
	    //String uri = "https://www.googleapis.com/books/v1/volumes/";
	    //String query =  uri + bokID;
	    //System.out.println(query);
	    Volume volumes = books.volumes().get(bookID).execute();
	    if (volumes.getSaleInfo() == null || volumes.getSaleInfo().isEmpty()) {
	      System.out.println("No matches found.");
	      return 0.0;
	    }
	      Volume.SaleInfo saleInfo = volumes.getSaleInfo();
	      //System.out.println(saleInfo);
	      Volume.VolumeInfo volumeInfo = volumes.getVolumeInfo();
	      String title = volumeInfo.getTitle();
	      try{
	      Double price =  saleInfo.getRetailPrice().getAmount();
	      
	      System.out.println(title + "  "
	              + CURRENCY_FORMATTER.format(price));
	      return price;
	      }
	      catch (NullPointerException e){
	    	  Double price = 0.0;
	    	  if ("FREE".equals(saleInfo.getSaleability()))
	    	  {
	    	  System.out.println("Ebook for "+title+" is Free");
	    	  }
	    	  else
	    	  {
	    	  System.out.println("Ebook for "+volumeInfo.getTitle()+" not available");  
	    	  }
	    	  
		     return price ;
	      }
	          
	        }
	   
	  }

