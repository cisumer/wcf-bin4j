package io.github.cisumer.wcfbin4j;

import java.util.HashMap;
import java.util.Map;
/**
* 加载字典json
*/
public class Dictionary {
	private static Map<Integer,String> DICT=new HashMap<Integer,String>();
	
	static{
		DICT.put(0x00,"mustUnderstand");
		DICT.put(0x02,"Envelope");
		DICT.put(0x04,"http://www.w3.org/2003/05/soap-envelope");
		DICT.put(0x06,"http://www.w3.org/2005/08/addressing");
		DICT.put(0x08,"Header");
		DICT.put(0x0A,"Action");
		DICT.put(0x0C,"To");
		DICT.put(0x0E,"Body");
		DICT.put(0x10,"Algorithm");
		DICT.put(0x12,"RelatesTo");
		DICT.put(0x14,"http://www.w3.org/2005/08/addressing/anonymous");
		DICT.put(0x16,"URI");
		DICT.put(0x18,"Reference");
		DICT.put(0x1A,"MessageID");
		DICT.put(0x1C,"Id");
		DICT.put(0x1E,"Identifier");
		DICT.put(0x20,"http://schemas.xmlsoap.org/ws/2005/02/rm");
		DICT.put(0x22,"Transforms");
		DICT.put(0x24,"Transform");
		DICT.put(0x26,"DigestMethod");
		DICT.put(0x28,"DigestValue");
		DICT.put(0x2A,"Address");
		DICT.put(0x2C,"ReplyTo");
		DICT.put(0x2E,"SequenceAcknowledgement");
		DICT.put(0x30,"AcknowledgementRange");
		DICT.put(0x32,"Upper");
		DICT.put(0x34,"Lower");
		DICT.put(0x36,"BufferRemaining");
		DICT.put(0x38,"http://schemas.microsoft.com/ws/2006/05/rm");
		DICT.put(0x3A,"http://schemas.xmlsoap.org/ws/2005/02/rm/SequenceAcknowledgement");
		DICT.put(0x3C,"SecurityTokenReference");
		DICT.put(0x3E,"Sequence");
		DICT.put(0x40,"MessageNumber");
		DICT.put(0x42,"http://www.w3.org/2000/09/xmldsig#");
		DICT.put(0x44,"http://www.w3.org/2000/09/xmldsig#enveloped-signature");
		DICT.put(0x46,"KeyInfo");
		DICT.put(0x48,"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");
		DICT.put(0x4A,"http://www.w3.org/2001/04/xmlenc#");
		DICT.put(0x4C,"http://schemas.xmlsoap.org/ws/2005/02/sc");
		DICT.put(0x4E,"DerivedKeyToken");
		DICT.put(0x50,"Nonce");
		DICT.put(0x52,"Signature");
		DICT.put(0x54,"SignedInfo");
		DICT.put(0x56,"CanonicalizationMethod");
		DICT.put(0x58,"SignatureMethod");
		DICT.put(0x5A,"SignatureValue");
		DICT.put(0x5C,"DataReference");
		DICT.put(0x5E,"EncryptedData");
		DICT.put(0x60,"EncryptionMethod");
		DICT.put(0x62,"CipherData");
		DICT.put(0x64,"CipherValue");
		DICT.put(0x66,"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd");
		DICT.put(0x68,"Security");
		DICT.put(0x6A,"Timestamp");
		DICT.put(0x6C,"Created");
		DICT.put(0x6E,"Expires");
		DICT.put(0x70,"Length");
		DICT.put(0x72,"ReferenceList");
		DICT.put(0x74,"ValueType");
		DICT.put(0x76,"Type");
		DICT.put(0x78,"EncryptedHeader");
		DICT.put(0x7A,"http://docs.oasis-open.org/wss/oasis-wss-wssecurity-secext-1.1.xsd");
		DICT.put(0x7C,"RequestSecurityTokenResponseCollection");
		DICT.put(0x7E,"http://schemas.xmlsoap.org/ws/2005/02/trust");
		DICT.put(0x80,"http://schemas.xmlsoap.org/ws/2005/02/trust#BinarySecret");
		DICT.put(0x82,"http://schemas.microsoft.com/ws/2006/02/transactions");
		DICT.put(0x84,"s");
		DICT.put(0x86,"Fault");
		DICT.put(0x88,"MustUnderstand");
		DICT.put(0x8A,"role");
		DICT.put(0x8C,"relay");
		DICT.put(0x8E,"Code");
		DICT.put(0x90,"Reason");
		DICT.put(0x92,"Text");
		DICT.put(0x94,"Node");
		DICT.put(0x96,"Role");
		DICT.put(0x98,"Detail");
		DICT.put(0x9A,"Value");
		DICT.put(0x9C,"Subcode");
		DICT.put(0x9E,"NotUnderstood");
		DICT.put(0xA0,"qname");
		DICT.put(0xA2,"");
		DICT.put(0xA4,"From");
		DICT.put(0xA6,"FaultTo");
		DICT.put(0xA8,"EndpointReference");
		DICT.put(0xAA,"PortType");
		DICT.put(0xAC,"ServiceName");
		DICT.put(0xAE,"PortName");
		DICT.put(0xB0,"ReferenceProperties");
		DICT.put(0xB2,"RelationshipType");
		DICT.put(0xB4,"Reply");
		DICT.put(0xB6,"a");
		DICT.put(0xB8,"http://schemas.xmlsoap.org/ws/2006/02/addressingidentity");
		DICT.put(0xBA,"Identity");
		DICT.put(0xBC,"Spn");
		DICT.put(0xBE,"Upn");
		DICT.put(0xC0,"Rsa");
		DICT.put(0xC2,"Dns");
		DICT.put(0xC4,"X509v3Certificate");
		DICT.put(0xC6,"http://www.w3.org/2005/08/addressing/fault");
		DICT.put(0xC8,"ReferenceParameters");
		DICT.put(0xCA,"IsReferenceParameter");
		DICT.put(0xCC,"http://www.w3.org/2005/08/addressing/reply");
		DICT.put(0xCE,"http://www.w3.org/2005/08/addressing/none");
		DICT.put(0xD0,"Metadata");
		DICT.put(0xD2,"http://schemas.xmlsoap.org/ws/2004/08/addressing");
		DICT.put(0xD4,"http://schemas.xmlsoap.org/ws/2004/08/addressing/role/anonymous");
		DICT.put(0xD6,"http://schemas.xmlsoap.org/ws/2004/08/addressing/fault");
		DICT.put(0xD8,"http://schemas.xmlsoap.org/ws/2004/06/addressingex");
		DICT.put(0xDA,"RedirectTo");
		DICT.put(0xDC,"Via");
		DICT.put(0xDE,"http://www.w3.org/2001/10/xml-exc-c14n#");
		DICT.put(0xE0,"PrefixList");
		DICT.put(0xE2,"InclusiveNamespaces");
		DICT.put(0xE4,"ec");
		DICT.put(0xE6,"SecurityContextToken");
		DICT.put(0xE8,"Generation");
		DICT.put(0xEA,"Label");
		DICT.put(0xEC,"Offset");
		DICT.put(0xEE,"Properties");
		DICT.put(0xF0,"Cookie");
		DICT.put(0xF2,"wsc");
		DICT.put(0xF4,"http://schemas.xmlsoap.org/ws/2004/04/sc");
		DICT.put(0xF6,"http://schemas.xmlsoap.org/ws/2004/04/security/sc/dk");
		DICT.put(0xF8,"http://schemas.xmlsoap.org/ws/2004/04/security/sc/sct");
		DICT.put(0xFA,"http://schemas.xmlsoap.org/ws/2004/04/security/trust/RST/SCT");
		DICT.put(0xFC,"http://schemas.xmlsoap.org/ws/2004/04/security/trust/RSTR/SCT");
		DICT.put(0xFE,"RenewNeeded");
		DICT.put(0x100,"BadContextToken");
		DICT.put(0x102,"c");
		DICT.put(0x104,"http://schemas.xmlsoap.org/ws/2005/02/sc/dk");
		DICT.put(0x106,"http://schemas.xmlsoap.org/ws/2005/02/sc/sct");
		DICT.put(0x108,"http://schemas.xmlsoap.org/ws/2005/02/trust/RST/SCT");
		DICT.put(0x10A,"http://schemas.xmlsoap.org/ws/2005/02/trust/RSTR/SCT");
		DICT.put(0x10C,"http://schemas.xmlsoap.org/ws/2005/02/trust/RST/SCT/Renew");
		DICT.put(0x10E,"http://schemas.xmlsoap.org/ws/2005/02/trust/RSTR/SCT/Renew");
		DICT.put(0x110,"http://schemas.xmlsoap.org/ws/2005/02/trust/RST/SCT/Cancel");
		DICT.put(0x112,"http://schemas.xmlsoap.org/ws/2005/02/trust/RSTR/SCT/Cancel");
		DICT.put(0x114,"http://www.w3.org/2001/04/xmlenc#aes128-cbc");
		DICT.put(0x116,"http://www.w3.org/2001/04/xmlenc#kw-aes128");
		DICT.put(0x118,"http://www.w3.org/2001/04/xmlenc#aes192-cbc");
		DICT.put(0x11A,"http://www.w3.org/2001/04/xmlenc#kw-aes192");
		DICT.put(0x11C,"http://www.w3.org/2001/04/xmlenc#aes256-cbc");
		DICT.put(0x11E,"http://www.w3.org/2001/04/xmlenc#kw-aes256");
		DICT.put(0x120,"http://www.w3.org/2001/04/xmlenc#des-cbc");
		DICT.put(0x122,"http://www.w3.org/2000/09/xmldsig#dsa-sha1");
		DICT.put(0x124,"http://www.w3.org/2001/10/xml-exc-c14n#WithComments");
		DICT.put(0x126,"http://www.w3.org/2000/09/xmldsig#hmac-sha1");
		DICT.put(0x128,"http://www.w3.org/2001/04/xmldsig-more#hmac-sha256");
		DICT.put(0x12A,"http://schemas.xmlsoap.org/ws/2005/02/sc/dk/p_sha1");
		DICT.put(0x12C,"http://www.w3.org/2001/04/xmlenc#ripemd160");
		DICT.put(0x12E,"http://www.w3.org/2001/04/xmlenc#rsa-oaep-mgf1p");
		DICT.put(0x130,"http://www.w3.org/2000/09/xmldsig#rsa-sha1");
		DICT.put(0x132,"http://www.w3.org/2001/04/xmldsig-more#rsa-sha256");
		DICT.put(0x134,"http://www.w3.org/2001/04/xmlenc#rsa-1_5");
		DICT.put(0x136,"http://www.w3.org/2000/09/xmldsig#sha1");
		DICT.put(0x138,"http://www.w3.org/2001/04/xmlenc#sha256");
		DICT.put(0x13A,"http://www.w3.org/2001/04/xmlenc#sha512");
		DICT.put(0x13C,"http://www.w3.org/2001/04/xmlenc#tripledes-cbc");
		DICT.put(0x13E,"http://www.w3.org/2001/04/xmlenc#kw-tripledes");
		DICT.put(0x140,"http://schemas.xmlsoap.org/2005/02/trust/tlsnego#TLS_Wrap");
		DICT.put(0x142,"http://schemas.xmlsoap.org/2005/02/trust/spnego#GSS_Wrap");
		DICT.put(0x144,"http://schemas.microsoft.com/ws/2006/05/security");
		DICT.put(0x146,"dnse");
		DICT.put(0x148,"o");
		DICT.put(0x14A,"Password");
		DICT.put(0x14C,"PasswordText");
		DICT.put(0x14E,"Username");
		DICT.put(0x150,"UsernameToken");
		DICT.put(0x152,"BinarySecurityToken");
		DICT.put(0x154,"EncodingType");
		DICT.put(0x156,"KeyIdentifier");
		DICT.put(0x158,"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary");
		DICT.put(0x15A,"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#HexBinary");
		DICT.put(0x15C,"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Text");
		DICT.put(0x15E,"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-x509-token-profile-1.0#X509SubjectKeyIdentifier");
		DICT.put(0x160,"http://docs.oasis-open.org/wss/oasis-wss-kerberos-token-profile-1.1#GSS_Kerberosv5_AP_REQ");
		DICT.put(0x162,"http://docs.oasis-open.org/wss/oasis-wss-kerberos-token-profile-1.1#GSS_Kerberosv5_AP_REQ1510");
		DICT.put(0x164,"http://docs.oasis-open.org/wss/oasis-wss-saml-token-profile-1.0#SAMLAssertionID");
		DICT.put(0x166,"Assertion");
		DICT.put(0x168,"urn:oasis:names:tc:SAML:1.0:assertion");
		DICT.put(0x16A,"http://docs.oasis-open.org/wss/oasis-wss-rel-token-profile-1.0.pdf#license");
		DICT.put(0x16C,"FailedAuthentication");
		DICT.put(0x16E,"InvalidSecurityToken");
		DICT.put(0x170,"InvalidSecurity");
		DICT.put(0x172,"k");
		DICT.put(0x174,"SignatureConfirmation");
		DICT.put(0x176,"TokenType");
		DICT.put(0x178,"http://docs.oasis-open.org/wss/oasis-wss-soap-message-security-1.1#ThumbprintSHA1");
		DICT.put(0x17A,"http://docs.oasis-open.org/wss/oasis-wss-soap-message-security-1.1#EncryptedKey");
		DICT.put(0x17C,"http://docs.oasis-open.org/wss/oasis-wss-soap-message-security-1.1#EncryptedKeySHA1");
		DICT.put(0x17E,"http://docs.oasis-open.org/wss/oasis-wss-saml-token-profile-1.1#SAMLV1.1");
		DICT.put(0x180,"http://docs.oasis-open.org/wss/oasis-wss-saml-token-profile-1.1#SAMLV2.0");
		DICT.put(0x182,"http://docs.oasis-open.org/wss/oasis-wss-saml-token-profile-1.1#SAMLID");
		DICT.put(0x184,"AUTH-HASH");
		DICT.put(0x186,"RequestSecurityTokenResponse");
		DICT.put(0x188,"KeySize");
		DICT.put(0x18A,"RequestedTokenReference");
		DICT.put(0x18C,"AppliesTo");
		DICT.put(0x18E,"Authenticator");
		DICT.put(0x190,"CombinedHash");
		DICT.put(0x192,"BinaryExchange");
		DICT.put(0x194,"Lifetime");
		DICT.put(0x196,"RequestedSecurityToken");
		DICT.put(0x198,"Entropy");
		DICT.put(0x19A,"RequestedProofToken");
		DICT.put(0x19C,"ComputedKey");
		DICT.put(0x19E,"RequestSecurityToken");
		DICT.put(0x1A0,"RequestType");
		DICT.put(0x1A2,"Context");
		DICT.put(0x1A4,"BinarySecret");
		DICT.put(0x1A6,"http://schemas.xmlsoap.org/ws/2005/02/trust/spnego");
		DICT.put(0x1A8,"http://schemas.xmlsoap.org/ws/2005/02/trust/tlsnego");
		DICT.put(0x1AA,"wst");
		DICT.put(0x1AC,"http://schemas.xmlsoap.org/ws/2004/04/trust");
		DICT.put(0x1AE,"http://schemas.xmlsoap.org/ws/2004/04/security/trust/RST/Issue");
		DICT.put(0x1B0,"http://schemas.xmlsoap.org/ws/2004/04/security/trust/RSTR/Issue");
		DICT.put(0x1B2,"http://schemas.xmlsoap.org/ws/2004/04/security/trust/Issue");
		DICT.put(0x1B4,"http://schemas.xmlsoap.org/ws/2004/04/security/trust/CK/PSHA1");
		DICT.put(0x1B6,"http://schemas.xmlsoap.org/ws/2004/04/security/trust/SymmetricKey");
		DICT.put(0x1B8,"http://schemas.xmlsoap.org/ws/2004/04/security/trust/Nonce");
		DICT.put(0x1BA,"KeyType");
		DICT.put(0x1BC,"http://schemas.xmlsoap.org/ws/2004/04/trust/SymmetricKey");
		DICT.put(0x1BE,"http://schemas.xmlsoap.org/ws/2004/04/trust/PublicKey");
		DICT.put(0x1C0,"Claims");
		DICT.put(0x1C2,"InvalidRequest");
		DICT.put(0x1C4,"RequestFailed");
		DICT.put(0x1C6,"SignWith");
		DICT.put(0x1C8,"EncryptWith");
		DICT.put(0x1CA,"EncryptionAlgorithm");
		DICT.put(0x1CC,"CanonicalizationAlgorithm");
		DICT.put(0x1CE,"ComputedKeyAlgorithm");
		DICT.put(0x1D0,"UseKey");
		DICT.put(0x1D2,"http://schemas.microsoft.com/net/2004/07/secext/WS-SPNego");
		DICT.put(0x1D4,"http://schemas.microsoft.com/net/2004/07/secext/TLSNego");
		DICT.put(0x1D6,"t");
		DICT.put(0x1D8,"http://schemas.xmlsoap.org/ws/2005/02/trust/RST/Issue");
		DICT.put(0x1DA,"http://schemas.xmlsoap.org/ws/2005/02/trust/RSTR/Issue");
		DICT.put(0x1DC,"http://schemas.xmlsoap.org/ws/2005/02/trust/Issue");
		DICT.put(0x1DE,"http://schemas.xmlsoap.org/ws/2005/02/trust/SymmetricKey");
		DICT.put(0x1E0,"http://schemas.xmlsoap.org/ws/2005/02/trust/CK/PSHA1");
		DICT.put(0x1E2,"http://schemas.xmlsoap.org/ws/2005/02/trust/Nonce");
		DICT.put(0x1E4,"RenewTarget");
		DICT.put(0x1E6,"CancelTarget");
		DICT.put(0x1E8,"RequestedTokenCancelled");
		DICT.put(0x1EA,"RequestedAttachedReference");
		DICT.put(0x1EC,"RequestedUnattachedReference");
		DICT.put(0x1EE,"IssuedTokens");
		DICT.put(0x1F0,"http://schemas.xmlsoap.org/ws/2005/02/trust/Renew");
		DICT.put(0x1F2,"http://schemas.xmlsoap.org/ws/2005/02/trust/Cancel");
		DICT.put(0x1F4,"http://schemas.xmlsoap.org/ws/2005/02/trust/PublicKey");
		DICT.put(0x1F6,"Access");
		DICT.put(0x1F8,"AccessDecision");
		DICT.put(0x1FA,"Advice");
		DICT.put(0x1FC,"AssertionID");
		DICT.put(0x1FE,"AssertionIDReference");
		DICT.put(0x200,"Attribute");
		DICT.put(0x202,"AttributeName");
		DICT.put(0x204,"AttributeNamespace");
		DICT.put(0x206,"AttributeStatement");
		DICT.put(0x208,"AttributeValue");
		DICT.put(0x20A,"Audience");
		DICT.put(0x20C,"AudienceRestrictionCondition");
		DICT.put(0x20E,"AuthenticationInstant");
		DICT.put(0x210,"AuthenticationMethod");
		DICT.put(0x212,"AuthenticationStatement");
		DICT.put(0x214,"AuthorityBinding");
		DICT.put(0x216,"AuthorityKind");
		DICT.put(0x218,"AuthorizationDecisionStatement");
		DICT.put(0x21A,"Binding");
		DICT.put(0x21C,"Condition");
		DICT.put(0x21E,"Conditions");
		DICT.put(0x220,"Decision");
		DICT.put(0x222,"DoNotCacheCondition");
		DICT.put(0x224,"Evidence");
		DICT.put(0x226,"IssueInstant");
		DICT.put(0x228,"Issuer");
		DICT.put(0x22A,"Location");
		DICT.put(0x22C,"MajorVersion");
		DICT.put(0x22E,"MinorVersion");
		DICT.put(0x230,"NameIdentifier");
		DICT.put(0x232,"Format");
		DICT.put(0x234,"NameQualifier");
		DICT.put(0x236,"Namespace");
		DICT.put(0x238,"NotBefore");
		DICT.put(0x23A,"NotOnOrAfter");
		DICT.put(0x23C,"saml");
		DICT.put(0x23E,"Statement");
		DICT.put(0x240,"Subject");
		DICT.put(0x242,"SubjectConfirmation");
		DICT.put(0x244,"SubjectConfirmationData");
		DICT.put(0x246,"ConfirmationMethod");
		DICT.put(0x248,"urn:oasis:names:tc:SAML:1.0:cm:holder-of-key");
		DICT.put(0x24A,"urn:oasis:names:tc:SAML:1.0:cm:sender-vouches");
		DICT.put(0x24C,"SubjectLocality");
		DICT.put(0x24E,"DNSAddress");
		DICT.put(0x250,"IPAddress");
		DICT.put(0x252,"SubjectStatement");
		DICT.put(0x254,"urn:oasis:names:tc:SAML:1.0:am:unspecified");
		DICT.put(0x256,"xmlns");
		DICT.put(0x258,"Resource");
		DICT.put(0x25A,"UserName");
		DICT.put(0x25C,"urn:oasis:names:tc:SAML:1.1:nameid-format:WindowsDomainQualifiedName");
		DICT.put(0x25E,"EmailName");
		DICT.put(0x260,"urn:oasis:names:tc:SAML:1.1:nameid-format:emailAddress");
		DICT.put(0x262,"u");
		DICT.put(0x264,"ChannelInstance");
		DICT.put(0x266,"http://schemas.microsoft.com/ws/2005/02/duplex");
		DICT.put(0x268,"Encoding");
		DICT.put(0x26A,"MimeType");
		DICT.put(0x26C,"CarriedKeyName");
		DICT.put(0x26E,"Recipient");
		DICT.put(0x270,"EncryptedKey");
		DICT.put(0x272,"KeyReference");
		DICT.put(0x274,"e");
		DICT.put(0x276,"http://www.w3.org/2001/04/xmlenc#Element");
		DICT.put(0x278,"http://www.w3.org/2001/04/xmlenc#Content");
		DICT.put(0x27A,"KeyName");
		DICT.put(0x27C,"MgmtData");
		DICT.put(0x27E,"KeyValue");
		DICT.put(0x280,"RSAKeyValue");
		DICT.put(0x282,"Modulus");
		DICT.put(0x284,"Exponent");
		DICT.put(0x286,"X509Data");
		DICT.put(0x288,"X509IssuerSerial");
		DICT.put(0x28A,"X509IssuerName");
		DICT.put(0x28C,"X509SerialNumber");
		DICT.put(0x28E,"X509Certificate");
		DICT.put(0x290,"AckRequested");
		DICT.put(0x292,"http://schemas.xmlsoap.org/ws/2005/02/rm/AckRequested");
		DICT.put(0x294,"AcksTo");
		DICT.put(0x296,"Accept");
		DICT.put(0x298,"CreateSequence");
		DICT.put(0x29A,"http://schemas.xmlsoap.org/ws/2005/02/rm/CreateSequence");
		DICT.put(0x29C,"CreateSequenceRefused");
		DICT.put(0x29E,"CreateSequenceResponse");
		DICT.put(0x2A0,"http://schemas.xmlsoap.org/ws/2005/02/rm/CreateSequenceResponse");
		DICT.put(0x2A2,"FaultCode");
		DICT.put(0x2A4,"InvalidAcknowledgement");
		DICT.put(0x2A6,"LastMessage");
		DICT.put(0x2A8,"http://schemas.xmlsoap.org/ws/2005/02/rm/LastMessage");
		DICT.put(0x2AA,"LastMessageNumberExceeded");
		DICT.put(0x2AC,"MessageNumberRollover");
		DICT.put(0x2AE,"Nack");
		DICT.put(0x2B0,"netrm");
		DICT.put(0x2B2,"Offer");
		DICT.put(0x2B4,"r");
		DICT.put(0x2B6,"SequenceFault");
		DICT.put(0x2B8,"SequenceTerminated");
		DICT.put(0x2BA,"TerminateSequence");
		DICT.put(0x2BC,"http://schemas.xmlsoap.org/ws/2005/02/rm/TerminateSequence");
		DICT.put(0x2BE,"UnknownSequence");
		DICT.put(0x2C0,"http://schemas.microsoft.com/ws/2006/02/tx/oletx");
		DICT.put(0x2C2,"oletx");
		DICT.put(0x2C4,"OleTxTransaction");
		DICT.put(0x2C6,"PropagationToken");
		DICT.put(0x2C8,"http://schemas.xmlsoap.org/ws/2004/10/wscoor");
		DICT.put(0x2CA,"wscoor");
		DICT.put(0x2CC,"CreateCoordinationContext");
		DICT.put(0x2CE,"CreateCoordinationContextResponse");
		DICT.put(0x2D0,"CoordinationContext");
		DICT.put(0x2D2,"CurrentContext");
		DICT.put(0x2D4,"CoordinationType");
		DICT.put(0x2D6,"RegistrationService");
		DICT.put(0x2D8,"Register");
		DICT.put(0x2DA,"RegisterResponse");
		DICT.put(0x2DC,"ProtocolIdentifier");
		DICT.put(0x2DE,"CoordinatorProtocolService");
		DICT.put(0x2E0,"ParticipantProtocolService");
		DICT.put(0x2E2,"http://schemas.xmlsoap.org/ws/2004/10/wscoor/CreateCoordinationContext");
		DICT.put(0x2E4,"http://schemas.xmlsoap.org/ws/2004/10/wscoor/CreateCoordinationContextResponse");
		DICT.put(0x2E6,"http://schemas.xmlsoap.org/ws/2004/10/wscoor/Register");
		DICT.put(0x2E8,"http://schemas.xmlsoap.org/ws/2004/10/wscoor/RegisterResponse");
		DICT.put(0x2EA,"http://schemas.xmlsoap.org/ws/2004/10/wscoor/fault");
		DICT.put(0x2EC,"ActivationCoordinatorPortType");
		DICT.put(0x2EE,"RegistrationCoordinatorPortType");
		DICT.put(0x2F0,"InvalidState");
		DICT.put(0x2F2,"InvalidProtocol");
		DICT.put(0x2F4,"InvalidParameters");
		DICT.put(0x2F6,"NoActivity");
		DICT.put(0x2F8,"ContextRefused");
		DICT.put(0x2FA,"AlreadyRegistered");
		DICT.put(0x2FC,"http://schemas.xmlsoap.org/ws/2004/10/wsat");
		DICT.put(0x2FE,"wsat");
		DICT.put(0x300,"http://schemas.xmlsoap.org/ws/2004/10/wsat/Completion");
		DICT.put(0x302,"http://schemas.xmlsoap.org/ws/2004/10/wsat/Durable2PC");
		DICT.put(0x304,"http://schemas.xmlsoap.org/ws/2004/10/wsat/Volatile2PC");
		DICT.put(0x306,"Prepare");
		DICT.put(0x308,"Prepared");
		DICT.put(0x30A,"ReadOnly");
		DICT.put(0x30C,"Commit");
		DICT.put(0x30E,"Rollback");
		DICT.put(0x310,"Committed");
		DICT.put(0x312,"Aborted");
		DICT.put(0x314,"Replay");
		DICT.put(0x316,"http://schemas.xmlsoap.org/ws/2004/10/wsat/Commit");
		DICT.put(0x318,"http://schemas.xmlsoap.org/ws/2004/10/wsat/Rollback");
		DICT.put(0x31A,"http://schemas.xmlsoap.org/ws/2004/10/wsat/Committed");
		DICT.put(0x31C,"http://schemas.xmlsoap.org/ws/2004/10/wsat/Aborted");
		DICT.put(0x31E,"http://schemas.xmlsoap.org/ws/2004/10/wsat/Prepare");
		DICT.put(0x320,"http://schemas.xmlsoap.org/ws/2004/10/wsat/Prepared");
		DICT.put(0x322,"http://schemas.xmlsoap.org/ws/2004/10/wsat/ReadOnly");
		DICT.put(0x324,"http://schemas.xmlsoap.org/ws/2004/10/wsat/Replay");
		DICT.put(0x326,"http://schemas.xmlsoap.org/ws/2004/10/wsat/fault");
		DICT.put(0x328,"CompletionCoordinatorPortType");
		DICT.put(0x32A,"CompletionParticipantPortType");
		DICT.put(0x32C,"CoordinatorPortType");
		DICT.put(0x32E,"ParticipantPortType");
		DICT.put(0x330,"InconsistentInternalState");
		DICT.put(0x332,"mstx");
		DICT.put(0x334,"Enlistment");
		DICT.put(0x336,"protocol");
		DICT.put(0x338,"LocalTransactionId");
		DICT.put(0x33A,"IsolationLevel");
		DICT.put(0x33C,"IsolationFlags");
		DICT.put(0x33E,"Description");
		DICT.put(0x340,"Loopback");
		DICT.put(0x342,"RegisterInfo");
		DICT.put(0x344,"ContextId");
		DICT.put(0x346,"TokenId");
		DICT.put(0x348,"AccessDenied");
		DICT.put(0x34A,"InvalidPolicy");
		DICT.put(0x34C,"CoordinatorRegistrationFailed");
		DICT.put(0x34E,"TooManyEnlistments");
		DICT.put(0x350,"Disabled");
		DICT.put(0x352,"ActivityId");
		DICT.put(0x354,"http://schemas.microsoft.com/2004/09/ServiceModel/Diagnostics");
		DICT.put(0x356,"http://docs.oasis-open.org/wss/oasis-wss-kerberos-token-profile-1.1#Kerberosv5APREQSHA1");
		DICT.put(0x358,"http://schemas.xmlsoap.org/ws/2002/12/policy");
		DICT.put(0x35A,"FloodMessage");
		DICT.put(0x35C,"LinkUtility");
		DICT.put(0x35E,"Hops");
		DICT.put(0x360,"http://schemas.microsoft.com/net/2006/05/peer/HopCount");
		DICT.put(0x362,"PeerVia");
		DICT.put(0x364,"http://schemas.microsoft.com/net/2006/05/peer");
		DICT.put(0x366,"PeerFlooder");
		DICT.put(0x368,"PeerTo");
		DICT.put(0x36A,"http://schemas.microsoft.com/ws/2005/05/routing");
		DICT.put(0x36C,"PacketRoutable");
		DICT.put(0x36E,"http://schemas.microsoft.com/ws/2005/05/addressing/none");
		DICT.put(0x370,"http://schemas.microsoft.com/ws/2005/05/envelope/none");
		DICT.put(0x372,"http://www.w3.org/2001/XMLSchema-instance");
		DICT.put(0x374,"http://www.w3.org/2001/XMLSchema");
		DICT.put(0x376,"nil");
		DICT.put(0x378,"type");
		DICT.put(0x37A,"char");
		DICT.put(0x37C,"boolean");
		DICT.put(0x37E,"byte");
		DICT.put(0x380,"unsignedByte");
		DICT.put(0x382,"short");
		DICT.put(0x384,"unsignedShort");
		DICT.put(0x386,"int");
		DICT.put(0x388,"unsignedInt");
		DICT.put(0x38A,"long");
		DICT.put(0x38C,"unsignedLong");
		DICT.put(0x38E,"float");
		DICT.put(0x390,"double");
		DICT.put(0x392,"decimal");
		DICT.put(0x394,"dateTime");
		DICT.put(0x396,"string");
		DICT.put(0x398,"base64Binary");
		DICT.put(0x39A,"anyType");
		DICT.put(0x39C,"duration");
		DICT.put(0x39E,"guid");
		DICT.put(0x3A0,"anyURI");
		DICT.put(0x3A2,"QName");
		DICT.put(0x3A4,"time");
		DICT.put(0x3A6,"date");
		DICT.put(0x3A8,"hexBinary");
		DICT.put(0x3AA,"gYearMonth");
		DICT.put(0x3AC,"gYear");
		DICT.put(0x3AE,"gMonthDay");
		DICT.put(0x3B0,"gDay");
		DICT.put(0x3B2,"gMonth");
		DICT.put(0x3B4,"integer");
		DICT.put(0x3B6,"positiveInteger");
		DICT.put(0x3B8,"negativeInteger");
		DICT.put(0x3BA,"nonPositiveInteger");
		DICT.put(0x3BC,"nonNegativeInteger");
		DICT.put(0x3BE,"normalizedString");
		DICT.put(0x3C0,"ConnectionLimitReached");
		DICT.put(0x3C2,"http://schemas.xmlsoap.org/soap/envelope/");
		DICT.put(0x3C4,"actor");
		DICT.put(0x3C6,"faultcode");
		DICT.put(0x3C8,"faultstring");
		DICT.put(0x3CA,"faultactor");
		DICT.put(0x3CC,"detail");
		System.out.println(DICT.size());
	}
	
	public static String getDictionary(Integer key){
	    return DICT.get(key);
	}
}
