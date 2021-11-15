package io.github.cisumer.wcfbin4j.records.texts;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import io.github.cisumer.wcfbin4j.records.Text;
import io.github.cisumer.wcfbin4j.util.ByteArrayUtil;

public class Int32Text extends Text<Integer> {

	@Override
	public int getType() {
		return 0x8c;
	}

	@Override
	public void parse(InputStream is) throws IOException {
		byte[] bs = new byte[4];
		is.read(bs);
		value = ByteArrayUtil.getIntByBytes(bs);
	}

	@Override
	public void renderContent(OutputStream os) throws Exception {
		os.write(ByteArrayUtil.getBytesByInt(value));
	}
}
