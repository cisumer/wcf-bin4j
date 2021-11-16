package io.github.cisumer.wcfbin4j.nodes.elements;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import io.github.cisumer.wcfbin4j.nodes.Element;
/**
 * 注释元素
 * @author github.com/cisumer
 *
 */
public class CommentElement extends Element{
	@Override
	public int getType() {
		return 0x02;
	}

	@Override
	public String toXML() {
		return "<!-- "+name+" -->\r\n";
	}

	@Override
	protected String parsePrefix(InputStream is) throws IOException {return null;}

	@Override
	protected String parseName(InputStream is) throws IOException {
		return parseLenString(is);
	}

	@Override
	protected void nameBytes(OutputStream os) throws Exception {
		lenStringBytes(name, os);
	}

	@Override
	protected void prefixBytes(OutputStream os) throws Exception {}

}
