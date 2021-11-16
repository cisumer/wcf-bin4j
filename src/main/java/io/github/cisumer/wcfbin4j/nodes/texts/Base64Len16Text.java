package io.github.cisumer.wcfbin4j.nodes.texts;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Base64;

import io.github.cisumer.wcfbin4j.nodes.Text;
import io.github.cisumer.wcfbin4j.util.ByteArrayUtil;

/**
 * 
 * @author github.com/cisumer
 *
 */
public class Base64Len16Text extends Text<String> {

	@Override
	public int getType() {
		return 0xA0;
	}

	@Override
	public void parse(InputStream is) throws IOException {
		byte[] lenb = new byte[2];
		is.read(lenb);
		byte[] bs = new byte[ByteArrayUtil.getIntByBytes(lenb)];
		is.read(bs);
		this.value = Base64.getEncoder().encodeToString(bs);
	}

	@Override
	public void renderContent(OutputStream os) throws Exception {
		byte[] bs = Base64.getDecoder().decode(value);
		os.write(ByteArrayUtil.getBytesByShort((short) bs.length));
		os.write(bs);
	}
}
