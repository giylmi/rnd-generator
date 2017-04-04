package ru.usifow.source;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import ru.usifow.model.BitsSequence;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by adel on 28.03.17.
 */
public class HotBitsSource implements Source {

    private HttpClient client;

    public HotBitsSource() {
        this.client = HttpClientBuilder.create().build();
    }

    @Override
    public BitsSequence getRandomBitsSequence(int length) {
        try {
            HttpResponse response = client.execute(
                    new HttpGet(
                            "http://www.fourmilab.ch/cgi-bin/Hotbits?nbytes=" + (length / 8 + 1) + "&fmt=bin"));
            if (response.getStatusLine().getStatusCode() == 200) {
                BitsSequence sequence = new BitsSequence(length / 8 + 1);
                InputStream content = response.getEntity().getContent();
                int b;
                List<Integer> bytes = new ArrayList<>();
                while ((b = content.read()) != -1 && length != 0) {
                    bytes.add(b);
                }
                Collections.reverse(bytes);
                for (int i = 0; i < bytes.size(); ++i) {
                    int c = Math.min(8, length);
                    sequence.addByte(bytes.get(i), c);
                    length -= c;
                }
                return sequence;
            }
            else {
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
