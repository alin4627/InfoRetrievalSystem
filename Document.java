
public class Document {
	public int ID,totalReviews;
	public String APP_Name, Genre , UserReview, Price;
	public double User_Rating;
	
	public Document( int ID, String APP_Name, String Genre , String Price, double User_Rating ,int totalReviews ,String UserReview)
	{
		this.ID = ID;
		this.totalReviews = totalReviews;
		this.APP_Name = APP_Name;
		this.Genre = Genre;
		this.UserReview = UserReview;
		this.User_Rating = User_Rating;
		this.Price = Price;
	}

	public Document()
	{
	}
	
	
	
	 public String toString() {
		 return "" + ID + "| " + APP_Name + "| " + Genre + "| " + Price + "| " + User_Rating + "| " + totalReviews + "| " + UserReview + "\n";
	 }

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getTotalReviews() {
		return totalReviews;
	}

	public void setTotalReviews(int totalReviews) {
		this.totalReviews = totalReviews;
	}

	public String getAPP_Name() {
		return APP_Name;
	}

	public void setAPP_Name(String aPP_Name) {
		APP_Name = aPP_Name;
	}

	public String getGenre() {
		return Genre;
	}

	public void setGenre(String genre) {
		Genre = genre;
	}

	public String getUserReview() {
		return UserReview;
	}

	public void setUserReview(String userReview) {
		UserReview = userReview;
	}

	public double getUser_Rating() {
		return User_Rating;
	}

	public void setUser_Rating(double user_Rating) {
		User_Rating = user_Rating;
	}

	public String getPrice() {
		return Price;
	}

	public void setPrice(String price) {
		Price = price;
	}
}
