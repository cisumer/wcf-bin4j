package io.github.cisumer.wcfbin4j.records.texts;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import io.github.cisumer.wcfbin4j.records.Text;

public class TrueText extends Text<Boolean> {

	@Override
	public int getType() {
		return 0x86;
	}

	@Override
	public void parse(InputStream is) throws IOException {
		value = true;
	}

	@Override
	public void renderContent(OutputStream os) throws Exception {}
}
