/*
 * Copyright 2015 the original author or authors.
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
 * limitations under the License
 */
package io.atomix.copycat.server.storage.snapshot;

import io.atomix.catalyst.buffer.Buffer;
import io.atomix.catalyst.buffer.BufferInput;
import io.atomix.catalyst.buffer.Bytes;
import io.atomix.catalyst.util.Assert;

/**
 * Server snapshot reader.
 *
 * @author <a href="http://github.com/kuujo>Jordan Halterman</a>
 */
public class SnapshotReader implements BufferInput<SnapshotReader> {
  private final Buffer buffer;
  private final Snapshot snapshot;

  SnapshotReader(Buffer buffer, Snapshot snapshot) {
    this.buffer = Assert.notNull(buffer, "buffer");
    this.snapshot = Assert.notNull(snapshot, "snapshot");
  }

  @Override
  public long remaining() {
    return buffer.remaining();
  }

  @Override
  public boolean hasRemaining() {
    return buffer.hasRemaining();
  }

  @Override
  public SnapshotReader skip(long bytes) {
    buffer.skip(bytes);
    return this;
  }

  @Override
  public SnapshotReader read(Bytes bytes) {
    buffer.read(bytes);
    return this;
  }

  @Override
  public SnapshotReader read(byte[] bytes) {
    buffer.read(bytes);
    return this;
  }

  @Override
  public SnapshotReader read(Bytes bytes, long offset, long length) {
    buffer.read(bytes, offset, length);
    return this;
  }

  @Override
  public SnapshotReader read(byte[] bytes, long offset, long length) {
    buffer.read(bytes, offset, length);
    return this;
  }

  @Override
  public SnapshotReader read(Buffer buffer) {
    this.buffer.read(buffer);
    return this;
  }

  @Override
  public int readByte() {
    return buffer.readByte();
  }

  @Override
  public int readUnsignedByte() {
    return buffer.readUnsignedByte();
  }

  @Override
  public char readChar() {
    return buffer.readChar();
  }

  @Override
  public short readShort() {
    return buffer.readShort();
  }

  @Override
  public int readUnsignedShort() {
    return buffer.readUnsignedShort();
  }

  @Override
  public int readMedium() {
    return buffer.readMedium();
  }

  @Override
  public int readUnsignedMedium() {
    return buffer.readUnsignedMedium();
  }

  @Override
  public int readInt() {
    return buffer.readInt();
  }

  @Override
  public long readUnsignedInt() {
    return buffer.readUnsignedInt();
  }

  @Override
  public long readLong() {
    return buffer.readLong();
  }

  @Override
  public float readFloat() {
    return buffer.readFloat();
  }

  @Override
  public double readDouble() {
    return buffer.readDouble();
  }

  @Override
  public boolean readBoolean() {
    return buffer.readBoolean();
  }

  @Override
  public String readString() {
    return buffer.readString();
  }

  @Override
  public String readUTF8() {
    return buffer.readUTF8();
  }

  @Override
  public void close() {
    buffer.close();
    snapshot.closeReader(this);
  }

}