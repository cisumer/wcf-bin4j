package io.github.cisumer.wcfbin4j.records.texts;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;

import io.github.cisumer.wcfbin4j.records.Text;
import io.github.cisumer.wcfbin4j.util.ByteArrayUtil;

/**
 * 无符号long类型
 * 
 * @author github.com/cisumer
 *
 */
public class UInt64Text extends Text<BigInteger> {

	@Override
	public int getType() {
		return 0x8e;
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
