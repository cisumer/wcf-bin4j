package io.github.cisumer.wcfbin4j.records.texts;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Base64;

import io.github.cisumer.wcfbin4j.records.Text;
import io.github.cisumer.wcfbin4j.util.ByteArrayUtil;

public class Base64Len32Text extends Text<String> {

	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return 0xA2;
	}

	@Override
	public void parse(InputStream is) throws IOException {
		byte[] lenb = new byte[4];
		is.read(lenb);
		byte[] bs = new byte[ByteArrayUtil.getIntByBytes(lenb)];
		is.read(bs);
		this.value = Base64.getEncoder().encodeToString(bs);
	}

	@Override
	public void renderContent(OutputStream os) throws IOException {
		byte[] bs = Base64.getDecoder().decode(value);
		os.write(ByteArrayUtil.getBytesByShort((short) bs.length));
		os.write(bs);
	}
}
