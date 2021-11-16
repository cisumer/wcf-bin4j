package io.github.cisumer.wcfbin4j.nodes.attributes;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import io.github.cisumer.wcfbin4j.nodes.Attribute;

/**
 * xmlns属性
 * 0x080x04test >> xmlns="test"
 * @author github.com/cisumer
 *
 */
public class XmlnsStringValueAttribute extends Attribute<String> {
	
    @Override
    public int getType() {
    	return 0x08;
    }

    @Override
    public void renderContent(OutputStream os) throws Exception {
		lenStringBytes(value, os);
    }

	@Override
	public String parseName(InputStream in) throws IOException {
		return "xmlns";
	}

	@Override
	public String parsePrefix(InputStream in) throws IOException {return null;}

	@Override
	public String parseValue(InputStream in) throws IOException {
		return parseLenString(in);
	}

}
