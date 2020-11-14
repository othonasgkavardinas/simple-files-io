//ONOMA: OTHONAS GKAVARDINAS 
//AM: 2620

package main;

public abstract class FileIO {
	
	private String path;
	
	public FileIO(String path){
		this.path = path;
	}
	
	public abstract boolean init();
	
	public abstract void close();
	
	public String getPath() {
		return path;
	}
}