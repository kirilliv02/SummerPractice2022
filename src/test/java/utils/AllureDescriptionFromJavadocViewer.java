package utils;

import io.qameta.allure.Allure;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.xml.bind.DatatypeConverter;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import static org.apache.commons.codec.digest.MessageDigestAlgorithms.MD5;

public class AllureDescriptionFromJavadocViewer {
    public static void updateFiles() throws NoSuchAlgorithmException, IOException {
        MessageDigest md = MessageDigest.getInstance(MD5);

        File directory = new File("target/allure-results");

        File[] files = directory.listFiles();

        for (File file : Objects.requireNonNull(files)) {
            if (file.getName().contains("result.json")) {
                BufferedReader br1 = new BufferedReader(new FileReader(file));
                String resultJson = br1.readLine();
                JSONObject object = new JSONObject(resultJson);
                if (object.get("description").toString().equals("")) {
                    JSONArray array = object.getJSONArray("labels");
                    object = array.getJSONObject(2);
                    String methodName = object.get("value").toString();
                    md.update(methodName.getBytes(StandardCharsets.UTF_8));
                    String descriptionFileName = DatatypeConverter.printHexBinary(md.digest()).toLowerCase();

                    File descriptionFile = new File("target/test-classes/allureDescriptions/" + descriptionFileName);
                    BufferedReader br2 = new BufferedReader(new FileReader(descriptionFile));
                    StringBuilder description = new StringBuilder();
                    String line = br2.readLine();
                    while (line != null) {
                        description.append(line);
                        line = br2.readLine();
                    }
                    object = new JSONObject(resultJson);
                    object.remove("description");
                    object.put("description", description.toString());
                    String result = object.toString();

                    try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, false)))){
                        bw.write(result);
                    }

                    br2.close();
                }
                br1.close();

            }
        }
    }
}
