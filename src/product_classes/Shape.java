/*Author Mark DiFiglio
*Date 4/20/2017
*
*holds a shapes object. Ex. all the information for the ThermalWeld Plus, Half Round shape
*you will have about 15 of these loaded to a ShapeHolder
*/
package product_classes;

import java.util.ArrayList;

public class Shape {
	
	/******************************************************************************************
	Variables
	******************************************************************************************/
	
	private String name; //name of the shape ex. Half Round
	private String per; //measurement it uses ex. Base
	
	private ArrayList<ArrayList<String>> size; //2d array of sizes ex. [UI, 22, 96], [Height, 0, 0], ...
	private ArrayList<String> energyList; //dropdown list ex. energySMART®Supreme 2, energySMART®Supreme 2 Triple, ...; don't include Muntins
	private ArrayList<ArrayList<String>> shapeNum; //2d array of shapeNum ex. [36, 482, 14, 28, ...], ...; include muntins numbers
	
	
	
	/******************************************************************************************
	Constructors
	******************************************************************************************/
	
	/**
	 * 
	 */
	public Shape(){
		this.name = "";
		this.per = "";
		this.size = new ArrayList<ArrayList<String>>();
		this.energyList = new ArrayList<String>();
		this.shapeNum = new ArrayList<ArrayList<String>>();		
	}

	/**
	 * @param name
	 * @param per
	 * @param size
	 * @param energyList
	 * @param shapeNum
	 */
	public Shape(String name, String per, ArrayList<ArrayList<String>> size, ArrayList<String> energyList, ArrayList<ArrayList<String>> shapeNum) {
		this.name = name;
		this.per = per;
		this.size = size;
		this.energyList = energyList;
		this.shapeNum = shapeNum;
	}

	
	
	/******************************************************************************************
	Get price methods
	******************************************************************************************/
	
	/**
	 * @param index
	 * @param unit is the measurement needed for that shape ex. UI or base.
	 * @return
	 */
	public float getEnergyPrice(int index, float unit){
		index += 2;
		if (index + 1 >= energyList.size()) return -1; //check index in bound
		if (unit >= Float.parseFloat(shapeNum.get(shapeNum.size() - 1).get(0))) return -2;//check unit in bound
		
		//loop until shapeNum.get(i).get(0) > unit
		int i = 0;
		while (Float.parseFloat(shapeNum.get(i).get(0)) > unit) i++;
		return Float.parseFloat(shapeNum.get(i).get(index)); //return energy price
	}
	
	/**
	 * @param unit
	 * @return
	 */
	public float getListPrice(float unit){
		if (unit >= Float.parseFloat(shapeNum.get(shapeNum.size() - 1).get(0))) return -1;//check unit in bound
		
		//loop until shapeNum.get(i).get(0) > unit
		int i = 0;
		while (Float.parseFloat(shapeNum.get(i).get(0)) > unit) i++;
		return Float.parseFloat(shapeNum.get(i).get(1)); //return list price
	}
	
	/**
	 * @param unit
	 * @return
	 */
	public float getMuntinPrice(float unit){
		if (unit >= Float.parseFloat(shapeNum.get(shapeNum.size() - 1).get(0))) return -1;//check unit in bound
		
		//loop until shapeNum.get(i).get(0) > unit
		int i = 0;
		while (Float.parseFloat(shapeNum.get(i).get(0)) > unit) i++;
		return Float.parseFloat(shapeNum.get(i).get(shapeNum.get(i).size() - 1)); //return muntin Price
	}
		
	
	
	/******************************************************************************************
	Public methods
	******************************************************************************************/
	
	/**
	 * @return
	 */
	public String getUIMinMax(){
		return size.get(0).get(0) + " Min:" + size.get(0).get(1) + " Max:" + size.get(0).get(2);
	}
	
	/**
	 * @return
	 */
	public String getHeightMinMax(){
		return size.get(1).get(0) + " Min:" + size.get(1).get(1) + " Max:" + size.get(1).get(2);
	}
	
	/**
	 * @return
	 */
	public String getWidthMinMax(){
		return size.get(2).get(0) + " Min:" + size.get(2).get(1) + " Max:" + size.get(2).get(2);
	}
	
	/**
	 * @return
	 */
	public String getBaseMinMax(){
		return size.get(3).get(0) + " Min:" + size.get(3).get(1) + " Max:" + size.get(3).get(2);
	}
	
	/**
	 * @return
	 */
	public String getDiameterMinMax(){
		return size.get(4).get(0) + " Min:" + size.get(4).get(1) + " Max:" + size.get(4).get(2);
	}
	
	/**
	 * @return
	 */
	public String getLegMinMax(){
		return size.get(5).get(0) + " Min:" + size.get(5).get(1) + " Max:" + size.get(5).get(2);
	}
	
	/**
	 * @return
	 */
	public String getPitchMinMax(){
		return size.get(6).get(0) + " Min:" + size.get(6).get(1) + " Max:" + size.get(6).get(2);
	}
	
	/**
	 * @return
	 */
	public String getAngleMinMax(){
		return size.get(7).get(0) + " Min:" + size.get(7).get(1) + " Max:" + size.get(7).get(2);
	}
	
	
	
	/******************************************************************************************
	Getters & Setters & Adders
	******************************************************************************************/
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the per
	 */
	public String getPer() {
		return per;
	}

	/**
	 * @param per the per to set
	 */
	public void setPer(String per) {
		this.per = per;
	}

	/**
	 * @return the size
	 */
	public ArrayList<ArrayList<String>> getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(ArrayList<ArrayList<String>> size) {
		this.size = size;
	}

	/**
	 * @return the energyList
	 */
	public ArrayList<String> getEnergyList() {
		return energyList;
	}

	/**
	 * @param energyList the energyList to set
	 */
	public void setEnergyList(ArrayList<String> energyList) {
		this.energyList = energyList;
	}

	/**
	 * @return the shapeNum
	 */
	public ArrayList<ArrayList<String>> getShapeNum() {
		return shapeNum;
	}

	/**
	 * @param shapeNum the shapeNum to set
	 */
	public void setShapeNum(ArrayList<ArrayList<String>> shapeNum) {
		this.shapeNum = shapeNum;
	}	
}
