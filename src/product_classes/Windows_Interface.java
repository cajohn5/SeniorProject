/*Mark DiFiglio
 * 4/3/2017
 * 
 *To be used to store all DynaWelds, all TWP except Shapes, all UW except Shapes & Garden
 */

package product_classes;

public interface Windows_Interface {

	public float getFrameColorPrice(int index, float UI);
	public float getFrameColorPricePD(int index, int widthIndex);
	public float getFrameColorPriceCustomPD(int index, float width, int panels);
	public float getGridOptionsPrice(int indexList, int index, float UI);
	public float getEnergyOptionsPrice(int index, float UI);
	public float getGlassStrengthPrice(int index, float UI);
	public float getGlassPrice(int index, float UI);
	public float getSpacerPrice(int index, float UI);
	public float getMullPrice(int index, int mull);
	public float getGlassTintPrice(int index, float UI);
	public float getCustomExtrasPrice(int index, float per);
	public float getExteriorPaintPrice(int index);
	public float getMiniblindsPrice(int index, float UI);
	public float getScreenPrice(int index);
	public float getScreenMeshPrice(int index);
	public float getReinforcementPrice(int index);
	public float getLockColorPrice(int index, boolean extraLock);
		
	public boolean canHaveExtraLock(float inch);
	public String checkSize(float width, float height, boolean tempered, boolean miniblinds);
	public boolean checkMiniblinds(float width, float height);
	public boolean checkTempered(float width, float height);
	
	public String getWidthLabel();
	public String getHeightLabel();
}
