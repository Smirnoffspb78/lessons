package com.smirnov.project.lesson25.homework.task1;

public interface Encryption {
    static byte[] encryption(byte[] fileInByteArray) {
        final byte key = 23;
        byte[] codeFile = new byte[fileInByteArray.length];
        for (int i = 0; i < codeFile.length; i++) {
            codeFile[i] = (byte) (key ^ fileInByteArray[i]);
        }
        return codeFile;
    }
}
