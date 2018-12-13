/*Author Mark DiFiglio
 * 4/6/2017
 * 
 * Holds the generic information of bays & bows and the Bays_Bows objects of each shape
 */

package product_classes;

import java.util.ArrayList;

public class Bays_BowsHolder extends Products{

	/******************************************************************************************
	Variables
	******************************************************************************************/
	
	private float priceMultiplier;
	private ArrayList<Float> size; //heightMin, heightMax
	
	private ArrayList<String> bays_bowsList; //holds the name list of bays & bows
	private ArrayList<Bays_Bows> bays_bows; //holds all the bays & bows
	
	private String gridOptionsLabel; //label
	private String gridOptionCheckBoxLabel1; //Window Sashes
	private String gridOptionCheckBoxLabel2; //Center WDW (Bay Only)	
	private ArrayList<String> gridOptions; //dropdown of top (ex. colonial)
	private ArrayList<String> gridOptionsList; //dropdown of left (ex. flat)
	private ArrayList<ArrayList<Float>> gridOptionsNum;
		
	private String energyOptionsLabel; //label
	private ArrayList<String> energyOptionsList; //dropdown
	private ArrayList<ArrayList<String>> energyOptionsNum;
	
	private String glassStrengthLabel; //label
	private ArrayList<String> glassStrengthList; //dropdown
	private ArrayList<ArrayList<String>> glassStrengthNum;

	private String screenLabel; //label
	private ArrayList<String> screenList; //dropdown
	private ArrayList<ArrayList<String>> screenNum;
	
	private String screenMeshLabel; //label
	private ArrayList<String> screenMeshList; //dropdown
	private ArrayList<ArrayList<String>> screenMeshNum;
	
	private String spacerLabel; //label
	private ArrayList<String> spacerList; //dropdown
	private ArrayList<ArrayList<String>> spacerNum;
		
	private String glassTintLabel; //label
	private ArrayList<String> glassTintList; //dropdown
	private ArrayList<ArrayList<String>> glassTintNum;

	private String exteriorPaintLabel;	//label
	private ArrayList<String> exteriorPaintList; //dropdown
	private ArrayList<ArrayList<String>> exteriorPaintNum;
	
	private String customExtrasLabel; //label
	private ArrayList<String> customExtrasList; //checkboxes   add the list of custom extras 2 to this list
	private ArrayList<ArrayList<String>> customExtrasNum; 
	
	private String lockColorLabel; //label
	private float lockLimit; //the inch limit for 2 locks
	private ArrayList<String> lockColorList; //dropdown
	private ArrayList<ArrayList<String>> lockColorNum;
	private int locks; // this is set by the gui_classes not the excel files

	private String accessoriesLabel; //label
	private ArrayList<String> accessoriesList; //checkboxes
	private ArrayList<ArrayList<String>> accessoriesNum;
	
	private String plasticLabel; //label
	private ArrayList<String> plasticList; //dropdown
	private ArrayList<ArrayList<String>> plasticNum;
	
	private String avoniteLabel; //label
	private ArrayList<String> avoniteList; //dropdown
	private ArrayList<ArrayList<String>> avoniteNum;
	
	private String prepaintLabel; //label
	private ArrayList<String> prepaintList; //checkboxes
	private ArrayList<ArrayList<String>> prepaintNum;
	
	private String additionalLabel; //label
	private ArrayList<String> additionalList; //each has a dropdown of numbers
	private ArrayList<ArrayList<String>> additionalNum;
	
	private String fullSheetLabel; //label
	private ArrayList<String> fullSheetList; //dropdown
	private ArrayList<ArrayList<String>> fullSheetNum;
	
	private String precutLabel; //label
	private ArrayList<String> precutList; //checkboxes
	private ArrayList<ArrayList<String>> precutNum;
	
	private String roofLabel1; //label
	private ArrayList<String> roofList1; //dropdown ex. None, Concave, Hip
	private ArrayList<ArrayList<String>> roofNum1;
	
	private String roofLabel2; //label Masonry Flashing checkbox
	private ArrayList<String> roofList2; //dropdown ex. None, Concave, Hip
	private ArrayList<ArrayList<String>> roofNum2;
	
	private String copperLabel; //label
	private ArrayList<String> copperList; //checkboxes
	private ArrayList<ArrayList<String>> copperNum;
	
	private String lightLabel; //label
	private ArrayList<String> lightList; //dropdown
	private ArrayList<ArrayList<String>> lightNum;
	
	
	
	/******************************************************************************************
	Constructors
	******************************************************************************************/	
	
	/**
	 * 
	 */
	public Bays_BowsHolder() {
		super();
		this.priceMultiplier = 1;
		this.size = new ArrayList<Float>();
		this.bays_bowsList = new ArrayList<String>();
		this.bays_bows = new ArrayList<Bays_Bows>();
		this.gridOptionsLabel = "";
		this.gridOptionCheckBoxLabel1 = "";
		this.gridOptionCheckBoxLabel2 = "";
		this.gridOptions = new ArrayList<String>();
		this.gridOptionsList = new ArrayList<String>();
		this.gridOptionsNum = new ArrayList<ArrayList<Float>>();
		this.energyOptionsLabel = "";
		this.energyOptionsList = new ArrayList<String>();
		this.energyOptionsNum = new ArrayList<ArrayList<String>>();
		this.glassStrengthLabel = "";
		this.glassStrengthList = new ArrayList<String>();
		this.glassStrengthNum = new ArrayList<ArrayList<String>>();
		this.screenLabel = "";
		this.screenList = new ArrayList<String>();
		this.screenNum = new ArrayList<ArrayList<String>>();
		this.screenMeshLabel = "";
		this.screenMeshList = new ArrayList<String>();
		this.screenMeshNum = new ArrayList<ArrayList<String>>();
		this.spacerLabel = "";
		this.spacerList = new ArrayList<String>();
		this.spacerNum = new ArrayList<ArrayList<String>>();
		this.glassTintLabel = "";
		this.glassTintList = new ArrayList<String>();
		this.glassTintNum = new ArrayList<ArrayList<String>>();
		this.exteriorPaintLabel = "";
		this.exteriorPaintList = new ArrayList<String>();
		this.exteriorPaintNum = new ArrayList<ArrayList<String>>();
		this.customExtrasLabel = "";
		this.customExtrasList = new ArrayList<String>();
		this.customExtrasNum = new ArrayList<ArrayList<String>>();
		this.lockColorLabel = "";
		this.lockLimit = 1;
		this.lockColorList = new ArrayList<String>();
		this.lockColorNum = new ArrayList<ArrayList<String>>();
		this.locks = 1;
		this.accessoriesLabel = "";
		this.accessoriesList = new ArrayList<String>();
		this.accessoriesNum = new ArrayList<ArrayList<String>>();
		this.plasticLabel = "";
		this.plasticList = new ArrayList<String>();
		this.plasticNum = new ArrayList<ArrayList<String>>();
		this.avoniteLabel = "";
		this.avoniteList = new ArrayList<String>();
		this.avoniteNum = new ArrayList<ArrayList<String>>();
		this.prepaintLabel = "";
		this.prepaintList = new ArrayList<String>();
		this.prepaintNum = new ArrayList<ArrayList<String>>();
		this.additionalLabel = "";
		this.additionalList = new ArrayList<String>();
		this.additionalNum = new ArrayList<ArrayList<String>>();
		this.fullSheetLabel = "";
		this.fullSheetList = new ArrayList<String>();
		this.fullSheetNum = new ArrayList<ArrayList<String>>();
		this.precutLabel = "";
		this.precutList = new ArrayList<String>();
		this.precutNum = new ArrayList<ArrayList<String>>();
		this.roofLabel1 = "";
		this.roofList1 = new ArrayList<String>();
		this.roofNum1 = new ArrayList<ArrayList<String>>();
		this.roofLabel2 = "";
		this.roofList2 = new ArrayList<String>();
		this.roofNum2 = new ArrayList<ArrayList<String>>();
		this.copperLabel = "";
		this.copperList = new ArrayList<String>();
		this.copperNum = new ArrayList<ArrayList<String>>();
		this.lightLabel = "";
		this.lightList = new ArrayList<String>();
		this.lightNum = new ArrayList<ArrayList<String>>();
	}
	
	/**
	 * @param priceMultiplier
	 * @param size
	 * @param bays_bowsList
	 * @param bays_bows
	 * @param gridOptionsLabel
	 * @param gridOptionCheckBoxLabel1
	 * @param gridOptionCheckBoxLabel2
	 * @param gridOptions
	 * @param gridOptionsList
	 * @param gridOptionsNum
	 * @param energyOptionsLabel
	 * @param energyOptionsList
	 * @param energyOptionsNum
	 * @param glassStrengthLabel
	 * @param glassStrengthList
	 * @param glassStrengthNum
	 * @param screenLabel
	 * @param screenList
	 * @param screenNum
	 * @param screenMeshLabel
	 * @param screenMeshList
	 * @param screenMeshNum
	 * @param spacerLabel
	 * @param spacerList
	 * @param spacerNum
	 * @param glassTintLabel
	 * @param glassTintList
	 * @param glassTintNum
	 * @param exteriorPaintLabel
	 * @param exteriorPaintList
	 * @param exteriorPaintNum
	 * @param customExtrasLabel
	 * @param customExtrasList
	 * @param customExtrasNum
	 * @param lockColorLabel
	 * @param lockLimit
	 * @param lockColorList
	 * @param lockColorNum
	 * @param locks
	 * @param accessoriesLabel
	 * @param accessoriesList
	 * @param accessoriesNum
	 * @param plasticLabel
	 * @param plasticList
	 * @param plasticNum
	 * @param avoniteLabel
	 * @param avoniteList
	 * @param avoniteNum
	 * @param prepaintLabel
	 * @param prepaintList
	 * @param prepaintNum
	 * @param additionalLabel
	 * @param additionalList
	 * @param additionalNum
	 * @param fullSheetLabel
	 * @param fullSheetList
	 * @param fullSheetNum
	 * @param precutLabel
	 * @param precutList
	 * @param precutNum
	 * @param roofLabel1
	 * @param roofList1
	 * @param roofNum1
	 * @param roofLabel2
	 * @param roofList2
	 * @param roofNum2
	 * @param copperLabel
	 * @param copperList
	 * @param copperNum
	 * @param lightLabel
	 * @param lightList
	 * @param lightNum
	 */
	public Bays_BowsHolder(String productName, String className, float priceMultiplier, ArrayList<Float> size, ArrayList<String> bays_bowsList, ArrayList<Bays_Bows> bays_bows,
			String gridOptionsLabel, String gridOptionCheckBoxLabel1, String gridOptionCheckBoxLabel2,
			ArrayList<String> gridOptions, ArrayList<String> gridOptionsList,
			ArrayList<ArrayList<Float>> gridOptionsNum, String energyOptionsLabel, ArrayList<String> energyOptionsList,
			ArrayList<ArrayList<String>> energyOptionsNum, String glassStrengthLabel,
			ArrayList<String> glassStrengthList, ArrayList<ArrayList<String>> glassStrengthNum, String screenLabel,
			ArrayList<String> screenList, ArrayList<ArrayList<String>> screenNum, String screenMeshLabel,
			ArrayList<String> screenMeshList, ArrayList<ArrayList<String>> screenMeshNum, String spacerLabel,
			ArrayList<String> spacerList, ArrayList<ArrayList<String>> spacerNum, String glassTintLabel,
			ArrayList<String> glassTintList, ArrayList<ArrayList<String>> glassTintNum, String exteriorPaintLabel,
			ArrayList<String> exteriorPaintList, ArrayList<ArrayList<String>> exteriorPaintNum,
			String customExtrasLabel, ArrayList<String> customExtrasList, ArrayList<ArrayList<String>> customExtrasNum,
			String lockColorLabel, float lockLimit, ArrayList<String> lockColorList,
			ArrayList<ArrayList<String>> lockColorNum, int locks, String accessoriesLabel,
			ArrayList<String> accessoriesList, ArrayList<ArrayList<String>> accessoriesNum, String plasticLabel,
			ArrayList<String> plasticList, ArrayList<ArrayList<String>> plasticNum, String avoniteLabel,
			ArrayList<String> avoniteList, ArrayList<ArrayList<String>> avoniteNum, String prepaintLabel,
			ArrayList<String> prepaintList, ArrayList<ArrayList<String>> prepaintNum, String additionalLabel,
			ArrayList<String> additionalList, ArrayList<ArrayList<String>> additionalNum, String fullSheetLabel,
			ArrayList<String> fullSheetList, ArrayList<ArrayList<String>> fullSheetNum, String precutLabel,
			ArrayList<String> precutList, ArrayList<ArrayList<String>> precutNum, String roofLabel1,
			ArrayList<String> roofList1, ArrayList<ArrayList<String>> roofNum1, String roofLabel2,
			ArrayList<String> roofList2, ArrayList<ArrayList<String>> roofNum2, String copperLabel,
			ArrayList<String> copperList, ArrayList<ArrayList<String>> copperNum, String lightLabel,
			ArrayList<String> lightList, ArrayList<ArrayList<String>> lightNum) {
		super(productName, className);
		this.priceMultiplier = priceMultiplier;
		this.size = size;
		this.bays_bowsList = bays_bowsList;
		this.bays_bows = bays_bows;
		this.gridOptionsLabel = gridOptionsLabel;
		this.gridOptionCheckBoxLabel1 = gridOptionCheckBoxLabel1;
		this.gridOptionCheckBoxLabel2 = gridOptionCheckBoxLabel2;
		this.gridOptions = gridOptions;
		this.gridOptionsList = gridOptionsList;
		this.gridOptionsNum = gridOptionsNum;
		this.energyOptionsLabel = energyOptionsLabel;
		this.energyOptionsList = energyOptionsList;
		this.energyOptionsNum = energyOptionsNum;
		this.glassStrengthLabel = glassStrengthLabel;
		this.glassStrengthList = glassStrengthList;
		this.glassStrengthNum = glassStrengthNum;
		this.screenLabel = screenLabel;
		this.screenList = screenList;
		this.screenNum = screenNum;
		this.screenMeshLabel = screenMeshLabel;
		this.screenMeshList = screenMeshList;
		this.screenMeshNum = screenMeshNum;
		this.spacerLabel = spacerLabel;
		this.spacerList = spacerList;
		this.spacerNum = spacerNum;
		this.glassTintLabel = glassTintLabel;
		this.glassTintList = glassTintList;
		this.glassTintNum = glassTintNum;
		this.exteriorPaintLabel = exteriorPaintLabel;
		this.exteriorPaintList = exteriorPaintList;
		this.exteriorPaintNum = exteriorPaintNum;
		this.customExtrasLabel = customExtrasLabel;
		this.customExtrasList = customExtrasList;
		this.customExtrasNum = customExtrasNum;
		this.lockColorLabel = lockColorLabel;
		this.lockLimit = lockLimit;
		this.lockColorList = lockColorList;
		this.lockColorNum = lockColorNum;
		this.locks = locks;
		this.accessoriesLabel = accessoriesLabel;
		this.accessoriesList = accessoriesList;
		this.accessoriesNum = accessoriesNum;
		this.plasticLabel = plasticLabel;
		this.plasticList = plasticList;
		this.plasticNum = plasticNum;
		this.avoniteLabel = avoniteLabel;
		this.avoniteList = avoniteList;
		this.avoniteNum = avoniteNum;
		this.prepaintLabel = prepaintLabel;
		this.prepaintList = prepaintList;
		this.prepaintNum = prepaintNum;
		this.additionalLabel = additionalLabel;
		this.additionalList = additionalList;
		this.additionalNum = additionalNum;
		this.fullSheetLabel = fullSheetLabel;
		this.fullSheetList = fullSheetList;
		this.fullSheetNum = fullSheetNum;
		this.precutLabel = precutLabel;
		this.precutList = precutList;
		this.precutNum = precutNum;
		this.roofLabel1 = roofLabel1;
		this.roofList1 = roofList1;
		this.roofNum1 = roofNum1;
		this.roofLabel2 = roofLabel2;
		this.roofList2 = roofList2;
		this.roofNum2 = roofNum2;
		this.copperLabel = copperLabel;
		this.copperList = copperList;
		this.copperNum = copperNum;
		this.lightLabel = lightLabel;
		this.lightList = lightList;
		this.lightNum = lightNum;
	}

	
	
	/******************************************************************************************
	Get price methods
	******************************************************************************************/
	
	/**
	 * @param bayBowIndex
	 * @param width
	 * @param height
	 * @return
	 */
	public float getBasePrice(int bayBowIndex, float width, float height){
		if (bayBowIndex >= bays_bows.size()) return -5; //check bayBowIndex
		return bays_bows.get(bayBowIndex).getBay_BowPrice(width, height); //calls bay_bow price
	}
	
	/**
	 * @param bayBowIndex
	 * @param styleIndex
	 * @param typeIndex
	 * @param centerWindow
	 * @return
	 */
	public float getGridPrice(int bayBowIndex, int styleIndex, int typeIndex, boolean centerWindow){
		if (bayBowIndex >= bays_bows.size()) return -1; //checl bayBowIndex
		if (styleIndex >= gridOptionsNum.get(0).size()/2) return -2; //check styleIndex
		if (typeIndex >= gridOptionsNum.size()) return -3; //check typeIndex
		
		float price = 0;
		int sashes = sashNum(bayBowIndex); //gets number of sashes
		if (isBay(bayBowIndex) && centerWindow) {
			sashes -= 2; //takes off side windows
			price += gridOptionsNum.get(typeIndex).get(styleIndex * 2 + 1) * sashes; //adds center window cost			
			sashes = 2;
		}		
		return priceMultiplier * (price + gridOptionsNum.get(typeIndex).get(styleIndex * 2) * sashes); //returns price
	}
	
	/**
	 * @param index
	 * @param UI
	 * @return
	 */
	public float getEnergyOptionsPrice(int index, float UI){
		return Float.parseFloat(energyOptionsNum.get(index).get(0)) * UI; //returns price
	}
	
	//keeps working from here for the rest of the price methods
	
	/******************************************************************************************
	Private helper methods
	******************************************************************************************/
	
	private int sashNum(int bayBowIndex){
		if (bays_bows.get(bayBowIndex).getBay_BowName().contains("4-")) return 4;
		else if (bays_bows.get(bayBowIndex).getBay_BowName().contains("5-")) return 5;
		else if (bays_bows.get(bayBowIndex).getBay_BowName().contains("6-")) return 6;
		else return 3;
	}
	
	
	/******************************************************************************************
	Public methods
	******************************************************************************************/
	
	/**
	 * @return True if within height.
	 */
	public Boolean getBay_BowHeight(float height) {
		if (height > size.get(1)) return false;
		return true;
	}
	
	/**
	 * @return the Bay_Bows height label.
	 */
	public String getBay_BowHeightLabel() {
		return "Height Min: " + size.get(0) + " Max: " + size.get(1); 
	}
	
	/**
	 * @param bayBowIndex
	 * @return
	 */
	public String getBay_BowWidthLabel(int bayBowIndex){
		if (bayBowIndex >= bays_bows.size()) return "indexError"; //check bayBowIndex
		return bays_bows.get(bayBowIndex).getBay_BowWidthLabel();
	}
	
	/**
	 * @param bayBowIndex
	 * @return
	 */
	public String getBay_BowProjectionLabel(int bayBowIndex){
		if (bayBowIndex >= bays_bows.size()) return "indexError"; //check bayBowIndex
		return bays_bows.get(bayBowIndex).getBay_BowProjection();
	}

	/**
	 * @param bayBowIndex
	 * @return
	 */
	public boolean isBay(int bayBowIndex){
		if (bays_bows.get(bayBowIndex).getBay_BowName().toLowerCase().contains("bay")) return true;
		return false;
	}
	
	
	
	/******************************************************************************************
	Getter & Setter & Adders
	******************************************************************************************/
	
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
	 * @return the size
	 */
	public ArrayList<Float> getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(ArrayList<Float> size) {
		this.size = size;
	}

	/**
	 * @return the bays_bowsList
	 */
	public ArrayList<String> getBays_bowsList() {
		return bays_bowsList;
	}

	/**
	 * @param bays_bowsList the bays_bowsList to add
	 */
	public void addBays_bowsList(String bays_bowsList) {
		this.bays_bowsList.add(bays_bowsList);
	}

	/**
	 * @return the bays_bows
	 */
	public ArrayList<Bays_Bows> getBays_bows() {
		return bays_bows;
	}

	/**
	 * @param bays_bows the bays_bows to add
	 */
	public void addBays_bows(Bays_Bows bays_bows) {
		this.bays_bowsList.add(bays_bows.getBay_BowName()); //adds bayBow name to list
		this.bays_bows.add(bays_bows);
	}

	/**
	 * @return the gridOptionsLabel
	 */
	public String getGridOptionsLabel() {
		return gridOptionsLabel;
	}

	/**
	 * @param gridOptionsLabel the gridOptionsLabel to set
	 */
	public void setGridOptionsLabel(String gridOptionsLabel) {
		this.gridOptionsLabel = gridOptionsLabel;
	}

	/**
	 * @return the gridOptionCheckBoxLabel1
	 */
	public String getGridOptionCheckBoxLabel1() {
		return gridOptionCheckBoxLabel1;
	}

	/**
	 * @param gridOptionCheckBoxLabel1 the gridOptionCheckBoxLabel1 to set
	 */
	public void setGridOptionCheckBoxLabel1(String gridOptionCheckBoxLabel1) {
		this.gridOptionCheckBoxLabel1 = gridOptionCheckBoxLabel1;
	}

	/**
	 * @return the gridOptionCheckBoxLabel2
	 */
	public String getGridOptionCheckBoxLabel2() {
		return gridOptionCheckBoxLabel2;
	}

	/**
	 * @param gridOptionCheckBoxLabel2 the gridOptionCheckBoxLabel2 to set
	 */
	public void setGridOptionCheckBoxLabel2(String gridOptionCheckBoxLabel2) {
		this.gridOptionCheckBoxLabel2 = gridOptionCheckBoxLabel2;
	}

	/**
	 * @return the gridOptions
	 */
	public ArrayList<String> getGridOptions() {
		return gridOptions;
	}

	/**
	 * @param gridOptions the gridOptions to set
	 */
	public void setGridOptions(ArrayList<String> gridOptions) {
		this.gridOptions = gridOptions;
	}

	/**
	 * @return the gridOptionsList
	 */
	public ArrayList<String> getGridOptionsList() {
		return gridOptionsList;
	}

	/**
	 * @param gridOptionsList the gridOptionsList to set
	 */
	public void setGridOptionsList(ArrayList<String> gridOptionsList) {
		this.gridOptionsList = gridOptionsList;
	}

	/**
	 * @return the gridOptionsNum
	 */
	public ArrayList<ArrayList<Float>> getGridOptionsNum() {
		return gridOptionsNum;
	}

	/**
	 * @param gridOptionsNum the gridOptionsNum to set
	 */
	public void setGridOptionsNum(ArrayList<ArrayList<Float>> gridOptionsNum) {
		this.gridOptionsNum = gridOptionsNum;
	}

	/**
	 * @return the energyOptionsLabel
	 */
	public String getEnergyOptionsLabel() {
		return energyOptionsLabel;
	}

	/**
	 * @param energyOptionsLabel the energyOptionsLabel to set
	 */
	public void setEnergyOptionsLabel(String energyOptionsLabel) {
		this.energyOptionsLabel = energyOptionsLabel;
	}

	/**
	 * @return the energyOptionsList
	 */
	public ArrayList<String> getEnergyOptionsList() {
		return energyOptionsList;
	}

	/**
	 * @param energyOptionsList the energyOptionsList to set
	 */
	public void setEnergyOptionsList(ArrayList<String> energyOptionsList) {
		this.energyOptionsList = energyOptionsList;
	}

	/**
	 * @return the energyOptionsNum
	 */
	public ArrayList<ArrayList<String>> getEnergyOptionsNum() {
		return energyOptionsNum;
	}

	/**
	 * @param energyOptionsNum the energyOptionsNum to set
	 */
	public void setEnergyOptionsNum(ArrayList<ArrayList<String>> energyOptionsNum) {
		this.energyOptionsNum = energyOptionsNum;
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
	 * @return the screenLabel
	 */
	public String getScreenLabel() {
		return screenLabel;
	}

	/**
	 * @param screenLabel the screenLabel to set
	 */
	public void setScreenLabel(String screenLabel) {
		this.screenLabel = screenLabel;
	}

	/**
	 * @return the screenList
	 */
	public ArrayList<String> getScreenList() {
		return screenList;
	}

	/**
	 * @param screenList the screenList to set
	 */
	public void setScreenList(ArrayList<String> screenList) {
		this.screenList = screenList;
	}

	/**
	 * @return the screenNum
	 */
	public ArrayList<ArrayList<String>> getScreenNum() {
		return screenNum;
	}

	/**
	 * @param screenNum the screenNum to set
	 */
	public void setScreenNum(ArrayList<ArrayList<String>> screenNum) {
		this.screenNum = screenNum;
	}

	/**
	 * @return the screenMeshLabel
	 */
	public String getScreenMeshLabel() {
		return screenMeshLabel;
	}

	/**
	 * @param screenMeshLabel the screenMeshLabel to set
	 */
	public void setScreenMeshLabel(String screenMeshLabel) {
		this.screenMeshLabel = screenMeshLabel;
	}

	/**
	 * @return the screenMeshList
	 */
	public ArrayList<String> getScreenMeshList() {
		return screenMeshList;
	}

	/**
	 * @param screenMeshList the screenMeshList to set
	 */
	public void setScreenMeshList(ArrayList<String> screenMeshList) {
		this.screenMeshList = screenMeshList;
	}

	/**
	 * @return the screenMeshNum
	 */
	public ArrayList<ArrayList<String>> getScreenMeshNum() {
		return screenMeshNum;
	}

	/**
	 * @param screenMeshNum the screenMeshNum to set
	 */
	public void setScreenMeshNum(ArrayList<ArrayList<String>> screenMeshNum) {
		this.screenMeshNum = screenMeshNum;
	}

	/**
	 * @return the spacerLabel
	 */
	public String getSpacerLabel() {
		return spacerLabel;
	}

	/**
	 * @param spacerLabel the spacerLabel to set
	 */
	public void setSpacerLabel(String spacerLabel) {
		this.spacerLabel = spacerLabel;
	}

	/**
	 * @return the spacerList
	 */
	public ArrayList<String> getSpacerList() {
		return spacerList;
	}

	/**
	 * @param spacerList the spacerList to set
	 */
	public void setSpacerList(ArrayList<String> spacerList) {
		this.spacerList = spacerList;
	}

	/**
	 * @return the spacerNum
	 */
	public ArrayList<ArrayList<String>> getSpacerNum() {
		return spacerNum;
	}

	/**
	 * @param spacerNum the spacerNum to set
	 */
	public void setSpacerNum(ArrayList<ArrayList<String>> spacerNum) {
		this.spacerNum = spacerNum;
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
	 * @return the exteriorPaintLabel
	 */
	public String getExteriorPaintLabel() {
		return exteriorPaintLabel;
	}

	/**
	 * @param exteriorPaintLabel the exteriorPaintLabel to set
	 */
	public void setExteriorPaintLabel(String exteriorPaintLabel) {
		this.exteriorPaintLabel = exteriorPaintLabel;
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

	/**
	 * @return the customExtrasLabel
	 */
	public String getCustomExtrasLabel() {
		return customExtrasLabel;
	}

	/**
	 * @param customExtrasLabel the customExtrasLabel to set
	 */
	public void setCustomExtrasLabel(String customExtrasLabel) {
		this.customExtrasLabel = customExtrasLabel;
	}

	/**
	 * @return the customExtrasList
	 */
	public ArrayList<String> getCustomExtrasList() {
		return customExtrasList;
	}

	/**
	 * @param customExtrasList the customExtrasList to set
	 */
	public void setCustomExtrasList(ArrayList<String> customExtrasList) {
		this.customExtrasList = customExtrasList;
	}

	/**
	 * @return the customExtrasNum
	 */
	public ArrayList<ArrayList<String>> getCustomExtrasNum() {
		return customExtrasNum;
	}

	/**
	 * @param customExtrasNum the customExtrasNum to set
	 */
	public void setCustomExtrasNum(ArrayList<ArrayList<String>> customExtrasNum) {
		this.customExtrasNum = customExtrasNum;
	}

	/**
	 * @return the lockColorLabel
	 */
	public String getLockColorLabel() {
		return lockColorLabel;
	}

	/**
	 * @param lockColorLabel the lockColorLabel to set
	 */
	public void setLockColorLabel(String lockColorLabel) {
		this.lockColorLabel = lockColorLabel;
	}

	/**
	 * @return the lockLimit
	 */
	public float getLockLimit() {
		return lockLimit;
	}

	/**
	 * @param lockLimit the lockLimit to set
	 */
	public void setLockLimit(float lockLimit) {
		this.lockLimit = lockLimit;
	}

	/**
	 * @return the lockColorList
	 */
	public ArrayList<String> getLockColorList() {
		return lockColorList;
	}

	/**
	 * @param lockColorList the lockColorList to set
	 */
	public void setLockColorList(ArrayList<String> lockColorList) {
		this.lockColorList = lockColorList;
	}

	/**
	 * @return the lockColorNum
	 */
	public ArrayList<ArrayList<String>> getLockColorNum() {
		return lockColorNum;
	}

	/**
	 * @param lockColorNum the lockColorNum to set
	 */
	public void setLockColorNum(ArrayList<ArrayList<String>> lockColorNum) {
		this.lockColorNum = lockColorNum;
	}

	/**
	 * @return the locks
	 */
	public int getLocks() {
		return locks;
	}

	/**
	 * @param locks the locks to set
	 */
	public void setLocks(int locks) {
		this.locks = locks;
	}

	/**
	 * @return the accessoriesLabel
	 */
	public String getAccessoriesLabel() {
		return accessoriesLabel;
	}

	/**
	 * @param accessoriesLabel the accessoriesLabel to set
	 */
	public void setAccessoriesLabel(String accessoriesLabel) {
		this.accessoriesLabel = accessoriesLabel;
	}

	/**
	 * @return the accessoriesList
	 */
	public ArrayList<String> getAccessoriesList() {
		return accessoriesList;
	}

	/**
	 * @param accessoriesList the accessoriesList to set
	 */
	public void setAccessoriesList(ArrayList<String> accessoriesList) {
		this.accessoriesList = accessoriesList;
	}

	/**
	 * @return the accessoriesNum
	 */
	public ArrayList<ArrayList<String>> getAccessoriesNum() {
		return accessoriesNum;
	}

	/**
	 * @param accessoriesNum the accessoriesNum to set
	 */
	public void setAccessoriesNum(ArrayList<ArrayList<String>> accessoriesNum) {
		this.accessoriesNum = accessoriesNum;
	}

	/**
	 * @return the plasticLabel
	 */
	public String getPlasticLabel() {
		return plasticLabel;
	}

	/**
	 * @param plasticLabel the plasticLabel to set
	 */
	public void setPlasticLabel(String plasticLabel) {
		this.plasticLabel = plasticLabel;
	}

	/**
	 * @return the plasticList
	 */
	public ArrayList<String> getPlasticList() {
		return plasticList;
	}

	/**
	 * @param plasticList the plasticList to set
	 */
	public void setPlasticList(ArrayList<String> plasticList) {
		this.plasticList = plasticList;
	}

	/**
	 * @return the plasticNum
	 */
	public ArrayList<ArrayList<String>> getPlasticNum() {
		return plasticNum;
	}

	/**
	 * @param plasticNum the plasticNum to set
	 */
	public void setPlasticNum(ArrayList<ArrayList<String>> plasticNum) {
		this.plasticNum = plasticNum;
	}

	/**
	 * @return the avoniteLabel
	 */
	public String getAvoniteLabel() {
		return avoniteLabel;
	}

	/**
	 * @param avoniteLabel the avoniteLabel to set
	 */
	public void setAvoniteLabel(String avoniteLabel) {
		this.avoniteLabel = avoniteLabel;
	}

	/**
	 * @return the avoniteList
	 */
	public ArrayList<String> getAvoniteList() {
		return avoniteList;
	}

	/**
	 * @param avoniteList the avoniteList to set
	 */
	public void setAvoniteList(ArrayList<String> avoniteList) {
		this.avoniteList = avoniteList;
	}

	/**
	 * @return the avoniteNum
	 */
	public ArrayList<ArrayList<String>> getAvoniteNum() {
		return avoniteNum;
	}

	/**
	 * @param avoniteNum the avoniteNum to set
	 */
	public void setAvoniteNum(ArrayList<ArrayList<String>> avoniteNum) {
		this.avoniteNum = avoniteNum;
	}

	/**
	 * @return the prepaintLabel
	 */
	public String getPrepaintLabel() {
		return prepaintLabel;
	}

	/**
	 * @param prepaintLabel the prepaintLabel to set
	 */
	public void setPrepaintLabel(String prepaintLabel) {
		this.prepaintLabel = prepaintLabel;
	}

	/**
	 * @return the prepaintList
	 */
	public ArrayList<String> getPrepaintList() {
		return prepaintList;
	}

	/**
	 * @param prepaintList the prepaintList to set
	 */
	public void setPrepaintList(ArrayList<String> prepaintList) {
		this.prepaintList = prepaintList;
	}

	/**
	 * @return the prepaintNum
	 */
	public ArrayList<ArrayList<String>> getPrepaintNum() {
		return prepaintNum;
	}

	/**
	 * @param prepaintNum the prepaintNum to set
	 */
	public void setPrepaintNum(ArrayList<ArrayList<String>> prepaintNum) {
		this.prepaintNum = prepaintNum;
	}

	/**
	 * @return the additionalLabel
	 */
	public String getAdditionalLabel() {
		return additionalLabel;
	}

	/**
	 * @param additionalLabel the additionalLabel to set
	 */
	public void setAdditionalLabel(String additionalLabel) {
		this.additionalLabel = additionalLabel;
	}

	/**
	 * @return the additionalList
	 */
	public ArrayList<String> getAdditionalList() {
		return additionalList;
	}

	/**
	 * @param additionalList the additionalList to set
	 */
	public void setAdditionalList(ArrayList<String> additionalList) {
		this.additionalList = additionalList;
	}

	/**
	 * @return the additionalNum
	 */
	public ArrayList<ArrayList<String>> getAdditionalNum() {
		return additionalNum;
	}

	/**
	 * @param additionalNum the additionalNum to set
	 */
	public void setAdditionalNum(ArrayList<ArrayList<String>> additionalNum) {
		this.additionalNum = additionalNum;
	}

	/**
	 * @return the fullSheetLabel
	 */
	public String getFullSheetLabel() {
		return fullSheetLabel;
	}

	/**
	 * @param fullSheetLabel the fullSheetLabel to set
	 */
	public void setFullSheetLabel(String fullSheetLabel) {
		this.fullSheetLabel = fullSheetLabel;
	}

	/**
	 * @return the fullSheetList
	 */
	public ArrayList<String> getFullSheetList() {
		return fullSheetList;
	}

	/**
	 * @param fullSheetList the fullSheetList to set
	 */
	public void setFullSheetList(ArrayList<String> fullSheetList) {
		this.fullSheetList = fullSheetList;
	}

	/**
	 * @return the fullSheetNum
	 */
	public ArrayList<ArrayList<String>> getFullSheetNum() {
		return fullSheetNum;
	}

	/**
	 * @param fullSheetNum the fullSheetNum to set
	 */
	public void setFullSheetNum(ArrayList<ArrayList<String>> fullSheetNum) {
		this.fullSheetNum = fullSheetNum;
	}

	/**
	 * @return the precutLabel
	 */
	public String getPrecutLabel() {
		return precutLabel;
	}

	/**
	 * @param precutLabel the precutLabel to set
	 */
	public void setPrecutLabel(String precutLabel) {
		this.precutLabel = precutLabel;
	}

	/**
	 * @return the precutList
	 */
	public ArrayList<String> getPrecutList() {
		return precutList;
	}

	/**
	 * @param precutList the precutList to set
	 */
	public void setPrecutList(ArrayList<String> precutList) {
		this.precutList = precutList;
	}

	/**
	 * @return the precutNum
	 */
	public ArrayList<ArrayList<String>> getPrecutNum() {
		return precutNum;
	}

	/**
	 * @param precutNum the precutNum to set
	 */
	public void setPrecutNum(ArrayList<ArrayList<String>> precutNum) {
		this.precutNum = precutNum;
	}

	/**
	 * @return the roofLabel1
	 */
	public String getRoofLabel1() {
		return roofLabel1;
	}

	/**
	 * @param roofLabel1 the roofLabel1 to set
	 */
	public void setRoofLabel1(String roofLabel1) {
		this.roofLabel1 = roofLabel1;
	}

	/**
	 * @return the roofList1
	 */
	public ArrayList<String> getRoofList1() {
		return roofList1;
	}

	/**
	 * @param roofList1 the roofList1 to set
	 */
	public void setRoofList1(ArrayList<String> roofList1) {
		this.roofList1 = roofList1;
	}

	/**
	 * @return the roofNum1
	 */
	public ArrayList<ArrayList<String>> getRoofNum1() {
		return roofNum1;
	}

	/**
	 * @param roofNum1 the roofNum1 to set
	 */
	public void setRoofNum1(ArrayList<ArrayList<String>> roofNum1) {
		this.roofNum1 = roofNum1;
	}

	/**
	 * @return the roofLabel2
	 */
	public String getRoofLabel2() {
		return roofLabel2;
	}

	/**
	 * @param roofLabel2 the roofLabel2 to set
	 */
	public void setRoofLabel2(String roofLabel2) {
		this.roofLabel2 = roofLabel2;
	}

	/**
	 * @return the roofList2
	 */
	public ArrayList<String> getRoofList2() {
		return roofList2;
	}

	/**
	 * @param roofList2 the roofList2 to set
	 */
	public void setRoofList2(ArrayList<String> roofList2) {
		this.roofList2 = roofList2;
	}

	/**
	 * @return the roofNum2
	 */
	public ArrayList<ArrayList<String>> getRoofNum2() {
		return roofNum2;
	}

	/**
	 * @param roofNum2 the roofNum2 to set
	 */
	public void setRoofNum2(ArrayList<ArrayList<String>> roofNum2) {
		this.roofNum2 = roofNum2;
	}

	/**
	 * @return the copperLabel
	 */
	public String getCopperLabel() {
		return copperLabel;
	}

	/**
	 * @param copperLabel the copperLabel to set
	 */
	public void setCopperLabel(String copperLabel) {
		this.copperLabel = copperLabel;
	}

	/**
	 * @return the copperList
	 */
	public ArrayList<String> getCopperList() {
		return copperList;
	}

	/**
	 * @param copperList the copperList to set
	 */
	public void setCopperList(ArrayList<String> copperList) {
		this.copperList = copperList;
	}

	/**
	 * @return the copperNum
	 */
	public ArrayList<ArrayList<String>> getCopperNum() {
		return copperNum;
	}

	/**
	 * @param copperNum the copperNum to set
	 */
	public void setCopperNum(ArrayList<ArrayList<String>> copperNum) {
		this.copperNum = copperNum;
	}

	/**
	 * @return the lightLabel
	 */
	public String getLightLabel() {
		return lightLabel;
	}

	/**
	 * @param lightLabel the lightLabel to set
	 */
	public void setLightLabel(String lightLabel) {
		this.lightLabel = lightLabel;
	}

	/**
	 * @return the lightList
	 */
	public ArrayList<String> getLightList() {
		return lightList;
	}

	/**
	 * @param lightList the lightList to set
	 */
	public void setLightList(ArrayList<String> lightList) {
		this.lightList = lightList;
	}

	/**
	 * @return the lightNum
	 */
	public ArrayList<ArrayList<String>> getLightNum() {
		return lightNum;
	}

	/**
	 * @param lightNum the lightNum to set
	 */
	public void setLightNum(ArrayList<ArrayList<String>> lightNum) {
		this.lightNum = lightNum;
	}	
}
