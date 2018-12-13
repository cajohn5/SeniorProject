/**Author Mark DiFiglio
 * 4/8/2017
 * 
 * Holds Garden window object.
 * 
 */

package product_classes;

import java.util.ArrayList;

public class Garden extends Windows{
	
	/******************************************************************************************
	Variables
	******************************************************************************************/
	
	private String optionsLabel; //label
	private ArrayList<String> optionsList; //dropdown
	private ArrayList<ArrayList<Float>> optionsNum;	
	
	private String surfaceLabel; //label this is the LG HI~MACS* acrylic solid
	private ArrayList<String> surfaceList; //dropdown
	private ArrayList<ArrayList<String>> surfaceNum;
	
	
	
	/******************************************************************************************
	Constructors
	******************************************************************************************/
	
	/**
	 * 
	 */
	public Garden() {
		super();
		this.optionsLabel = "";
		this.optionsList = new ArrayList<String>();
		this.optionsNum = new ArrayList<ArrayList<Float>>();
		this.surfaceLabel = "";
		this.surfaceList = new ArrayList<String>();
		this.surfaceNum = new ArrayList<ArrayList<String>>();
	}

	/**
	 * @param productName
	 * @param className
	 * @param priceMultiplier
	 * @param maxUI
	 * @param size
	 * @param frameColorLabel
	 * @param frameColorList
	 * @param frameColorNum
	 * @param gridOptionsLabel
	 * @param gridOptions
	 * @param gridOptionsList
	 * @param gridOptionsNum
	 * @param energyOptionsLabel
	 * @param energyOptionsList
	 * @param energyOptionsNum
	 * @param glassStrengthLabel
	 * @param glassStrengthList
	 * @param glassStrengthNum
	 * @param glassLabel
	 * @param glassList
	 * @param glassNum
	 * @param spacerLabel
	 * @param spacerList
	 * @param spacerNum
	 * @param mullLabel
	 * @param mullList
	 * @param mullNum
	 * @param glassTintLabel
	 * @param glassTintList
	 * @param glassTintNum
	 * @param customExtrasLabel
	 * @param customExtrasList
	 * @param customExtrasNum
	 * @param woodgrains
	 * @param woodgrainsList
	 * @param exteriorPaintLabel
	 * @param exteriorPaintList
	 * @param exteriorPaintNum
	 * @param miniblindsLabel
	 * @param miniblindsList
	 * @param miniblindsNum
	 * @param screenLabel
	 * @param screenList
	 * @param screenNum
	 * @param screenMeshLabel
	 * @param screenMeshList
	 * @param screenMeshNum
	 * @param reinforcementLabel
	 * @param reinforcementList
	 * @param reinforcementNum
	 * @param lockColorLabel
	 * @param lockLimit
	 * @param lockColorList
	 * @param lockColorNum
	 * @param locks
	 * @param panelLabel
	 * @param panelList
	 * @param panelNum
	 * @param optionsLabel
	 * @param optionsList
	 * @param optionsNum
	 * @param surfaceLabel
	 * @param surfaceList
	 * @param surfaceNum
	 */
	public Garden(String productName, String className, float priceMultiplier, ArrayList<Float> maxUI, Size size,
			String frameColorLabel, ArrayList<String> frameColorList, ArrayList<ArrayList<String>> frameColorNum,
			String gridOptionsLabel, ArrayList<String> gridOptions, ArrayList<String> gridOptionsList,
			ArrayList<ArrayList<Float>> gridOptionsNum, String energyOptionsLabel, ArrayList<String> energyOptionsList,
			ArrayList<ArrayList<String>> energyOptionsNum, String glassStrengthLabel,
			ArrayList<String> glassStrengthList, ArrayList<ArrayList<String>> glassStrengthNum, String glassLabel,
			ArrayList<String> glassList, ArrayList<ArrayList<String>> glassNum, String spacerLabel,
			ArrayList<String> spacerList, ArrayList<ArrayList<String>> spacerNum, String mullLabel,
			ArrayList<String> mullList, ArrayList<ArrayList<String>> mullNum, String glassTintLabel,
			ArrayList<String> glassTintList, ArrayList<ArrayList<String>> glassTintNum, String customExtrasLabel,
			ArrayList<String> customExtrasList, ArrayList<ArrayList<String>> customExtrasNum, String woodgrains,
			ArrayList<String> woodgrainsList, String exteriorPaintLabel, ArrayList<String> exteriorPaintList,
			ArrayList<ArrayList<String>> exteriorPaintNum, String miniblindsLabel, ArrayList<String> miniblindsList,
			ArrayList<ArrayList<String>> miniblindsNum, String screenLabel, ArrayList<String> screenList,
			ArrayList<ArrayList<String>> screenNum, String screenMeshLabel, ArrayList<String> screenMeshList,
			ArrayList<ArrayList<String>> screenMeshNum, String reinforcementLabel, ArrayList<String> reinforcementList,
			ArrayList<ArrayList<String>> reinforcementNum, String lockColorLabel, float lockLimit,
			ArrayList<String> lockColorList, ArrayList<ArrayList<String>> lockColorNum, int locks, String panelLabel,
			ArrayList<String> panelList, ArrayList<ArrayList<String>> panelNum, String optionsLabel, ArrayList<String> optionsList, 
			ArrayList<ArrayList<Float>> optionsNum, String surfaceLabel, ArrayList<String> surfaceList, 
			ArrayList<ArrayList<String>> surfaceNum) {
		super(productName, className, priceMultiplier, maxUI, size, frameColorLabel, frameColorList, frameColorNum,
				gridOptionsLabel, gridOptions, gridOptionsList, gridOptionsNum, energyOptionsLabel, energyOptionsList,
				energyOptionsNum, glassStrengthLabel, glassStrengthList, glassStrengthNum, glassLabel, glassList, glassNum,
				spacerLabel, spacerList, spacerNum, mullLabel, mullList, mullNum, glassTintLabel, glassTintList, glassTintNum,
				customExtrasLabel, customExtrasList, customExtrasNum, woodgrains, woodgrainsList, exteriorPaintLabel,
				exteriorPaintList, exteriorPaintNum, miniblindsLabel, miniblindsList, miniblindsNum, screenLabel, screenList,
				screenNum, screenMeshLabel, screenMeshList, screenMeshNum, reinforcementLabel, reinforcementList,
				reinforcementNum, lockColorLabel, lockLimit, lockColorList, lockColorNum, locks, panelLabel, panelList,
				panelNum);
		this.optionsLabel = optionsLabel;
		this.optionsList = optionsList;
		this.optionsNum = optionsNum;
		this.surfaceLabel = surfaceLabel;
		this.surfaceList = surfaceList;
		this.surfaceNum = surfaceNum;
	}

	
	
	/******************************************************************************************
	Get price methods
	******************************************************************************************/
	
	/**
	 * @param index
	 * @param height
	 * @return
	 */
	public float getOptionsPrice(int index, float height){
		index++;
		if (index >= optionsNum.get(0).size()) return -1; //check index
		if (height >= getSize().getHeight().get(1)) return -2; //check height
		int i = 0;
		while (optionsNum.get(i).get(0) > height) i++; //get row of height
		return getPriceMultiplier() * optionsNum.get(i).get(index); //return option price
	}
	
	/**
	 * @param index
	 * @return
	 */
	public float getSurfacePrice(int index){
		if (index >= surfaceNum.size()) return -1; //check index
		return getPriceMultiplier() * Float.parseFloat(surfaceNum.get(index).get(0)); //return surface price
	}
	
	
	
	/******************************************************************************************
	Getters & Setters
	******************************************************************************************/
	
	/**
	 * @return the optionsLabel
	 */
	public String getOptionsLabel() {
		return optionsLabel;
	}

	/**
	 * @param optionsLabel the optionsLabel to set
	 */
	public void setOptionsLabel(String optionsLabel) {
		this.optionsLabel = optionsLabel;
	}

	/**
	 * @return the optionsList
	 */
	public ArrayList<String> getOptionsList() {
		return optionsList;
	}

	/**
	 * @param optionsList the optionsList to set
	 */
	public void setOptionsList(ArrayList<String> optionsList) {
		this.optionsList = optionsList;
	}

	/**
	 * @return the optionsNum
	 */
	public ArrayList<ArrayList<Float>> getOptionsNum() {
		return optionsNum;
	}

	/**
	 * @param optionsNum the optionsNum to set
	 */
	public void setOptionsNum(ArrayList<ArrayList<Float>> optionsNum) {
		this.optionsNum = optionsNum;
	}

	/**
	 * @return the surfaceLabel
	 */
	public String getSurfaceLabel() {
		return surfaceLabel;
	}

	/**
	 * @param surfaceLabel the surfaceLabel to set
	 */
	public void setSurfaceLabel(String surfaceLabel) {
		this.surfaceLabel = surfaceLabel;
	}

	/**
	 * @return the surfaceList
	 */
	public ArrayList<String> getSurfaceList() {
		return surfaceList;
	}

	/**
	 * @param surfaceList the surfaceList to set
	 */
	public void setSurfaceList(ArrayList<String> surfaceList) {
		this.surfaceList = surfaceList;
	}

	/**
	 * @return the surfaceNum
	 */
	public ArrayList<ArrayList<String>> getSurfaceNum() {
		return surfaceNum;
	}

	/**
	 * @param surfaceNum the surfaceNum to set
	 */
	public void setSurfaceNum(ArrayList<ArrayList<String>> surfaceNum) {
		this.surfaceNum = surfaceNum;
	}		
}
