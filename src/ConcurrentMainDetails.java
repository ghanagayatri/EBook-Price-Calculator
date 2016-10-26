import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.api.services.books.Books;
import com.google.api.services.books.model.Volume;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import javax.swing.JLabel;
import java.awt.*;

import com.google.api.client.json.JsonFactory;

//sample execution of the code to retrieve the data in for a string 
class ConcurrentMainDetails{
	public static void main(final String[] args) throws IOException,Exception{
		InitDatabase User = new InitDatabase();
		ReaderInfo UserInfo = User.Initusers();
		
		
		final int numberOfCores = Runtime.getRuntime().availableProcessors();
		final double blockingCoefficient = 0.9;
		final int poolSize = (int)(numberOfCores / (1 - blockingCoefficient));
		String userID = null;
		
		PageOne frame1 = new PageOne();
		PageError frameError = new PageError();
		frame1.setLocation(0, 0);
		frame1.setVisible(true);
		
		//frame.btnOk.addActionListener((ActionListener) frame);
		
		
		//retrieving userID from username from the database
		while (!frame1.pageOneFlag)
		{
			userID = UserInfo.RetrieveUserID(frame1.nameget);
			if (userID == null && frame1.pageOneFlag)
			{
				frameError.setVisible(true);
				frame1.pageOneFlag = false;
			}
		}
		//retrieving user's bookshelf in the form a string
		final JsonFactory jsonFactory = new JacksonFactory();
		Retrievingbookids userBookIDS = new Retrievingbookids();
		ArrayList<String> BookIdList  = userBookIDS.queryUserID(jsonFactory,userID);
		System.out.println("list size: "+ BookIdList.size());
		final List<Callable<Map<String,Double>>> partitions = new ArrayList<Callable<Map<String,Double>>>();
		
		final long start = System.nanoTime();
		for (final String bookId:BookIdList)
		{
			partitions.add(new Callable<Map<String,Double>>() {
	    		 public Map<String,Double> call() throws Exception {
	    			 Map<String,Double> bookDict = new RetrievingDetails().queryBookIDList(jsonFactory,bookId);
	    		 	return bookDict;
	    		 }
			});
		}
		
		final ExecutorService executorPool = 
			      Executors.newFixedThreadPool(poolSize);
		  final List<Future<Map<String,Double>>> BookPrices = 
			      executorPool.invokeAll(partitions, 50000, TimeUnit.SECONDS);
		  
		  Double netprice=0.0;
		  Double price = 0.0;
		  int count =0;
		  
		  String spaces = "                                   ";
		  PageTwo frame2 = new PageTwo();
		  frame1.setVisible(false);
		  frame2.setVisible(true);
		  for(final Future<Map<String,Double>> BookPrice : BookPrices)
		  {
			  Map<String,Double> bookDict = BookPrice.get();
			  for (String title:bookDict.keySet())
			  {
				  price = bookDict.get(title);
				  String PriceString = spaces+(Double.toString(price));
				  
				  if (price == -1.0)
				  {
					  price = 0.0;
					  PriceString = spaces+"Free";
				  }
				  else if(price == -2.0)
				  {
					  price = 0.0;
					  PriceString = spaces+"NA";
					  
				  }
				  
				  
				  frame2.addRowTable(title, PriceString, count);
			  
			  }
			count = count+1;  
		  netprice += price; 
		  }
		  
		  DecimalFormat twoDForm = new DecimalFormat("#.##");
	      netprice = Double.valueOf(twoDForm.format(netprice));
		  
		  frame2.addRowTable("Total",spaces+Double.toString(netprice),count);
		  
		  executorPool.shutdown();
		  System.out.println("Total Price $"+netprice);
		  final long end = System.nanoTime();
		  frame2.addTime((end - start)/1.0e9);
		  int count1 =0;
		  while(!frame2.pagetwocloseflag){
			   count1 = count1 +1;
			   System.out.print("");
		  }
		  frame2.setVisible(false);
		  frame2.getDefaultCloseOperation();
		  System.exit(0);
		  //frame1.textField.setText("");
		  //frame1.setVisible(true);
		  	
		  }
		
	}
	