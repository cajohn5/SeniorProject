/*Author Mark DiFiglio
*Date 4/2/2017
*
*This class is used to handle the size variable of windows product.
*The array list are filled in as follows: 
*[Minimum, Maximum, Miniblinds Minimum, Miniblinds Maximum, Tempered, Tempered & Miniblinds, Multipoint Lock Minimum, Mulled Maximum]
*
*A value of N/A in the excel sheet should be a value of -1 in the array list
*/

package product_classes;

import java.util.ArrayList;
import java.util.Arrays;

public class Size {
	
	/******************************************************************************************
	Variables
	******************************************************************************************/
	private ArrayList<Float> width; //first set of width sizes
	private ArrayList<Float> height; //first set of height sizes
	private ArrayList<Float> width2; //second set of width sizes
	private ArrayList<Float> height2; //second set of height sizes

	private ArrayList<Float> oneSide; //if one side must be at least this length

	
	
	/******************************************************************************************
	Constructors
	******************************************************************************************/
	
	/**
	 * 
	 */
	public Size(){ //everything is set to -1 by default
		float f = -1;
		this.width = new ArrayList<Float>(Arrays.asList(f,f,f,f,f,f,f,f));
		this.height = new ArrayList<Float>(Arrays.asList(f,f,f,f,f,f,f,f));
		this.width2 = new ArrayList<Float>(Arrays.asList(f,f,f,f,f,f,f,f));
		this.height2 = new ArrayList<Float>(Arrays.asList(f,f,f,f,f,f,f,f));

		this.oneSide = new ArrayList<Float>(Arrays.asList(f,f));		
	}
	
	/**
	 * @param width
	 * @param height
	 * @param width2
	 * @param height2
	 * @param oneSide
	 */
	public Size(ArrayList<Float> width, ArrayList<Float> height, ArrayList<Float> width2, ArrayList<Float> height2,
			ArrayList<Float> oneSide) {
		super();
		this.width = width;
		this.height = height;
		this.width2 = width2;
		this.height2 = height2;
		this.oneSide = oneSide;
	}

	
	
	/******************************************************************************************
	Getters & Setters
	******************************************************************************************/
	
	/**
	 * @return the width
	 */
	public ArrayList<Float> getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(ArrayList<Float> width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public ArrayList<Float> getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(ArrayList<Float> height) {
		this.height = height;
	}

	/**
	 * @return the width2
	 */
	public ArrayList<Float> getWidth2() {
		return width2;
	}

	/**
	 * @param width2 the width2 to set
	 */
	public void setWidth2(ArrayList<Float> width2) {
		this.width2 = width2;
	}

	/**
	 * @return the height2
	 */
	public ArrayList<Float> getHeight2() {
		return height2;
	}

	/**
	 * @param height2 the height2 to set
	 */
	public void setHeight2(ArrayList<Float> height2) {
		this.height2 = height2;
	}

	/**
	 * @return the oneSide
	 */
	public ArrayList<Float> getOneSide() {
		return oneSide;
	}

	/**
	 * @param oneSide the oneSide to set
	 */
	public void setOneSide(ArrayList<Float> oneSide) {
		this.oneSide = oneSide;
	}

}
