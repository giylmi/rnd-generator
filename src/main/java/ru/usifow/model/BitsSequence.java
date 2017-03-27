package ru.usifow.model;

/**
 * Created by a.gilmullin on 21.03.2017.
 */
public class BitsSequence {
    private short[] buffer;
    private short bitsLength;

    public BitsSequence(String bits) {
        buffer = new short[(bits.length() % 8 == 0) ? bits.length() / 8 : (bits.length() / 8 + 1)];
        for (int i = 0; i < bits.length(); ++i) {
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

    private byte getBit(int pos) {
        if (pos > bitsLength) {
            throw new ArrayIndexOutOfBoundsException();
        }
        short bytesNum = (short) (pos / 8);
        byte bitsNum = (byte) (pos % 8);
        return (byte) ((buffer[bytesNum] >> bitsNum) % 2);
    }

    public String print() {
        String res = "";
        for (int i = 0; i < bitsLength; ++i) {
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
}
