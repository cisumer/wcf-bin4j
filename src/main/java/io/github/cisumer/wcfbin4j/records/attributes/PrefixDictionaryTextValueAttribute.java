package io.github.cisumer.wcfbin4j.records.attributes;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import io.github.cisumer.wcfbin4j.util.ByteArrayUtil;

/**
 * 使用Text作为值的有前缀并使用字典作为属性名的属性<br/>
 * 0x070x01x0x0C0x86 >> x:To="true"
 * @author github.com/cisumer
 *
 */
public class PrefixDictionaryTextValueAttribute extends DictionaryTextValueAttribute{

	@Override
	public int getType() {
		return 0x07;
	}

	@Override
	public String parsePrefix(InputStream is) throws IOException {
		return parseLenString(is);
	}

	@Override
	public void renderContent(OutputStream os) throws Exception {
		lenStringBytes(prefix, os);
		byte[] bs=ByteArrayUtil.MultiByteInt31ToBytes(index);
		os.write(bs);
		value.toBytes(os);
	}
}
