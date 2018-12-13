/*Mark DiFiglio
 * 4/3/2017
 * 
 *To be used to store all DynaWelds, all TWP except Shapes, all UW except Shapes & Garden
 */

package product_classes;

import java.util.ArrayList;

public class Windows extends Products implements Windows_Interface{
		
	/******************************************************************************************
	Variables
	******************************************************************************************/
	private float priceMultiplier;
	
	private ArrayList<Float> maxUI; //[UI, SQ, Temper]
	
	private Size size; //check size.java class
	
	private String frameColorLabel; //label
	private ArrayList<String> patioDoorList; //dropdown 
	private ArrayList<String> frameColorList; //dropdown top
	private ArrayList<ArrayList<String>> frameColorNum;
	
	private String gridOptionsLabel; //label
	private ArrayList<String> gridOptions; //dropdown of top (ex. colonial)
	private ArrayList<String> gridOptionsList; //dropdown of left (ex. flat)
	private ArrayList<ArrayList<Float>> gridOptionsNum;
	
	private String energyOptionsLabel; //label
	private ArrayList<String> energyOptionsList; //dropdown
	private ArrayList<ArrayList<String>> energyOptionsNum;
	
	private String glassStrengthLabel; //label
	private ArrayList<String> glassStrengthList; //dropdown
	private ArrayList<ArrayList<String>> glassStrengthNum;
	
	private String glassLabel; //label
	private ArrayList<String> glassList; //dropdown
	private ArrayList<ArrayList<String>> glassNum;
	
	private String spacerLabel; //label
	private ArrayList<String> spacerList; //dropdown
	private ArrayList<ArrayList<String>> spacerNum;
	
	private String mullLabel; //label
	private ArrayList<String> mullList; //dropdown
	private ArrayList<ArrayList<String>> mullNum;
	
	private String glassTintLabel; //label
	private ArrayList<String> glassTintList; //dropdown
	private ArrayList<ArrayList<String>> glassTintNum;
	
	private String customExtrasLabel; //label
	private ArrayList<String> customExtrasList; //checkboxes
	private ArrayList<ArrayList<String>> customExtrasNum;
	
	private String woodgrainsLabel; //label
	private ArrayList<String> woodgrainsList; //dropdown
	
	private String exteriorPaintLabel;	//label
	private ArrayList<String> exteriorPaintList; //dropdown
	private ArrayList<ArrayList<String>> exteriorPaintNum;

	private String miniblindsLabel; //label
	private ArrayList<String> miniblindsList; //dropdown of colors
	private ArrayList<ArrayList<String>> miniblindsNum;
	
	private String screenLabel; //label
	private ArrayList<String> screenList; //dropdown
	private ArrayList<ArrayList<String>> screenNum;
	
	private String screenMeshLabel; //label
	private ArrayList<String> screenMeshList; //dropdown
	private ArrayList<ArrayList<String>> screenMeshNum;

	private String reinforcementLabel; //label
	private ArrayList<String> reinforcementList; //dropdown
	private ArrayList<ArrayList<String>> reinforcementNum;

	private String lockColorLabel; //label
	private float lockLimit; //the inch limit for 2 locks
	private ArrayList<String> lockColorList; //dropdown
	private ArrayList<ArrayList<String>> lockColorNum;
	private int locks; // this is set by the gui_classes not the excel files
	
	private String panelLabel; //label
	private ArrayList<String> panelList; //dropdown
	private ArrayList<ArrayList<String>> panelNum;
	
	
	
	/******************************************************************************************
	Constructors
	******************************************************************************************/	
	
	/**
	 * 
	 */
	public Windows() {
		super();
		this.priceMultiplier = 0;
		this.maxUI = new ArrayList<Float>();
		this.size = new Size();
		
		this.frameColorLabel = new String();
		this.frameColorList = new ArrayList<String>();
		this.frameColorNum = new ArrayList<ArrayList<String>>();
		
		this.gridOptionsLabel = new String();
		this.gridOptions = new ArrayList<String>();
		this.gridOptionsList = new ArrayList<String>();
		this.gridOptionsNum = new ArrayList<ArrayList<Float>>();
		
		this.energyOptionsLabel = new String();
		this.energyOptionsList = new ArrayList<String>();
		this.energyOptionsNum = new ArrayList<ArrayList<String>>();
		
		this.glassStrengthLabel = new String();
		this.glassStrengthList = new ArrayList<String>();
		this.glassStrengthNum = new ArrayList<ArrayList<String>>();
		
		this.glassLabel = new String();
		this.glassList = new ArrayList<String>();
		this.glassNum = new ArrayList<ArrayList<String>>();
		
		this.spacerLabel = new String();
		this.spacerList = new ArrayList<String>();
		this.spacerNum = new ArrayList<ArrayList<String>>();
		
		this.mullLabel = new String();
		this.mullList = new ArrayList<String>();
		this.mullNum = new ArrayList<ArrayList<String>>();
		
		this.glassTintLabel = new String();
		this.glassTintList = new ArrayList<String>();
		this.glassTintNum = new ArrayList<ArrayList<String>>();
		
		this.customExtrasLabel = new String();
		this.customExtrasList = new ArrayList<String>();
		this.customExtrasNum = new ArrayList<ArrayList<String>>();
		
		this.woodgrainsLabel = new String();		
		this.woodgrainsList = new ArrayList<String>();
		
		this.exteriorPaintLabel = new String();
		this.exteriorPaintList = new ArrayList<String>();
		this.exteriorPaintNum = new ArrayList<ArrayList<String>>();
		
		this.miniblindsLabel = new String();
		this.miniblindsList = new ArrayList<String>();
		this.miniblindsNum = new ArrayList<ArrayList<String>>();
		
		this.screenLabel = new String();
		this.screenList = new ArrayList<String>();
		this.screenNum = new ArrayList<ArrayList<String>>();
		
		this.screenMeshLabel = new String();
		this.screenMeshList = new ArrayList<String>();
		this.screenMeshNum = new ArrayList<ArrayList<String>>();
		
		this.reinforcementLabel = new String();
		this.reinforcementList = new ArrayList<String>();
		this.reinforcementNum = new ArrayList<ArrayList<String>>();
		
		this.lockColorLabel = new String();
		this.lockLimit = 30;
		this.lockColorList = new ArrayList<String>();
		this.lockColorNum = new ArrayList<ArrayList<String>>();		
		this.locks = 1;
		
		this.panelLabel = new String();
		this.panelList = new ArrayList<String>();
		this.panelNum = new ArrayList<ArrayList<String>>();
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
	 */
	public Windows(String productName, String className, float priceMultiplier, ArrayList<Float> maxUI,
			Size size, String frameColorLabel, ArrayList<String> frameColorList,
			ArrayList<ArrayList<String>> frameColorNum, String gridOptionsLabel, ArrayList<String> gridOptions,
			ArrayList<String> gridOptionsList, ArrayList<ArrayList<Float>> gridOptionsNum, String energyOptionsLabel,
			ArrayList<String> energyOptionsList, ArrayList<ArrayList<String>> energyOptionsNum,
			String glassStrengthLabel, ArrayList<String> glassStrengthList,
			ArrayList<ArrayList<String>> glassStrengthNum, String glassLabel, ArrayList<String> glassList,
			ArrayList<ArrayList<String>> glassNum, String spacerLabel, ArrayList<String> spacerList,
			ArrayList<ArrayList<String>> spacerNum, String mullLabel, ArrayList<String> mullList,
			ArrayList<ArrayList<String>> mullNum, String glassTintLabel, ArrayList<String> glassTintList,
			ArrayList<ArrayList<String>> glassTintNum, String customExtrasLabel, ArrayList<String> customExtrasList,
			ArrayList<ArrayList<String>> customExtrasNum, String woodgrains, ArrayList<String> woodgrainsList,
			String exteriorPaintLabel, ArrayList<String> exteriorPaintList, ArrayList<ArrayList<String>> exteriorPaintNum,
			String miniblindsLabel, ArrayList<String> miniblindsList, ArrayList<ArrayList<String>> miniblindsNum,
			String screenLabel, ArrayList<String> screenList, ArrayList<ArrayList<String>> screenNum, String screenMeshLabel,
			ArrayList<String> screenMeshList, ArrayList<ArrayList<String>> screenMeshNum, String reinforcementLabel,
			ArrayList<String> reinforcementList, ArrayList<ArrayList<String>> reinforcementNum, String lockColorLabel,
			float lockLimit, ArrayList<String> lockColorList, ArrayList<ArrayList<String>> lockColorNum, int locks,
			String panelLabel, ArrayList<String> panelList, ArrayList<ArrayList<String>> panelNum) {
		super(productName, className);
		this.priceMultiplier = priceMultiplier;
		this.maxUI = maxUI;
		this.size = size;
		this.frameColorLabel = frameColorLabel;
		this.frameColorList = frameColorList;
		this.frameColorNum = frameColorNum;
		this.gridOptionsLabel = gridOptionsLabel;
		this.gridOptions = gridOptions;
		this.gridOptionsList = gridOptionsList;
		this.gridOptionsNum = gridOptionsNum;
		this.energyOptionsLabel = energyOptionsLabel;
		this.energyOptionsList = energyOptionsList;
		this.energyOptionsNum = energyOptionsNum;
		this.glassStrengthLabel = glassStrengthLabel;
		this.glassStrengthList = glassStrengthList;
		this.glassStrengthNum = glassStrengthNum;
		this.glassLabel = glassLabel;
		this.glassList = glassList;
		this.glassNum = glassNum;
		this.spacerLabel = spacerLabel;
		this.spacerList = spacerList;
		this.spacerNum = spacerNum;
		this.mullLabel = mullLabel;
		this.mullList = mullList;
		this.mullNum = mullNum;
		this.glassTintLabel = glassTintLabel;
		this.glassTintList = glassTintList;
		this.glassTintNum = glassTintNum;
		this.customExtrasLabel = customExtrasLabel;
		this.customExtrasList = customExtrasList;
		this.customExtrasNum = customExtrasNum;
		this.woodgrainsLabel = woodgrains;
		this.woodgrainsList = woodgrainsList;
		this.exteriorPaintLabel = exteriorPaintLabel;
		this.exteriorPaintList = exteriorPaintList;
		this.exteriorPaintNum = exteriorPaintNum;
		this.miniblindsLabel = miniblindsLabel;
		this.miniblindsList = miniblindsList;
		this.miniblindsNum = miniblindsNum;
		this.screenLabel = screenLabel;
		this.screenList = screenList;
		this.screenNum = screenNum;
		this.screenMeshLabel = screenMeshLabel;
		this.screenMeshList = screenMeshList;
		this.screenMeshNum = screenMeshNum;
		this.reinforcementLabel = reinforcementLabel;
		this.reinforcementList = reinforcementList;
		this.reinforcementNum = reinforcementNum;
		this.lockColorLabel = lockColorLabel;
		this.lockLimit = lockLimit;
		this.lockColorList = lockColorList;
		this.lockColorNum = lockColorNum;
		this.locks = locks;
		this.panelLabel = panelLabel;
		this.panelList = panelList;
		this.panelNum = panelNum;
	}
		


	/******************************************************************************************
	Get price methods
	******************************************************************************************/
	
	/**
	 * Returns a float of the frame price.
	 * 
	 * @param Index is the index of the picked item on the associated frameColorList.
	 * @param UI is the currently entered UI.
	 * @return Float of the frame price of the selected item.
	 */
	@Override
	public float getFrameColorPrice(int index, float UI){
		index++;
		if (index > frameColorList.size()) return -1; //error flag for bad index input
		if (!checkUI(UI)) return -2; //error flag for bad UI input
		
		String name = this.getProductName();
		if (name.contains("3070")) return Float.parseFloat(frameColorNum.get(0).get(index)); //this is the DynaWeld 3070 Hopper
		
		int i = 0;
		while (UI > Float.parseFloat(frameColorNum.get(i).get(0))) i++; //finds the UI index of frameColorNum based off UI
				
		if (i > frameColorNum.size()) return -3; //error flag to stop internal error of frameColorNum
		
		//if it is one of the product that does price by UI for frame color
		//3000 = DW picture, 7400 = TWP picture, 8400 = UW picture, 8403 = UW slim line picture, 8405 = UW casement picture, 8485 = UW transom
		if (name.contains("3000") || name.contains("7000") || name.contains("7400") || name.contains("8400") || name.contains("8403") || name.contains("8405") || name.contains("8485")){
			return pricePerUI(UI, Float.parseFloat(frameColorNum.get(i).get(index)));			
		}
		
		//if here then pull price from frameColorNum
		return pricePerWindow(Float.parseFloat(frameColorNum.get(i).get(index)));		
	}
	
	/**
	 * Returns a float of the frame price. Use for normal patio doors (not transom/sidelite/custom patio doors).
	 * 
	 * @param Index is the index of the picked item on the associated frameColorList.
	 * @param WidthIndex is the currently entered widthIndex.
	 * @return Float of the frame price of the selected item.
	 */
	@Override
	public float getFrameColorPricePD(int index, int widthIndex){
		index++;
		if (index > frameColorList.size()) return -1; //error flag for bad index input
		if (widthIndex > patioDoorList.size()) return -2; //error flag for bad widthIndex input
		
		int i = 0;
		while (widthIndex > Float.parseFloat(frameColorNum.get(i).get(0))) i++; //finds the index of frameColorNum based off widthIndex
		
		if (i > frameColorNum.size()) return -3; //error flag to stop internal error of frameColorNum
		
		return pricePerWindow(Float.parseFloat(frameColorNum.get(i).get(index)));
	}
	
	/**
	 * Returns a float of the frame price. Use for custom patio doors only.
	 * 
	 * @param Index is the index of the picked item on the associated frameColorList.
	 * @param Width is the currently entered width.
	 * @param Panel is the currently entered panel.
	 * @return Float of the frame price of the selected item.
	 */
	@Override
	public float getFrameColorPriceCustomPD(int index, float width, int panels){
		index++;
		if (index > frameColorList.size()) return -1; //error flag for bad index input
		//no maxUI to check
		if (panels < 2 || panels > 3) return -2; //error for bad panel input
		
		
		int i = 0;
		if (panels == 2) i = 0;
		else if (panels == 3) i = 2;
		while (width > Float.parseFloat(frameColorNum.get(i).get(0))) {
			i++; //finds the index of frameColorNum based off width
			if (panels == 2 && i == 2) return -3; //bad panel to width 
		}
		
		if (i > frameColorNum.size()) return -4; //error flag to stop internal error of frameColorNum
		
		return pricePerWindow(Float.parseFloat(frameColorNum.get(i).get(index)));
	}
	
	/**
	 * Returns a float of the grid option price.
	 * 
	 * @param IndexList is the index of the picked item on the associated grid options list.
	 * @param Index is the index of the picked item on the associated grid options.
	 * @param UI is the currently entered UI.
	 * @return Float of the grid option price of the selected item.
	 */
	@Override
	public float getGridOptionsPrice(int indexList, int index, float UI) {
		if (!checkUI(UI)) return -1; //error 
		int ratio = gridOptionsNum.get(0).size() / gridOptions.size(); //see if UI matters
		if (ratio > 1) { //UI matters
			indexList++; //add one for UI row
			if (index >= gridOptionsNum.get(0).size() / ratio || index < 0) return -2; //index error	
			if (indexList >= gridOptionsNum.size() || indexList < 0) return -3; //index error
			int i = 0;
			while (UI > gridOptionsNum.get(0).get(i)) i++;
			return priceMultiplier * gridOptionsNum.get(indexList).get(index * ratio + i);
		} else { //UI doesn't matter
			if (index >= gridOptionsNum.get(0).size() || index < 0) return -4; //index error	
			if (indexList >= gridOptionsNum.size() || indexList < 0) return -5; //index error			
			return priceMultiplier * gridOptionsNum.get(indexList).get(index);			
		}
	}

	/**
	 * Returns a float of the energy options price.
	 * 
	 * @param Index is the index of the picked item on the associated energy options list.
	 * @param UI is the currently entered UI.
	 * @return Float of the energy option price of the selected item.
	 */
	@Override
	public float getEnergyOptionsPrice(int index, float UI) {//fix here
		if (energyOptionsNum.get(0).size() < energyOptionsNum.get(1).size()){ //then IU matters
			index++;
			int i = 0;
			while (UI > Float.parseFloat(energyOptionsNum.get(0).get(i))) {
				i++;				
			}
			if (energyOptionsNum.get(index).get(i).contains("N/A")) return 0;
			return Float.parseFloat(energyOptionsNum.get(index).get(i));			
		}
		if (index < energyOptionsList.size() && checkUI(UI)) return pricePerUI(UI, Float.parseFloat(energyOptionsNum.get(index).get(0)));
		return -1; //error flag
	}

	/**
	 * Returns a float of the glass strength price.
	 * 
	 * @param Index is the index of the picked item on the associated glass strength list.
	 * @param UI is the currently entered UI.
	 * @return Float of the glass strength price of the selected item.
	 */
	@Override
	public float getGlassStrengthPrice(int index, float UI) {
		if (!checkUI(UI)) return -2; //error flag to for bad UI input
		
		if (glassStrengthNum.size() > 1 && glassStrengthNum.get(0).size() < glassStrengthNum.get(1).size()) { //means that UI matters
			index++;
			if (index > glassStrengthList.size()) return -1; //error flag for bad index input
			String per = glassStrengthNum.get(index).get(glassStrengthNum.get(index).size() - 1); //gets type ex. UI or Sash
			if (per.contains("UI")) return pricePerUI(UI, Float.parseFloat(glassStrengthNum.get(index).get(0)));
			int i = 0;
			//if (checkUI(UI)) return -4; //bad UI
			while (UI > Float.parseFloat(glassStrengthNum.get(0).get(i))) {
				if (glassStrengthNum.get(0).size() == i + 1) {
					if (per.contains("Sash")) return 0;
				}
				i++;
			}
			if (per.contains("Sash")) return pricePerSash(Float.parseFloat(glassStrengthNum.get(index).get(i)));			
		}
		
		if (index >= glassStrengthList.size()) return -1; //error flag for bad index input
		
		String per = glassStrengthNum.get(index).get(glassStrengthNum.get(index).size() - 1); //gets type ex. UI or Sash
		if (per.contains("UI")) return pricePerUI(UI, Float.parseFloat(glassStrengthNum.get(index).get(0)));
		if (per.contains("Sash")) return pricePerSash(Float.parseFloat(glassStrengthNum.get(index).get(0)));
		return -3; //error flag
	}
	
	/**
	 * Returns a float of the glass price.
	 * 
	 * @param Index is the index of the picked item on the associated glass list.
	 * @param UI is the currently entered UI.
	 * @return Float of the glass price of the selected item.
	 */
	@Override
	public float getGlassPrice(int index, float UI) {//need to change
		if (!checkUI(UI)) return -2; //error flag to for bad UI input
		if (index >= glassList.size()) return -1; //error flag for bad index input
		
		if (glassList.get(0).equals("N/A for UI")) return 0; //for when ui makes list n/a
		
		if (glassNum.size() > 1 && glassNum.get(0).size() < glassNum.get(1).size()) { //means that UI matters
			index++;
			String per = glassNum.get(index).get(glassNum.get(index).size() - 1); //gets type ex. UI or Sash			
			int i = 0;
			while (UI > Float.parseFloat(glassNum.get(0).get(i))) {
				if (glassNum.get(0).size() == i + 1) { //need for glass due to ui limits
					if (per.contains("Sash")) return 0;
				}
				i++;
			}
			if (per.contains("UI")) return pricePerUI(UI, Float.parseFloat(glassNum.get(index).get(i)));
			if (per.contains("Sash")) return pricePerSash(Float.parseFloat(glassNum.get(index).get(i)));
			if (per.contains("Door")) return pricePerDoor(Float.parseFloat(glassNum.get(index).get(i)));			
		} else {
			String per = glassNum.get(index).get(glassNum.get(index).size() - 1); //gets type ex. UI or Sash
			if (per.contains("UI")) return pricePerUI(UI, Float.parseFloat(glassNum.get(index).get(0)));
			if (per.contains("Sash")) return pricePerSash(Float.parseFloat(glassNum.get(index).get(0)));
			if (per.contains("Door")) return pricePerDoor(Float.parseFloat(glassNum.get(index).get(0)));
		}
		return -3; //error flag
	}
	
	/**
	 * Returns a float of the spacer price.
	 * 
	 * @param Index is the index of the picked item on the associated spacer list.
	 * @param UI is the currently entered UI.
	 * @return Float of the spacer price of the selected item.
	 */
	@Override
	public float getSpacerPrice(int index, float UI) {
		if (index < spacerList.size() && checkUI(UI)) return pricePerUI(UI, Float.parseFloat(spacerNum.get(index).get(0)));
		return -1; //error flag
	}

	/**
	 * Returns a float of the mull price.
	 * 
	 * @param Index is the index of the picked item on the associated mull list.
	 * @param Mull is the currently entered number of mulls.
	 * @return Float of the mull price of the selected item.
	 */
	@Override
	public float getMullPrice(int index, int mull) {
		if (index < mullList.size()) return pricePerMull(mull, Float.parseFloat(mullNum.get(index).get(0)));
		return -1; //error flag
	}

	/**
	 * Returns a float of the glass tint price.
	 * 
	 * @param Index is the index of the picked item on the associated glass tint list.
	 * @param UI is the currently entered UI.
	 * @return Float of the glass tint price of the selected item.
	 */
	@Override
	public float getGlassTintPrice(int index, float UI) {
		if (!checkUI(UI)) return -1;
		
		if (glassTintNum.size() > 1 && glassTintNum.get(0).size() < glassTintNum.get(1).size()) { //means that UI matters
			index++;
			if (index >= glassTintNum.size()) return -2;
			String per = glassTintNum.get(index).get(glassTintNum.get(index).size() - 1); //gets type ex. UI or Sash			
			int i = 0;
			while (UI > Float.parseFloat(glassTintNum.get(0).get(i))) i++;
			if (per.contains("UI")) return pricePerUI(UI, Float.parseFloat(glassTintNum.get(index).get(i)));
			if (per.contains("Sash")) return pricePerSash(Float.parseFloat(glassTintNum.get(index).get(i)));
			if (per.contains("Door")) return pricePerDoor(Float.parseFloat(glassTintNum.get(index).get(i)));		
		} else {
			if (index >= glassTintNum.size()) return -3;
			String per = glassTintNum.get(index).get(glassTintNum.get(index).size() - 1); //gets type ex. UI or Sash					
			if (per.contains("UI")) return pricePerUI(UI, Float.parseFloat(glassTintNum.get(index).get(0)));
			if (per.contains("Sash")) return pricePerSash(Float.parseFloat(glassTintNum.get(index).get(0)));
			if (per.contains("Door")) return pricePerDoor(Float.parseFloat(glassTintNum.get(index).get(0)));
		}
		return -1; //error flag
	}

	/**
	 * Returns a float of the custom extra price.
	 * 
	 * @param Index is the index of the picked item on the associated custom extra list.
	 * @param UI is the currently entered UI.
	 * @return Float of the custom extra price of the selected item.
	 */
	@Override
	public float getCustomExtrasPrice(int index, float UI) {
		if (!checkUI(UI)) return -1;
		if (customExtrasNum.size() > 1 && customExtrasNum.get(0).size() < customExtrasNum.get(1).size()) { //means that UI matters
			index++;
			if (index >= customExtrasNum.size()) return -2;
			String per = customExtrasNum.get(index).get(customExtrasNum.get(index).size() - 1); //gets type ex. UI or Sash			
			int i = 0;
			while (UI > Float.parseFloat(customExtrasNum.get(0).get(i))) i++;
			if (per.contains("UI")) return pricePerUI(UI, Float.parseFloat(customExtrasNum.get(index).get(i)));
			if (per.contains("Window")) return pricePerWindow(Float.parseFloat(customExtrasNum.get(index).get(0)));
			if (per.contains("Sash")) return pricePerSash(Float.parseFloat(customExtrasNum.get(index).get(i)));
			if (per.contains("Door")) return pricePerDoor(Float.parseFloat(customExtrasNum.get(index).get(i)));	
		} else {
			if (index >= customExtrasNum.size()) return -3;
			String per = customExtrasNum.get(index).get(customExtrasNum.get(index).size() - 1); //gets type ex. UI or Sash					
			if (per.contains("UI")) return pricePerUI(UI, Float.parseFloat(customExtrasNum.get(index).get(0)));
			if (per.contains("Window")) return pricePerWindow(Float.parseFloat(customExtrasNum.get(index).get(0)));
			if (per.contains("Sash")) return pricePerSash(Float.parseFloat(customExtrasNum.get(index).get(0)));
			if (per.contains("Door")) return pricePerDoor(Float.parseFloat(customExtrasNum.get(index).get(0)));
		}
		/*if (index < customExtrasList.size()){
			if (customExtrasNum.get(index).get(1).contains("Window")) return pricePerWindow(Float.parseFloat(customExtrasNum.get(index).get(0))); 
			if (customExtrasNum.get(index).get(1).contains("UI")) {
				if (checkUI(UI)) return pricePerUI(UI ,Float.parseFloat(customExtrasNum.get(index).get(0)));
				else return -1; //error flag
			}
		}*/
		return -1; //error flag
	}
	
	/**
	 * Returns a float of the exterior paint price.
	 * 
	 * @param Index is the index of the picked item on the associated exterior paint list.
	 * @return Float of the exterior paint price of the selected item.
	 */
	@Override
	public float getExteriorPaintPrice(int index) {
		if (index < exteriorPaintList.size()) return priceMultiplier * Float.parseFloat(exteriorPaintNum.get(index).get(0));
		return -1; //error flag
	}

	/**
	 * Returns a float of the miniblinds price.
	 * 
	 * @param Index is the index of the picked item on the associated miniblinds list.
	 * @param UI is the currently entered UI.
	 * @return Float of the miniblinds price of the selected item.
	 */
	@Override
	public float getMiniblindsPrice(int index, float UI) {
		if (!checkUI(UI)) return -1;
		index++;
		if (index >= miniblindsNum.get(0).size() - 1) return -2;
		
		int i = 0;
		while (UI > Float.parseFloat(miniblindsNum.get(i).get(0))) i++;							
		if (miniblindsNum.get(i).get(index).contains("N/A")) return 0;
		String per = miniblindsNum.get(i).get(miniblindsNum.get(i).size() - 1); //gets type ex. UI or Sash		
		if (per.contains("UI")) return pricePerUI(UI, Float.parseFloat(miniblindsNum.get(i).get(index)));
		if (per.contains("Sash")) return pricePerSash(Float.parseFloat(miniblindsNum.get(i).get(index)));
		if (per.contains("Door")) return pricePerDoor(Float.parseFloat(miniblindsNum.get(i).get(index)));	
		return -3;
	}	
	
	/**
	 * Returns a float of the screen price.
	 * 
	 * @param Index is the index of the picked item on the associated screen list.
	 * @return Float of the screen price of the selected item.
	 */
	@Override
	public float getScreenPrice(int index) {
		if (index < screenList.size()) return pricePerWindow(Float.parseFloat(screenNum.get(index).get(0)));
		return -1; //error flag
	}

	/**
	 * Returns a float of the screen mesh price.
	 * 
	 * @param Index is the index of the picked item on the associated screen mesh list.
	 * @return Float of the screen mesh price of the selected item.
	 */
	@Override
	public float getScreenMeshPrice(int index) {
		if (index < screenMeshList.size()) return pricePerWindow(Float.parseFloat(screenMeshNum.get(index).get(0)));
		return -1; //error flag
	}

	/**
	 * Returns a float of the reinforcement price.
	 * 
	 * @param Index is the index of the picked item on the associated reinforcement list.
	 * @return Float of the reinforcement price of the selected item.
	 */
	@Override
	public float getReinforcementPrice(int index) {
		if (index < reinforcementList.size()) return pricePerWindow(Float.parseFloat(reinforcementNum.get(index).get(0)));		
		return -1; //error flag
	}

	/**
	 * Returns a float of the lock color price.
	 * 
	 * @param Index is the index of the picked item on the associated lock color list.
	 * @param ExtraLock is true if extra lock is checked.
	 * @return Float of the lock color price of the selected item.
	 */
	@Override
	public float getLockColorPrice(int index, boolean extraLock) {
		if (index < lockColorList.size()){
			if (extraLock == true) return pricePerLock(Float.parseFloat(lockColorNum.get(index).get(0)), locks + 1);
			else return pricePerLock(Float.parseFloat(lockColorNum.get(index).get(0)), locks);
		}
		return -1; //error flag
	}
	
	
	
	/******************************************************************************************
	Private helpers
	******************************************************************************************/
	
	/**
	 * Returns true if UI is within range.
	 * 
	 * @param UI is the UI.
	 * @return True if UI within range.
	 */
	private boolean checkUI(float UI){
		if (maxUI.size() == 0) return true;
		int panels = 0;
		if (UI <= maxUI.get(0) && UI > 0) {
			if (maxUI.size() > 3) panels = maxUI.size() - 2;
			else panels = 1;
			if (maxUI.get(panels) == -1) return true; //no sq set for product
			else if (UI/144 <= maxUI.get(panels+1)) return true; //if sq set then check 			
		}		
		return false;
	}
	
	/**
	 * Returns a float of the lock color price.
	 * 
	 * @param Price is the price per lock.
	 * @param Locks is the number of locks.
	 * @return Float of the total lock price.
	 */
	private float pricePerLock(float price, int locks){
		return priceMultiplier * price * locks;
	}
	
	/**
	 * Returns a float of the input price times priceX times UI.
	 * 
	 * @param UI is the given UI.
	 * @param Price is the item price.
	 * @return Float of the total price.
	 */
	private float pricePerUI(float UI, float price){		
		return priceMultiplier * price * UI;
	}
	
	/**
	 * Returns a float of the input price times priceX times sash.
	 * 
	 * @param Price is the item price.
	 * @return Float of the total price.
	 */
	private float pricePerSash(float price){
		return priceMultiplier * price * sashNum(getProductName());
	}
	
	/**
	 * Returns a float of the mull price time priceX times mull.
	 * 
	 * @param Mull is the number of mulls.
	 * @param Price is the item price.
	 * @return Float of the total lock price.
	 */
	private float pricePerMull(int mull, float price){
		return priceMultiplier * price * mull;
	}
	
	/**
	 * Returns a float of the input price times priceX.
	 * 
	 * @param Price is the item price.
	 * @return Float of the total price.
	 */
	private float pricePerWindow(float price){
		return priceMultiplier * price;
	}
	
	/**
	 * Returns a float of the input price times priceX.
	 * 
	 * @param Price is the item price.
	 * @return Float of the total price.
	 */
	private float pricePerDoor(float price){
		return priceMultiplier * price;
	}
	
	/**
	 * Returns a int of the number of sash has based on it's product name.
	 * 
	 * @param The product's name.
	 * @return The number of sash as an int.
	 */
	private int sashNum(String productName){
		if (productName.contains("Double") || productName.contains("2-LiteGlider")) return 2;
		else if (productName.contains("3-LiteGlider") || productName.contains("Triple")) return 3;
		return 1;
	}
	
	
	
	/******************************************************************************************
	Public methods
	******************************************************************************************/
	
	/**
	 * 
	 * @param width
	 * @param height
	 * @param tempered
	 * @param miniblinds
	 * @param panels
	 * @return
	 */
	@Override
	public String checkSize(float width, float height, boolean tempered, boolean miniblinds){ //needs more work
		//maxUI and one side
		if (width + height > maxUI.get(0)) return "Over Max UI: " + maxUI.get(0); //checks maxUI
		if (maxUI.size() > 1 && maxUI.get(1) != -1 && (width + height) / 144 > maxUI.get(1)) return "Over Max SQ:" + maxUI.get(1); //checks max SQ
		if (!tempered && maxUI.size() > 2 && maxUI.get(2) != -1  && (width + height) / 144 > maxUI.get(2)) return "Over Max Tempered SQ:" + maxUI.get(2) + ", must be tempered"; //checks max SQ for tempered
		if (size.getOneSide().size() > 0 && width < size.getOneSide().get(0) && height < size.getOneSide().get(0)) return "One side must be at least: " + size.getOneSide().get(0); //check one side				
		//basic width/height
		if (width < size.getWidth().get(0)) return "Below Min Width: " + size.getWidth().get(0); //min width
		if (width > size.getWidth().get(1)) return "Above Max Width: " +  size.getWidth().get(1); //max width
		if (height < size.getHeight().get(0)) return "Below Min Height: " + size.getHeight().get(0); //min height
		if (height > size.getHeight().get(1)) return "Above Max Height: " +  size.getHeight().get(1); //max height
		//miniblind width/height
		if (miniblinds){
			if (size.getWidth().get(2) > 0 && width < size.getWidth().get(2)) return "Below Min Miniblinds Width: " + size.getWidth().get(2); //min miniblinds width
			if (size.getWidth().get(3) > 0 && width > size.getWidth().get(3)) return "Above Max Miniblinds Width: " +  size.getWidth().get(3); //max miniblinds width
			if (size.getHeight().get(2) > 0 && height < size.getHeight().get(2)) return "Below Min Miniblinds Height: " + size.getHeight().get(2); //min miniblinds height
			if (size.getHeight().get(3) > 0 && height > size.getHeight().get(3)) return "Above Max Miniblinds Height: " +  size.getHeight().get(3); //max miniblinds height
		}
		//tempered?
		//tempered & miniblinds?
		//multipoint locks?
		
		return "Good UI";
	}
	
	/**
	 * 
	 * @param width
	 * @param height
	 * @param tempered
	 * @param miniblinds
	 * @param panels
	 * @return
	 */
	public String checkSize(float width, float height, boolean tempered, boolean miniblinds, int panels){ //needs more work
		//maxUI and one side
		if (width + height > maxUI.get(panels)) return "Over Max UI: " + maxUI.get(panels); //checks maxUI
		int i = maxUI.size() - 2; //how many panels there are
		if (maxUI.size() > i && maxUI.get(i) != -1 && (width + height) / 144 > maxUI.get(i)) return "Over Max SQ:" + maxUI.get(i); //checks max SQ
		if (!tempered && maxUI.size() > i+1 && maxUI.get(i+1) != -1  && (width + height) / 144 > maxUI.get(i+1)) return "Over Max Tempered SQ:" + maxUI.get(i+1) + ", must be tempered"; //checks max SQ for tempered
		if (size.getOneSide().size() > 0 && width < size.getOneSide().get(0) && height < size.getOneSide().get(0)) return "One side must be at least: " + size.getOneSide().get(0); //check one side				
		//basic width/height
		if (panels == 0) {
			if (width < size.getWidth().get(0)) return "Below Min Width: " + size.getWidth().get(0); //min width
			if (width > size.getWidth().get(1)) return "Above Max Width: " +  size.getWidth().get(1); //max width
			if (height < size.getHeight().get(0)) return "Below Min Height: " + size.getHeight().get(0); //min height
			if (height > size.getHeight().get(1)) return "Above Max Height: " +  size.getHeight().get(1); //max height
			//miniblind width/height
			if (miniblinds){
				if (size.getWidth().get(2) > 0 && width < size.getWidth().get(2)) return "Below Min Miniblinds Width: " + size.getWidth().get(2); //min miniblinds width
				if (size.getWidth().get(3) > 0 && width > size.getWidth().get(3)) return "Above Max Miniblinds Width: " +  size.getWidth().get(3); //max miniblinds width
				if (size.getHeight().get(2) > 0 && height < size.getHeight().get(2)) return "Below Min Miniblinds Height: " + size.getHeight().get(2); //min miniblinds height
				if (size.getHeight().get(3) > 0 && height > size.getHeight().get(3)) return "Above Max Miniblinds Height: " +  size.getHeight().get(3); //max miniblinds height
			}
		} else {
			if (width < size.getWidth2().get(0)) return "Below Min Width: " + size.getWidth2().get(0); //min width
			if (width > size.getWidth2().get(1)) return "Above Max Width: " +  size.getWidth2().get(1); //max width
			if (height < size.getHeight2().get(0)) return "Below Min Height: " + size.getHeight2().get(0); //min height
			if (height > size.getHeight2().get(1)) return "Above Max Height: " +  size.getHeight2().get(1); //max height
			//miniblind width/height
			if (miniblinds){
				if (size.getWidth2().get(2) > 0 && width < size.getWidth2().get(2)) return "Below Min Miniblinds Width: " + size.getWidth2().get(2); //min miniblinds width
				if (size.getWidth2().get(3) > 0 && width > size.getWidth2().get(3)) return "Above Max Miniblinds Width: " +  size.getWidth2().get(3); //max miniblinds width
				if (size.getHeight2().get(2) > 0 && height < size.getHeight2().get(2)) return "Below Min Miniblinds Height: " + size.getHeight2().get(2); //min miniblinds height
				if (size.getHeight2().get(3) > 0 && height > size.getHeight2().get(3)) return "Above Max Miniblinds Height: " +  size.getHeight2().get(3); //max miniblinds height
			}
		}
		
		//tempered?
		//tempered & miniblinds?
		//multipoint locks?
		
		return "Good UI";
	}
	
	/**
	 * Returns true if miniblind UI is good.
	 * 
	 * @param Width as a float.
	 * @param Height as a float.
	 * @return Float of the total price.
	 */
	public boolean checkMiniblinds(float width, float height){
		//must account for -1 places
		float f = -1;
		if (size.getWidth().get(2) != f && width >= size.getWidth().get(2) &&
			size.getWidth().get(3) != f && width >= size.getWidth().get(3) &&
			size.getHeight().get(2) != f && height >= size.getHeight().get(2) &&
			size.getHeight().get(3) != f && height >= size.getHeight().get(3)) return true;
		return false;
	}
	
	/**
	 * Returns true if tempered UI is good.
	 * 
	 * @param Width as a float.
	 * @param Height as a float.
	 * @return Float of the total price.
	 */
	public boolean checkTempered(float width, float height){ //needs rework of size
		return true;
	}
	
	/**
	 * Returns true if the extra lock checkbox can be check.
	 * 
	 * @param inches of either height or width depending on the product.
	 * @return True if inches is in the range to allow the option checkbox.
	 */
	public boolean canHaveExtraLock(float inch){
		//use width for xx20
		//use height for xx30
		if (getProductName().contains("84") && inch >= 24 && inch < 30) {
			locks = 1;
			return true;
		} else if (inch < 24) {
			locks = 1;
			return false;
		} else if (getProductName().contains("70") && inch <= 26) {
			locks = 1;
			return true;				
		} else if (inch < 26) {
			locks = 1;
			return false;
		}
		locks = 2;
		return false;
	}
	
	/**
	 * Returns string of the width size label.
	 * 
	 * @return String of the width size label.
	 */
	public String getWidthLabel(){
		String label = "Min: " + size.getWidth().get(0) + "  Max: " + size.getWidth().get(1);
		if (true); //need to check for miniblinds and add to label
		return label;		
	}
	
	/**
	 * Returns string of the height size label.
	 * 
	 * @return String of the height size label.
	 */
	public String getHeight2Label(){
		String label = "Min: " + size.getHeight2().get(0) + "  Max: " + size.getHeight2().get(1);
		if (true); //need to check for miniblinds and add to label
		return label;		
	}

	/**
	 * Returns string of the width size label.
	 * 
	 * @return String of the width size label.
	 */
	public String getWidth2Label(){
		String label = "Min: " + size.getWidth2().get(0) + "  Max: " + size.getWidth2().get(1);
		if (true); //need to check for miniblinds and add to label
		return label;		
	}
	
	/**
	 * Returns string of the height size label.
	 * 
	 * @return String of the height size label.
	 */
	public String getHeightLabel(){
		String label = "Min: " + size.getHeight().get(0) + "  Max: " + size.getHeight().get(1);
		if (true); //need to check for miniblinds and add to label
		return label;		
	}
	
	/**
	 * @param index
	 * @return
	 */
	public ArrayList<String> getGridList2(int index){
		ArrayList<String> gridList = new ArrayList<String>();			
		int ratio = gridOptionsNum.get(0).size() / gridOptions.size(); //see if UI matters
		if (ratio > 1) { //UI matters
			index++; //add one for UI row
			if (index >= gridOptionsNum.size() || index < 0) return gridList; //index error	
			int gridSize  = gridOptionsNum.get(index).size() / ratio;
			for (int i = 0; i < gridSize; i++) {
				if (gridOptionsNum.get(index).get(i * ratio) > 0) gridList.add(gridOptions.get(i));
			}
			if (gridList.size() == 0) gridList.add("None");
			return gridList;
		} else { //UI doesn't matter
			if (index >= gridOptionsNum.size() || index < 0) return gridList; //index error	
			for (int i = 0; i < gridOptionsNum.get(index).size(); i++) {
				if (gridOptionsNum.get(index).get(i) > 0) gridList.add(gridOptions.get(i));
			}
			if (gridList.size() == 0) gridList.add("None");
			return gridList;
		}
	}
	
	/**
	 * 
	 * @param UI
	 * @return
	 */
	public ArrayList<String> getGlassList2(float UI){		
		if (!checkUI(UI)) return this.glassList;
		int i = 0;
		while (UI > Float.parseFloat(glassNum.get(0).get(i))) {
			if (i + 1 == glassNum.get(0).size()) {
				ArrayList<String> glassList = new ArrayList<String>();
				glassList.add("N/A for UI");
				return glassList;
			}
			i++;
		}
		return this.glassList;		
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<String> getPatioSize(){
		ArrayList<String> sizeList = new ArrayList<String>();
		for (int i = 0; i < frameColorNum.size(); i++) {
			sizeList.add(frameColorNum.get(i).get(frameColorNum.get(i).size() -1));
		}
		return sizeList;
	}
	
	public float getPatioUI(int index){
		String line = getPatioSize().get(index);
		float num = 0;
		int start = line.indexOf('(') + 1;
		int end = line.indexOf('"', start);
		String width = line.substring(start, end);
		start = line.indexOf('X', end) + 2;
		end = line.indexOf('"', start);
		String height = line.substring(start, end);
		return Float.parseFloat(width) + Float.parseFloat(height);
	}
		
	public float getPatioNum(int index){
		String line = getPatioSize().get(index);
		int end = line.indexOf("'");
		return Float.parseFloat(line.substring(0, end));				
	}
	
	public ArrayList<String> getPatioEnergyList(int index){
		ArrayList<String> energyList = new ArrayList<String>();
		for (int i = 1; i < energyOptionsNum.size(); i++) {
			if (!energyOptionsNum.get(i).get(index).equals("N/A")) energyList.add(energyOptionsList.get(i - 1));
			else energyList.add("N/A for size");
		}
		return energyList;
	}
	
	
	public ArrayList<String> getPatioMiniblindList(int index){
		ArrayList<String> miniblindList = new ArrayList<String>();
		for (int i = 1; i < miniblindsNum.get(index).size() - 1; i++) {
			if (!miniblindsNum.get(index).get(i).equals("N/A")) miniblindList.add(miniblindsList.get(i - 1));
			else miniblindList.add("N/A for size");
		}
		return miniblindList;
	}
	/******************************************************************************************
	Getter & Setter
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
	 * @return the maxUI
	 */
	public ArrayList<Float> getMaxUI() {
		return maxUI;
	}

	/**
	 * @param maxUI the maxUI to set
	 */
	public void setMaxUI(ArrayList<Float> maxUI) {
		this.maxUI = maxUI;
	}

	/**
	 * @return the size
	 */
	public Size getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(Size size) {
		this.size = size;
	}

	/**
	 * @return the frameColorLabel
	 */
	public String getFrameColorLabel() {
		return frameColorLabel;
	}

	/**
	 * @param frameColorLabel the frameColorLabel to set
	 */
	public void setFrameColorLabel(String frameColorLabel) {
		this.frameColorLabel = frameColorLabel;
	}

	/**
	 * @return the patioDoorList
	 */
	public ArrayList<String> getPatioDoorList() {
		return patioDoorList;
	}

	/**
	 * @param patioDoorList the patioDoorList to set
	 */
	public void setPatioDoorList(ArrayList<String> patioDoorList) {
		this.patioDoorList = patioDoorList;
	}

	/**
	 * @return the frameColorList
	 */
	public ArrayList<String> getFrameColorList() {
		return frameColorList;
	}

	/**
	 * @param frameColorList the frameColorList to set
	 */
	public void setFrameColorList(ArrayList<String> frameColorList) {
		this.frameColorList = frameColorList;
	}

	/**
	 * @return the frameColorNum
	 */
	public ArrayList<ArrayList<String>> getFrameColorNum() {
		return frameColorNum;
	}

	/**
	 * @param frameColorNum the frameColorNum to set
	 */
	public void setFrameColorNum(ArrayList<ArrayList<String>> frameColorNum) {
		this.frameColorNum = frameColorNum;
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
	 * @return the mullLabel
	 */
	public String getMullLabel() {
		return mullLabel;
	}

	/**
	 * @param mullLabel the mullLabel to set
	 */
	public void setMullLabel(String mullLabel) {
		this.mullLabel = mullLabel;
	}

	/**
	 * @return the mullList
	 */
	public ArrayList<String> getMullList() {
		return mullList;
	}

	/**
	 * @param mullList the mullList to set
	 */
	public void setMullList(ArrayList<String> mullList) {
		this.mullList = mullList;
	}

	/**
	 * @return the mullNum
	 */
	public ArrayList<ArrayList<String>> getMullNum() {
		return mullNum;
	}

	/**
	 * @param mullNum the mullNum to set
	 */
	public void setMullNum(ArrayList<ArrayList<String>> mullNum) {
		this.mullNum = mullNum;
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
	 * @return the woodgrainsLabel
	 */
	public String getWoodgrainsLabel() {
		return woodgrainsLabel;
	}

	/**
	 * @param woodgrainsLabel the woodgrainsLabel to set
	 */
	public void setWoodgrainsLabel(String woodgrainsLabel) {
		this.woodgrainsLabel = woodgrainsLabel;
	}

	/**
	 * @return the woodgrainsList
	 */
	public ArrayList<String> getWoodgrainsList() {
		return woodgrainsList;
	}

	/**
	 * @param woodgrainsList the woodgrainsList to set
	 */
	public void setWoodgrainsList(ArrayList<String> woodgrainsList) {
		this.woodgrainsList = woodgrainsList;
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
	 * @return the miniblindsLabel
	 */
	public String getMiniblindsLabel() {
		return miniblindsLabel;
	}

	/**
	 * @param miniblindsLabel the miniblindsLabel to set
	 */
	public void setMiniblindsLabel(String miniblindsLabel) {
		this.miniblindsLabel = miniblindsLabel;
	}

	/**
	 * @return the miniblindsList
	 */
	public ArrayList<String> getMiniblindsList() {
		return miniblindsList;
	}

	/**
	 * @param miniblindsList the miniblindsList to set
	 */
	public void setMiniblindsList(ArrayList<String> miniblindsList) {
		this.miniblindsList = miniblindsList;
	}

	/**
	 * @return the miniblindsNum
	 */
	public ArrayList<ArrayList<String>> getMiniblindsNum() {
		return miniblindsNum;
	}

	/**
	 * @param miniblindsNum the miniblindsNum to set
	 */
	public void setMiniblindsNum(ArrayList<ArrayList<String>> miniblindsNum) {
		this.miniblindsNum = miniblindsNum;
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
	 * @return the reinforcementLabel
	 */
	public String getReinforcementLabel() {
		return reinforcementLabel;
	}

	/**
	 * @param reinforcementLabel the reinforcementLabel to set
	 */
	public void setReinforcementLabel(String reinforcementLabel) {
		this.reinforcementLabel = reinforcementLabel;
	}

	/**
	 * @return the reinforcementList
	 */
	public ArrayList<String> getReinforcementList() {
		return reinforcementList;
	}

	/**
	 * @param reinforcementList the reinforcementList to set
	 */
	public void setReinforcementList(ArrayList<String> reinforcementList) {
		this.reinforcementList = reinforcementList;
	}

	/**
	 * @return the reinforcementNum
	 */
	public ArrayList<ArrayList<String>> getReinforcementNum() {
		return reinforcementNum;
	}

	/**
	 * @param reinforcementNum the reinforcementNum to set
	 */
	public void setReinforcementNum(ArrayList<ArrayList<String>> reinforcementNum) {
		this.reinforcementNum = reinforcementNum;
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
	 * @return the panelLabel
	 */
	public String getPanelLabel() {
		return panelLabel;
	}

	/**
	 * @param panelLabel the panelLabel to set
	 */
	public void setPanelLabel(String panelLabel) {
		this.panelLabel = panelLabel;
	}

	/**
	 * @return the panelList
	 */
	public ArrayList<String> getPanelList() {
		return panelList;
	}

	/**
	 * @param panelList the panelList to set
	 */
	public void setPanelList(ArrayList<String> panelList) {
		this.panelList = panelList;
	}

	/**
	 * @return the panelNum
	 */
	public ArrayList<ArrayList<String>> getPanelNum() {
		return panelNum;
	}

	/**
	 * @param panelNum the panelNum to set
	 */
	public void setPanelNum(ArrayList<ArrayList<String>> panelNum) {
		this.panelNum = panelNum;
	}
	
}
