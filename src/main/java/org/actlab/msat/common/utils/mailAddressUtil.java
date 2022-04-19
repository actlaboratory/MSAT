package org.actlab.msat.common.utils;

import java.util.Hashtable;
import java.util.Optional;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

import org.springframework.stereotype.Component;

@Component
public class mailAddressUtil {
    private static Pattern mxPattern = Pattern.compile("^(\\d+) ([0-9a-z\\.]+)\\.$");

    public static Optional<TreeMap<Integer, String>> mxLookup(String domain){
        Hashtable<String,String> env = new Hashtable<String,String>();
        env.put("java.naming.factory.initial", "com.sun.jndi.dns.DnsContextFactory");
        try{
            DirContext ictx = new InitialDirContext(env);
            Attributes attrs = ictx.getAttributes(domain, new String[] { "MX" });
            Attribute attr = attrs.get( "MX" );        
            if(attr == null){
                return Optional.empty();
            }
            if(attr.size() == 0){
                return Optional.empty();
            }
            TreeMap<Integer, String> records = new TreeMap<Integer, String>();
            for(int i=0; i<attr.size(); i++){
                Object record_obj = attr.get(i);
                if(record_obj == null){
                    continue;
                }
                String record = record_obj.toString();
                Matcher matcher = mxPattern.matcher(record);
                if(!matcher.matches()){
                    continue;
                }
                int priority = Integer.parseInt(matcher.group(1));
                String exchanger = matcher.group(2);
                records.put(priority, exchanger);
            }
            if(records.size() == 0){
                return Optional.empty();
            }
            return Optional.of(records);
        } catch(NamingException e){
            return Optional.empty();
        }
    }

    public static String getDomainFromAddress(String address){
        String[] splited_address = address.split("@");
        if(splited_address.length == 0){
            return "";
        }
        return splited_address[1];
    }

}