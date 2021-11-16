package io.github.cisumer.wcfbin4j.nodes.attributes;

import java.io.IOException;
import java.io.InputStream;

import io.github.cisumer.wcfbin4j.NodeFactory;
import io.github.cisumer.wcfbin4j.nodes.Attribute;
import io.github.cisumer.wcfbin4j.nodes.Text;

/**
 * 使用Text类型作为value的Attribute
 * @author github.com/cisumer
 *
 */
public abstract class TextValueAttribute extends Attribute<Text<?>>{

	public Text<?> parseValue(InputStream in)throws IOException {
		Text<?> text= (Text<?>) NodeFactory.createNode(in.read());
		text.parse(in);
		return text;
	}
	
	public String toValueXML(){
		return value.toXML();
	}
}
