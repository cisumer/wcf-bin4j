# wcf-bin4j
参考[ernw/python-wcfbin](https://github.com/ernw/python-wcfbin)的python实现方式，使用Java实现了wcf-binary(application/msbin1)协议的解析。
1. Example为示例程序
2. 引入依赖
```
	<dependency>
		<groupId>io.github.cisumer</groupId>
		<artifactId>wcf-bin4j</artifactId>
		<version>1.1</version>
	</dependency>
```
3. 使用NodeFactory解析节点
```
 Node root=NodeFactory.parse(InputStream in);
 String xml=root.toXML();
```
4. 本项目仅用于解析application/msbin1，请勿用于非法用途。