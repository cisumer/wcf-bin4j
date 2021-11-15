package io.github.cisumer.wcfbin4j.records.texts;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import io.github.cisumer.wcfbin4j.records.Text;
import io.github.cisumer.wcfbin4j.util.ByteArrayUtil;

public class UnicodeChars16Text extends Text<String> {

	@Override
	public int getType() {
		return 0xB8;
	}

	@Override
	public void parse(InputStream is) throws IOException {
		byte[] bs = new byte[2];
		is.read(bs);
		int len = ByteArrayUtil.getIntByBytes(bs);
		byte[] name = new byte[len];
		is.read(name);
		value = new String(name, "UTF-16LE");
	}

	@Override
	public void renderContent(OutputStream os) throws Exception {
		byte[] vs = value.getBytes("UTF-16LE");
		byte[] len = ByteArrayUtil.getBytesByShort((short) vs.length);
		os.write(len);
		// ByteArrayUtil.high2low(vs);
		os.write(vs);
	}

}
