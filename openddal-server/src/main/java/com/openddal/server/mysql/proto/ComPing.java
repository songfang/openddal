package com.openddal.server.mysql.proto;

import java.util.ArrayList;

public class ComPing extends Packet {
    
    public ArrayList<byte[]> getPayload() {
        ArrayList<byte[]> payload = new ArrayList<byte[]>();
        
        payload.add(Proto.build_byte(Flags.COM_PING));
        
        return payload;
    }
    
    public static ComPing loadFromPacket(byte[] packet) {
        ComPing obj = new ComPing();
        Proto proto = new Proto(packet, 3);
        
        obj.sequenceId = proto.get_fixed_int(1);
        
        return obj;
    }

    @Override
    public String toString() {
        return "COM_PING";
    }
    
}
