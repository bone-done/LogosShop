package com.bonedone.logosshop.domain;

import lombok.Data;

@Data
public class ImageDTO {
    private String id;
    private Long productId;
    private String fileName;
    private Boolean isHeadPicture;
}
