package io.github.cisumer.wcfbin4j.records.texts;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import io.github.cisumer.wcfbin4j.Dictionary;
import io.github.cisumer.wcfbin4j.records.Text;
import io.github.cisumer.wcfbin4j.util.ByteArrayUtil;

public class DictionaryText extends Text<String>{
	private int index;
	public void setIndex(int index){
		this.index=index;
	}
	@Override
	public int getType() {
		return 0xAA;
	}

	@Override
	public void parse(InputStream is) throws IOException {
	    index=ByteArrayUtil.getMultiByteInt31(is);
	    value=Dictionary.getDictionary(index);
	}

	@Override
	public void renderContent(OutputStream os) throws Exception {
		byte[] bs=ByteArrayUtil.MultiByteInt31ToBytes(index);
	    os.write(bs);
	}	
}
