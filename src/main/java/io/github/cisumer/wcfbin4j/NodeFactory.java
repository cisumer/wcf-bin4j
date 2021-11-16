package io.github.cisumer.wcfbin4j;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import io.github.cisumer.wcfbin4j.exception.NodeNotFoundException;
import io.github.cisumer.wcfbin4j.nodes.PrefixCodeNode;
import io.github.cisumer.wcfbin4j.nodes.Text;
import io.github.cisumer.wcfbin4j.nodes.attributes.DictionaryTextValueAttribute;
import io.github.cisumer.wcfbin4j.nodes.attributes.NamedTextValueAttribute;
import io.github.cisumer.wcfbin4j.nodes.attributes.NamedXmlnsDictionaryValueAttribute;
import io.github.cisumer.wcfbin4j.nodes.attributes.PrefixCodeDictionaryTextValueAttribute;
import io.github.cisumer.wcfbin4j.nodes.attributes.PrefixCodeNamedTextValueAttribute;
import io.github.cisumer.wcfbin4j.nodes.attributes.PrefixDictionaryTextValueAttribute;
import io.github.cisumer.wcfbin4j.nodes.attributes.PrefixNamedTextValueAttribute;
import io.github.cisumer.wcfbin4j.nodes.attributes.PrefixXmlnsNamedDictionaryValueAttribute;
import io.github.cisumer.wcfbin4j.nodes.attributes.PrefixXmlnsNamedStringValueAttribute;
import io.github.cisumer.wcfbin4j.nodes.attributes.XmlnsStringValueAttribute;
import io.github.cisumer.wcfbin4j.nodes.elements.ArrayElement;
import io.github.cisumer.wcfbin4j.nodes.elements.CommentElement;
import io.github.cisumer.wcfbin4j.nodes.elements.EndElement;
import io.github.cisumer.wcfbin4j.nodes.elements.NamedDictionaryElement;
import io.github.cisumer.wcfbin4j.nodes.elements.NamedElement;
import io.github.cisumer.wcfbin4j.nodes.elements.PrefixCodeDictionaryElement;
import io.github.cisumer.wcfbin4j.nodes.elements.PrefixCodeNamedElement;
import io.github.cisumer.wcfbin4j.nodes.elements.PrefixDictionaryElement;
import io.github.cisumer.wcfbin4j.nodes.elements.PrefixNamedElement;
import io.github.cisumer.wcfbin4j.nodes.elements.TextWithEndElement;
import io.github.cisumer.wcfbin4j.nodes.texts.Base64Len16Text;
import io.github.cisumer.wcfbin4j.nodes.texts.Base64Len32Text;
import io.github.cisumer.wcfbin4j.nodes.texts.Base64Len8Text;
import io.github.cisumer.wcfbin4j.nodes.texts.BigIntegerText;
import io.github.cisumer.wcfbin4j.nodes.texts.BoolText;
import io.github.cisumer.wcfbin4j.nodes.texts.ByteText;
import io.github.cisumer.wcfbin4j.nodes.texts.Chars16Text;
import io.github.cisumer.wcfbin4j.nodes.texts.Chars32Text;
import io.github.cisumer.wcfbin4j.nodes.texts.Chars8Text;
import io.github.cisumer.wcfbin4j.nodes.texts.DateTimeText;
import io.github.cisumer.wcfbin4j.nodes.texts.DecimalText;
import io.github.cisumer.wcfbin4j.nodes.texts.DictionaryText;
import io.github.cisumer.wcfbin4j.nodes.texts.DoubleText;
import io.github.cisumer.wcfbin4j.nodes.texts.EmptyText;
import io.github.cisumer.wcfbin4j.nodes.texts.FalseText;
import io.github.cisumer.wcfbin4j.nodes.texts.FloatText;
import io.github.cisumer.wcfbin4j.nodes.texts.IntegerText;
import io.github.cisumer.wcfbin4j.nodes.texts.LongText;
import io.github.cisumer.wcfbin4j.nodes.texts.OneText;
import io.github.cisumer.wcfbin4j.nodes.texts.QNameDictionaryText;
import io.github.cisumer.wcfbin4j.nodes.texts.ShortText;
import io.github.cisumer.wcfbin4j.nodes.texts.TimeSpanText;
import io.github.cisumer.wcfbin4j.nodes.texts.TrueText;
import io.github.cisumer.wcfbin4j.nodes.texts.UUIDText;
import io.github.cisumer.wcfbin4j.nodes.texts.UnicodeChars16Text;
import io.github.cisumer.wcfbin4j.nodes.texts.UnicodeChars32Text;
import io.github.cisumer.wcfbin4j.nodes.texts.UnicodeChars8Text;
import io.github.cisumer.wcfbin4j.nodes.texts.UniqueIdText;
import io.github.cisumer.wcfbin4j.nodes.texts.ZeroText;
/**
 * 解析wcfbin工厂类，定义协议类型
 * @author github.com/cisumer
 *
 */
public class NodeFactory {
    @SuppressWarnings("unchecked")
    private final static Class<? extends Node>[] nodes = new Class[256];
    static {    	
    	nodes[0x01] = EndElement.class;//结束
    	nodes[0x02] = CommentElement.class;//注释    	
    	nodes[0x03] = ArrayElement.class;//数组元素
		// 属性
    	nodes[0x04] = NamedTextValueAttribute.class;
    	nodes[0x05] = PrefixNamedTextValueAttribute.class;
    	nodes[0x06] = DictionaryTextValueAttribute.class;
    	nodes[0x07] = PrefixDictionaryTextValueAttribute.class;
		nodes[0x08] = XmlnsStringValueAttribute.class;//
		nodes[0x09] = PrefixXmlnsNamedStringValueAttribute.class;//
		nodes[0x0A] = NamedXmlnsDictionaryValueAttribute.class;//
		nodes[0x0B] = PrefixXmlnsNamedDictionaryValueAttribute.class;
		// 固定前缀属性
		for (int x = 0x0C; x <= 0x25; x++) {
		    nodes[x] = PrefixCodeDictionaryTextValueAttribute.class;
		}
		for (int x = 0x26; x <= 0x3F; x++) {
		    nodes[x] = PrefixCodeNamedTextValueAttribute.class;
		}
		
		// 元素
		nodes[0x40] = NamedElement.class;//
		nodes[0x41] = PrefixNamedElement.class;//
		nodes[0x42] = NamedDictionaryElement.class;//
		nodes[0x43] = PrefixDictionaryElement.class;//
		// 固定前缀元素
		for (int x = 0x44; x <= 0x5D; x++) {
		    nodes[x] = PrefixCodeDictionaryElement.class;
		}
		for (int x = 0x5e; x <= 0x77; x++) {
		    nodes[x] = PrefixCodeNamedElement.class;
		}
	
		// 文本
		nodes[0x80] = ZeroText.class;//0
		nodes[0x82] = OneText.class;//1
		nodes[0x84] = FalseText.class;//false
		nodes[0x86] = TrueText.class;//true
		nodes[0x88] = ByteText.class;//byte
		nodes[0x8a] = ShortText.class;//short
		nodes[0x8c] = IntegerText.class;//int
		nodes[0x8e] = LongText.class;//long
		nodes[0x90] = FloatText.class;//float
		nodes[0x92] = DoubleText.class;//double
		nodes[0x94] = DecimalText.class;//BigDecimal
		nodes[0x96] = DateTimeText.class;//Date(long)
		nodes[0x98] = Chars8Text.class;//String
		nodes[0x9A] = Chars16Text.class;//String
		nodes[0x9C] = Chars32Text.class;//String
		nodes[0x9E] = Base64Len8Text.class;//base64 8bit len
		nodes[0xA0] = Base64Len16Text.class;//base64 16bit len
		nodes[0xA2] = Base64Len32Text.class;//base64 32bit len
		nodes[0xA4] = EmptyText.class;//StartList
		nodes[0xA6] = EmptyText.class;//EndList
		nodes[0xA8] = EmptyText.class;//Empty
		nodes[0xAA] = DictionaryText.class;//dictionary index
		nodes[0xAC] = UniqueIdText.class;//
		nodes[0xAE] = TimeSpanText.class;//
		nodes[0xB0] = UUIDText.class;//
		nodes[0xB2] = BigIntegerText.class;//
		nodes[0xB4] = BoolText.class;//
		nodes[0xB6] = UnicodeChars8Text.class;//
		nodes[0xB8] = UnicodeChars16Text.class;//
		nodes[0xBA] = UnicodeChars32Text.class;//
		nodes[0xBC] = QNameDictionaryText.class;//
    }

    /**
     * 根据类型获取节点
     * @param type
     * @return
     */
    public static Node createNode(int type) {
		try {
			if(hasType(type)){
			    Node node = nodes[type].newInstance();
			    if ((type >= 0x5e && type <= 0x77) ||
			    	(type >= 0x44 && type <= 0x5D) ||
			    	(type >= 0x0C && type <= 0x25) ||
			    	(type >= 0x26 && type <= 0x3F)) {
				 ((PrefixCodeNode)node).setType((char)type);
			    }
			    return node;
			}else{
				TextWithEndElement endText=new TextWithEndElement();
				endText.setType(type);
				return endText;
			}
		} catch (Exception e) {
		    throw new NodeNotFoundException(type);
		}
    }
	/**
	 * 如果没有的节点，则使用type-1获取,此时获取的节点必为Text类型
	 * @param type
	 * @return
	 */
	public static Text<?> getText(int type){
		if (type >= 0x80 && type%2==0){
			Text<?> text=(Text<?>) createNode(type);
			return text;
		}
		return null;
	}

    public static boolean hasType(int type) {
    	return nodes[type] != null;
    }

    /**
     * 解析根节点，从流中读取第一个字节，就是根节点类型
     * @param is
     * @return 根节点
     * @throws IOException
     */
    public static Node parse(final InputStream is) throws IOException{
		int type = is.read();
		Node record = createNode(type);
		record.parse(is);
		return record;
    }

    public static Node parse(byte[] bs) throws IOException {
    	return parse(new ByteArrayInputStream(bs));
    }
}
