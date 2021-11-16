package io.github.cisumer.wcfbin4j.nodes.texts;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import io.github.cisumer.wcfbin4j.nodes.Text;

public class TrueText extends Text<Boolean> {
	
	public TrueText(){
		value = true;
	}
	@Override
	public int getType() {
		return 0x86;
	}

	@Override
	public void parse(InputStream is) throws IOException {}

	@Override
	public void renderContent(OutputStream os) throws Exception {}
}
