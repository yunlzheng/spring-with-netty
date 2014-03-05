package com.moo.springnetty.server;

import com.moo.springnetty.cfg.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Ignore;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class TCPServerTest extends AbstractJUnit4SpringContextTests {

    @Test
    public void testStop() throws Exception {

    }
}
