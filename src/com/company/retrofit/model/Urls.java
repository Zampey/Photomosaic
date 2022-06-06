package com.company.retrofit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Urls {
    @SerializedName("small")
    @Expose
    private String small;
}
