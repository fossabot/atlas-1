/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.atlas.repository.graphdb.titan1.serializer;

import java.math.BigInteger;

import com.thinkaurelius.titan.core.attribute.AttributeSerializer;
import com.thinkaurelius.titan.diskstorage.ScanBuffer;
import com.thinkaurelius.titan.diskstorage.WriteBuffer;
import com.thinkaurelius.titan.graphdb.database.serialize.attribute.ByteArraySerializer;

/**
 * Serializer for BigInteger values.
 */
public class BigIntegerSerializer implements AttributeSerializer<BigInteger> {

    private final ByteArraySerializer delegate = new ByteArraySerializer();

    @Override
    public BigInteger read(ScanBuffer buffer) {
        byte[] value = delegate.read(buffer);
        return new BigInteger(value);
    }

    @Override
    public void write(WriteBuffer buffer, BigInteger attribute) {
        byte[] value = attribute.toByteArray();
        delegate.write(buffer, value);
    }

}
