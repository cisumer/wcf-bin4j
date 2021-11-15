package io.github.cisumer.wcfbin4j.records.attributes;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import io.github.cisumer.wcfbin4j.Dictionary;
import io.github.cisumer.wcfbin4j.util.ByteArrayUtil;
/**
 * 
 * 使用字典作为值，xmlns作为前缀的属性
 * 0x0B0x01ax06 >> xmlns:a="http://www.w3.org/2005/08/addressing"
 * @author github.com/cisumer
 *
 */
public class PrefixXmlnsNamedDictionaryValueAttribute extends NamedXmlnsDictionaryValueAttribute {

	public int getType(){
		return 0x0B;
	}

	@Override
	public String parseName(InputStream is) throws IOException {
		return parseLenString(is);
	}
	public String parseValue(InputStream is) throws IOException {
		index=ByteArrayUtil.getMultiByteInt31(is);
		return Dictionary.getDictionary(index);
	}
	
	@Override
	public void toBytes(OutputStream os) throws Exception {
		os.write(getType());
		lenStringBytes(name, os);
		byte[] bs=ByteArrayUtil.MultiByteInt31ToBytes(index);
		os.write(bs);
	}
}
