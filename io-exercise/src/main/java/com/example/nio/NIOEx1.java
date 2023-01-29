package com.example.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

import static com.example.Constants.TEST_DEST_FILE;
import static com.example.Constants.TEST_SOURCE_FILE;

public class NIOEx1 {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream
                = new FileInputStream(TEST_SOURCE_FILE);
        ReadableByteChannel source = fileInputStream.getChannel();

        FileOutputStream fileOutputStream
                = new FileOutputStream(TEST_DEST_FILE);
        WritableByteChannel destination = fileOutputStream.getChannel();

        copyData(source, destination);
        source.close();
        destination.close();

    }

    private static void copyData(ReadableByteChannel source,
                                 WritableByteChannel destination) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(20 * 1024);
        while (source.read(buffer) != -1) {
            buffer.flip();
            while (buffer.hasRemaining()) {
                destination.write(buffer);
            }
            buffer.clear();
        }
    }
}
