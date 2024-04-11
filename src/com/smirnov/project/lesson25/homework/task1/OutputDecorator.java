package com.smirnov.project.lesson25.homework.task1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

import static java.util.Arrays.copyOf;
import static java.util.Objects.requireNonNull;

/**
 * Декоратор расшифровывает данные и записывает в файл.
 */
public class OutputDecorator extends OutputStream implements Encryption {
    /**
     * Декорируемый объект.
     */
    OutputStream outputStream;

    /**
     * Конструктор создает декорируемый объект
     *
     * @param fileOutputStream
     */

    public OutputDecorator(FileOutputStream fileOutputStream) {
        this.outputStream = requireNonNull(fileOutputStream);
    }

    /**
     * Writes the specified byte to this output stream. The general
     * contract for {@code write} is that one byte is written
     * to the output stream. The byte to be written is the eight
     * low-order bits of the argument {@code b}. The 24
     * high-order bits of {@code b} are ignored.
     *
     * @param b the {@code byte}.
     * @throws IOException if an I/O error occurs. In particular,
     *                     an {@code IOException} may be thrown if the
     *                     output stream has been closed.
     */
    @Override
    public void write(int b) throws IOException {
    }

    /**
     * Writes {@code b.length} bytes from the specified byte array
     * to this output stream. The general contract for {@code write(b)}
     * is that it should have exactly the same effect as the call
     * {@code write(b, 0, b.length)}.
     *
     * @param b the data.
     * @throws IOException if an I/O error occurs.
     * @see OutputStream#write(byte[], int, int)
     */
    @Override
    public void write(byte[] b) throws IOException {
        byte[] outByte = copyOf(Encryption.encryption(b), b.length);
        System.out.println(Arrays.toString(outByte));
        outputStream.write(outByte);
    }
}
