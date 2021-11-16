package io.github.cisumer.wcfbin4j.nodes.texts;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;

import io.github.cisumer.wcfbin4j.nodes.Text;
import io.github.cisumer.wcfbin4j.util.ByteArrayUtil;

/**
 * 无符号long类型
 * 
 * @author github.com/cisumer
 *
 */
public class BigIntegerText extends Text<BigInteger> {

	@Override
	public int getType() {
		return 0xB2;
	}

	@Override
	public void parse(InputStream is) throws IOException {
		byte[] bs = new byte[8];
		is.read(bs);
		value = ByteArrayUtil.getBigIntegerByBytes(bs);
	}

	@Override
	public void renderContent(OutputStream os) throws Exception {
		os.write(ByteArrayUtil.getBytesByBigInteger(value));
	}

}
