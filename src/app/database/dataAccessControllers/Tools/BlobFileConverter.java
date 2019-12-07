package app.database.dataAccessControllers.Tools;

import java.io.*;
import java.sql.Blob;
import java.sql.SQLException;

public class BlobFileConverter {
    public static byte[] getByteArrayFromFile(final File handledDocument) throws IOException {
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        final InputStream in = new FileInputStream(handledDocument);
        final byte[] buffer = new byte[500];
        int read = -1;
        while ((read = in.read(buffer)) > 0) {
            baos.write(buffer, 0, read);
        }
        in.close();
        return baos.toByteArray();
    }

    public static File getFileFromBlob(Blob blob, String fileName) throws IOException, SQLException {
        File file = new File(fileName);
        file.createNewFile();
        InputStream in = blob.getBinaryStream();
        OutputStream out = new FileOutputStream(file);
        byte[] buff = new byte[4096];  // how much of the blob to read/write at a time
        int len = 0;

        while ((len = in.read(buff)) != -1) {
            out.write(buff, 0, len);
        }

        return file;
    }
}
