package io.github.cisumer.wcfbin4j.records.attributes;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 使用Text作为值的有前缀属性<br/>
 * 0x050x01x0x04test0x86 >> x:test="true"
 * @author github.com/cisumer
 *
 */
public class PrefixNamedTextValueAttribute extends TextValueAttribute {
		
	@Override
	public int getType() {
		return 0x05;
	}
    
	@Override
	public void renderContent(OutputStream os) throws Exception {
		lenStringBytes(prefix, os);
		lenStringBytes(name, os);
		value.toBytes(os);
	}
	
	@Override
	public String parseName(InputStream in) throws IOException {
		return parseLenString(in);
	}
	@Override
	public String parsePrefix(InputStream in) throws IOException {
		return parseLenString(in);
	}
}
