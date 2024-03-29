package io.github.cisumer.wcfbin4j.nodes.texts;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import io.github.cisumer.wcfbin4j.nodes.Text;
import io.github.cisumer.wcfbin4j.util.ByteArrayUtil;

public class LongText extends Text<Long> {

	@Override
	public int getType() {
		return 0x8e;
	}

	@Override
	public void parse(InputStream is) throws IOException {
		byte[] bs = new byte[8];
		is.read(bs);
		value = ByteArrayUtil.getLongByBytes(bs);
	}

	@Override
	public void renderContent(OutputStream os) throws Exception {
		os.write(ByteArrayUtil.getBytesByLong(value));
	}
}
