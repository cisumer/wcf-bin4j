package io.github.cisumer.wcfbin4j.records;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import io.github.cisumer.wcfbin4j.Node;
import io.github.cisumer.wcfbin4j.NodeFactory;
import io.github.cisumer.wcfbin4j.records.elements.EndElement;
import io.github.cisumer.wcfbin4j.records.texts.TextWithEndElement;
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
		int type=is.read();
		Node child=NodeFactory.getNode(type);
		System.out.println(type+" : "+child);
		while(!EndElement.class.equals(child.getClass())){
		    try{
				child.parse(is);
				if(Attribute.class.isAssignableFrom(child.getClass())){//attribute
					attributes.add(child);
				}else{//ELEMENT or TEXT
					childs.add(child);
					//结束的文本节点
					if(TextWithEndElement.class.isAssignableFrom(child.getClass()))
						break;
				}
		    }catch(Exception e){
				throw new RuntimeException("类型："+Integer.toHexString(child.getType())+"没有找到！");
		    }
			child=NodeFactory.getNode(is.read());
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
	    if(childs.size()==0 || !(childs.get(childs.size()-1) instanceof Text)){
	    	os.write(0x01);
	    	return;
	    }
	    for(Node c :childs){
	    	c.toBytes(os);
	    }
	}
	
	protected String prefixXML() {
		return StringUtils.isEmpty(prefix)?"":(prefix+":");
	}
	@Override
	public String toXML() {
		return "\r\n<"+prefixXML()+name+getAttributeXml()+">"+getChildXml()+(childs!=null&&childs.size()>1?"\r\n":"")+"</"+name+">\r\n";
	}
	protected String getAttributeXml(){
	    String attrs="";
	    for(Node attr :attributes){
	    	attrs+=" "+attr.toXML();
	    }
	    return attrs;
	}
	protected String getChildXml(){
	    StringBuffer c=new StringBuffer();
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
