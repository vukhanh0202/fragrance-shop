package com.gemstones.dto;

public class BlogDTO extends AbstractDTO<BlogDTO> {

    private String title;
    private String shortDescription;
    private String content;
    private String thumbnail;
    private byte[] thumbnailByte;
    private String typeBlog;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public byte[] getThumbnailByte() {
        return thumbnailByte;
    }

    public void setThumbnailByte(byte[] thumbnailByte) {
        this.thumbnailByte = thumbnailByte;
    }

    public String getTypeBlog() {
        return typeBlog;
    }

    public void setTypeBlog(String typeBlog) {
        this.typeBlog = typeBlog;
    }
}
