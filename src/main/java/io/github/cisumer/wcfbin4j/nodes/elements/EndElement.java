package io.github.cisumer.wcfbin4j.nodes.elements;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import io.github.cisumer.wcfbin4j.Node;

/**
 * 结束节点
 * @author github.com/cisumer
 *
 */
public class EndElement implements Node{
	public static final String END_FLAG="END:0x01";
	@Override
	public int getType() {return 0x01;}

	@Override
	public String toXML() {return "";}

	public void parse(InputStream is) throws IOException {}

	@Override
	public void renderContent(OutputStream os) throws Exception {}
	
	public static boolean isEnd(Class<? extends Node> clazz){
		return EndElement.class.isAssignableFrom(clazz);
	}
	public static boolean isEnd(int type){
		return 0x01==type;
	}
}
