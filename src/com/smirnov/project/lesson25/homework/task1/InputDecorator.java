package com.smirnov.project.lesson25.homework.task1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static java.util.Arrays.copyOf;
import static java.util.Objects.requireNonNull;

/**
 * Декоратор, реализующий шифрование информации из прочитанного файла.
 */
public class InputDecorator extends InputStream implements Encryption {

    /**
     * Декорируемый объект.
     */
    private final InputStream inputStream;

    /**
     * Информация из файла.
     */
    private byte[] fileInByteArray;

    /**
     * Конструктор создает декоратор для шифрования.
     *
     * @param inputStream Декорируемый объект
     */
    public InputDecorator(FileInputStream inputStream) {
        this.inputStream = requireNonNull(inputStream);
        try {
            fileInByteArray = new byte[inputStream.available()];
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Reads the next byte of data from the input stream. The value byte is
     * returned as an {@code int} in the range {@code 0} to
     * {@code 255}. If no byte is available because the end of the stream
     * has been reached, the value {@code -1} is returned. This method
     * blocks until input data is available, the end of the stream is detected,
     * or an exception is thrown.
     *
     * @return the next byte of data, or {@code -1} if the end of the
     * stream is reached.
     * @throws IOException if an I/O error occurs.
     */
    @Override
    public int read() throws IOException {
        inputStream.read(fileInByteArray);
        System.out.println(fileInByteArray);
        fileInByteArray = copyOf(Encryption.encryption(fileInByteArray), fileInByteArray.length);
        return fileInByteArray.length;
    }

    public byte[] getFileInByteArray() {
        return fileInByteArray.clone();
    }
}
