package io.github.cisumer.wcfbin4j.nodes.elements;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 字典前缀元素
 * @author github.com/cisumer
 *
 */
public class PrefixDictionaryElement extends NamedDictionaryElement {

	@Override
	public int getType() {
		return 0x43;
	}
	
	protected String parsePrefix(InputStream is)throws IOException{
		return parseLenString(is);
	}

	protected void prefixBytes(OutputStream os)throws IOException{
		lenStringBytes(prefix, os);
	}

}
