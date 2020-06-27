package com.gb.amazonlocker.model;

import lombok.Getter;
import lombok.Setter;

import java.nio.ByteBuffer;
import java.util.Base64;
import java.util.UUID;

@Getter
@Setter
public class Locker {
    private String id;
    private LockerSize lockerSize;
    private Location location;
    private LockerStatus lockerStatus;

    public Locker() {
        id = encodeUUIDBase64(UUID.randomUUID());
    }

    private static String encodeUUIDBase64(UUID uuid) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
        bb.putLong(uuid.getMostSignificantBits());
        bb.putLong(uuid.getLeastSignificantBits());
        return removeTrailingEqual(new String(Base64.getEncoder().encode(bb.array())));
    }

    private static String removeTrailingEqual(String s) {
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() > 0 && sb.charAt(sb.length() - 1) == '=') {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }
}
