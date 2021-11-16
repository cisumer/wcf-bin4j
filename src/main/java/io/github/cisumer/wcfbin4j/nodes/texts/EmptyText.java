package io.github.cisumer.wcfbin4j.nodes.texts;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import io.github.cisumer.wcfbin4j.nodes.Text;

public class EmptyText extends Text<String> {

	@Override
	public int getType() {
		return 0xA8;
	}

	@Override
	public void parse(InputStream is) throws IOException {
		value = "";
	}

	@Override
	public void renderContent(OutputStream os) throws Exception {
	}

}
