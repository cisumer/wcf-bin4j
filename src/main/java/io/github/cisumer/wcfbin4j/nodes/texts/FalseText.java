package io.github.cisumer.wcfbin4j.nodes.texts;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import io.github.cisumer.wcfbin4j.nodes.Text;

public class FalseText extends Text<Boolean> {
	public FalseText(){value = false;}
	@Override
	public int getType() {
		return 0x84;
	}

	@Override
	public void parse(InputStream is) throws IOException {}

	@Override
	public void renderContent(OutputStream os) throws Exception {
	}

}
