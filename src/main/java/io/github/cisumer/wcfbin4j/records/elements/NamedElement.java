package io.github.cisumer.wcfbin4j.records.elements;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import io.github.cisumer.wcfbin4j.records.Element;

/**
 * 简单元素<br/> 
 * [0x40][len][name] eg: @0x04test >> &lt;test&gt;
 * @author github.com/cisumer
 *
 */
public class NamedElement extends Element{
	@Override
	public int getType() {
		return 0x40;
	}
	protected String parseName(InputStream is) throws IOException{
		return parseLenString(is);
	}
	protected String parsePrefix(InputStream is) throws IOException{return null;}

	protected void prefixBytes(OutputStream os) throws Exception {}
	
	protected void nameBytes(OutputStream os)throws Exception{
	    lenStringBytes(name, os);
	}

	
}
