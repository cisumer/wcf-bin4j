# wcf-bin4j
参考[ernw/python-wcfbin](https://github.com/ernw/python-wcfbin)的python实现方式，使用Java实现了wcf-binary(application/msbin1)协议的解析。
1. Example为示例程序，解析test.bin
2. 引入依赖
```
	<dependency>
		<groupId>io.github.cisumer</groupId>
		<artifactId>wcf-bin4j</artifactId>
		<version>1.3</version>
	</dependency>
```
3. 使用NodeFactory解析节点
```
 Node root=NodeFactory.parse(InputStream in);
 String xml=root.toXML();
```
4. 后续将增加简单的xml转换API
5. 本项目仅用于解析application/msbin1，请勿用于非法用途。
6. github不稳定，主要在gitee维护本项目
