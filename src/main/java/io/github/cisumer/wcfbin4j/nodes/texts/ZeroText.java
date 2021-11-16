package io.github.cisumer.wcfbin4j.nodes.texts;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import io.github.cisumer.wcfbin4j.nodes.Text;

/**
 * 长度为1字节的utf-8编码字符串
 * 
 * @author github.com/cisumer
 *
 */
public class ZeroText extends Text<Integer> {
	public ZeroText(){
		value = 0;
	}
	
	@Override
	public int getType() {
		return 0x80;
	}

	@Override
	public void parse(InputStream is) throws IOException {}

	@Override
	public void renderContent(OutputStream os) throws Exception {}
}
