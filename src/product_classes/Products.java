/*Author Mark DiFiglio
 * 4/3/2017
 * 
 * Parent class of all product classes (Windows, ShapeHolder, Garden, Bays_Bows)
 * Holds the information needed to access the products in the arrayLists of Holder.
 */

package product_classes;

public class Products{
	
	/******************************************************************************************
	Variables
	******************************************************************************************/
	
	private String productName; //the first cell on the sheet
	private String className; //the name of the class it will go to like ex. DW_Extra
	
	
	
	/******************************************************************************************
	Constructors
	******************************************************************************************/
	
	/**
	 * 
	 */
	Products (){
		productName = "NULL";
		className = "Products";
	}
	
	/**
	 * @param productName
	 * @param className
	 */
	Products (String productName, String className){
		this.productName = productName;
		this.className = className;
	}
	
	
	
	/******************************************************************************************
	Getters & Setters
	******************************************************************************************/
	
	/**
	 * 
	 * @return
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * @param className
	 */
	public void setClassName(String className) {
		this.className = className;
	}
}
