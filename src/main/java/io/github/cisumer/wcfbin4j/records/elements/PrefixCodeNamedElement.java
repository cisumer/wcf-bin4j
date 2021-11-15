package io.github.cisumer.wcfbin4j.records.elements;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import io.github.cisumer.wcfbin4j.records.PrefixCodeNode;
/**
 * 固定前缀元素<br/>
 * [0x5E-0x77][len(1)][name] >> 0x5E0x04test >> &lt;a:test&gt;<br/>
 * 前缀标识映射关系：<br/>
 * 0x5E : a <br/>
 * 0x5F : b <br/>
 * ...<br/>
 * 0x77 : z 
 * @author github.com/cisumer
 *
 */
public class PrefixCodeNamedElement extends NamedElement implements PrefixCodeNode{
	private int type;
	public int getType() {
		return type;
	}
	public void setType(int type){
		this.type=type;
	}
	public void setType(char type){
		this.type=type-3;
	}
    protected void prefixBytes(OutputStream os)throws Exception{}
	@Override
	public String parsePrefix(InputStream is) throws IOException{
		return Character.toString((char)(type+3));
	}
	
}
