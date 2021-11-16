package io.github.cisumer.wcfbin4j.nodes.attributes;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import io.github.cisumer.wcfbin4j.nodes.PrefixCodeNode;

/**
 * 根据type计算ascii码固定前缀的属性<br/>
 * 0x260x04name0x86 >> a:name="true"
 * @author github.com/cisumer
 *
 */
public class PrefixCodeNamedTextValueAttribute extends PrefixNamedTextValueAttribute implements PrefixCodeNode{
	private int type;
	public void setType(char type){this.type=type-'a'+0x26;}
	public void setType(int type){this.type=type;}
	public int getType(){return type;}
	
	@Override
	public void renderContent(OutputStream os) throws Exception {
		lenStringBytes(name, os);
		value.toBytes(os);
	}
	@Override
	public String parsePrefix(InputStream in) throws IOException {
		return Character.toString((char)(type - 0x26 + 'a'));
	}
}
