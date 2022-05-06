package librarymanagementsystem.project.model;

public class Category {
		int categoryid;
		String categoryname;
		
		public Category(int categoryid, String categoryname)
		{
			this.categoryid = categoryid;
			this.categoryname = categoryname;
		}
		
		public String toString()
		{
			return "CATEGORY_ID: " + categoryid + "\nCATEGORY_NAME: " + categoryname;

		}
		public int getCategoryId()
		{
			return categoryid;
		}
		public String getCategoryName()
		{
			return categoryname;
		}
}
