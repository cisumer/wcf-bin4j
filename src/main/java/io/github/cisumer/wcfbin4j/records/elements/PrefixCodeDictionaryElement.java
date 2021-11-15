package io.github.cisumer.wcfbin4j.records.elements;

import java.io.IOException;
import java.io.InputStream;

/**
 * 固定前缀的字典元素
 * 
 * @author github.com/cisumer
 *
 */
public class PrefixCodeDictionaryElement extends NamedDictionaryElement {
	private int type;
	@Override
	public int getType() {
		return type;
	}
	public void setType(int type){
		this.type=type;
	}
	public void setType(char type){
		this.type=type-'a'+0x44;
	}
	
	public String parsePrefix(InputStream is) throws IOException{
		return Character.toString((char)(type - 0x44 + 'a'));
	}
}
