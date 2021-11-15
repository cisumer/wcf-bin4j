package io.github.cisumer.wcfbin4j.records.elements;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import io.github.cisumer.wcfbin4j.records.Element;

/**
 * 结束节点
 * @author github.com/cisumer
 *
 */
public class EndElement extends Element{

	@Override
	public int getType() {return 0x01;}

	@Override
	public String toXML() {return "";}

	@Override
	protected String parsePrefix(InputStream is) throws IOException {return null;}

	@Override
	protected String parseName(InputStream is) throws IOException {return null;}

	@Override
	protected void nameBytes(OutputStream os) throws Exception {}

	@Override
	protected void prefixBytes(OutputStream os) throws Exception {}

}
