import java.io.BufferedReader;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.api.services.books.Books;
import com.google.api.services.books.model.Volume;
import java.io.IOException;
import java.text.NumberFormat;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.api.client.json.JsonFactory;

//sample execution of the code to retrieve the data in for a string 
class SequentialMain{
	public static void main(final String[] args) throws IOException,Exception{
		InitDatabase User = new InitDatabase();
		ReaderInfo UserInfo = User.Initusers();
		//retrieving userID from username from the database
		String userID = UserInfo.RetrieveUserID("nisarg.shah1988");
		System.out.println("User Id:"+userID);
		//retrieving user's bookshelf in the form a string
		JsonFactory jsonFactory = new JacksonFactory();
		Retrievingbookids userBookIDS = new Retrievingbookids();
		ArrayList<String> BookIdList  = userBookIDS.queryUserID(jsonFactory,userID);
		RetrievingPrices bookPrice = new RetrievingPrices();
		double TotalPrice = 0.0;
		final long start = System.nanoTime();
		for (String bookId:BookIdList)
		{
			TotalPrice = TotalPrice +  bookPrice.queryBookIDList(jsonFactory,bookId);
		}
		System.out.println("Total Price $"+TotalPrice);
		final long end = System.nanoTime();
		System.out.println("Time (seconds) taken " + (end - start)/1.0e9);	
	}
}