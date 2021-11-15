package io.github.cisumer.wcfbin4j.records.texts;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.text.StringEscapeUtils;

import io.github.cisumer.wcfbin4j.records.Text;

/**
 * 长度为1字节的utf-8编码字符串
 * 
 * @author github.com/cisumer
 *
 */
public class Chars8Text extends Text<String> {

	@Override
	public int getType() {
		return 0x98;
	}

	@Override
	public void parse(InputStream is) throws IOException {
		value = (parseLenString(is));
	}

	@Override
	public void renderContent(OutputStream os) throws Exception {
		lenStringBytes(value, os);
	}
	/**
	 * 此处需要对xml元素进行转义
	 */
	public String toXML(){
		return StringEscapeUtils.escapeXml10(value);
	}
}
