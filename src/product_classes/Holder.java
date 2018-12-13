/*Mark DiFiglio
 * 4/3/2017
 * 
 * The class that holds all the classes of Polaris products.
 * Use this class to hold and pass the products to the excel sheet and gui_classes.
 * Parent of Products class.
 * 
 */

package product_classes;

import java.util.ArrayList;

public class Holder {
	
	/******************************************************************************************
	Variables
	******************************************************************************************/
	
	private ArrayList<Products> DynaWeld;
	private ArrayList<Products> ThermalWeldPlus;
	private ArrayList<Products> UltraWeld;
	private ArrayList<Products> Shapes;
	private ArrayList<Products> Bay_Bows;
	private ArrayList<String> productList;
	private ArrayList<Integer> productListIndex;
	
	
	
	/******************************************************************************************
	Constructors
	******************************************************************************************/
	
	/**
	 * 
	 */
	public Holder() {
		this.DynaWeld = new ArrayList<Products>();
		this.ThermalWeldPlus = new ArrayList<Products>();
		this.UltraWeld = new ArrayList<Products>();
		this.Shapes = new ArrayList<Products>();
		this.Bay_Bows = new ArrayList<Products>();
		this.productList = new ArrayList<String>();
		this.productListIndex = new ArrayList<Integer>();
	}

	/**
	 * @param dynaWeld
	 * @param thermalWeldPlus
	 * @param ultraWeld
	 * @param shapes
	 * @param bay_Bows
	 * @param productList
	 * @param productListIndex
	 */
	public Holder(ArrayList<Products> dynaWeld, ArrayList<Products> thermalWeldPlus, ArrayList<Products> ultraWeld, ArrayList<Products> shapes,
			ArrayList<Products> bay_Bows, ArrayList<String> productList, ArrayList<Integer> productListIndex) {
		this.DynaWeld = dynaWeld;
		this.ThermalWeldPlus = thermalWeldPlus;
		this.UltraWeld = ultraWeld;
		this.Shapes = shapes;
		this.Bay_Bows = bay_Bows;
		this.productList = productList;
		this.productListIndex = productListIndex;
	}

	
	
	/******************************************************************************************
	Public methods
	******************************************************************************************/

	/**
	 * Given the index of the productList will return the index of that product in it's product array list.
	 * 
	 * @param Index of productList.
	 * @return Index of the product in it's array list.
	 */
	public int getProductIndex(int index){
		return productListIndex.get(index);
	}
	
	
	
	/******************************************************************************************
	Private methods
	******************************************************************************************/

	/**
	 * @param Adds a product to the ProductList array list.
	 */
	private void addProductList(String productName) {
		productList.add(productName);
	}

	/**
	 * @return the productListIndex
	 */
	private ArrayList<Integer> getProductListIndex() {
		return productListIndex;
	}

	/**
	 * @param index the index to set
	 */
	private void addProductListIndex(int index) {
		productListIndex.add(index);
	}
	
	
	
	/******************************************************************************************
	Getters & Adders
	******************************************************************************************/
	
	/**
	 * @return the dynaWeld
	 */
	public ArrayList<Products> getDynaWeld() {
		return DynaWeld;
	}

	/**
	 * @param Adds a Windows object to the dynaWeld array list.
	 */
	public void addDynaWeld(Windows dynaWeld) {
		addProductListIndex(DynaWeld.size()); //will take care of productList and productListIndex
		addProductList(dynaWeld.getProductName());
		DynaWeld.add(dynaWeld);	
	}

	/**
	 * @return the thermalWeldPlus
	 */
	public ArrayList<Products> getThermalWeldPlus() {
		return ThermalWeldPlus;
	}

	/**
	 * @param Adds a Windows object to the ThermalWeldPlus array list.
	 */
	public void addThermalWeldPlus(Windows thermalWeldPlus) {
		addProductListIndex(ThermalWeldPlus.size()); //will take care of productList and productListIndex
		addProductList(thermalWeldPlus.getProductName());
		ThermalWeldPlus.add(thermalWeldPlus);
	}

	/**
	 * @return the ultraWeld
	 */
	public ArrayList<Products> getUltraWeld() {
		return UltraWeld;
	}

	/**
	 * @param Adds a Windows object to the UltraWeld array list.
	 */
	public void addUltraWeld(Windows ultraWeld) {
		addProductListIndex(UltraWeld.size()); //will take care of productList and productListIndex
		addProductList(ultraWeld.getProductName());
		UltraWeld.add(ultraWeld);
	}

	/**
	 * @return the shapes
	 */
	public ArrayList<Products> getShapes() {
		return Shapes;
	}

	/**
	 * @param Adds a ShapeHolder object to the shapes array list.
	 */
	public void addShapes(ShapeHolder shapes) {
		addProductListIndex(Shapes.size()); //will take care of productList and productListIndex
		addProductList(shapes.getProductName());
		Shapes.add(shapes);
	}

	/**
	 * @return the bay_Bow
	 */
	public ArrayList<Products> getBay_Bows() {
		return Bay_Bows;
	}

	/**
	 * @param Adds a Bays_Bows object to the Bay_Bows array list.
	 */
	public void addBay_Bows(Bays_BowsHolder bay_Bows) {
		addProductListIndex(Bay_Bows.size()); //will take care of productList and productListIndex
		addProductList(bay_Bows.getProductName());
		Bay_Bows.add(bay_Bows);
	}

	/**
	 * @return the productList
	 */
	public ArrayList<String> getProductList() {
		return productList;
	}
		
}
