package io.github.cisumer.wcfbin4j.nodes.attributes;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import io.github.cisumer.wcfbin4j.Dictionary;
import io.github.cisumer.wcfbin4j.util.ByteArrayUtil;

/**
 * 使用Text作为值，字典作为属性名的属性
 * 0x06x0c0x86 >> To="true"
 * @author github.com/cisumer
 *
 */
public class DictionaryTextValueAttribute extends TextValueAttribute {
	protected int index;

	@Override
	public int getType() {
		return 0x06;
	}

	@Override
	public void renderContent(OutputStream os) throws Exception {
		byte[] bs=ByteArrayUtil.MultiByteInt31ToBytes(index);
		os.write(bs);
		value.toBytes(os);
	}
	@Override
	public String parseName(InputStream in) throws IOException {
		index=ByteArrayUtil.getMultiByteInt31(in);
		name=Dictionary.getDictionary(index);
		return name;
	}
	@Override
	public String parsePrefix(InputStream in) throws IOException {return null;}
	
}
