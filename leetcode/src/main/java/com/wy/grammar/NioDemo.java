package com.wy.grammar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wy
 * @date 2020/4/2
 * @description
 */
public class NioDemo {
    private static String url = "/Users/wy/workspace/temp";

    public static void main(String[] args) throws IOException, InterruptedException {
//        treePath();
//        listenPathFile();
        changeFileAttribute();
    }


    private static void treePath() throws IOException {
        final Path path = Paths.get(url);
        final Path root = path.toAbsolutePath();
        final int nameCount = root.getNameCount();
        System.out.println(root);
        System.out.println(nameCount);
        Files.walkFileTree(path, new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println("当前正在访问的文件：" + file);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    private static void listenPathFile() throws IOException, InterruptedException {
        final WatchService watchService = FileSystems.getDefault().newWatchService();
        Paths.get(url).register(
                watchService,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY);
        while (true) {
            final WatchKey key = watchService.take();
            for (WatchEvent<?> pollEvent : key.pollEvents()) {
                System.out.println("" + pollEvent.context() + pollEvent.kind());
            }
            final boolean reset = key.reset();
            if (!reset) {
                break;
            }
        }
    }

    private static void changeFileAttribute() {
        File file = new File("/Users/wy/workspace/company-porject/test-mysql-charset/temp");
        Set<PosixFilePermission> perms = new HashSet<>();
        perms.add(PosixFilePermission.OWNER_READ);
        perms.add(PosixFilePermission.OWNER_WRITE);
        perms.add(PosixFilePermission.OWNER_EXECUTE);
        perms.add(PosixFilePermission.GROUP_READ);
        perms.add(PosixFilePermission.GROUP_WRITE);
        perms.add(PosixFilePermission.GROUP_EXECUTE);
        perms.add(PosixFilePermission.OTHERS_WRITE);
        perms.add(PosixFilePermission.OTHERS_READ);
        final Path path = Paths.get(file.getAbsolutePath());
        try {
            Files.setPosixFilePermissions(path, perms);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
