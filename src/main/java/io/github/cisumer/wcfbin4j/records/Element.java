package io.github.cisumer.wcfbin4j.records;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import io.github.cisumer.wcfbin4j.Node;
import io.github.cisumer.wcfbin4j.NodeFactory;
/**
 * 元素基类，提供子节点和属性的基本实现
 * @author github.com/cisumer
 *
 */
public abstract class Element implements Node{
	protected int type;
	protected String prefix;
	protected String name;
	protected List<Node> childs=new ArrayList<Node>();
	protected List<Node> attributes=new ArrayList<Node>();
	
	@Override
	public void parse(InputStream is) throws IOException{
		prefix=parsePrefix(is);
		name=parseName(is);
		type=is.read();
		while(type!=0x01){
		    try{
				if(type>=0x03&&type<0x40){//attribute
					Node attr=NodeFactory.getNode(type);
					attr.parse(is);
					attributes.add(attr);
				}else{//ELEMENT or TEXT
					Node child=null;
					if(NodeFactory.hasType(type)){
						child=NodeFactory.getNode(type);
						childs.add(child);
						child.parse(is);
					}else{
						child=NodeFactory.getNode(type-1);
						childs.add(child);
						child.parse(is);
						break;
					}
				}
		    }catch(NullPointerException e){
				System.err.println(type);
				throw new RuntimeException(type+"没有找到");
		    }
			type=is.read();
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
		return "\r\n<"+prefixXML()+name+getAttributeXml()+">"+getChildXml()+"</"+name+">";
	}
	private String getAttributeXml(){
	    String attrs="";
	    for(Node attr :attributes){
		attrs+=" "+attr.toXML();
	    }
	    return attrs;
	}
	private String getChildXml(){
	    String c="";
	    for(Node n :childs){
	    	c+=n.toXML();
	    }
	    if(childs.get(childs.size()-1) instanceof Element)
		    c+="\r\n";
	    return c;
	}
	
	public void setText(Text<?> text){
		childs.clear();
		childs.add(text);
	}	
	public void addChild(Node node){
		childs.add(node);
	}
	public void addAttribute(Attribute<?> attr){
		attributes.add(attr);
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
	public void setName(String name){
	    this.name=name;
	}
}
