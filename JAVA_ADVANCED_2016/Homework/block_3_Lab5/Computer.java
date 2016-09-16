/**
 * 
 */
package block_3_Lab5;


/**
 * @author artem.stepanov
 *
 */
public class Computer {
	

	private String name = "PC";
	private double freq = 486;
	private int video = 32;
	private int ram = 128;
	private int hdd = 40;
	
	public Computer(String name, double freq, int video, int ram, int hdd){
		setName(name);
		setFreq(freq);
		setVideo(video);
		setRam(ram);
		setHdd(hdd);
	}
	
	public Computer(){}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getFreq() {
		return freq;
	}
	public void setFreq(double freq) {
		this.freq = freq;
	}
	public int getVideo() {
		return video;
	}
	public void setVideo(int video) {
		this.video = video;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public int getHdd() {
		return hdd;
	}
	public void setHdd(int hdd) {
		this.hdd = hdd;
	}
	
	@Override
	public String toString() {
		return "name=" + name + ", freq=" + freq + ", video=" + video + ", ram=" + ram + ", hdd=" + hdd;
	}
	

	@My_Annot
	public void makeItFaster(){
		setFreq(getFreq()+500);
		setRam(getRam()+256);
	}

	
}
