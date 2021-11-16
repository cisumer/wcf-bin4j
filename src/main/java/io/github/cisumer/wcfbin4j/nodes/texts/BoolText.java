package io.github.cisumer.wcfbin4j.nodes.texts;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import io.github.cisumer.wcfbin4j.nodes.Text;

/**
 * 布尔类型内容,1为true 否则为false
 * @author github.com/cisumer
 *
 */
public class BoolText extends Text<Boolean> {

	@Override
	public int getType() {
		return 0xB4;
	}

	@Override
	public void parse(InputStream is) throws IOException {
		int i = is.read();
		value = (i == 1);
	}

	@Override
	public void renderContent(OutputStream os)throws Exception{
		os.write(value ? 1 : 0);
	}
}
