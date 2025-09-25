package ccrm.io;
import java.nio.file.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BackupService {
    public void backup(String srcDir, String destBaseDir) throws IOException {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        Path destDir = Paths.get(destBaseDir, "backup_" + timestamp);
        Files.createDirectories(destDir);
        Files.walk(Paths.get(srcDir)).forEach(source -> {
            try {
                Path dest = destDir.resolve(Paths.get(srcDir).relativize(source));
                if (Files.isDirectory(source)) {
                    Files.createDirectories(dest);
                } else {
                    Files.copy(source, dest, StandardCopyOption.REPLACE_EXISTING);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
