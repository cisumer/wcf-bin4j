

import java.io.File;

import org.apache.commons.io.FileUtils;

import io.github.cisumer.wcfbin4j.Node;
import io.github.cisumer.wcfbin4j.NodeFactory;
/**
 * 该示例仅用于演示解析application/msbin1数据，请勿用于非法用途。
 * @author github.com/cisumer
 *
 */
public class Example {
	
	public static void main(String[] args) throws Exception {
		File file=new File("test.bin");
		System.out.println(file.getPath());
		Node root=NodeFactory.parse(FileUtils.openInputStream(file));
		System.out.println(root.toXML());
	}
}
