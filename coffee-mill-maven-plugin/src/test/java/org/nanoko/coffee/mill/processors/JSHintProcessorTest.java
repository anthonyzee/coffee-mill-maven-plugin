/*
 * Copyright 2013 OW2 Nanoko Project
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.nanoko.coffee.mill.processors;

import org.junit.Test;
import org.nanoko.coffee.mill.mojos.compile.JavaScriptCompilerMojo;

import java.io.File;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Tests the behavior of the JSHintProcessor
 */
public class JSHintProcessorTest {

    @Test
    public void testJSHint() throws Processor.ProcessorException {
        JavaScriptCompilerMojo mojo = new JavaScriptCompilerMojo();
        mojo.javaScriptDir = new File("src/test/resources/js");
        mojo.workDir = mojo.javaScriptDir;

        JSHintProcessor processor = new JSHintProcessor();
        processor.configure(mojo, null);

        processor.processAll();

        assertThat(processor.validate(new File(mojo.javaScriptDir, "sample/test.js")).size()).isEqualTo(1);
    }
}