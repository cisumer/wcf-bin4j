package io.github.cisumer.wcfbin4j.records.attributes;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import io.github.cisumer.wcfbin4j.records.Attribute;
/**
 * xmlns为前缀的属性
 * 0x04name0x05value >> xmlns:name="value"
 * @author github.com/cisumer
 *
 */
public class PrefixXmlnsNamedStringValueAttribute extends Attribute<String>{

    @Override
    public int getType() {
    	return 0x09;
    }

	@Override
	public void renderContent(OutputStream os) throws Exception {
		lenStringBytes(name, os);
		lenStringBytes(value, os);
	}

	@Override
	public String parseName(InputStream in) throws IOException {
		return parseLenString(in);
	}

	@Override
	public String parsePrefix(InputStream in) throws IOException {
		return "xmlns";
	}

	@Override
	public String parseValue(InputStream in) throws IOException {
		return parseLenString(in);
	}
}
