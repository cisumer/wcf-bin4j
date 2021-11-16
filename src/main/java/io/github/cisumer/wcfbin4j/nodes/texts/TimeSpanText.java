package io.github.cisumer.wcfbin4j.nodes.texts;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.TimeZone;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import io.github.cisumer.wcfbin4j.nodes.Text;
import io.github.cisumer.wcfbin4j.util.ByteArrayUtil;

public class TimeSpanText extends Text<Long>{

	@Override
	public int getType() {
		return 0xAE;
	}

	@Override
	public void parse(InputStream is) throws IOException {
		byte[] bs = new byte[8];
		is.read(bs);
		ByteArrayUtil.reverse(bs);
		ByteBuffer bb = ByteBuffer.wrap(bs);
		value = bb.getLong();		
	}

	@Override
	public void renderContent(OutputStream os) throws Exception {
		ByteBuffer bb = ByteBuffer.allocate(8);
		bb.putLong(value);
		byte[] bs = bb.array();
		ArrayUtils.reverse(bs);
		os.write(bs);
	}
	public String toXML() {
		return DateFormatUtils.format(value, "HH:mm:ss", TimeZone.getTimeZone("GMT"));
	}
}
