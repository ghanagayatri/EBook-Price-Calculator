# EBook-Price-Calculator

## Description
This tool helps a user to login into his google account and help him retrieve prices for the ebooks on his readshelf.

# How is concurrency handled?
  1. The E-book price calculator involves retrieving prices from the Google Books API.
  2. We have implemented a sequential as well as a concurrent version of the code.
  3. In order to implement the concurrent version we have used ThreadPools and ExecutorService.
  4. Since the task in hand is I/O intensive we implement more threads as compared to the number of cores.
  5. The number of partitions used is equivalent to the number of books present in the ‘To Read’ section of the user’s bookshelf.
  6. Because of this we introduce isolated mutability where the threads do not have to share any information between each other.
  7. The prices retrieved from each thread is than added to the final total using the ‘Callable’ and ‘Future’ constructs in Java.
  
## Tools Used for the Project
  1. Eclipse – Development environment
  2. Google data plugin – Tool for interfacing code with Google Books API
  3. Swing plugin – UI design
