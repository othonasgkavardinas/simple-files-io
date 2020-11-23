//ONOMA: OTHONAS GKAVARDINAS 
//AM: 2620

package main;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public abstract class FileIO {
	private @Getter String path;
	
	public abstract boolean init();
	public abstract void close();
}