package ru.usifow.model;

import java.util.Objects;

/**
 * Created by a.gilmullin on 21.03.2017.
 */
public class BitsSequence {
    private short[] buffer;
    private short bitsLength;

    public BitsSequence(String bits) {
        buffer = new short[(bits.length() % 8 == 0) ? bits.length() / 8 : (bits.length() / 8 + 1)];
        for (int i = bits.length() - 1; i >= 0; --i) {
            if (bits.charAt(i) != '0' && bits.charAt(i) != '1')
                throw new IllegalArgumentException();
            addBit((byte) (bits.charAt(i) - '0'));
        }
    }

    public BitsSequence(int max_bytes) {
        buffer = new short[max_bytes];
    }

    public short getBitsLength() {
        return bitsLength;
    }

    public BitsSequence xor(BitsSequence another) {
        if (bitsLength != another.bitsLength) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < bitsLength; ++i) {
            setBit(i, (byte) (getBit(i) ^ another.getBit(i)));
        }
        return this;
    }

    public BitsSequence consumeLast(short bitsLength) {
        if (bitsLength > this.bitsLength)
            throw new ArrayIndexOutOfBoundsException();
        BitsSequence sequence = new BitsSequence(
                (bitsLength % 8 == 0) ? bitsLength / 8 : (bitsLength / 8 + 1));
        for (int i = this.bitsLength - bitsLength; i < this.bitsLength; ++i) {
            sequence.addBit(this.getBit(i));
        }
        this.bitsLength -= bitsLength;
        return sequence;
    }

    public void addBit(byte bit) {
        short bytesNum = (short) (bitsLength / 8);
        byte bitsNum = (byte) (bitsLength % 8);
        buffer[bytesNum] += (1 << bitsNum) * (bit % 2);
        bitsLength++;
    }

    public byte getBit(int pos) {
        if (pos > bitsLength) {
            throw new ArrayIndexOutOfBoundsException();
        }
        short bytesNum = (short) (pos / 8);
        byte bitsNum = (byte) (pos % 8);
        return (byte) ((buffer[bytesNum] >> bitsNum) % 2);
    }

    public void setBit(int pos, byte bit) {
        if (pos > bitsLength) {
            throw new ArrayIndexOutOfBoundsException();
        }
        short bytesNum = (short) (pos / 8);
        byte bitsNum = (byte) (pos % 8);
        buffer[bytesNum] -= ((buffer[bytesNum] >> bitsNum) % 2) << bitsNum; // set bit to 0;
        buffer[bytesNum] += (1 << bitsNum) * (bit % 2); // set bit to 0;
    }

    public String print() {
        String res = "";
        for (int i = bitsLength - 1; i >= 0; --i) {
            res += getBit(i);
        }
        return res;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append('[');
        builder.append("bitsLength = ");
        builder.append(bitsLength);
        builder.append(", ");
        builder.append("buffer = ");
        builder.append("[");
        for (int i = 0; i < bitsLength; ++i) {
            builder.append(getBit(i));
            if (i != bitsLength - 1) {
                builder.append(", ");
            }
        }
        builder.append(']');
        builder.append("]");
        return builder.toString();
    }

    public void addByte(int b) {
        addByte(b, 8);
    }

    public void addByte(int b, int bits) {
        for (int i = bits - 1; i >= 0; --i) {
            addBit((byte) ((b >> i) % 2));
        }
    }
}
