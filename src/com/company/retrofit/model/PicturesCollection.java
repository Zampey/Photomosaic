package com.company.retrofit.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PicturesCollection {
    private int total;
    private List<Picture> results;
}
