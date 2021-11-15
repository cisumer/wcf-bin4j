package io.github.cisumer.wcfbin4j.records.texts;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import io.github.cisumer.wcfbin4j.records.Text;

/**
 * 长度为1字节的utf-8编码字符串
 * 
 * @author github.com/cisumer
 *
 */
public class OneText extends Text<Integer> {

	@Override
	public int getType() {
		return 0x82;
	}

	@Override
	public void parse(InputStream is) throws IOException {
		value = 1;
	}

	@Override
	public void renderContent(OutputStream os) throws Exception {}

}
