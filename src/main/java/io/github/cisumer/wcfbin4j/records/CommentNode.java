package io.github.cisumer.wcfbin4j.records;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import io.github.cisumer.wcfbin4j.Node;

public class CommentNode implements Node{
	private String content;
	@Override
	public int getType() {
		return 0x02;
	}

	@Override
	public String toXML() {
		return "<!-- "+content+" -->";
	}

	@Override
	public void parse(InputStream is) throws IOException {
		content=parseLenString(is);
	}

	@Override
	public void renderContent(OutputStream os) throws Exception {
		lenStringBytes(content, os);
	}

}
