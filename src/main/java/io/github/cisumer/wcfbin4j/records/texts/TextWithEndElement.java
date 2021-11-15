package io.github.cisumer.wcfbin4j.records.texts;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import io.github.cisumer.wcfbin4j.NodeFactory;
import io.github.cisumer.wcfbin4j.records.Text;
import io.github.cisumer.wcfbin4j.records.elements.EndElement;
/**
 * 文本节点之后结束的，type为原文本节点类型+1
 * @author github.com/cisumer
 */
public class TextWithEndElement extends EndElement {
	private int type;
	private Text<?> text;
	public void setType(int type){this.type=type;}
	public void setText(Text<?> text){this.text=text;}
	@Override
	public int getType() {
		return type;
	}

	@Override
	public void parse(InputStream is) throws IOException {
		text=(Text<?>) NodeFactory.getText(type-1);
		text.parse(is);
	}

	public void renderContent(OutputStream os)throws Exception{
	    renderContent(os);
	}
		
	public String toXML(){
	    return text.toXML();
	}
}
