package io.github.cisumer.wcfbin4j.nodes.texts;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import io.github.cisumer.wcfbin4j.nodes.Text;
import io.github.cisumer.wcfbin4j.util.ByteArrayUtil;

/**
 * short类型
 * 
 * @author github.com/cisumer
 *
 */
public class ShortText extends Text<Short> {

	@Override
	public int getType() {
		return 0x88;
	}

	@Override
	public void parse(InputStream is) throws IOException {
		byte[] bs = new byte[2];
		is.read(bs);
		value = (short) ByteArrayUtil.getShortByBytes(bs);
	}

	@Override
	public void renderContent(OutputStream os) throws Exception {
		os.write(ByteArrayUtil.getBytesByShort(value));
	}

}
