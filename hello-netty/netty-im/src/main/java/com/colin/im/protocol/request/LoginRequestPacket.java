package com.colin.im.protocol.request;

import com.colin.im.protocol.Packet;
import com.colin.im.protocol.command.Command;
import lombok.Data;


@Data
public class LoginRequestPacket extends Packet {
    private String userName;

    private String password;

    @Override
    public Byte getCommand() {

        return Command.LOGIN_REQUEST;
    }
}
