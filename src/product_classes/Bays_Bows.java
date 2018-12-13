/*Author Mark DiFiglio
 * 4/6/2017
 * 
 * Holds the information of one type of bay or bow window
 */

package product_classes;

import java.util.ArrayList;

public class Bays_Bows extends Products{

	/******************************************************************************************
	Variables
	******************************************************************************************/
	
	private ArrayList<ArrayList<String>> bay_BowNum; //store the whole chart in this as seen in the excel sheet
	
	
	
	/******************************************************************************************
	Constructors
	******************************************************************************************/
	
	/**
	 * 
	 */
	public Bays_Bows(){
		bay_BowNum = new ArrayList<ArrayList<String>>();
	} 
	
	/**
	 * @param bay_BowNum
	 */
	public Bays_Bows(ArrayList<ArrayList<String>> bay_BowNum) {
		this.bay_BowNum = bay_BowNum;
	}

	
	
	/******************************************************************************************
	Get price method
	******************************************************************************************/
	
	/**
	 * @return the Bay_Bows price.
	 */
	public float getBay_BowPrice(float width, float height) {
		if (!bay_BowNum.isEmpty()) {
			int w = 1; //width
			int h = 1; //height
			//check min/max width/heights
			while (width > Float.parseFloat(bay_BowNum.get(w).get(0))) { //find width index
				w++;
				if (w == bay_BowNum.size() - 1) return -1; //error flag
			}
			while (height > Float.parseFloat(bay_BowNum.get(0).get(h))) { //find height index
				h++;
				if (h == bay_BowNum.size()) return -2; //error flag
			}
			if (bay_BowNum.get(w).get(h).equals("N/A")) return -3; //no price/error
			return Float.parseFloat(bay_BowNum.get(w).get(h));
		}
		return -1; //error flag
	}	
	
	
	
	/******************************************************************************************
	Getters & Setters
	******************************************************************************************/

	/**
	 * @return the bay_BowNum
	 */
	public ArrayList<ArrayList<String>> getBay_BowNum() {
		return bay_BowNum;
	}

	/**
	 * @param bay_BowNum the bay_BowNum to set
	 */
	public void setBay_BowNum(ArrayList<ArrayList<String>> bay_BowNum) {
		this.bay_BowNum = bay_BowNum;
	}
	
	
	/**
	 * @return the Bay_Bows name.
	 */
	public String getBay_BowName() {
		if (bay_BowNum.size() > 0 && bay_BowNum.get(0).size() > 0) return bay_BowNum.get(0).get(0);
		return "null";
	}
	
	/**
	 * @return the Bay_Bows projection.
	 */
	public String getBay_BowProjection() {
		if (!bay_BowNum.isEmpty()) {
			String str = "Min: " + bay_BowNum.get(bay_BowNum.size() - 1).get(3);
			if (bay_BowNum.get(bay_BowNum.size() - 1).size() > 4) str += " Max: " + bay_BowNum.get(bay_BowNum.size() - 1).get(4);
			return str;
		}				
		return "null";
	}
	
	/**
	 * @return the Bay_Bows width label.
	 */
	public String getBay_BowWidthLabel() {
		if (!bay_BowNum.isEmpty()) {
			return "Min: " + bay_BowNum.get(bay_BowNum.size() - 1).get(1) + " Max " + bay_BowNum.get(bay_BowNum.size() - 1).get(2);
		}
		return "null";
	}	
	
	/**
	 * @return True if within width.
	 */
	public Boolean getBay_BowWidth(float width) {
		if (!bay_BowNum.isEmpty()) {
			if (width >= Float.parseFloat(bay_BowNum.get(bay_BowNum.size() - 1).get(1)) 
				&& width <= Float.parseFloat(bay_BowNum.get(bay_BowNum.size() - 1).get(2))) return true;
		}
		return false;
	}
}
