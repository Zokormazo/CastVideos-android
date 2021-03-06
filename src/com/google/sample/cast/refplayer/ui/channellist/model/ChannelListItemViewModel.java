package com.google.sample.cast.refplayer.ui.channellist.model;

public class ChannelListItemViewModel {
    private String id;
    private String name;
    private String coverURL;
    private String mosaicCoverURL;
    private String jsonURL;

    public String getId() {
        return id;
    }

    public String getCoverURL() {
        return coverURL;
    }

    public String getName() {
        return name;
    }

    public String getJsonURL() {
        return jsonURL;
    }

    public String getMosaicCoverURL() {
        return mosaicCoverURL;
    }

    private ChannelListItemViewModel(Builder builder) {
        id = builder.id;
        name = builder.name;
        coverURL = builder.coverURL;
        mosaicCoverURL = builder.mosaicCoverURL;
        jsonURL = builder.jsonURL;
    }

    public static final class Builder {
        private String id;
        private String name;
        private String coverURL;
        private String mosaicCoverURL;
        private String jsonURL;

        public Builder() {
        }

        public Builder id(String val) {
            id = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder coverURL(String val) {
            coverURL = val;
            return this;
        }

        public Builder mosaicCoverURL(String val) {
            mosaicCoverURL = val;
            return this;
        }

        public Builder jsonURL(String val) {
            jsonURL = val;
            return this;
        }

        public ChannelListItemViewModel build() {
            return new ChannelListItemViewModel(this);
        }
    }
}
