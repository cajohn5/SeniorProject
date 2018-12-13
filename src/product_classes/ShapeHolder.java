/*Author Mark DiFiglio
*Date 4/20/2017
*
*This holds all the shape windows of either ThermalWeld Plus or UltraWeld. 
*You will have two of these loaded to the arrayList Shapes in Holder.java
*create this object, read the sheet to load up Shape objects and add those objects to this class 
*once loaded with the ~15 Shape objects add it to the Holder object shapes arrayList
*/

package product_classes;

import java.util.ArrayList;

public class ShapeHolder extends Products{
	
	/******************************************************************************************
	Variables
	******************************************************************************************/
	private ArrayList<String> shapeList; //dropdown of all the shape names Ex. Half Round, Extended Leg Half Round, ...
	private ArrayList<Shape> shapeObjects; //holds all the different shapes
	
	private float priceMultiplier; //hold priceMultiplier information
	
	private String gridLabel; //label
	private ArrayList<String> gridList; //dropdown
	private ArrayList<ArrayList<String>> gridNum;
	
	private String vinylColorLabel; //label
	private ArrayList<String> vinylColorList; //dropdown
	private ArrayList<ArrayList<String>> vinylColorNum;
	
	private String glassStrengthLabel; //label
	private ArrayList<String> glassStrengthList; //dropdown
	private ArrayList<ArrayList<String>> glassStrengthNum;
	
	private String glassLabel; //label
	private ArrayList<String> glassList; //dropdown
	private ArrayList<ArrayList<String>> glassNum;
	
	private String glassTintLabel; //label
	private ArrayList<String> glassTintList; //dropdown
	private ArrayList<ArrayList<String>> glassTintNum;
	
	private String exteriorPaint;	//label
	private ArrayList<String> exteriorPaintList; //dropdown
	private ArrayList<ArrayList<String>> exteriorPaintNum;

	
	
	/******************************************************************************************
	Constructors
	******************************************************************************************/
	
	/**
	 * 
	 */
	public ShapeHolder() {
		super();
		this.shapeList = new ArrayList<String>();
		this.shapeObjects = new ArrayList<Shape>();
		this.priceMultiplier = 0;
		this.gridList = new ArrayList<String>();
		this.gridNum = new ArrayList<ArrayList<String>>();
		this.vinylColorLabel = "";
		this.vinylColorList = new ArrayList<String>();
		this.vinylColorNum = new ArrayList<ArrayList<String>>();
		this.glassStrengthLabel = "";
		this.glassStrengthList = new ArrayList<String>();
		this.glassStrengthNum = new ArrayList<ArrayList<String>>();
		this.glassLabel = "";
		this.glassList = new ArrayList<String>();
		this.glassNum = new ArrayList<ArrayList<String>>();
		this.glassTintLabel = "";
		this.glassTintList = new ArrayList<String>();
		this.glassTintNum = new ArrayList<ArrayList<String>>();
		this.exteriorPaint = "";
		this.exteriorPaintList = new ArrayList<String>();
		this.exteriorPaintNum = new ArrayList<ArrayList<String>>();
	}
	
	/**
	 * @param productName
	 * @param className
	 * @param shapeList
	 * @param shapeObjects
	 * @param priceMultiplier
	 * @param gridLabel
	 * @param gridList
	 * @param gridNum
	 * @param vinylColorLabel
	 * @param vinylColorList
	 * @param vinylColorNum
	 * @param glassStrengthLabel
	 * @param glassStrengthList
	 * @param glassStrengthNum
	 * @param glassLabel
	 * @param glassList
	 * @param glassNum
	 * @param glassTintLabel
	 * @param glassTintList
	 * @param glassTintNum
	 * @param exteriorPaint
	 * @param exteriorPaintList
	 * @param exteriorPaintNum
	 */
	public ShapeHolder(String productName, String className, ArrayList<String> shapeList, ArrayList<Shape> shapeObjects, float priceMultiplier,
			String gridLabel, ArrayList<String> gridList, ArrayList<ArrayList<String>> gridNum, String vinylColorLabel,
			ArrayList<String> vinylColorList, ArrayList<ArrayList<String>> vinylColorNum, String glassStrengthLabel,
			ArrayList<String> glassStrengthList, ArrayList<ArrayList<String>> glassStrengthNum, String glassLabel,
			ArrayList<String> glassList, ArrayList<ArrayList<String>> glassNum, String glassTintLabel,
			ArrayList<String> glassTintList, ArrayList<ArrayList<String>> glassTintNum, String exteriorPaint,
			ArrayList<String> exteriorPaintList, ArrayList<ArrayList<String>> exteriorPaintNum) {
		super(productName, className);
		this.shapeList = shapeList;
		this.shapeObjects = shapeObjects;
		this.priceMultiplier = priceMultiplier;
		this.gridLabel = gridLabel;
		this.gridList = gridList;
		this.gridNum = gridNum;
		this.vinylColorLabel = vinylColorLabel;
		this.vinylColorList = vinylColorList;
		this.vinylColorNum = vinylColorNum;
		this.glassStrengthLabel = glassStrengthLabel;
		this.glassStrengthList = glassStrengthList;
		this.glassStrengthNum = glassStrengthNum;
		this.glassLabel = glassLabel;
		this.glassList = glassList;
		this.glassNum = glassNum;
		this.glassTintLabel = glassTintLabel;
		this.glassTintList = glassTintList;
		this.glassTintNum = glassTintNum;
		this.exteriorPaint = exteriorPaint;
		this.exteriorPaintList = exteriorPaintList;
		this.exteriorPaintNum = exteriorPaintNum;
	}
	
	
	
	/******************************************************************************************
	Get price methods
	******************************************************************************************/
	
	/**
	 * @param shapeIndex
	 * @param energyIndex
	 * @param unit
	 * @return
	 */
	public float getEnergyPrice(int shapeIndex, int energyIndex, float unit){		
		if (shapeIndex >= shapeObjects.size()) return -5; //check shapeIndex
		return priceMultiplier * shapeObjects.get(shapeIndex).getEnergyPrice(energyIndex, unit); //calls shape energyPrice
	}
	
	/**
	 * @param shapeIndex
	 * @param unit
	 * @return
	 */
	public float getListPrice(int shapeIndex, float unit){
		if (shapeIndex >= shapeObjects.size()) return -5; //check shapeIndex
		return priceMultiplier * shapeObjects.get(shapeIndex).getListPrice(unit); //calls shape listPrice		
	}
	
	/**
	 * @param shapeIndex
	 * @param unit
	 * @return
	 */
	public float getMuntinPrice(int shapeIndex, float unit){
		if (shapeIndex >= shapeObjects.size()) return -5; //check shapeIndex
		return priceMultiplier * shapeObjects.get(shapeIndex).getMuntinPrice(unit); //calls shape muntinPrice
	}
		
	/**
	 * @param shapeIndex
	 * @param gridIndex
	 * @param unit
	 * @return
	 */
	public float getGridPrice(int shapeIndex, int gridIndex, float unit){
		if (shapeIndex >= shapeObjects.size()) return -5; //check shapeIndex
		if (gridIndex >= gridNum.size()) return -6; //check gridIndex
		return priceMultiplier * Float.parseFloat(gridNum.get(gridIndex).get(0)) * shapeObjects.get(shapeIndex).getMuntinPrice(unit); //returns grid price
	}
	
	/**
	 * @param shapeIndex
	 * @param vinylColorIndex
	 * @param unit
	 * @return
	 */
	public float getVinylColorPrice(int shapeIndex, int vinylColorIndex, float unit){
		if (shapeIndex >= shapeObjects.size()) return -5; //check shapeIndex
		if (vinylColorIndex >= vinylColorNum.size()) return -6; //check vinylColorIndex
		return priceMultiplier * Float.parseFloat(vinylColorNum.get(vinylColorIndex).get(0)) * shapeObjects.get(shapeIndex).getListPrice(unit); //returns vinyl color price	
	}
	
	/**
	 * @param index
	 * @param UI
	 * @return
	 */
	public float getGlassStrengthPrice(int index, float UI){
		if (index >= glassStrengthNum.size()) return -1; //index good
		return priceMultiplier * Float.parseFloat(glassStrengthNum.get(index).get(0)) * UI; //returns glass strength price
	}
	
	/**
	 * @param shapeIndex
	 * @param glassIndex
	 * @param unit
	 * @return
	 */
	public float getGlassTintPrice(int shapeIndex, int glassTintIndex, float unit){
		if (shapeIndex >= shapeObjects.size()) return -5; //check shapeIndex
		if (glassTintIndex >= glassTintNum.size()) return -6; //check glassTintIndex
		return priceMultiplier * Float.parseFloat(glassTintNum.get(glassTintIndex).get(0)) * shapeObjects.get(shapeIndex).getListPrice(unit); //returns glass tint price	
	}
	
	/**
	 * @param shapeIndex
	 * @param glassTintIndex
	 * @param unit
	 * @return
	 */
	public float getGlassPrice(int shapeIndex, int glassIndex, float unit){
		if (shapeIndex >= shapeObjects.size()) return -5; //check shapeIndex
		if (glassIndex >= glassNum.size()) return -6; //check vinylColorIndex
		return priceMultiplier * Float.parseFloat(glassNum.get(glassIndex).get(0)) * shapeObjects.get(shapeIndex).getListPrice(unit); //returns glass price	
	}
	
	/**
	 * @param index
	 * @return
	 */
	public float getExteriorPaint(int index){
		if (index >= exteriorPaintNum.size()) return -1; //check index
		return priceMultiplier * Float.parseFloat(exteriorPaintNum.get(index).get(0)); //returns exterior paint price
	}
	
	
	
	/******************************************************************************************
	Getters & Setters & Adders
	******************************************************************************************/
	
	/**
	 * @return the shapeList
	 */
	public ArrayList<String> getShapeList() {
		return shapeList;
	}

	/**
	 * @param shapeList the shapeList to set
	 */
	public void addShapeList(String shapeList) {
		this.shapeList.add(shapeList);
	}

	/**
	 * @return the shapeObjects
	 */
	public ArrayList<Shape> getShapeObjects() {
		return shapeObjects;
	}

	/**
	 * @param shapeObjects the shapeObjects to set
	 */
	public void addShapeObjects(Shape shapeObjects) {
		this.shapeObjects.add(shapeObjects);
	}

	/**
	 * @return the priceMultiplier
	 */
	public float getPriceMultiplier() {
		return priceMultiplier;
	}

	/**
	 * @param priceMultiplier the priceMultiplier to set
	 */
	public void setPriceMultiplier(float priceMultiplier) {
		this.priceMultiplier = priceMultiplier;
	}

	/**
	 * @return the gridLabel
	 */
	public String getGridLabel() {
		return gridLabel;
	}

	/**
	 * @param gridLabel the gridLabel to set
	 */
	public void setGridLabel(String gridLabel) {
		this.gridLabel = gridLabel;
	}

	/**
	 * @return the gridList
	 */
	public ArrayList<String> getGridList() {
		return gridList;
	}

	/**
	 * @param gridList the gridList to set
	 */
	public void setGridList(ArrayList<String> gridList) {
		this.gridList = gridList;
	}

	/**
	 * @return the gridNum
	 */
	public ArrayList<ArrayList<String>> getGridNum() {
		return gridNum;
	}

	/**
	 * @param gridNum the gridNum to set
	 */
	public void setGridNum(ArrayList<ArrayList<String>> gridNum) {
		this.gridNum = gridNum;
	}

	/**
	 * @return the vinylColorLabel
	 */
	public String getVinylColorLabel() {
		return vinylColorLabel;
	}

	/**
	 * @param vinylColorLabel the vinylColorLabel to set
	 */
	public void setVinylColorLabel(String vinylColorLabel) {
		this.vinylColorLabel = vinylColorLabel;
	}

	/**
	 * @return the vinylColorList
	 */
	public ArrayList<String> getVinylColorList() {
		return vinylColorList;
	}

	/**
	 * @param vinylColorList the vinylColorList to set
	 */
	public void setVinylColorList(ArrayList<String> vinylColorList) {
		this.vinylColorList = vinylColorList;
	}

	/**
	 * @return the vinylColorNum
	 */
	public ArrayList<ArrayList<String>> getVinylColorNum() {
		return vinylColorNum;
	}

	/**
	 * @param vinylColorNum the vinylColorNum to set
	 */
	public void setVinylColorNum(ArrayList<ArrayList<String>> vinylColorNum) {
		this.vinylColorNum = vinylColorNum;
	}

	/**
	 * @return the glassStrengthLabel
	 */
	public String getGlassStrengthLabel() {
		return glassStrengthLabel;
	}

	/**
	 * @param glassStrengthLabel the glassStrengthLabel to set
	 */
	public void setGlassStrengthLabel(String glassStrengthLabel) {
		this.glassStrengthLabel = glassStrengthLabel;
	}

	/**
	 * @return the glassStrengthList
	 */
	public ArrayList<String> getGlassStrengthList() {
		return glassStrengthList;
	}

	/**
	 * @param glassStrengthList the glassStrengthList to set
	 */
	public void setGlassStrengthList(ArrayList<String> glassStrengthList) {
		this.glassStrengthList = glassStrengthList;
	}

	/**
	 * @return the glassStrengthNum
	 */
	public ArrayList<ArrayList<String>> getGlassStrengthNum() {
		return glassStrengthNum;
	}

	/**
	 * @param glassStrengthNum the glassStrengthNum to set
	 */
	public void setGlassStrengthNum(ArrayList<ArrayList<String>> glassStrengthNum) {
		this.glassStrengthNum = glassStrengthNum;
	}

	/**
	 * @return the glassLabel
	 */
	public String getGlassLabel() {
		return glassLabel;
	}

	/**
	 * @param glassLabel the glassLabel to set
	 */
	public void setGlassLabel(String glassLabel) {
		this.glassLabel = glassLabel;
	}

	/**
	 * @return the glassList
	 */
	public ArrayList<String> getGlassList() {
		return glassList;
	}

	/**
	 * @param glassList the glassList to set
	 */
	public void setGlassList(ArrayList<String> glassList) {
		this.glassList = glassList;
	}

	/**
	 * @return the glassNum
	 */
	public ArrayList<ArrayList<String>> getGlassNum() {
		return glassNum;
	}

	/**
	 * @param glassNum the glassNum to set
	 */
	public void setGlassNum(ArrayList<ArrayList<String>> glassNum) {
		this.glassNum = glassNum;
	}

	/**
	 * @return the glassTintLabel
	 */
	public String getGlassTintLabel() {
		return glassTintLabel;
	}

	/**
	 * @param glassTintLabel the glassTintLabel to set
	 */
	public void setGlassTintLabel(String glassTintLabel) {
		this.glassTintLabel = glassTintLabel;
	}

	/**
	 * @return the glassTintList
	 */
	public ArrayList<String> getGlassTintList() {
		return glassTintList;
	}

	/**
	 * @param glassTintList the glassTintList to set
	 */
	public void setGlassTintList(ArrayList<String> glassTintList) {
		this.glassTintList = glassTintList;
	}

	/**
	 * @return the glassTintNum
	 */
	public ArrayList<ArrayList<String>> getGlassTintNum() {
		return glassTintNum;
	}

	/**
	 * @param glassTintNum the glassTintNum to set
	 */
	public void setGlassTintNum(ArrayList<ArrayList<String>> glassTintNum) {
		this.glassTintNum = glassTintNum;
	}

	/**
	 * @return the exteriorPaint
	 */
	public String getExteriorPaint() {
		return exteriorPaint;
	}

	/**
	 * @param exteriorPaint the exteriorPaint to set
	 */
	public void setExteriorPaint(String exteriorPaint) {
		this.exteriorPaint = exteriorPaint;
	}

	/**
	 * @return the exteriorPaintList
	 */
	public ArrayList<String> getExteriorPaintList() {
		return exteriorPaintList;
	}

	/**
	 * @param exteriorPaintList the exteriorPaintList to set
	 */
	public void setExteriorPaintList(ArrayList<String> exteriorPaintList) {
		this.exteriorPaintList = exteriorPaintList;
	}

	/**
	 * @return the exteriorPaintNum
	 */
	public ArrayList<ArrayList<String>> getExteriorPaintNum() {
		return exteriorPaintNum;
	}

	/**
	 * @param exteriorPaintNum the exteriorPaintNum to set
	 */
	public void setExteriorPaintNum(ArrayList<ArrayList<String>> exteriorPaintNum) {
		this.exteriorPaintNum = exteriorPaintNum;
	}	
}
