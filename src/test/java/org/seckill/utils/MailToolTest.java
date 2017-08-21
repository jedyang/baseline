package org.seckill.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class MailToolTest {
    @Test
    public void sendMail() throws Exception {
        MailTool.sendMail("yangyunsheng1989@126.com","hello");
    }

}