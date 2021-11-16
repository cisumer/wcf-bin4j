package io.github.cisumer.wcfbin4j.nodes;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.lang3.StringUtils;

import io.github.cisumer.wcfbin4j.Node;

/**
 * 属性节点
 * @author github.com/cisumer
 *
 */
public abstract class Attribute<T> implements Node{
	protected String prefix;
	protected String name;
	protected T value;
	
	public void parse(InputStream in)throws IOException{
		prefix=parsePrefix(in);
		name=parseName(in);
		value=parseValue(in);
	}
	/**
	 * 解析属性名
	 * @param in
	 * @return
	 * @throws IOException
	 */
	public abstract String parseName(InputStream in)throws IOException;
	/**
	 * 解析属性前缀
	 * @param in
	 * @return
	 * @throws IOException
	 */
	public abstract String parsePrefix(InputStream in)throws IOException;
	/**
	 * 解析属性值
	 * @param in
	 * @return
	 * @throws IOException
	 */
	public abstract T parseValue(InputStream in)throws IOException;

	/**
	 * 获取属性值在XML中的展示的字符串
	 * @return 
	 */
	public String toValueXML(){
		return value.toString();
	}
	/**
	 * 获取前缀字符串，如果不为空则补全:
	 * @return 
	 */
	protected String getPrefixValue(){
		return StringUtils.isEmpty(this.prefix)?"":(this.prefix+":");
	}
	
	public String toXML(){
		return getPrefixValue()+name+"=\""+toValueXML()+"\"";
	}
	public String getPrefix() {
		return prefix;
	}
	public Attribute<T> setPrefix(String prefix) {
		this.prefix = prefix;
		return this;
	}
	public String getName() {
		return name;
	}
	public Attribute<T> setName(String name) {
		this.name = name;
		return this;
	}
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
}
