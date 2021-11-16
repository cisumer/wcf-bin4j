package io.github.cisumer.wcfbin4j.nodes;

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
	
	public Text<T> setValue(T value){
		this.value=value;
		return this;
	}
	
	public String toXML(){
	    return value.toString();
	}
	
}
