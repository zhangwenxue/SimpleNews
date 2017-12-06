
package com.sharenews.internal.bean;

import java.io.Serializable;
import java.util.List;

public class JuheNews implements Serializable {

    private String stat;
    private List<Data> data;

    public void setStat(String stat) {
        this.stat = stat;
    }

    public String getStat() {
        return stat;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public List<Data> getData() {
        return data;
    }

    public static class Data implements Serializable {

        private String uniqueKey;
        private String title;
        private String date;
        private String category;
        private String authorName;
        private String url;
        private String thumbnailPicS;
        private String thumbnailPicS02;
        private String thumbnailPicS03;

        public void setUniqueKey(String uniqueKey) {
            this.uniqueKey = uniqueKey;
        }

        public String getUniqueKey() {
            return uniqueKey;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getDate() {
            return date;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getCategory() {
            return category;
        }

        public void setAuthorName(String authorName) {
            this.authorName = authorName;
        }

        public String getAuthorName() {
            return authorName;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }

        public void setThumbnailPicS(String thumbnailPicS) {
            this.thumbnailPicS = thumbnailPicS;
        }

        public String getThumbnailPicS() {
            return thumbnailPicS;
        }

        public void setThumbnailPicS02(String thumbnailPicS02) {
            this.thumbnailPicS02 = thumbnailPicS02;
        }

        public String getThumbnailPicS02() {
            return thumbnailPicS02;
        }

        public void setThumbnailPicS03(String thumbnailPicS03) {
            this.thumbnailPicS03 = thumbnailPicS03;
        }

        public String getThumbnailPicS03() {
            return thumbnailPicS03;
        }

    }

}