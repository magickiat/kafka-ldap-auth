package cc.magickiat.kafka.auth.ldap;

import org.apache.kafka.common.security.plain.internals.PlainSaslServer;
import org.apache.kafka.common.security.plain.internals.PlainSaslServerProvider;

import java.security.Provider;
import java.security.Security;

public class LdapPlainSaslServerProvider extends Provider {
    public LdapPlainSaslServerProvider(){
        super("LDAP SASL/PLAIN Server Provider", 1.0, "LDAP SASL/PLAIN Server Provider for Kafka");
        put("SaslServerFactory." + LdapPlainSaslServer.PLAIN_MECHANISM, LdapPlainSaslServerFactory.class.getName());

    }
    public static void initialize() {
        Security.addProvider(new LdapPlainSaslServerProvider());
    }

}
