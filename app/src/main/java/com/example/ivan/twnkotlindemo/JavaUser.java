package com.example.ivan.twnkotlindemo;

import android.os.Parcel;
import android.os.Parcelable;

public class JavaUser implements Parcelable {
    private long id;
    private String name;
    private String address;
    private String description;
    private String profileImageUrl;

    public JavaUser(long id, String name, String description, String profileImageUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.profileImageUrl = profileImageUrl;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.name);
        dest.writeString(this.address);
        dest.writeString(this.description);
        dest.writeString(this.profileImageUrl);
    }

    public JavaUser(Parcel in) {
        this.id = in.readLong();
        this.name = in.readString();
        this.address = in.readString();
        this.description = in.readString();
        this.profileImageUrl = in.readString();
    }

    public static final Parcelable.Creator<JavaUser> CREATOR = new Parcelable.Creator<JavaUser>() {
        @Override
        public JavaUser createFromParcel(Parcel source) {
            return new JavaUser(source);
        }

        @Override
        public JavaUser[] newArray(int size) {
            return new JavaUser[size];
        }
    };
}
