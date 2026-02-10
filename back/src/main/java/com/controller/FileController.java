package com.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 文件上传控制器（修复路径不存在问题）
 */
@RestController
public class FileController {

    // 自定义上传根路径（绝对路径，避免依赖Tomcat临时目录）
    // 建议改为你自己的固定路径，比如 D:/upload/
    private static final String UPLOAD_ROOT_PATH = "D:/springboot_upload/";

    @PostMapping("/api/upload")
    public Result upload(@RequestParam("file") MultipartFile file) {
        // 1. 基础校验：文件为空
        if (file.isEmpty()) {
            return Result.error("上传失败：请选择要上传的文件");
        }

        try {
            // 2. 第一步：强制创建上传根目录（关键！mkdirs递归创建所有层级）
            File rootDir = new File(UPLOAD_ROOT_PATH);
            if (!rootDir.exists()) {
                boolean isCreate = rootDir.mkdirs();
                if (!isCreate) {
                    return Result.error("上传失败：创建上传根目录失败，请检查路径权限");
                }
            }

            // 3. 生成唯一文件名（避免重复，兼容中文）
            String originalFileName = file.getOriginalFilename();
            // 校验文件名和后缀
            if (originalFileName == null || originalFileName.lastIndexOf(".") == -1) {
                return Result.error("上传失败：文件格式无效（无后缀）");
            }
            String suffix = originalFileName.substring(originalFileName.lastIndexOf("."));
            String newFileName = System.currentTimeMillis() + "_" + UUID.randomUUID().toString().substring(0, 8) + suffix;

            // 4. 拼接最终文件路径（根目录 + 新文件名）
            File destFile = new File(rootDir, newFileName);

            // 5. 写入文件（此时目录已存在，不会报路径不存在）
            file.transferTo(destFile);

            // 6. 返回成功结果（前端访问路径，需配置静态资源映射）
            String accessUrl = "/upload/" + newFileName;
            return Result.success("上传成功", accessUrl);

        } catch (IOException e) {
            e.printStackTrace();
            return Result.error("上传失败：文件写入异常 - " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("上传失败：系统异常 - " + e.getMessage());
        }
    }

    /**
     * 通用返回结果类（无需修改）
     */
    static class Result {
        private int code; // 200成功，500失败
        private String msg; // 提示信息
        private Object data; // 返回数据（如文件访问路径）

        // 成功响应
        public static Result success(String msg, Object data) {
            Result r = new Result();
            r.code = 200;
            r.msg = msg;
            r.data = data;
            return r;
        }

        // 失败响应
        public static Result error(String msg) {
            Result r = new Result();
            r.code = 500;
            r.msg = msg;
            r.data = null;
            return r;
        }

        // Getter & Setter（必须有，否则前端接收不到数据）
        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }
    }
}