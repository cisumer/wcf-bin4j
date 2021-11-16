package io.github.cisumer.wcfbin4j.nodes.texts;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import io.github.cisumer.wcfbin4j.nodes.Text;

public class FloatText extends Text<Float> {

	@Override
	public int getType() {
		return 0x90;
	}

	@Override
	public void parse(InputStream is) throws IOException {
		byte[] bs = new byte[4];
		is.read(bs);
		value = ByteBuffer.wrap(bs).order(ByteOrder.LITTLE_ENDIAN).getFloat();
	}

	@Override
	public void renderContent(OutputStream os) throws Exception {
		byte[] bs = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putFloat(value).array();
		os.write(bs);
	}
}
