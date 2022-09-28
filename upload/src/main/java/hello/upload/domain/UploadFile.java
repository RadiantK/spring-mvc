package hello.upload.domain;

import lombok.Data;

@Data
public class UploadFile {
    
    private String uploadFileName; // 업로드된 파일명
    private String storeFileName; // 시스템에 저장한 파일명

    public UploadFile(String uploadFileName, String storeFileName) {
        this.uploadFileName = uploadFileName;
        this.storeFileName = storeFileName;
    }
}
