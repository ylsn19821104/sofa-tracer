/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alipay.common.tracer.core.appender;

import com.alipay.common.tracer.core.utils.TracerUtils;
import org.junit.After;
import org.junit.Before;

import java.io.File;

import static junit.framework.TestCase.assertEquals;

/**
 * TracerLogRootDeamon Tester.
 *
 * @author <guanchao.ygc>
 * @version 1.0
 * @since <pre>七月 24, 2017</pre>
 */
public class TracerLogRootDeamonTest {

    @Before
    public void before() throws Exception {

        System.setProperty(TracerLogRootDeamon.TRACER_APPEND_PID_TO_LOG_PATH_KEY, "true");

    }

    @After
    public void after() throws Exception {
        System.clearProperty(TracerLogRootDeamon.TRACER_APPEND_PID_TO_LOG_PATH_KEY);
    }

    //@Test
    public void testLogRoot() {
        String traceLogRoot = System.getProperty("user.home") + File.separator + "logs";
        traceLogRoot += File.separator + "tracelog";
        traceLogRoot += File.separator + TracerUtils.getPID();
        assertEquals(TracerLogRootDeamon.LOG_FILE_DIR, traceLogRoot);
    }

}
