package io.github.cisumer.wcfbin4j;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 节点接口，节点有三种类型：元素、属性、文本，对应xml中的element、attribute、text<br/>
 * wcfbin的基本解析规则为[节点标识][长度][节点名称/内容][子节点...][0x01] 0x01为结束标识，遇到结束标识返回上一级节点<br/>
 * 解析时根据InputStream按位取值，分别解析出对应节点，采用递归方式构建出节点树<br/>
 * 元素:0x40 - 0x77 <br/>
 * 属性:0x04 - 0x3f <br/>
 * 文本:0x80 - 0xbc 文本标识全为偶数，获取到的标识值-1为映射的节点类型，此时没有结束标识也返回上一级节点<br/>
 * @author github.com/cisumer
 *
 */
public interface Node {
	/**
	 * 获取节点的类型
	 * @return
	 */
	public int getType();
	
	/**
	 * 返回XML字符串
	 * @return
	 */
	public String toXML();
	/**
	 * 根据当前节点的规则解析输入流<br/>
	 * 
	 * @param is
	 * @throws IOException
	 */
	public void parse(InputStream is)throws IOException;
	/**
	 * 转为字节流，第一位输出类型，后续输出
	 * @param os
	 * @throws Exception
	 */
	default void toBytes(OutputStream os)throws Exception{
	    os.write(getType());
	    renderContent(os);
	}
	/**
	 * 将节点内容转为字节流输出
	 * @param os
	 * @throws IOException
	 */
	public void renderContent(OutputStream os)throws Exception;
	/**
	 * 解析带有长度的元素，第一个字节为长度，之后根据长度获取内容
	 * @param is 
	 * @return 元素内容
	 * @throws IOException
	 */
	default String parseLenString(InputStream is) throws IOException{
		int len=is.read();
		byte[] name=new byte[len];
		is.read(name);
		return new String(name,"UTF-8");
	}
	/**
	 * 输出带有长度的元素，同解析的规则
	 * @param name
	 * @param os
	 * @throws IOException
	 */
	default void lenStringBytes(String name,OutputStream os)throws IOException{
	    byte[] bs=name.getBytes("UTF-8");
	    os.write(bs.length);
	    os.write(bs);
	}
}
