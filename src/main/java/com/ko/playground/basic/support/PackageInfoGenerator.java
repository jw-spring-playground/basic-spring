package com.ko.playground.basic.support;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.lang.NonNullApi;
import org.springframework.lang.NonNullFields;

public class PackageInfoGenerator {

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: java PackageInfoGenerator <baseDir>");
            System.exit(1);
        }

        File baseDir = new File(args[0]);
        if (!baseDir.exists() || !baseDir.isDirectory()) {
            System.err.println("Invalid base directory: " + args[0]);
            System.exit(2);
        }

        generate(baseDir);
    }

    public static void generate(File baseDir) throws IOException {
        for (File dir : baseDir.listFiles()) {
            walkAndGenerate(dir, baseDir);
        }
    }

    private static void walkAndGenerate(File dir, File baseDir) throws IOException {
        if (!dir.isDirectory()) return;

        // 1. 해당 디렉토리에 실제 Java 파일이 없으면 건너뜀
        boolean hasJavaFiles = false;
        for (File f : dir.listFiles()) {
            if (f.getName().endsWith(".java") && !f.getName().equals("package-info.java")) {
                hasJavaFiles = true;
                break;
            }
        }

        if (!hasJavaFiles) {
            // 하위 디렉토리는 계속 탐색해야 하니까 재귀 호출은 유지
            for (File sub : dir.listFiles()) {
                walkAndGenerate(sub, baseDir);
            }
            return;
        };

        // 2. package-info.java가 없으면 생성
        File packageInfo = new File(dir, "package-info.java");
        if (!packageInfo.exists()) {
            String relativePath = baseDir.toURI().relativize(dir.toURI()).getPath();
            String packageName = relativePath.replace('/', '.').replaceAll("\\.$", "");

            String content = String.format("""
                @NonNullApi
                @NonNullFields
                package %s;

                import org.springframework.lang.NonNullApi;
                import org.springframework.lang.NonNullFields;
                """, packageName);

            try (FileWriter writer = new FileWriter(packageInfo)) {
                writer.write(content);
            }

            System.out.println("✅ Created package-info.java in: " + dir.getPath());
        }

        // 3. 재귀적으로 하위 디렉토리 처리
        for (File sub : dir.listFiles()) {
            walkAndGenerate(sub, baseDir);
        }
    }
}
