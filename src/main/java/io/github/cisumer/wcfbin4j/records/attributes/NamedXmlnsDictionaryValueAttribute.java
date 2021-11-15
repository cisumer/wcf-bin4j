package io.github.cisumer.wcfbin4j.records.attributes;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import io.github.cisumer.wcfbin4j.Dictionary;
import io.github.cisumer.wcfbin4j.records.Attribute;
import io.github.cisumer.wcfbin4j.util.ByteArrayUtil;
/**
 * 
 * 使用字典作为值的xmlns属性
 * 0x0Ax06 >> xmlns="http://www.w3.org/2005/08/addressing"
 * @author github.com/cisumer
 *
 */
public class NamedXmlnsDictionaryValueAttribute extends Attribute<String>{
	protected int index;
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}

	public int getType(){
		return 0x0A;
	}
	
	@Override
	public void renderContent(OutputStream os) throws Exception {
		byte[] bs=ByteArrayUtil.MultiByteInt31ToBytes(index);
		os.write(bs);
	}
	@Override
	public String parseName(InputStream in) throws IOException {return "xmlns";}
	@Override
	public String parsePrefix(InputStream in) throws IOException {return null;}
	@Override
	public String parseValue(InputStream in) throws IOException {
		index=ByteArrayUtil.getMultiByteInt31(in);
		return Dictionary.getDictionary(index);
	}
}
