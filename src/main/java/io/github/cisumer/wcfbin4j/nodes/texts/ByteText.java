package io.github.cisumer.wcfbin4j.nodes.texts;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import io.github.cisumer.wcfbin4j.nodes.Text;

/**
 * byte
 * 
 * @author github.com/cisumer
 *
 */
public class ByteText extends Text<Byte> {

	@Override
	public int getType() {
		return 0x88;
	}

	@Override
	public void parse(InputStream is) throws IOException {
		value = ((byte) is.read());
	}

	@Override
	public void renderContent(OutputStream os) throws Exception {
		os.write(value);
	}

}
