package com.tokens;

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;
import org.hashids.Hashids;
import java.util.UUID;


public class Token {
    public static UUID uuid = UUID.randomUUID();

    public static String getToken() { return uuid.toString(); }
}
