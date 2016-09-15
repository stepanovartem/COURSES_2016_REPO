/**
 * 
 */
package block_3_Lab5;

/**
 * @author artem.stepanov
 *
 */
public class TabletPC extends Computer {
	
	private double display;
	private String os;
	private double battery;
	
	public TabletPC(String name, double freq, int video, int ram, int hdd, double display, String os, double battery) {
		super(name, freq, video, ram, hdd);
		setDisplay(display);
		setOs(os);
		setBattery(battery);
	}
	
	public TabletPC() {}
	
	
	public double getDisplay() {
		return display;
	}
	public void setDisplay(double display) {
		this.display = display;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public double getBattery() {
		return battery;
	}
	public void setBattery(double battery) {
		this.battery = battery;
	}
	
	@Override
	public String toString() {
		return super.toString()+", display=" + getDisplay() + ", OS=" + getOs() + ", battery=" + getBattery();
	}
	
	
		
}
