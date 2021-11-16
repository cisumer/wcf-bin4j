package io.github.cisumer.wcfbin4j.nodes.texts;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import io.github.cisumer.wcfbin4j.Dictionary;
import io.github.cisumer.wcfbin4j.nodes.Text;

/**
 * 
 * @author github.com/cisumer
 *
 */
public class QNameDictionaryText extends Text<String> {
	private int index;
	private String prefix;
	
	public void setIndex(int index){
		this.index=index;
	}
	public void setPrefix(String prefix){
		this.prefix=prefix;
	}
	@Override
	public int getType() {
		return 0xBC;
	}

	@Override
	public void parse(InputStream is) throws IOException {
		prefix=Character.toString((char)(is.read() + 'a'));
		byte[] bs=new byte[3];
		is.read(bs);
		index = bs[0] << 16 | bs[1] << 8 | bs[2];
		value=Dictionary.getDictionary(index);
	}
	@Override
	public void renderContent(OutputStream os) throws Exception {
		os.write(prefix.charAt(0)-'a');
		byte[] bs=new byte[3];
		bs[0] = (byte) ((index >> 16) & 0xFF);
		bs[1] = (byte) ((index >> 8) & 0xFF) ;
		bs[2] = (byte) (index & 0xFF);
		os.write(bs);
	}	
}
