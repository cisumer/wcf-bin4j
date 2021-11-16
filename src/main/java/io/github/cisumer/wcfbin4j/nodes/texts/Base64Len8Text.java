package io.github.cisumer.wcfbin4j.nodes.texts;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Base64;

import io.github.cisumer.wcfbin4j.nodes.Text;

public class Base64Len8Text extends Text<String> {

	@Override
	public int getType() {
		return 0xA0;
	}

	@Override
	public void parse(InputStream is) throws IOException {
		int len = is.read();
		byte[] bs = new byte[len];
		is.read(bs);
		this.value = Base64.getEncoder().encodeToString(bs);
	}

	@Override
	public void renderContent(OutputStream os) throws Exception {
		byte[] bs = Base64.getDecoder().decode(value);
		os.write((byte) bs.length);
		os.write(bs);
	}
}
