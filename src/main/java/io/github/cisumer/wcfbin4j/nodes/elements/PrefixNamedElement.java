package io.github.cisumer.wcfbin4j.nodes.elements;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 
 * 前缀元素<br/>
 * [0x41][len(1)][prefix][len(1)][name]>> 0x410x01x0x04test >> &lt;x:test&gt;
 * 
 * @author github.com/cisumer
 *
 */
public class PrefixNamedElement extends NamedElement{
    public int getType() {
    	return 0x41;
    }
    protected void prefixBytes(OutputStream os)throws Exception{
        lenStringBytes(prefix, os);
    }
    public String parsePrefix(InputStream is) throws IOException {
    	return parseLenString(is);
    }
    
}
