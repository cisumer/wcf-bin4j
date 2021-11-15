package io.github.cisumer.wcfbin4j.records;

import java.io.OutputStream;

import io.github.cisumer.wcfbin4j.Node;
/**
 * 文本节点
 * @author github.com/cisumer
 * @param <T> 内容的类型
 */
public abstract class Text<T> implements Node {
	protected T value;

	public T getValue() {
		return value;
	}
	
	public void setValue(T value){
		this.value=value;
	}
	
	public String toXML(){
	    return value.toString();
	}
	
	public void toBytes(OutputStream os)throws Exception{
	    os.write(getType()-1);
	    renderContent(os);
	}
}
