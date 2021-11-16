package io.github.cisumer.wcfbin4j.nodes.texts;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import io.github.cisumer.wcfbin4j.util.ByteArrayUtil;

/**
 * 长度为4字节的utf-8编码字符串
 * 
 * @author github.com/cisumer
 *
 */
public class Chars32Text extends Chars8Text {

	@Override
	public int getType() {
		return 0x9c;
	}

	@Override
	public void parse(InputStream is) throws IOException {
		byte[] bs = new byte[4];
		is.read(bs);
		int len = ByteArrayUtil.getIntByBytes(bs);
		byte[] name = new byte[len];
		is.read(name);
		value = new String(name, "UTF-8");
	}

	@Override
	public void renderContent(OutputStream os) throws Exception {
		byte[] bs = value.getBytes("UTF-8");
		byte[] len = ByteArrayUtil.getBytesByInt(bs.length);
		os.write(len);
		os.write(bs);
	}

}
