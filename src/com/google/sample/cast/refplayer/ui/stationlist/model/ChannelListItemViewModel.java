package com.google.sample.cast.refplayer.ui.stationlist.model;

public class ChannelListItemViewModel {
    private int id;
    private String name;
    private String coverURL;

    public int getId() {
        return id;
    }

    public String getCoverURL() {
        return coverURL;
    }

    public String getName() {
        return name;
    }

    private ChannelListItemViewModel(Builder builder) {
        id = builder.id;
        name = builder.name;
        coverURL = builder.coverURL;
    }

    public static final class Builder {
        private int id;
        private String name;
        private String coverURL;

        public Builder() {
        }

        public Builder id(int val) {
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

        public ChannelListItemViewModel build() {
            return new ChannelListItemViewModel(this);
        }
    }
}
