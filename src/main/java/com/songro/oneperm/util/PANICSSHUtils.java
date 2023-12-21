package com.songro.oneperm.util;

import com.jcraft.jsch.*;

public class PANICSSHUtils {
    private final String usrname = "paincapisv";
    private final String host = "";
    private final int port = 75;
    private final String password = "dpstudioapi";

    private Session session;
    private ChannelExec execu;

    /** Tries to connect SSH host server. */
    private void connectSSH() throws JSchException {
        session = new JSch().getSession(usrname, host, port);
        session.setPassword(password);
        session.setConfig("StrictHostKeyChecking", "no");
        session.connect();
    }

    /** Send command to SSH host server, command should be in String format and, linux type command.*/
    public void command(String command) {
        try {
            connectSSH();
            execu = (ChannelExec) session.openChannel("exec");	// 실행할 channel 생성
            execu.setCommand(command);
            execu.connect();
        } catch (JSchException e) {
            System.out.println("JSchExpection Occurred.\n" + e.getCause());
        } finally {
            this.disConnectSSH();
        }
    }

    /** Disconnects from SSH host server, mostly from plugin shutdown */
    public void disConnectSSH() {
        System.out.println("[ONEPERM] Disconnected.");
        if (session != null) session.disconnect();
        if (execu != null) execu.disconnect();
    }

}
