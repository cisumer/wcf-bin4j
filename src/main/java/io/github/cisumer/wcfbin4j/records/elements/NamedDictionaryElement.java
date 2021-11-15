package io.github.cisumer.wcfbin4j.records.elements;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import io.github.cisumer.wcfbin4j.Dictionary;
import io.github.cisumer.wcfbin4j.util.ByteArrayUtil;

/**
 * 简单字典元素<br/> 
 * [0x40][code] eg: 0x040x02 >> &lt;Envelope&gt;
 * @author github.com/cisumer
 */
public class NamedDictionaryElement extends NamedElement {
	protected int index;
	@Override
	public int getType() {
		return 0x42;
	}
	@Override
	protected void nameBytes(OutputStream os) throws Exception {
	    byte[] bs=ByteArrayUtil.MultiByteInt31ToBytes(index);
	    os.write(bs);
	}
	@Override
	protected String parseName(InputStream is) throws IOException {
	    index=ByteArrayUtil.getMultiByteInt31(is);
	    return Dictionary.getDictionary(index);
	}

}
