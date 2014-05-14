/*
 * Copyright 2014 Real Logic Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package uk.co.real_logic.aeron.util;

import java.io.File;
import java.nio.ByteBuffer;

/**
 * Interface for encapsulating the strategy of allocating ByteBuffers conductor ring buffers.
 *
 * Assumes one media driver per API instance.
 */
public abstract class ConductorBufferManagement implements AutoCloseable
{
    protected static final String MEDIA_DRIVER_FILE = "media-driver";
    protected static final String CLIENT_FILE = "client";

    protected final File toMediaDriver;
    protected final File toClient;

    public ConductorBufferManagement(final String adminDir)
    {
        toMediaDriver = new File(adminDir, MEDIA_DRIVER_FILE);
        toClient = new File(adminDir, CLIENT_FILE);
    }

    public abstract ByteBuffer toMediaDriver() throws Exception;

    public abstract ByteBuffer toClient() throws Exception;

    public abstract void close();
}