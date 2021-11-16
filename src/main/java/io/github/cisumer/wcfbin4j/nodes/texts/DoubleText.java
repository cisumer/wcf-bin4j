package io.github.cisumer.wcfbin4j.nodes.texts;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

import io.github.cisumer.wcfbin4j.nodes.Text;
import io.github.cisumer.wcfbin4j.util.ByteArrayUtil;

public class DoubleText extends Text<Double> {

	@Override
	public int getType() {
		return 0x92;
	}

	@Override
	public void parse(InputStream is) throws IOException {
		byte[] bs = new byte[8];
		is.read(bs);
		ByteArrayUtil.reverse(bs);
		ByteBuffer bb = ByteBuffer.wrap(bs);
		value = bb.getDouble();
	}

	@Override
	public void renderContent(OutputStream os) throws Exception {
		ByteBuffer bb = ByteBuffer.allocate(8);
		bb.putDouble(value);
		byte[] bs = bb.array();
		ByteArrayUtil.reverse(bs);
		os.write(bs);
	}
}
