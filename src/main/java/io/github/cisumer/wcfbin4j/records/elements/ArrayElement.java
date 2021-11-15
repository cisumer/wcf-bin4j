package io.github.cisumer.wcfbin4j.records.elements;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import io.github.cisumer.wcfbin4j.Node;
import io.github.cisumer.wcfbin4j.NodeFactory;
import io.github.cisumer.wcfbin4j.records.Element;
import io.github.cisumer.wcfbin4j.util.ByteArrayUtil;
/**
 * 数组元素<br/>
 * 0x030x400x04item >> 
 * @author github.com/cisumer
 *
 */
public class ArrayElement implements Node{
	protected List<Node> contents; 
	protected Element element;
	@Override
	public int getType() {
		return 0x03;
	}

	@Override
	public void parse(InputStream is) throws IOException {
		element=(Element) NodeFactory.getNode(is.read());
		element.parse(is);
		int type=is.read();
		int len=ByteArrayUtil.getMultiByteInt31(is);
		contents=new ArrayList<Node>();
		IntStream.range(0, len)
			.mapToObj(i->NodeFactory.getNode(type))
			.peek(node->{
				try {
					node.parse(is);
				} catch (IOException e) {
					throw new RuntimeException("读取："+Integer.toHexString(node.getType())+"错误");
				}
			}).forEach(contents::add);
	}

	@Override
	public void renderContent(OutputStream os) throws Exception {
		element.toBytes(os);
		os.write(new EndElement().getType());
		if(contents!=null && contents.size()>0){
			os.write(contents.get(0).getType());
			os.write(ByteArrayUtil.MultiByteInt31ToBytes(contents.size()));
			contents.forEach(text->{
				try {
					text.renderContent(os);
				} catch (Exception e) {
					throw new RuntimeException("写入："+Integer.toHexString(text.getType())+"错误");
				}
			});			
		}
	}

	@Override
	public String toXML() {
		StringBuffer sb=new StringBuffer();
		if(contents!=null && contents.size()>0){
			contents.stream().map(t->{
				Element child=((Element) NodeFactory.getNode(element.getType()))
					 .setPrefix(element.getPrefix())
					 .setName(element.getName())
					 .copyAttributes(element)
					 .addChild(t);
				return child;
			}).map(Element::toXML).forEach(sb::append);
		}
		return sb.toString();
	}
	
	public List<Node> getContents() {
		return contents;
	}
	public ArrayElement addContents(Node content) {
		if(this.contents==null)this.contents=new ArrayList<Node>();
		this.contents.add(content);
		return this;
	}
	public void setContents(List<Node> contents) {
		this.contents = contents;
	}

	public Element getElement() {
		return element;
	}

	public void setElement(Element element) {
		this.element = element;
	}

}
