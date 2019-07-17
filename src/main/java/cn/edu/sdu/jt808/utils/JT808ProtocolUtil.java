package cn.edu.sdu.jt808.utils;

import cn.edu.sdu.jt808.protocol.Session;
import cn.edu.sdu.jt808.jtframework.server.manager.SessionManager;

public class JT808ProtocolUtil {
    public static void updateSession(Session session, String terminalPhone, String AuthCode) {
        SessionManager sessionManager = SessionManager.getInstance();
        Session phoneSession = sessionManager.findByTerminalPhone(terminalPhone);
        if (phoneSession != null) {
            phoneSession.getChannel().close();
            sessionManager.removeBySessionId(phoneSession.getChannel().id().asLongText());
        }
        Session authenticationSession = sessionManager.findByAuthenticationCode(AuthCode);
        if (authenticationSession != null) {
            authenticationSession.getChannel().close();
            sessionManager.removeBySessionId(authenticationSession.getChannel().id().asLongText());
        }

        session.setAuthenticationCode(AuthCode);
        session.setTerminalPhone(terminalPhone);
        sessionManager.put(session.getChannel().id().asLongText(), session);
    }
}
