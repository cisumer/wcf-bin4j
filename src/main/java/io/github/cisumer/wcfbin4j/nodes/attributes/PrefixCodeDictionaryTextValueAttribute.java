package io.github.cisumer.wcfbin4j.nodes.attributes;

import java.io.IOException;
import java.io.InputStream;

import io.github.cisumer.wcfbin4j.nodes.PrefixCodeNode;
/**
 * Text作为值，并使用固定前缀和字典的属性
 * 0x0D0x020x86 >> b:Envelope="true"
 * @author github.com/cisumer
 *
 */
public class PrefixCodeDictionaryTextValueAttribute extends DictionaryTextValueAttribute implements PrefixCodeNode{
	int type;
	public void setType(char type){
		this.type=type-'a'+0x0C;
	}
	public void setType(int type){
		this.type=type;
	}
	public int getType(){return type;}

	@Override
	public String parsePrefix(InputStream in) throws IOException {
		return Character.toString((char)(type - 0x0C + 'a'));
	}
}
