package io.github.cisumer.wcfbin4j.records.attributes;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 使用Text作为值的无前缀属性节点<br/>
 * 0x040x04test0x86 >> test="true"
 * @author github.com/cisumer
 *
 */
public class NamedTextValueAttribute extends TextValueAttribute{

    @Override
    public int getType() {
    	return 0x04;
    }
    
    @Override
    public void renderContent(OutputStream os) throws Exception {
		lenStringBytes(name, os);
		value.toBytes(os);
    }

	@Override
	public String parseName(InputStream in) throws IOException {
		return parseLenString(in);
	}

	@Override
	public String parsePrefix(InputStream in) throws IOException {return null;}
}
