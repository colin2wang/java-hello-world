package com.colin.im.protocol.response;


import com.colin.im.protocol.Packet;
import com.colin.im.protocol.command.Command;

public class HeartBeatResponsePacket extends Packet {
    @Override
    public Byte getCommand() {
        return Command.HEARTBEAT_RESPONSE;
    }
}
