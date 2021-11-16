package io.github.cisumer.wcfbin4j.nodes.texts;

import java.util.UUID;

/**
 * UUID [4bit](LE)[2bit](LE)[2bit](LE)[2bit](BE)[6bit](BE)<BR/>
 * HEX BYTES b'00112233445566778899aabbccddeeff' ->
 * 33221100-5544-7766-8899-aabbccddeeff
 * 
 * @author github.com/cisumer
 *
 */
public class UUIDText extends UniqueIdText {

	@Override
	public int getType() {
		return 0xB0;
	}

	public static UUIDText getUUIDText(String uuid) {
		UUIDText ut = new UUIDText();
		ut.value = UUID.fromString(uuid);
		return ut;
	}

	@Override
	public String toXML() {
		return this.value.toString();
	}
}
