class InitDatabase{
	ReaderInfo Initusers(){
		ReaderInfo User = new ReaderInfo();
		//manually adding username and userID this is our database as of now
		User.AddUser("nisarg.shah1988", "116053512345265482466");
		User.AddUser("rutrulez", "115037832852289404118");
		User.AddUser("rutvibjoshi", "100013786485917808706");
		User.AddUser("gayatrisrinivas29","104374773528264225928");
		return User;
	}

}