package io.github.cisumer.wcfbin4j.nodes;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import io.github.cisumer.wcfbin4j.Node;
import io.github.cisumer.wcfbin4j.NodeFactory;
import io.github.cisumer.wcfbin4j.exception.NodeParseException;
import io.github.cisumer.wcfbin4j.nodes.elements.EndElement;
/**
 * 元素基类，提供子节点和属性的基本实现
 * @author github.com/cisumer
 *
 */
public abstract class Element implements Node{
	protected String prefix;
	protected String name;
	protected List<Node> childs=new ArrayList<Node>();
	protected List<Node> attributes=new ArrayList<Node>();
	
	@Override
	public void parse(InputStream is) throws IOException{
		prefix=parsePrefix(is);
		name=parseName(is);
		int type=-1;
		while((type=is.read())>-1){//直到流读取完
			Node child=NodeFactory.createNode(type);
		    try{
				if(Attribute.class.isAssignableFrom(child.getClass())){//attribute
					attributes.add(child);
				}else{//ELEMENT or TEXT
					childs.add(child);
				}
				//解析子节点
				child.parse(is);
				//结束的节点，退出循环到前一个节点解析
				if(EndElement.isEnd(child.getClass()))
					break;
		    }catch(Exception e){
				throw new NodeParseException(type);
		    }
		}
	}
	/**
	 * 解析前缀
	 * @param is
	 * @return
	 * @throws IOException
	 */
	protected abstract String parsePrefix(InputStream is) throws IOException;
	/**
	 * 解析元素名称
	 * @param is
	 * @return
	 * @throws IOException
	 */
	protected abstract String parseName(InputStream is) throws IOException;
	/**
	 * 写入元素名称
	 * @param os 
	 * @return
	 * @throws IOException
	 */
	protected abstract void nameBytes(OutputStream os) throws Exception;
	/**
	 * 写入元素前缀
	 * @param is
	 * @return
	 * @throws IOException
	 */
	protected abstract void prefixBytes(OutputStream os) throws Exception;
	
	@Override
	public void renderContent(OutputStream os) throws Exception {
	    prefixBytes(os);
	    nameBytes(os);
	    attrsBytes(os);
	    childsBytes(os);
	}
	private void attrsBytes(OutputStream os) throws Exception{
	    for(Node attr :attributes){
	    	attr.toBytes(os);
	    }
	}
	private void childsBytes(OutputStream os) throws Exception{
	    for(Node c :childs){
	    	c.toBytes(os);
	    }
	}
	
	protected String prefixXML() {
		return StringUtils.isEmpty(prefix)?"":(prefix+":");
	}
	@Override
	public String toXML() {
		return "<"+prefixXML()+name+getAttributeXml()+">"+getChildXml()+"</"+prefixXML()+name+">\r\n";
	}
	protected String getAttributeXml(){
		StringBuffer attrs=new StringBuffer();
	    for(Node attr :attributes){
	    	attrs.append(" ").append(attr.toXML());
	    }
	    return attrs.toString();
	}
	protected String getChildXml(){
	    if(childs.size()==0)return"";
	    StringBuffer c=new StringBuffer();
    	if(!EndElement.class.isAssignableFrom(childs.get(0).getClass()))
    		c.append("\r\n");
	    for(Node n :childs){
	    	c.append(n.toXML());
	    }
	    return c.toString();
	}
	
	public void setText(Text<?> text){
		childs.clear();
		childs.add(text);
	}
	public Element addChild(Node node){
		childs.add(node);
		return this;
	}
	/**
	 * 复制元素的子节点
	 * @param node
	 * @return
	 */
	public Element copyChilds(Element node){
		childs.addAll(node.childs);
		return this;
	}
	public Element addAttribute(Attribute<?> attr){
		attributes.add(attr);
		return this;
	}
	/**
	 * 复制元素的属性
	 * @param node
	 * @return
	 */
	public Element copyAttributes(Element node){
		attributes.addAll(node.attributes);
		return this;
	}
	public List<Node> getChilds() {
		return childs;
	}
	public List<Node> getAttribute() {
		return attributes;
	}
	public String getName(){
		return name;
	}
	public Element setName(String name){
	    this.name=name;
	    return this;
	}
	public String getPrefix() {
		return prefix;
	}
	public Element setPrefix(String prefix) {
		this.prefix = prefix;
		return this;
	}
	
}
