package com.company.retrofit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Picture {
    @SerializedName("color")
    @Expose
    private String color;
    @SerializedName("urls")
    @Expose
    private Urls urls;
}
