
import java.io.ByteArrayOutputStream;
import java.io.File;

import org.apache.commons.io.FileUtils;

import io.github.cisumer.wcfbin4j.Node;
import io.github.cisumer.wcfbin4j.NodeFactory;
import io.github.cisumer.wcfbin4j.util.ByteArrayUtil;
/**
 * 该示例仅用于演示解析application/msbin1数据，请勿用于非法用途。
 * @author github.com/cisumer
 *
 */
public class Example {
	
	public static void main(String[] args) throws Exception {
		File file=new File("test.bin");
		System.out.println(file.getName());
		Node root=NodeFactory.parse(FileUtils.openInputStream(file));
		ByteArrayOutputStream os=new ByteArrayOutputStream();
		root.toBytes(os);
		byte[] bs=os.toByteArray();
		int len=bs.length>16?16:bs.length,poi=0;
		while(poi<bs.length){
			System.out.printf("%04x\t",poi/16);
			System.out.println(ByteArrayUtil.byteArrayToHexString(
					ByteArrayUtil.getByteArrayData(bs, poi, len), " "));
			poi+=16;
			len=bs.length-poi>16?16:bs.length-poi;
		}
		System.out.println(root.toXML());
	}
}
